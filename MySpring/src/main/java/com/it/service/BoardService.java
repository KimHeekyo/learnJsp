package com.it.service;

import java.util.List;

import com.it.domain.BoardVO;

public interface BoardService {

	public BoardVO read(BoardVO board);		// 단일 레코드 조회
	
	public void insert(BoardVO board);		// 레코드 입력
	
	public List<BoardVO> getList();			// 전체 레코드 조회
	
	public void update(BoardVO board);		// 레코드 수정
	
	public void delete(BoardVO board);		// 레코드 삭제
}
