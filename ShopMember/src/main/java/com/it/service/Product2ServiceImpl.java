package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.Product2VO;
import com.it.mapper.Product2Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class Product2ServiceImpl implements Product2Service {
	@Setter(onMethod_ = @Autowired)
	private Product2Mapper mapper;
	
	@Override
	public Product2VO read(Product2VO product) {
		return mapper.read(product);
	}
	
	@Override
	public void insert(Product2VO product) {
		mapper.insert(product);
	}
	
	@Override
	public List<Product2VO> getList() {
		return mapper.getList();
	}

	@Override
	public void update(Product2VO product) {
		mapper.update(product);
	}
	
	@Override
	public void delete(Product2VO product) {
		mapper.delete(product);
	}

}
