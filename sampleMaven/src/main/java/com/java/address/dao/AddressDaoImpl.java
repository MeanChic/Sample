package com.java.address.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.address.dto.AddressDto;

@Component
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
}
