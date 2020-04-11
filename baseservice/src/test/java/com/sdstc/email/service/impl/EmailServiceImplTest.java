package com.sdstc.email.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.BaseserviceStart;
import com.sdstc.email.dto.EmailDto;
import com.sdstc.email.service.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BaseserviceStart.class })
class EmailServiceImplTest {
	@Autowired
    private EmailService emailService;
	@Test
	void testSend() {
		EmailDto dto=new EmailDto();
		dto.setSubject("标题");
		dto.setText("内容太");
		dto.setToEmail("chengang@sdas.org");
		emailService.send(dto);
	}

}
