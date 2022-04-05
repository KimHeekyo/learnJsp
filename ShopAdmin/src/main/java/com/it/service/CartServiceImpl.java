package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.CartdetailDTO;
import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;
import com.it.mapper.CartMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CartServiceImpl implements CartService {
	
	@Setter(onMethod_ = @Autowired)
	private CartMapper mapper;
	
	@Override
	public void cartinsert(CartmainVO cartmain, CartsubVO cartsub) {
		CartmainVO cm = new CartmainVO();
		cm = mapper.readmainid(cartmain);	// 세션 아이디를 인수로 조회하여 결과 반환, 있으면 레코드 1개, 없으면 null 반환
		if (cm == null) {	// cartmain에 해당 사용자의 레코드 1개를 신규생성해야 함
			mapper.insertmain(cartmain); 	// cartmain에 레코드 추가
			// cm_code 가 생성되었으나 조회해야 알 수 있음
			cm = mapper.readmainid(cartmain);	// 해당사용자로 신규 추가 후 조회
			cartsub.setCm_code(cm.getCm_code()); // 조회한 신규 cm_code를 cartsub에 추가
			mapper.insertsub(cartsub);	// 그냥 사용하면 정보는 담기지만 정보를 담을 장바구니(cartmain)가 없다.
		} else { // 이미 최소 1개는 카트에 상품이 존재한다는 의미
			cartsub.setCm_code(cm.getCm_code());
			CartsubVO cs = new CartsubVO();
			cs = mapper.readsubproduct(cartsub);
			if (cs == null) { // 선택한 상품이 장바구니에 없다면 cartsub에 물건을 추가하고
				mapper.insertsub(cartsub);
			} else { // 선택한 상품이 장바구니에 있다면 기존 물건에서 수량만 더해준다.
				//int tmp = cs.getCs_cnt() + cartsub.getCs_cnt(); 기존 + 신규
				cs.setCs_cnt(cs.getCs_cnt() + cartsub.getCs_cnt()); // 기존 + 신규
				mapper.updatesub(cs);
			}
		}
		
	}
	
	@Override
	public CartmainVO readmainid(CartmainVO cartmain) {
		cartmain = mapper.readmainid(cartmain);	// 특정 사용자 아이디로 조회
		return cartmain;
	}
	
	@Override
	public List<CartsubVO> getListCart(CartmainVO cartmain) {
		return mapper.getListCart(cartmain);
	}
	
	@Override
	public List<CartdetailDTO> getListCartDetail(CartmainVO cartmain) {
		return mapper.getListCartDetail(cartmain);
	}
	
	@Override
	public CartmemberDTO getCartTotal(CartmainVO cartmain) {
		return mapper.getCartTotal(cartmain);
	}
	
	@Override
	public void updatesub(CartsubVO cartsub) {
		mapper.updatesub(cartsub);
	}
	
	@Override
	public void deletesub(CartsubVO cartsub) {
		mapper.deletesub(cartsub);
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(cartsub.getCm_code());
		List<CartsubVO> tmp = mapper.getListCart(cartmain);
		//log.info(tmp.size());
		if (tmp.size() == 0) {	// 장바구니에 상품이 1개도 없을경우
			mapper.deletemain(cartmain);	// cartmain 삭제
		}
	}
	
	@Override
	public void deletesuball(CartmainVO cartmain) {
		mapper.deletesuball(cartmain);	// 장바구니 상세 내용 삭제(cm_code 활용)
		mapper.deletemain(cartmain);	// 장바구니 삭제(cm_code 활용)
	}

}
