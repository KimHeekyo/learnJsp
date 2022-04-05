package com.it.service;

import java.util.List;

import com.it.domain.Board2VO;
import com.it.domain.PageDTO;

public interface Board2Service {
public Board2VO read(Board2VO board);		// 단일 레코드 조회
	
	public void insert(Board2VO board);		// 레코드 입력
	
	public List<Board2VO> getList(PageDTO page);			// 전체 레코드 조회
	
	public void update(Board2VO board);		// 레코드 수정
	
	public void delete(Board2VO board);		// 레코드 삭제
	
	public int getTotalCount();

}
