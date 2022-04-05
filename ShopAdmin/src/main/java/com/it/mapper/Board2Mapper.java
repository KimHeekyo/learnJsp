package com.it.mapper;

import java.util.List;

import com.it.domain.Board2VO;
import com.it.domain.PageDTO;

public interface Board2Mapper {
public List<Board2VO> getList(PageDTO page);	// 값을 넘기지 않았으므로 xml에서 #기호를 쓰지않음
	
	public void insert(Board2VO board);
	
	public Board2VO read(Board2VO board);	// num을 넘겨도 되지만 통째로 넘기는게 더 안정적
	
	public void update(Board2VO board);
	
	public void delete(Board2VO board);
	
	public int getTotalCount();

}
