package com.it.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.it.domain.CartmainVO;
import com.it.domain.OrderdetailDTO;
import com.it.domain.OrderlistDTO;
import com.it.domain.OrdermainVO;
import com.it.domain.OrdermemberDTO;

public interface OrderService {
	
	public OrdermainVO orderproc(CartmainVO cartmain);
	
	public List<OrderdetailDTO> getListOrderDetail(OrdermainVO ordermain);
	
	public List<OrderlistDTO> getListOrderList(@Param("pageNum") int pageNum, @Param("pageAmount") int pageAmount, @Param("a_id") String a_id);
	
	public OrdermemberDTO getOrderTotal(OrdermainVO ordermain);
	
	public int getTotalCount();

}
