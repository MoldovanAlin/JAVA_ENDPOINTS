package com.java.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.java.restservice.model.User;

@RestResource(exported = false)
public interface UserRepository extends JpaRepository<User, String> {

}