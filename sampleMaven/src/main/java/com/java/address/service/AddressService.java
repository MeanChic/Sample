package com.java.address.service;

import org.springframework.web.servlet.ModelAndView;


public interface AddressService {
	
	public void delete(ModelAndView mav);
	public void update(ModelAndView mav);
	public void select(ModelAndView mav);
}
