package com.java.address.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.address.dto.AddressDto;
import com.java.address.dto.AddressDto;

@Component
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		System.out.println("deleteDao");
		return sqlSession.delete("dao.addressMapper.delete",name);
	}
	
	public AddressDto select(String name){
		return sqlSession.selectOne("addrSelect", name);
	}
	
	public int update(AddressDto addr){
		return sqlSession.update("addrUpdate", addr);
	}
}
