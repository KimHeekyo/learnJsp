package com.it.mapper;

import java.util.List;

import com.it.domain.NoticeVO;

public interface NoticeMapper {
	public List<NoticeVO> getList();
	
	public void insert(NoticeVO notice);
	

}