package com.java.address.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.address.dao.AddressDao;
import com.java.address.dto.AddressDto;

@Component
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	public void writeOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		AddressDto addressDto=(AddressDto)map.get("addressDto");
		
		int check=addressDao.writeOk(addressDto);
		
		mav.addObject("check", check);
		mav.setViewName("address/writeOk");
	}
}
