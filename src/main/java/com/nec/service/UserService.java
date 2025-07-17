package com.nec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nec.entity.User;
import com.nec.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> getAll() {
		return repository.findAll();
	}

	public void saveUser(User user) {
		repository.save(user);
		
	}

	public Optional<User> getUserByid(Long id) {
		return repository.findById(id);
	}

	public void deleteByid(Long id) {
		repository.deleteById(id);
		
	}

}