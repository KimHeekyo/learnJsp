package com.it.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	//@Test
	public void testRead() {
		BoardVO board = new BoardVO();
		board.setB_num(3);
		board = service.read(board);
		log.info(board);
	}
	
	//@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
	}
	
	//@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setB_subject("게시판입력테스트");
		board.setB_name("홍길동");
		board.setB_contents("테스트입니다");
		service.insert(board);
		log.info(board);
	}
	
	//@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setB_num(2);
		board.setB_subject("게시판입력테스트수정");
		board.setB_name("홍길동수정");
		board.setB_contents("테스트입니다수정");
		service.update(board);
		log.info(board);
	}
	
	//@Test
	public void testDelete() {
		BoardVO board = new BoardVO();
		board.setB_num(2);
		service.delete(board);
		log.info(board);
	}

}
