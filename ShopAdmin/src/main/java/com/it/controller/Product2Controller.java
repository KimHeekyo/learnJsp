package com.it.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.PageDTO;
import com.it.domain.Product2VO;
import com.it.service.Product2Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/product2/")
public class Product2Controller {
	@Setter(onMethod_ = @Autowired)
	private Product2Service service;
	
	@GetMapping("/list")
	public String list(Model model, HttpSession session) { // Controller에서 VO객체를 저장해서 jsp 파일로 전송 (반드시선언, 쓰던 안쓰던 상관없음)
		String a_id = (String)session.getAttribute("a_id");
		model.addAttribute("a_id", a_id);
		// list.jsp 에 데이터를 전달해야 함
		model.addAttribute("list", service.getList()); // getList로 조회한 모든 내용을 list변수로 전달
		return "product2/list";
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request) {
		DiskFileUpload upload = new DiskFileUpload();	 // 데이터전송컴포넌트객체 생성
		try {
			List items = upload.parseRequest(request); 	// 웹브라우저전송객체 생성해서 업로드컴포넌트에 전달
			
			Iterator params = items.iterator();			// 반복자 생성
			String filepath = "C:\\myWorkSpace\\learnJsp\\ShopAdmin\\src\\main\\webapp\\resources\\product2";
			//log.info(items.size());
			Product2VO product = new Product2VO();
			while (params.hasNext()) {	// form 객체가 있을 경우 , 값이 없더라도 있다고 간주하고 반복 foreach는 값이 없으면 거기서 끝남
				FileItem item = (FileItem)params.next();	// 폼 형식 객체를 변수에 저장
				if (item.isFormField()) {	// 파일형식이 아니라면
					// p_code = item.getString();	// 파일보다 먼저 반환됨
					String fieldname = item.getFieldName();	// FieldName은 insert.jsp의 name
					String fieldvalue = item.getString("utf-8");	// utf-8이 있어야 한글 깨짐 현상이 일어나지 않는다.
					// log.info(fieldname + ":" + fieldvalue);
					
					if (fieldname.equals("p_name")) {
						product.setP_name(fieldvalue);
					} else if (fieldname.equals("p_price")) {
						Integer price = Integer.parseInt(fieldvalue);
						product.setP_price(price);
					}
				} else {	// 바이너리 파일이라면
					String fname = item.getName();
					// log.info(fname);
					if (fname != "") {
						product.setP_image(fname);
						File file = new File(filepath + "/" + fname);	// 파일객체 생성
						item.write(file); // 해당 경로에 파일 저장
					}
				}
			}
			log.info(product);
			service.insert(product);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/product2/list";
	}

	@GetMapping("/view")
	public void view(Product2VO product, Model model) {
		product = service.read(product);
		log.info(product);
		model.addAttribute("product", product);
	}
	
	@GetMapping("/update")
	public void update(Product2VO product, Model model, PageDTO page) {
		product = service.read(product);
		model.addAttribute("product", product);
		model.addAttribute("page", page);
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, PageDTO page) {
		DiskFileUpload upload = new DiskFileUpload();	 // 데이터전송컴포넌트객체 생성
		Product2VO product = new Product2VO();
		try {
			List items = upload.parseRequest(request); 	// 웹브라우저전송객체 생성해서 업로드컴포넌트에 전달
			Iterator params = items.iterator();			// 반복자 생성
			String filepath = "C:\\myWorkSpace\\learnJsp\\ShopAdmin\\src\\main\\webapp\\resources\\product2";
			//log.info(items.size());
			while (params.hasNext()) {	// form 객체가 있을 경우 , 값이 없더라도 있다고 간주하고 반복 foreach는 값이 없으면 거기서 끝남
				FileItem item = (FileItem)params.next();	// 폼 형식 객체를 변수에 저장
				if (item.isFormField()) {	// 파일형식이 아니라면
					// p_code = item.getString();	// 파일보다 먼저 반환됨
					String fieldname = item.getFieldName();	// FieldName은 insert.jsp의 name
					String fieldvalue = item.getString("utf-8");	// utf-8이 있어야 한글 깨짐 현상이 일어나지 않는다.
					// log.info(fieldname + ":" + fieldvalue);
					if (fieldname.equals("p_name")) {
						product.setP_name(fieldvalue);
					} else if (fieldname.equals("p_price")) {
						Integer price = Integer.parseInt(fieldvalue);
						product.setP_price(price);
					} else if (fieldname.equals("p_code")) {
						Integer code = Integer.parseInt(fieldvalue);
						product.setP_code(code);
					} else if (fieldname.equals("p_image")) {
						product.setP_image(fieldvalue);
					}
				} else {	// 바이너리 파일이라면
					String fname = item.getName();
					// log.info(fname);
					if (fname != "") {
						product.setP_image(fname);
						File file = new File(filepath + "/" + fname);	// 파일객체 생성
						item.write(file); // 해당 경로에 파일 저장
					}
				}
			}
			log.info(product);
			service.update(product);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/product2/view?p_code=" + product.getP_code() + "&pageNum=" + page.getPageNum();
	}
	
	@GetMapping("/delete")
	public String delete(Product2VO product) {
		service.delete(product);
		return "redirect:/product2/list";
	}


}
