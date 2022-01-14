package com.it.mapper;

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
public class NoticeMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private NoticeMapper mapper;
	
	//@Test
	public void testgetList() {
		mapper.getList().forEach(notice -> log.info(notice));
	}
	
	//@Test
	public void testInsert() {
		NoticeVO notice = new NoticeVO();
		notice.setN_subject("성공했나요?");
		notice.setN_name("김희교");
		notice.setN_contents("혼자 생성한 notice 테이블 성공했나요?");
		mapper.insert(notice);
		//log.info(notice);
	}
	
	

}
