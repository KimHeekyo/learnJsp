package com.it.mapper;

import java.util.List;

import com.it.domain.Product2VO;

public interface Product2Mapper {
	
public List<Product2VO> getList();
	
	public void insert(Product2VO product);
	
	public Product2VO read(Product2VO product);
	
	public void update(Product2VO product);
	
	public void delete(Product2VO product);

}
