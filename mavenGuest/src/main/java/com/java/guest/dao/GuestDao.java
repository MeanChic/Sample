package com.java.guest.dao;

import java.util.List;

import com.java.guest.dto.GuestDto;



public interface GuestDao {  //무조건 IOC 방식으로 만들기 위해 Dao 에서도 인터페이스를 만든다.
	public int getGuestCount();
	
	public List<GuestDto> getGuestList(int startRow,int endRow);
	
	public int insert(GuestDto guestDto);
	
	public int delete(int num);
	
	public GuestDto select(int num);
	
	public int update(GuestDto guestDto);
	
	
	
	

}
