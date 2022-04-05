package com.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;
import com.it.domain.OrderlistDTO;
import com.it.domain.OrdermainVO;
import com.it.domain.OrdermemberDTO;
import com.it.service.CartService;
import com.it.service.MemberService;
import com.it.service.OrderService;
import com.it.service.Product2Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/shop/")
public class ShopController {
	
	@Setter(onMethod_ = @Autowired)
	private Product2Service product2service;
	
	@Setter(onMethod_ = @Autowired)
	private MemberService memberservice;
	
	@Setter(onMethod_ = @Autowired)
	private CartService cartservice;
	
	@Setter(onMethod_ = @Autowired)
	private OrderService orderservice;
	
	
	
	@GetMapping("/list")
	public void list(Model model) { // Model 객체는 VO객체를 저장해서 jsp 파일로 전송 (반드시선언, 쓰던 안쓰던 상관없음)
		// list.jsp 에 데이터를 전달해야 함
		model.addAttribute("list", product2service.getList()); // getList로 조회한 모든 내용을 list변수로 전달
	}
	
	@PostMapping("/cart")
	public String cart(HttpSession session, CartsubVO cartsub) {
		log.info("-----장바구니테스트------");
		log.info(cartsub);
		String m_id = (String)session.getAttribute("m_id");
		if (m_id != null) {	// 로그인이 되어있을 경우 장바구니 처리 진행
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id);	// VO에 사용자의 세션정보를 저장
			cartservice.cartinsert(cartmain, cartsub);	// 서비스 계층 호출
			return "redirect:/shop/cartinfo";
		} else {
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/cartinfo")
	public String cartinfo(HttpSession session, Model model) {
		//로그인 상태 확인
		String m_id = (String)session.getAttribute("m_id");
		String m_name = (String)session.getAttribute("m_name");
		if (m_id != null) {
		//세션아이디를 이용해서 cm_code를 조회해야함
			CartmainVO cartmain = new CartmainVO();
			cartmain.setM_id(m_id);
			cartmain = cartservice.readmainid(cartmain);
			if (cartmain != null) {
				//cartservice.getListCart(cartmain).forEach(cartsub -> log.info(cartsub));
				
				model.addAttribute("list", cartservice.getListCartDetail(cartmain));
				
				CartmemberDTO carttotal = cartservice.getCartTotal(cartmain);
				carttotal.setCm_code(cartmain.getCm_code());
				carttotal.setM_id(m_id);
				carttotal.setM_name(m_name);
				model.addAttribute("carttotal", carttotal);
				model.addAttribute("cm_code", cartmain.getCm_code());	// cm_code 전달 목적(장바구니 세부항목 삭제시 필요)
				
				log.info("장바구니에 물건이 있습니다.");
			} else {
				log.info("장바구니가 비어있습니다.");
			}
		//cm_code를 이용해서 getListCart 를 조회해서 리스트 출력
			log.info("로그인상태");
			return "/shop/cartinfo";	// cartinfo 페이지로 이동(반드시 작성)
		} else {
			log.info("로그아웃상태");
			return "redirect:/member/login";	// redirect 사용 시 컨트롤러(컨트롤러를 확인해야함)의 메서드를 호출 후에 jsp로 이동
												// redirect 생략 시 jsp페이지로 바로 이동
		}
	}
		
		@PostMapping("/cartupdate")
		public String cartupdate(CartsubVO cartsub) {
			cartservice.updatesub(cartsub);
			return "redirect:/shop/cartinfo";
			
		}
		
		@GetMapping("/cartdelete")
		public String cartdelete(CartsubVO cartsub) {
			cartservice.deletesub(cartsub);
			return "redirect:/shop/cartinfo";
		}
		
		@GetMapping("/cartdeleteall")
		public String cartdeleteall(CartmainVO cartmain) {
			cartservice.deletesuball(cartmain);
			return "redirect:/shop/cartinfo";
		}
		
		@GetMapping("/orderinfo")
		public String orderinfo(HttpSession session, CartmainVO cartmain, Model model) {
			String m_id = (String)session.getAttribute("m_id");
			String m_name = (String)session.getAttribute("m_name");
			if (m_id != null) {
				cartmain.setM_id(m_id);
				OrdermainVO ordermain = orderservice.orderproc(cartmain); // om_code 획득
				log.info(ordermain);
				model.addAttribute("list", orderservice.getListOrderDetail(ordermain));
				
				OrdermemberDTO ordertotal = orderservice.getOrderTotal(ordermain);
				log.info(ordertotal);
				ordertotal.setOm_code(ordermain.getOm_code());
				ordertotal.setM_id(m_id);
				model.addAttribute("ordertotal", ordertotal);
				model.addAttribute("om_code", ordermain.getOm_code());
			
				return "/shop/orderinfo";
			} else {
				return "/member/login";
			}
		}
		
		@GetMapping("/orderlist")
		public String orderlist(HttpSession session, Model model, OrderlistDTO orderlist) {
			String m_id = (String)session.getAttribute("m_id");
			if (m_id != null) {
				orderlist.setM_id(m_id);
				model.addAttribute("list", orderservice.getListOrderList(orderlist));
				
				return "/shop/orderlist";
			} else {
				return "/member/login";
			}
		
	}
}
