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
	final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private AddressService addService;
	
	
	@RequestMapping(value="/address/delete.do", method=RequestMethod.GET)
	public String delete(HttpServletRequest request, HttpServletResponse response){
		logger.info("delete-----------------------------------------");
		return "address/delete";
		
	}
	@RequestMapping(value="/address/deleteOk.do", method=RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request){
		logger.info("deleteOk---------------------------------------");
		ModelAndView mav= new ModelAndView();
		
		mav.addObject("request",request);
		addService.delete(mav);
		return mav;
	}
	
	@RequestMapping(value="/address/select.do", method=RequestMethod.GET)
	public String select(HttpServletRequest request){
		return "address/select";
	}
	
	@RequestMapping(value="/address/select.do", method=RequestMethod.POST)
	public ModelAndView select(HttpServletRequest request, ModelAndView mav){
		mav.addObject("request", request);
		addService.select(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/address/update.do", method=RequestMethod.GET)
	public String update(HttpServletRequest reqeust){
		return "address/update";
	}
	
	@RequestMapping(value="/address/update.do", method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, ModelAndView mav){
		mav.addObject("request", request);
		mav.addObject("update", "update");
		addService.select(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/address/updateOk.do", method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, ModelAndView mav, AddressDto addr){
		mav.addObject("request", request);
		mav.addObject("addr", addr);

		addService.update(mav);
		
		return mav;
	}
	
	
	
}
