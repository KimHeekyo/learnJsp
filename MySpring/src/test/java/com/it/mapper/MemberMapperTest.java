package com.it.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	//@Test
	public void testGetList() {
		mapper.getList().forEach(member -> log.info(member)); // 레코드만큼 반복하는 람다식
	}
	
	//@Test
	public void testInsert() {
		MemberVO member = new MemberVO();
		member.setM_id("icecream");
		member.setM_passwd("icecream");
		member.setM_name("아이스크림");
		mapper.insert(member);
		//log.info(member);
	}
	
	//@Test
	public void testRead() {
		MemberVO member = new MemberVO();
		member.setM_id("icecream");
		member = mapper.read(member);
		log.info(member);
	}
	
	//@Test
	public void testUpdate() {
		MemberVO member = new MemberVO();
		member.setM_id("icecream1");
		member.setM_passwd("icecream1");
		member.setM_name("아이스크림1");
		mapper.update(member);
		log.info(member);
	}
	
	//@Test
	public void testDelete() {
		MemberVO member = new MemberVO();
		member.setM_id("icecream");
		mapper.delete(member);
	}

}
