package com.it.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.NoticeVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	private NoticeService service;
	
	//@Test
	public void testRead() {
		NoticeVO notice = new NoticeVO();
		notice.setN_num(2);
		notice = service.read(notice);
		log.info(notice);
	}
	
	//@Test
	public void testGetList() {
		service.getList().forEach(notice->log.info(notice));
	}
	
	//@Test
	public void testInsert() {
		NoticeVO notice = new NoticeVO();
		notice.setN_subject("(^///^)");
		notice.setN_name("o(*￣▽￣*)ブ");
		notice.setN_contents("(❁´◡`❁)");
		service.insert(notice);
		log.info(notice);
	}
	
	//@Test
	public void testUpdate() {
		NoticeVO notice = new NoticeVO();
		notice.setN_num(2);
		notice.setN_subject("혼자만들기 수정");
		notice.setN_name("김희교 수정");
		notice.setN_contents("혼자 생성한 notice 테이블 수정");
		service.update(notice);
		log.info(notice);
	}
	
	//@Test
	public void testDelete() {
		NoticeVO notice = new NoticeVO();
		notice.setN_num(2);
		service.delete(notice);
		log.info(notice);
	}


}
