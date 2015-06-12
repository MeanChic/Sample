package com.java.address.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.address.dto.AddressDto;
import com.java.address.service.AddressService;

@Controller
public class AddressController {
	
	private Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private AddressService addService;
	
	@RequestMapping(value="/address/write.do", method=RequestMethod.GET)
	public String write(HttpServletRequest req, HttpServletResponse res){
		logger.info("write------------------");
		
		return "address/write";
	}
	
	@RequestMapping(value="/address/write.do", method=RequestMethod.POST)
	public ModelAndView write(HttpServletRequest req, HttpServletResponse res, AddressDto addressDto){
		logger.info("writeOk------------------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("addressDto", addressDto);
		
		addService.writeOk(mav);
		
		return mav;
	}
	
}
