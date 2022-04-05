package com.it.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.domain.Board2VO;
import com.it.domain.PageDTO;
import com.it.domain.PageViewDTO;
import com.it.service.Board2Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board2/")
public class Board2Controller {

	@Setter(onMethod_ = @Autowired)
	private Board2Service service;

	@GetMapping("/list")
	public void list(Model model, PageDTO page /* @RequestParam("user") String user, @RequestParam("age") int age */) {
		// Controller에서 VO객체를 저장해서 jsp 파일로 전송 (반드시선언, 쓰던 안쓰던 상관없음)
		// list.jsp 에 데이터를 전달해야 함
		// 객체를 만들지않고 단순하게 값을 전달하려고 할 때 @RequestParam을 사용(확실한 처리가 가능할 때만 사용, 꼭 써야하는 경우는
		// 거의 없고 객체를 만들어놨는데 또 만들지 않기 위해 사용)
		model.addAttribute("list", service.getList(page)); // getList로 조회한 모든 내용을 list변수로 전달
		int total = service.getTotalCount(); // 전체 레코드 갯수
		PageViewDTO pageview = new PageViewDTO(page, total);
		model.addAttribute("pageview", pageview);
	}

	@GetMapping("/insert")
	public void insert() {
		// 페이지를 호출만 함
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, HttpSession session, Model model) {
		String m_id = (String) session.getAttribute("m_id");
		model.addAttribute("m_id", m_id);
		if (m_id != null) {
			DiskFileUpload upload = new DiskFileUpload(); // 데이터전송컴포넌트객체 생성
			try {
				List items = upload.parseRequest(request); // 웹브라우저전송객체 생성해서 업로드컴포넌트에 전달

				Iterator params = items.iterator(); // 반복자 생성
				String filepath = "C:\\myWorkSpace\\learnJsp\\pds";
				// log.info(items.size());
				Board2VO board = new Board2VO();
				while (params.hasNext()) { // form 객체가 있을 경우 , 값이 없더라도 있다고 간주하고 반복 foreach는 값이 없으면 거기서 끝남
					FileItem item = (FileItem) params.next(); // 폼 형식 객체를 변수에 저장
					if (item.isFormField()) { // 파일형식이 아니라면
						// p_code = item.getString(); // 파일보다 먼저 반환됨
						String fieldname = item.getFieldName(); // FieldName은 insert.jsp의 name
						String fieldvalue = item.getString("utf-8"); // utf-8이 있어야 한글 깨짐 현상이 일어나지 않는다.
						// log.info(fieldname + ":" + fieldvalue);
						if (fieldname.equals("b_subject")) {
							board.setB_subject(fieldvalue);
						} else if (fieldname.equals("b_name")) {
							board.setB_name(fieldvalue);
						} else if (fieldname.equals("b_contents")) {
							board.setB_contents(fieldvalue);
						}
					} else { // 바이너리 파일이라면
						String fname = item.getName();
						// log.info(fname);
						if (fname != "") {
							board.setB_file(fname);
							File file = new File(filepath + "/" + fname); // 파일객체 생성
							item.write(file); // 해당 경로에 파일 저장
						}

					}
				}
				log.info(board);
				service.insert(board);

			} catch (Exception e) {
				System.out.println(e);
			}
			return "redirect:/board2/list";
		} else {
			return "redirect:/member/login";
		}
	}

	@GetMapping("/view")
	public void view(Board2VO board, Model model, PageDTO page) {
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

	@GetMapping("/download")
	public void download(Board2VO board, HttpServletResponse response) {
		try {
			board = service.read(board); // b_num을 이용해서 해당 레코드 정보 반환
			String filepath = "C:\\myWorkSpace\\learnJsp\\pds\\" + board.getB_file();
			File file = new File(filepath + "\\" + board.getB_file());

			String newName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"); // 파일한글깨짐방지처리
			response.setHeader("Content-Disposition", "attachment;filename=" + newName);
			log.info(file.getName());
			// 웹페이지가 아닌 파일객체를 클라이언트에 전송한다는 지시어(헤더)
			// 기본값은 text/html
			// 클라이언트 웹브라우저에 파일다운로드 처리됨

			FileInputStream fis = new FileInputStream(filepath);
			OutputStream out = response.getOutputStream();

			int read = 0; // 1024 단위로 읽은 바이트 수
			byte[] buffer = new byte[1024]; // 임의로 조정 가능
			while ((read = fis.read(buffer)) != -1) { // 끝에 도달했을 경우 -1 반환
				out.write(buffer, 0, read); // 웹브라우저에 출력
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@GetMapping("/update")
	public void update(Board2VO board, Model model, PageDTO page) {
		log.info("--------------업데이트를 위한 번호--------------");
		log.info(board);
		board = service.read(board); // 번호만 사용하여 조회
		log.info("--------------업데이트를 위한 데이터--------------");
		log.info(board);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
	}

	@PostMapping("/update")
	public String update(Board2VO board, PageDTO page) {
		log.info("--------------업데이트 데이터--------------");
		log.info(board);
		service.update(board); // 업데이트
		return "redirect:/board2/view?b_num=" + board.getB_num() + "&pageNum=" + page.getPageNum();
	}

//	@PostMapping("/update")
//	public String update(HttpServletRequest request, PageDTO page) {
//		DiskFileUpload upload = new DiskFileUpload();	 // 데이터전송컴포넌트객체 생성
//		Board2VO board = new Board2VO();
//		try {
//			List items = upload.parseRequest(request); 	// 웹브라우저전송객체 생성해서 업로드컴포넌트에 전달
//			
//			Iterator params = items.iterator();			// 반복자 생성
//			String filepath = "C:\\myWorkSpace\\learnJsp\\pds";
//			//log.info(items.size());
//			while (params.hasNext()) {	// form 객체가 있을 경우 , 값이 없더라도 있다고 간주하고 반복 foreach는 값이 없으면 거기서 끝남
//				FileItem item = (FileItem)params.next();	// 폼 형식 객체를 변수에 저장
//				if (item.isFormField()) {	// 파일형식이 아니라면
//					// p_code = item.getString();	// 파일보다 먼저 반환됨
//					String fieldname = item.getFieldName();	// FieldName은 insert.jsp의 name
//					String fieldvalue = item.getString("utf-8");	// utf-8이 있어야 한글 깨짐 현상이 일어나지 않는다.
//					// log.info(fieldname + ":" + fieldvalue);
//					
//					int fv = Integer.parseInt(fieldvalue);
//					log.info("----------------------------");
//					log.info(fv);
//					
//					if (fieldname.equals("b_subject")) {
//						board.setB_subject(fieldvalue);
//					} else if (fieldname.equals("b_name")) {
//						board.setB_name(fieldvalue);
//					} else if (fieldname.equals("b_contents")) {
//						board.setB_contents(fieldvalue);
//					} 	
//										
//				} else {	// 바이너리 파일이라면
//					String fname = item.getName();
//					// log.info(fname);
//					if (fname != "") {
//						board.setB_file(fname);
//						File file = new File(filepath + "/" + fname);	// 파일객체 생성
//						item.write(file); // 해당 경로에 파일 저장
//					}
//					
//				}
//			}
//			log.info(board);
//			service.update(board);
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return "redirect:/board2/view?b_num=" + board.getB_num() + "&pageNum=" + page.getPageNum();
//	}

	@GetMapping("/delete")
	public String delete(Board2VO board) {
		log.info("--------------삭제--------------");
		service.delete(board);
		return "redirect:/board2/list";
	}
}
