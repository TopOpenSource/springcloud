package com.sdstc.file.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.sdstc.file.dto.PolicyDto;

public interface FileService {
	/**
	 * 获取许可
	 * 
	 * @param bucket
	 * @param dir
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	PolicyDto getPolicy(String bucket, String dir) throws UnsupportedEncodingException;

	/**
	 * 下载本地文件
	 * 
	 * @param path
	 * @param writer
	 * @throws IOException
	 */
	void downloadLocalFile();

	/**
	 * 下载oss的文件
	 * 
	 * @param bucket
	 * @param path
	 * @param writer
	 * @throws IOException
	 */
	void downloadOssFile(String bucket, String path, BufferedWriter writer) throws IOException;

	/**
	 * 上传OSS文件
	 */
	void uploadOssFile(String bucket,String path,InputStream instream) throws IOException ;
	
	/**
	 * 上传本地文件
	 */
	void uploadLocalFile();

}
