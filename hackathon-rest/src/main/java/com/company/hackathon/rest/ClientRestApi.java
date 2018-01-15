package com.company.hackathon.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.hackathon.entity.Client;
import com.company.hackathon.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientRestApi {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
	
	@PostMapping
    public Client addClient(Client input) {
        return clientService.addNewClient(input);
    }
}
