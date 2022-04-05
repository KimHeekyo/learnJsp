package com.it.service;

import java.util.List;

import com.it.domain.CartmainVO;
import com.it.domain.OrderdetailDTO;
import com.it.domain.OrderlistDTO;
import com.it.domain.OrdermainVO;
import com.it.domain.OrdermemberDTO;

public interface OrderService {
	
	public OrdermainVO orderproc(CartmainVO cartmain);
	
	public List<OrderdetailDTO> getListOrderDetail(OrdermainVO ordermain);
	
	public List<OrderlistDTO> getListOrderList(OrderlistDTO orderlist);
	
	public OrdermemberDTO getOrderTotal(OrdermainVO ordermain);
	
	

}
