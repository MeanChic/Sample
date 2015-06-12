package com.java.address.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.address.dao.AddressDao;

@Component
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addDao;
}
