package com.it.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.ProductVO;
import com.it.service.ProductService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/product/")
public class ProductController {
	@Setter(onMethod_ = @Autowired)
	private ProductService service;

	@GetMapping("/list")
	public void list(Model model) { // Controller에서 VO객체를 저장해서 jsp 파일로 전송 (반드시선언, 쓰던 안쓰던 상관없음)
		// list.jsp 에 데이터를 전달해야 함
		model.addAttribute("list", service.getList()); // getList로 조회한 모든 내용을 list변수로 전달
	}

	@GetMapping("/insert")
	public void insert() {

	}

	@PostMapping("/insert")
	public String insert(ProductVO product) {
//		log.info(product);
		service.insert(product);
		return "redirect:/product/list";
	}

	@GetMapping("/view")
	public void view(ProductVO product, Model model) {
		log.info(product);
		product = service.read(product);
		model.addAttribute("product", product);
	}

	@GetMapping("/imgupload")
	public void imgupload(ProductVO product, Model model) {
		log.info(product);
		model.addAttribute("p_code", product.getP_code());
	}

	@PostMapping("imgupload")
	public void imgupload(HttpServletRequest request) {
		DiskFileUpload upload = new DiskFileUpload();	 // 데이터전송컴포넌트객체 생성
		try {
			List items = upload.parseRequest(request); 	// 웹브라우저전송객체 생성해서 업로드컴포넌트에 전달
			Iterator params = items.iterator();			// 반복자 생성
			String imgpath = "C:\\myWorkSpace\\learnJsp\\MySpring\\src\\main\\webapp\\resources\\product";
			String p_code = "";
			//log.info(items.size());
			while (params.hasNext()) {	// form 객체가 있을 경우 , 값이 없더라도 있다고 간주하고 반복 foreach는 값이 없으면 거기서 끝남
				FileItem item = (FileItem)params.next();	// 폼 형식 객체를 변수에 저장
				if (item.isFormField()) {	// 파일형식이 아니라면
					p_code = item.getString();	// 파일보다 먼저 반환됨
				} else {	// 바이너리 이라면
					File imgfile = new File(imgpath + "/" + p_code + ".jpg");	// 파일객체 생성
					item.write(imgfile); // 해당 경로에 파일 저장
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
