package com.java.guest.service;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;




@Component
public class GuestServiceImpl implements GuestService {
	final Logger logger=Logger.getLogger(this.getClass().getName());

	@Autowired
	private GuestDao guestDao;



	@Override
	public void testing(ModelAndView mav) {
		// TODO Auto-generated method stub
		//요청 -->DB
		
		mav.addObject("msg","하하하");
		mav.addObject("a","우하하하");
		mav.setViewName("test/testOk");
	}

	@Override
	public void guestWrite(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map=mav.getModel();
		HttpServletRequest request=(HttpServletRequest)map.get("request");  //Object로 반환되기 때문에 
		
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null) pageNumber="1";
		int currentPage=Integer.parseInt(pageNumber);
		logger.info("currentPage:" + currentPage);
		
		//전체레코드수,현재번호의 시작번호, 끝번호--> DB
		int count=guestDao.getGuestCount();
		logger.info("count:" + count);
		
		int boardSize=3;
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=currentPage*boardSize;
		logger.info("startRow:" + startRow + ",endRow" + endRow);
		
		List<GuestDto> guestList=null;
		
		if(count >0) guestList=guestDao.getGuestList(startRow,endRow);
		logger.info("guestList" + guestList.size());
		
		mav.addObject("list", guestList);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage",currentPage);
		mav.setViewName("guest/write");
	}


	@Override
	public void guestWriteOk(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map=mav.getModelMap();
		GuestDto guestDto=(GuestDto)map.get("guestDto");
		guestDto.setWriteDate(new Date());
		
		int check=guestDao.insert(guestDto);
		logger.info("check" + check);
		
		mav.addObject("check", check);
		mav.setViewName("guest/writeOk");
		
	}


	@Override
	public void guestDelete(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
		logger.info("num:" + num + "\t pageNumber" +pageNumber);
		
		int check=guestDao.delete(num);
		
		logger.info("check:" + check);
		
		mav.addObject("check", check);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName("guest/delete");
	}


	@Override
	public void guestSelect(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String,Object> map=mav.getModel();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
		GuestDto guestDto=guestDao.select(num);
		System.out.println(guestDto);
		
		mav.addObject("guest",guestDto);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName("guest/update");
	}


	@Override
	public void guestUpdate(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map<String,Object> map=mav.getModelMap();
		HttpServletRequest request= (HttpServletRequest) map.get("request");
		GuestDto guestDto=(GuestDto) map.get("guestDto");
		
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		int check=guestDao.update(guestDto);
		logger.info("check" + check);
		
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("check",check);
		mav.setViewName("guest/updateOk");
		
		
	}
}
