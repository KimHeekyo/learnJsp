package com.it.service;

import java.util.List;

import com.it.domain.MemberVO;

public interface MemberService {
	public MemberVO read(MemberVO member);		// 단일 레코드 조회
	
	public boolean auth(MemberVO member);		// 아이디와 암호를 전달하여 인증 처리 후 true/false 반환
	
	public void insert(MemberVO member);		// 레코드 입력
	
	public List<MemberVO> getList();			// 전체 레코드 조회
	
	public void update(MemberVO member);		// 레코드 수정
	
	public void delete(MemberVO member);		// 레코드 삭제

}
