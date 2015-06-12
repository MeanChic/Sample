package com.java.address.dao;

import com.java.address.dto.AddressDto;

public interface AddressDao {

	
	
	public int delete(String name);
	public int update(AddressDto addr);
	public AddressDto select(String name);
	



	int writeOk(AddressDto addressDto);

}
