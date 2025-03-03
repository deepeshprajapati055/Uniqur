package com.uniqur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniqur.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
