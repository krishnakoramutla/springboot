package com.example.restfullwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfullwebservices.Entity.Users;
import com.example.restfullwebservices.Repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	private UsersRepository usersRepository;
	
@Autowired
	public UsersServiceImpl(UsersRepository usersRepository) {
	
		this.usersRepository = usersRepository;
	}

	@Override
	public List<Users> findAll() {
		
		return usersRepository.findAll();
	}

	@Override
	public Users findById(int theId) {
		Users thUsers=usersRepository.getById(theId);
		
			return thUsers;
			
		
	}

	@Override
	public void save(Users theUsers) {
		usersRepository.save(theUsers);

	}

	@Override
	public void deleteById(int theId) {
		usersRepository.deleteById(theId);

	}

}
