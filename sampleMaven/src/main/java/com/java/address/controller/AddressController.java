package com.java.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.java.address.service.AddressService;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addService;
	
	
}
