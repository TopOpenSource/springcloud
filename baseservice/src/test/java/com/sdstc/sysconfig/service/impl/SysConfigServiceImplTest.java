package com.sdstc.sysconfig.service.impl;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.BaseserviceStart;
import com.sdstc.sysconfig.service.SysConfigService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BaseserviceStart.class })
class SysConfigServiceImplTest {
	@Autowired
    private SysConfigService sysConfigService;
	@Test
	void testGetConfigAsInt() {
		fail("Not yet implemented");
	}

	@Test
	void testGetConfigAsStr() {
		String value=sysConfigService.getConfigAsStr("0","a");
		System.out.println(value);
	}

}
