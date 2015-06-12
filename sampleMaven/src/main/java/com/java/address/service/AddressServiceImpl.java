package com.java.address.service;

import java.util.Map;
<<<<<<< HEAD
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
=======
>>>>>>> branch 'master' of https://github.com/MeanChic/Sample.git

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
<<<<<<< HEAD

import com.java.address.dto.AddressDto;
=======
>>>>>>> branch 'master' of https://github.com/MeanChic/Sample.git

import com.java.address.dao.AddressDao;
import com.java.address.dto.AddressDto;

@Component
public class AddressServiceImpl implements AddressService {
<<<<<<< HEAD

	
	final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private AddressDao addDao;
	
	@Override
	public void delete(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String,Object> hMap=mav.getModelMap();
		HttpServletRequest request= (HttpServletRequest) hMap.get("request");
		String name=request.getParameter("name");
		
		Integer check=addDao.delete(name);
		
		logger.info(check.toString());
		mav.addObject("check",check);
		mav.setViewName("address/deleteOk");
	}
	
	public void select(ModelAndView mav){
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String update = (String)map.get("update");
		
		String name = request.getParameter("name");
		AddressDto addr = addDao.select(name);
		
		mav.addObject("addr", addr);
		if(update == null){
			mav.setViewName("address/selectOk");
		}else{
			mav.setViewName("address/update");
		}
		
	}
	
	public void update(ModelAndView mav){
		Map<String, Object> map = mav.getModelMap();
		AddressDto addr = (AddressDto) map.get("addr");
		System.out.println("Ok1");
		int check = addDao.update(addr);
		System.out.println("Ok2");
		mav.addObject("check", check);
		mav.setViewName("address/updateOk");
=======
	@Autowired
	private AddressDao addressDao;

	public void writeOk(ModelAndView mav) {
		Map<String, Object> map=mav.getModelMap();
		AddressDto addressDto=(AddressDto)map.get("addressDto");
		
		int check=addressDao.writeOk(addressDto);
		
		mav.addObject("check", check);
		mav.setViewName("address/writeOk");
>>>>>>> branch 'master' of https://github.com/MeanChic/Sample.git
	}
}
