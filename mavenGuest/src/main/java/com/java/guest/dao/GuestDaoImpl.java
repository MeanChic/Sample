package com.java.guest.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.guest.dto.GuestDto;



@Component
public class GuestDaoImpl implements GuestDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	


	@Override
	public int getGuestCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("guestCount"); //이전처럼 open close  try catch 해줄필요없다 Template는 알아서 다 해줘요
	}

	@Override
	public List<GuestDto> getGuestList(int startRow, int endRow) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hMap=new HashMap<String,Integer>();
		hMap.put("startRow",startRow);
		hMap.put("endRow", endRow);
		return sqlSession.selectList("guestList", hMap); //SelectList Dto를 자동으로 받아서 ㅃ려주는 역할  

	}

	@Override
	public int insert(GuestDto guestDto) {
		// TODO Auto-generated method stub
		return sqlSession.insert("guestInsert", guestDto);
	}

	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		return sqlSession.delete("guestDelete", num);
	}

	@Override
	public GuestDto select(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("guestSelect", num);
	}

	@Override
	public int update(GuestDto guestDto) {
		// TODO Auto-generated method stub
		return sqlSession.update("guestUpdate", guestDto);
	}
}
