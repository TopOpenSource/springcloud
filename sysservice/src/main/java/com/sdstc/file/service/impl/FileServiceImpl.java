package com.sdstc.file.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.CompleteMultipartUploadRequest;
import com.aliyun.oss.model.CompleteMultipartUploadResult;
import com.aliyun.oss.model.InitiateMultipartUploadRequest;
import com.aliyun.oss.model.InitiateMultipartUploadResult;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PartETag;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyun.oss.model.UploadPartRequest;
import com.aliyun.oss.model.UploadPartResult;
import com.sdstc.file.dto.PolicyDto;
import com.sdstc.file.service.FileService;
import com.sdstc.pub.constant.SysConfigConstant;
import com.sdstc.sysconfig.service.SysConfigService;

@Service("ossFileService")
public class FileServiceImpl implements FileService{
	@Autowired
	private SysConfigService sysConfigService;
	
	private String accessId = null;
	private String endpoint = null;
	
	@Override
	public PolicyDto getPolicy(String bucket,String dir) throws UnsupportedEncodingException {
		OSS client=this.getOssClient();
		String host = "http://" + bucket + "." + endpoint;
		
		//过期时间 秒
		long expireTime = Long.parseLong(sysConfigService.getConfigAsStr(SysConfigConstant.OSS, "EXPIRE_TIME"));
		long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
		Date expiration = new Date(expireEndTime);
		//代理
		PolicyConditions policyConds = new PolicyConditions();
		policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
		policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
		
		//生成policy
		String postPolicy = client.generatePostPolicy(expiration, policyConds);
		byte[] binaryData = postPolicy.getBytes("utf-8");
		String encodedPolicy = BinaryUtil.toBase64String(binaryData);
		//计算戳
		String postSignature = client.calculatePostSignature(postPolicy);
		
		PolicyDto policyDto=new PolicyDto();
		policyDto.setOSSAccessKeyId(accessId);
		policyDto.setPolicy(encodedPolicy);
		policyDto.setSignature(postSignature);
		policyDto.setDir(dir);
		policyDto.setHost(host);
		policyDto.setExpire(String.valueOf(expireEndTime / 1000));
		
		client.shutdown();
		return policyDto;
	}
	
	private OSS getOssClient() {
		endpoint = sysConfigService.getConfigAsStr(SysConfigConstant.OSS, "ENDPOINT");
		accessId = sysConfigService.getConfigAsStr(SysConfigConstant.OSS, "ACCESS_ID");
		String accessKey =sysConfigService.getConfigAsStr(SysConfigConstant.OSS, "ACCESS_KEY");
		OSS client =new OSSClientBuilder().build(endpoint, accessId, accessKey);
		return client;
	}

	@Override
	public void downloadOssFile(String bucket, String path, BufferedWriter writer) throws IOException {
		OSS client=this.getOssClient();
		OSSObject ossObject = client.getObject(bucket, path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
		IOUtils.copy(reader, writer);
		reader.close();
		client.shutdown();
		writer.flush();
		writer.close();
	}

	@Override
	public void uploadOssFile(String bucket,String path,InputStream instream) throws IOException {
		// 创建OSSClient实例。
		OSS ossClient = this.getOssClient();
		// 创建InitiateMultipartUploadRequest对象。
		InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(bucket,path);

		// 初始化分片。
		InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);
		// 返回uploadId，它是分片上传事件的唯一标识，您可以根据这个ID来发起相关的操作，如取消分片上传、查询分片上传等。
		String uploadId = upresult.getUploadId();

		// partETags是PartETag的集合。PartETag由分片的ETag和分片号组成。
		List<PartETag> partETags =  new ArrayList<PartETag>();
		// 计算文件有多少个分片。
		final long partSize = 1 * 1024 * 1024L;   // 1MB
		final File sampleFile = new File("<localFile>");
		long fileLength = sampleFile.length();
		int partCount = (int) (fileLength / partSize);
		if (fileLength % partSize != 0) {
		    partCount++;
		 }
		// 遍历分片上传。
		for (int i = 0; i < partCount; i++) {
		    long startPos = i * partSize;
		    long curPartSize = (i + 1 == partCount) ? (fileLength - startPos) : partSize;
		    // 跳过已经上传的分片。
		    instream.skip(startPos);
		    UploadPartRequest uploadPartRequest = new UploadPartRequest();
		    uploadPartRequest.setBucketName(bucket);
		    uploadPartRequest.setKey(path);
		    uploadPartRequest.setUploadId(uploadId);
		    uploadPartRequest.setInputStream(instream);
		    // 设置分片大小。除了最后一个分片没有大小限制，其他的分片最小为100KB。
		    uploadPartRequest.setPartSize(curPartSize);
		    // 设置分片号。每一个上传的分片都有一个分片号，取值范围是1~10000，如果超出这个范围，OSS将返回InvalidArgument的错误码。
		    uploadPartRequest.setPartNumber( i + 1);
		    // 每个分片不需要按顺序上传，甚至可以在不同客户端上传，OSS会按照分片号排序组成完整的文件。
		    UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
		    // 每次上传分片之后，OSS的返回结果会包含一个PartETag。PartETag将被保存到partETags中。
		    partETags.add(uploadPartResult.getPartETag());
		}

		// 创建CompleteMultipartUploadRequest对象。
		// 在执行完成分片上传操作时，需要提供所有有效的partETags。OSS收到提交的partETags后，会逐一验证每个分片的有效性。当所有的数据分片验证通过后，OSS将把这些分片组合成一个完整的文件。
		CompleteMultipartUploadRequest completeMultipartUploadRequest =new CompleteMultipartUploadRequest(bucket, path, uploadId, partETags);

		// 完成上传。
		CompleteMultipartUploadResult completeMultipartUploadResult = ossClient.completeMultipartUpload(completeMultipartUploadRequest);
		// 关闭OSSClient。
		ossClient.shutdown();
	}

	@Override
	public void downloadLocalFile() {
		
	}

	@Override
	public void uploadLocalFile() {
		
	}

}
