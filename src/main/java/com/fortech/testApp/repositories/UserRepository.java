package com.fortech.testApp.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.fortech.testApp.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	  boolean existsByUsername(String username);
	  User findByUsername(String username);
	  @Transactional
	  void deleteByUsername(String username);
}
