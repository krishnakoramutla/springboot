package com.example.restfullwebservices.Rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfullwebservices.Entity.Users;
import com.example.restfullwebservices.service.UsersService;

@Validated
@RestController
public class UsersController {
	
	private UsersService usersService;
	

	@Autowired
	public UsersController(UsersService usersService) {
	
		this.usersService = usersService;
	}
	
	@GetMapping("/hello-world")
	public String helloWorld() {

		return "Hello World";
	}
	@GetMapping("/users")
	public List<Users> usersList(){
		
		return usersService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Users findByIdUsers(@PathVariable int id) {
		
		 return usersService.findById(id);
	}
	
	@PostMapping("/users")
	public Users addUsers(@Valid @RequestBody Users thUsers) {
		thUsers.setId(0);
		usersService.save(thUsers);
		return thUsers;
		
	}
	@PutMapping("/users")
	public Users updatUsers(@RequestBody Users tHUsers) {
		
		usersService.save(tHUsers);
		return tHUsers;
		
	}
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		
		usersService.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
	

}
