package com.uniqur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniqur.entity.Subscribers;

@Repository
public interface SubscribersRepository extends JpaRepository<Subscribers, Integer>{
	
	Subscribers findByEmail(Subscribers subscribers);
	
}
