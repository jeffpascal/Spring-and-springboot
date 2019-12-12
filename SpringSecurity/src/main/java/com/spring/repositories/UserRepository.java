package com.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring.entities.User;

public interface UserRepository extends CrudRepository<User,Long>{

}
