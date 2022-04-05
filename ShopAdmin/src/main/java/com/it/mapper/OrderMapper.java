package com.it.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	public List<OrderlistDTO> getListOrderList(@Param("pageNum") int pageNum, @Param("pageAmount") int pageAmount, @Param("a_id") String a_id);
	
	public OrdermemberDTO getOrderTotal(OrdermainVO ordermain);
	
	public int getTotalCount();

}
