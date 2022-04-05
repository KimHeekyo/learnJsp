package com.it.mapper;

import java.util.List;

import com.it.domain.OrderdetailDTO;
import com.it.domain.OrderlistDTO;
import com.it.domain.OrdermainVO;
import com.it.domain.OrdermemberDTO;
import com.it.domain.OrdersubVO;

public interface OrderMapper {
	
	public void insertmain(OrdermainVO ordermain);
	
	public OrdermainVO readmainid(OrdermainVO ordermain);
	
	public void insertsub(OrdersubVO ordersub);
	
	public List<OrderdetailDTO> getListOrderDetail(OrdermainVO ordermain);
	
	public List<OrderlistDTO> getListOrderList(OrderlistDTO orderlist);
	
	public OrdermemberDTO getOrderTotal(OrdermainVO ordermain);


}
