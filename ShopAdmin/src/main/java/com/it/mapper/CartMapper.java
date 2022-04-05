package com.it.mapper;

import java.util.List;

import com.it.domain.CartdetailDTO;
import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;

public interface CartMapper {
	
	public List<CartmainVO> getListMain();
	
	public List<CartsubVO> getListSub();
	
	public List<CartsubVO> getListCart(CartmainVO cartmain);
	
	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain);
	
	public CartmemberDTO getCartTotal(CartmainVO cartmain);	// cart 총금액
	
	public CartmainVO readmain(CartmainVO cartmain);
	
	public CartmainVO readmainid(CartmainVO cartmain);	
	
	public CartsubVO readsub(CartsubVO cartsub);
	
	public CartsubVO readsubproduct(CartsubVO cartsub);
	
	public void insertmain(CartmainVO cartmain);
	
	public void insertsub(CartsubVO cartsub);
	
	public void updatesub(CartsubVO cartsub);
	
	public void deletemain(CartmainVO cartmain);
	
	public void deletesub(CartsubVO cartsub);
	
	public void deletesuball(CartmainVO cartmain);

}
