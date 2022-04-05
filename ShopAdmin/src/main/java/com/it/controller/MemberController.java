package com.it.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.MemberVO;
import com.it.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/")
public class MemberController {
	@Setter(onMethod_ = @Autowired)
	private MemberService service;

	@GetMapping("/list")
	public String list(Model model, HttpSession session) { // Controller에서 VO객체를 저장해서 jsp 파일로 전송 (반드시선언, 쓰던 안쓰던 상관없음)
		String a_id = (String) session.getAttribute("a_id");
		model.addAttribute("a_id", a_id);
		// list.jsp 에 데이터를 전달해야 함
		model.addAttribute("list", service.getList()); // getList로 조회한 모든 내용을 list변수로 전달
		return "member/list";
	}

	@GetMapping("/insert")
	public void insert() {
		// 페이지를 호출만 함
	}

	@PostMapping("/insert")
	public String insert(MemberVO member) {
		log.info("--------------회원추가 시작--------------");
		log.info(member);
		// 테이블에 입력
		service.insert(member);
		// 리스트로 이동(return 사용)
		log.info("--------------회원추가 완료--------------");

		return "redirect:/member/list"; // controller 를 통해서 이동
	}

	@GetMapping("/view")
	public String view(MemberVO member, Model model, HttpSession session) {
		String a_id = (String) session.getAttribute("a_id");
		if (a_id != null) {
			// 보여주고 멈추는 목적이면 void 페이지가 넘어가면 String
			log.info("--------------읽기 전--------------");
			log.info(member);
			member = service.read(member);
			log.info("--------------읽은 후--------------");
			log.info(member);
			model.addAttribute("member", member);
			// 앞은 사용할 이름을 정해줘도 되고 뒤에는 가져온 것과 같은 이름을 사용, board를 51열에서 가져왔다.
			return "/member/view";
		} else {
			return "redirect:/admin/login";
		}
	}

	@GetMapping("/update")
	public void update(MemberVO member, Model model) {
		log.info("--------------업데이트를 위한 번호--------------");
		log.info(member);
		member = service.read(member); // 아이디만 사용하여 조회
		log.info("--------------업데이트를 위한 데이터--------------");
		log.info(member);
		model.addAttribute("member", member);
	}

	@PostMapping("/update")
	public String update(MemberVO member) {
		log.info("--------------업데이트 데이터--------------");
		log.info(member);
		service.update(member);

		return "redirect:/member/view?m_id=" + member.getM_id();
	}

	@GetMapping("/delete")
	public String delete(MemberVO member) {
		log.info("--------------삭제--------------");
		service.delete(member);
		return "redirect:/member/list";
	}

//	------------------------- 로그인 -----------------------------
	@GetMapping("/login")
	public void login() {
//		로그인 페이지 호출
	}

	@PostMapping("/login")
	public void login(MemberVO member, HttpSession session) {
		log.info(member);
		boolean chk = service.auth(member);
		if (chk == true) {
			member = service.read(member); // 아이디와 패스워드가 담겨있음
			session.setAttribute("m_id", member.getM_id()); // 세션변수 생성
			session.setAttribute("m_name", member.getM_name()); // 세션변수 생성
			log.info("인증성공");
		} else {
			log.info("인증실패");
		}
	}

//	로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 끊기, 관련된 모든 변수 삭제
		return "redirect:/";
	}

}
