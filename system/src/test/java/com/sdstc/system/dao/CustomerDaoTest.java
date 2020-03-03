package com.sdstc.system.dao;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.SystemStart;
import com.sdstc.pub.snowflake.SnowflakeIdWorker;
import com.sdstc.system.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SystemStart.class })
class CustomerDaoTest {
	@Autowired
    private CustomerDao customerDao;
	
	@Test
	void testInsertCustomer() {
		SnowflakeIdWorker snowflakeIdWorker=new SnowflakeIdWorker(0);
		Date now=new Date();
		
		Customer  customer=new Customer();
		customer.setId(snowflakeIdWorker.nextId());
		customer.setGmtCreate(now);
		customer.setCreateAccount("admin");
		customer.setName("山东道普");
		customer.setRegisterDate(now);
		customer.setState((char)1);
		
		customerDao.insertCustomer(customer);
		
	}

	@Test
	void testInsertCustomerState() {
	}

}
