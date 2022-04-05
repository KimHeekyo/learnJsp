package com.it.service;

import java.util.List;

import com.it.domain.CartdetailDTO;
import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;

public interface CartService {
	
	public void cartinsert(CartmainVO cartmain, CartsubVO cartsub);
	
	public CartmainVO readmainid(CartmainVO cartmain);
	
	public List<CartsubVO> getListCart(CartmainVO cartmain);
	
	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain);
	
	public CartmemberDTO getCartTotal(CartmainVO cartmain);
	
	public void updatesub(CartsubVO cartsub);
	
	public void deletesub(CartsubVO cartsub);
	
	public void deletesuball(CartmainVO cartmain);
	

}