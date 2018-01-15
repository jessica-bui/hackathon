package com.company.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hackathon.dao.ClientDAO;
import com.company.hackathon.entity.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	public List<Client> getAllClients() {
		List<Client> list = new ArrayList<>();
		clientDAO.findAll().forEach(list::add);
		return list;
	}
	
	public Client addNewClient(Client input) {
		Client entity = new Client();
		BeanUtils.copyProperties(input, entity);
		return clientDAO.save(entity);
	}

}
