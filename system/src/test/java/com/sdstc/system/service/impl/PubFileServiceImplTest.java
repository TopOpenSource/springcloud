package com.sdstc.system.service.impl;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.SystemStart;
import com.sdstc.pub.dto.PageDto;
import com.sdstc.pub.snowflake.SnowflakeIdWorker;
import com.sdstc.system.model.PubFile;
import com.sdstc.system.service.PubFileService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SystemStart.class })
class PubFileServiceImplTest {
	@Autowired
    private PubFileService pubFileService;
	@Test
	void testInsert() {
		SnowflakeIdWorker snowflakeIdWorker=new SnowflakeIdWorker(0);
		Date now=new Date();
		PubFile dto=new PubFile();
		dto.setId(snowflakeIdWorker.nextId());
		dto.setCreateAccount("admin");
		dto.setGmtCreate(now);
		dto.setPath("xxx");
		dto.setCustomerId(snowflakeIdWorker.nextId());
		pubFileService.insert(dto);
		
	}

	@Test
	void testUpdateByPK() {
		Date now=new Date();
		PubFile dto=new PubFile();
		dto.setId(687285058712633344L);
		dto.setModifiedAccount("cheng");
		dto.setGmtModified(now);
		dto.setPath("xxx1");
		dto.setCustomerId(687285058712633345L);
		pubFileService.updateByPK(dto);
	}

	@Test
	void testUpdateSelectiveByPK() {
		Date now=new Date();
		PubFile dto=new PubFile();
		dto.setId(687285058712633344L);
		dto.setModifiedAccount("cheng");
		dto.setGmtModified(now);
		dto.setPath("xxx1");
		dto.setCustomerId(687285058712633345L);
		pubFileService.updateSelectiveByPK(dto);
	}

	@Test
	void testDeleteByPK() {
		pubFileService.deleteByPK(687285058712633344L, 687285058712633345L);
	}

	@Test
	void testSelectByPK() {
		PubFile dto= pubFileService.selectByPK(687285058712633344L, 687285058712633345L);
		System.out.println(dto.getPath());
	}
	
	@Test
	void selectPageByDto() {
		PubFile dto=new PubFile();
		PageDto pageDto=new PageDto();
		pageDto.setPageSize(2);
		pageDto.setPage(2);
		
		List<PubFile> pubFiles=pubFileService.selectPageByDto(dto, pageDto);
		System.out.println();
		
	}

}
