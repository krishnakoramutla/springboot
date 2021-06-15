package com.example.restfullwebservices.service;

import java.util.List;

import com.example.restfullwebservices.Entity.Users;

public interface UsersService {
	
	public List<Users> findAll();
	public Users findById(int theId);
	public void save(Users theUsers);
	public void deleteById(int theId);

}
