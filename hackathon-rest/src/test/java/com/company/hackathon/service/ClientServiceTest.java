package com.company.hackathon.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.hackathon.HackathonRestApplication;
import com.company.hackathon.entity.Client;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HackathonRestApplication.class)
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	
	@Test
	public void testAddNewClient() {
		Client input = new Client();
		input.setName("client1");
		input.setEmail("client1@gmail.com");
		input = clientService.addNewClient(input);
		Assert.assertNotNull(input.getId());
	}

}
