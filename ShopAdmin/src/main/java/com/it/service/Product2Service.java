package com.it.service;

import java.util.List;

import com.it.domain.Product2VO;

public interface Product2Service {

public Product2VO read(Product2VO product);		// 단일 레코드 조회
	
	public void insert(Product2VO product);		// 레코드 입력
	
	public List<Product2VO> getList();			// 전체 레코드 조회
	
	public void update(Product2VO product);		// 레코드 수정
	
	public void delete(Product2VO product);		// 레코드 삭제
}
