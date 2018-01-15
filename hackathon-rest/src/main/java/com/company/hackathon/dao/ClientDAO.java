package com.company.hackathon.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.hackathon.entity.Client;

public interface ClientDAO extends CrudRepository<Client, Long> {
	Client findByEmail(String email);
}
