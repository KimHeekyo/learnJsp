package com.it.mapper;

import java.util.List;

import com.it.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();	// 값을 넘기지 않았으므로 xml에서 #기호를 쓰지않음
	
	public void insert(BoardVO board);
	
	public BoardVO read(BoardVO board);	// num을 넘겨도 되지만 통째로 넘기는게 더 안정적
	
	public void update(BoardVO board);
	
	public void delete(BoardVO board);
}
