package com.uniqur.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniqur.entity.Subscribers;
import com.uniqur.repository.SubscribersRepository;
import com.uniqur.service.SubscribersService;

@Service
public class SubscribersServiceImpl implements SubscribersService {
	
	@Autowired
	private SubscribersRepository subscribersRepository;
	public SubscribersServiceImpl(SubscribersRepository subscribersRepository) {
		super();
		this.subscribersRepository = subscribersRepository;
	}
	@Override
	public Subscribers addSubscribers(Subscribers subscribers) {
		return this.subscribersRepository.save(subscribers);
	}
	
}