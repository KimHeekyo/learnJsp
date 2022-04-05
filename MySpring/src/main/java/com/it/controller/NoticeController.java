package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.NoticeVO;
import com.it.domain.PageDTO;
import com.it.domain.PageViewDTO;
import com.it.service.NoticeService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/notice/")
public class NoticeController {
	
	@Setter(onMethod_ = @Autowired)
	private NoticeService service;
	
	@GetMapping("/list")
	public void list(Model model, PageDTO page) {
		model.addAttribute("list", service.getList(page));
		int total = service.getTotalCount();
		PageViewDTO pageview = new PageViewDTO(page, total);
		model.addAttribute("pageview", pageview);
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	@PostMapping("/insert")
	public String insert(NoticeVO notice) {
		log.info("---글작성---");
		log.info(notice);
		service.insert(notice);
		log.info("---글작성종료---");
		return "redirect:/notice/list";
	}
	
	@GetMapping("/view")
	public void view(NoticeVO notice, Model model, PageDTO page) {
		log.info("---읽기전---");
		log.info(notice);
		notice = service.read(notice);
		log.info("---읽은후---");
		model.addAttribute("notice", notice);
		model.addAttribute("page", page);
	}
	
	@GetMapping("/update")
	public void update(NoticeVO notice, Model model, PageDTO page) {
		log.info("---수정번호---");
		log.info(notice);
		notice = service.read(notice);
		log.info("---수정데이터---");
		log.info(notice);
		model.addAttribute("notice", notice);
		model.addAttribute("page", page);
	}
	
	@PostMapping("/update")
	public String update(NoticeVO notice, PageDTO page) {
		log.info("---수정전---");
		log.info(notice);
		service.update(notice);
		return "redirect:/notice/view?n_num=" + notice.getN_num() + "&pageNum=" + page.getPageNum();
	}
	
	@GetMapping("/delete")
	public String delete(NoticeVO notice) {
		service.delete(notice);
		return "redirect:/notice/list";
	}
}
