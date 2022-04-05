package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.BoardVO;
import com.it.domain.PageDTO;
import com.it.domain.PageViewDTO;
import com.it.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/")
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model, PageDTO page /*@RequestParam("user") String user, @RequestParam("age") int age*/) {
		// Controller에서 VO객체를 저장해서 jsp 파일로 전송 (반드시선언, 쓰던 안쓰던 상관없음)
		// list.jsp 에 데이터를 전달해야 함
		// 객체를 만들지않고 단순하게 값을 전달하려고 할 때 @RequestParam을 사용(확실한 처리가 가능할 때만 사용, 꼭 써야하는 경우는 거의 없고 객체를 만들어놨는데 또 만들지 않기 위해 사용)
		model.addAttribute("list", service.getList(page));	// getList로 조회한 모든 내용을 list변수로 전달
		int total = service.getTotalCount();	// 전체 레코드 갯수
		PageViewDTO pageview = new PageViewDTO(page, total);
		log.info(page);
		log.info(pageview);
		model.addAttribute("pageview", pageview);
		log.info("여기--------------------------------------");
		//log.info(user);
		//log.info(age + 1);
		//model.addAttribute("user", user);
		//model.addAttribute("age", age);
	}
	
	@GetMapping("/insert")
	public void insert() {
		// 페이지를 호출만 함
	}
	
	@PostMapping("/insert")
	public String insert(BoardVO board) {
		log.info("--------------글쓰기 시작--------------");
		log.info(board);
		// 테이블에 입력
		service.insert(board);
		// 리스트로 이동(return 사용)
		log.info("--------------글쓰기 완료--------------");
		
		return "redirect:/board/list";	// controller 를 통해서 이동
	}
	
	@GetMapping("/view")
	public void view(BoardVO board, Model model, PageDTO page) {
		// 보여주고 멈추는 목적이면 void 페이지가 넘어가면 String
		log.info("--------------읽기 전--------------");
		log.info(board);
		board = service.read(board);
		log.info("--------------읽은 후--------------");
		log.info(board);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		// 앞은 사용할 이름을 정해줘도 되고 뒤에는 가져온 것과 같은 이름을 사용, board를 51열에서 가져왔다.
	}
	
	@GetMapping("/update")
	public void update(BoardVO board, Model model, PageDTO page) {
		log.info("--------------업데이트를 위한 번호--------------");
		log.info(board);
		board = service.read(board);	// 번호만 사용하여 조회
		log.info("--------------업데이트를 위한 데이터--------------");
		log.info(board);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
	}
	
	@PostMapping("/update")
	public String update(BoardVO board, PageDTO page) {
		log.info("--------------업데이트 데이터--------------");
		log.info(board);
		service.update(board); // 업데이트
		return "redirect:/board/view?b_num=" + board.getB_num() + "&pageNum=" + page.getPageNum();
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO board) {
		log.info("--------------삭제--------------");
		service.delete(board);
		return "redirect:/board/list";
	}

}
