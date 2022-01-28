package com.it.mapper;

import java.util.List;

import com.it.domain.MemberVO;

public interface MemberMapper {
	public List<MemberVO> getList();	// 값을 넘기지 않았으므로 xml에서 #기호를 쓰지않음
	
	public void insert(MemberVO member);
	
	public MemberVO read(MemberVO member);	// num을 넘겨도 되지만 통째로 넘기는게 더 안정적
	
	//public MemberVO auth(MemberVO member);	// 활용하지 않음
	
	public void update(MemberVO member);
	
	public void delete(MemberVO member);
	
}
