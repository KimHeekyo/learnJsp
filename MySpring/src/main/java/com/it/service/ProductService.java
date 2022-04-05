package com.it.service;

import java.util.List;

import com.it.domain.ProductVO;

public interface ProductService {
	public ProductVO read(ProductVO product);		// 단일 레코드 조회
	
	public void insert(ProductVO product);		// 레코드 입력
	
	public List<ProductVO> getList();			// 전체 레코드 조회
	
	public void update(ProductVO product);		// 레코드 수정
	
	public void delete(ProductVO product);		// 레코드 삭제

}
