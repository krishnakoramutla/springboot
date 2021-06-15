package com.example.restfullwebservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfullwebservices.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
