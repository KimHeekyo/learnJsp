package com.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.AdminVO;
import com.it.service.AdminService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/")
public class AdminController {
	@Setter(onMethod_ = @Autowired)
	private AdminService service;
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(AdminVO admin, HttpSession session) {
		log.info(admin);
		boolean chk = service.auth(admin);
		if (chk == true) {
			//admin = service.read(admin);	// 아이디와 패스워드가 담겨있음 auth엔 이미 id 값이 담겨있으므로 name을 지워서 필요없음
			session.setAttribute("a_id", admin.getA_id()); // 세션변수 생성
			//session.setAttribute("a_name", admin.getA_name()); // 관리자이므로 굳이 필요 없음
			log.info("인증성공");
			return "redirect:/shop/list";
		} else {
			log.info("인증실패");
			return "redirect:/admin/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	// 세션 끊기, 관련된 모든 변수 삭제
		return "redirect:/";
	}

}
