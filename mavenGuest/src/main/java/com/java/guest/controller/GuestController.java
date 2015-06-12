package com.java.guest.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.guest.dto.GuestDto;
import com.java.guest.service.GuestService;



//여기서 모든 작업을 다해줘도 되지만 부담이 커지기 때문에 서비스 컨트롤러로 빼는 겁니다 mav 넘겨서

@Controller
public class GuestController {  //MultiActionController을 상속받으므로서 여러 함수들을 매핑할수있다
	final Logger logger=Logger.getLogger(this.getClass().getName());
	
	
	//setMethod 자동으로 해준다 setter를 생성해서 알아서 guestService를 받아서 this.guestService로 해준다 
	@Autowired 
	private GuestService guestService;  //일단 내가 만든 클래스는 생성자로 받고  상속 받은건 setter로 한다 
	

	@RequestMapping(value="/guest/test.do", method=RequestMethod.GET)
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response){
		logger.info("Spring Web Start------------------------");
		
		ModelAndView mav=new ModelAndView(); //model과 view를 같이 작업해준다는 거에요 request 
		mav.addObject("request",request); //다넘길수 있다
		guestService.testing(mav);
		
		return mav;
		
	}
	
	@RequestMapping(value="/guest/write.do", method=RequestMethod.GET)
	public ModelAndView guestWrite(HttpServletRequest request, HttpServletResponse reponse){ //
		
		logger.info("guestWrite--------------------------------------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		guestService.guestWrite(mav);
		
		
		return mav;
		
	}
	
	@RequestMapping(value="/guest/write.do", method=RequestMethod.POST)
	public ModelAndView guestWriteOk(HttpServletRequest request, HttpServletResponse reponse, GuestDto guestDto){
		
		logger.info("guestWriteOk--------------------------------------");
		logger.info("guestDto:" + guestDto + "," + guestDto.getPassword());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("guestDto", guestDto);
		guestService.guestWriteOk(mav);
		return mav;
	}
	
	@RequestMapping(value="/guest/delete.do", method=RequestMethod.GET)
	public ModelAndView guestDelete(HttpServletRequest request, HttpServletResponse reponse, GuestDto guestDto){
		logger.info("guestDelete--------------------------");
		
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		guestService.guestDelete(mav);
		return mav;
		
	}

	@RequestMapping(value="/guest/update.do", method=RequestMethod.GET)
	public ModelAndView guestUpdate(HttpServletRequest request, HttpServletResponse reponse ){
		logger.info("guestUpdate-----------------------------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		guestService.guestSelect(mav);   
		return mav;
		
		
	}
	
	@RequestMapping(value="/guest/update.do", method=RequestMethod.POST)
	public ModelAndView guestUpdateOk(HttpServletRequest request, HttpServletResponse reponse,GuestDto guestDto){
		logger.info("guestUpdateOk-----------------------------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("guestDto", guestDto);
		mav.addObject("request", request);
		guestService.guestUpdate(mav);
		
		return mav;
	}
}