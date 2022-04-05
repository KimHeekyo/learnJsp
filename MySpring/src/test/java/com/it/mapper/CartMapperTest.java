package com.it.mapper;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.CartdetailDTO;
import com.it.domain.CartmainVO;
import com.it.domain.CartmemberDTO;
import com.it.domain.CartsubVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CartMapperTest {
	@Setter(onMethod_ = @Autowired)
	private CartMapper mapper;
	
	//@Test
	public void testInsertMain() {
		CartmainVO cartmain = new CartmainVO();
		cartmain.setM_id("tiger");
		mapper.insertmain(cartmain);
		log.info(cartmain);
	}
	
	//@Test
	public void testInsertSub() {
		CartsubVO cartsub = new CartsubVO();
		cartsub.setCm_code(1003);
		cartsub.setP_code(1005);
		cartsub.setCs_cnt(2);
		mapper.insertsub(cartsub);
		log.info(cartsub);
		cartsub.setCm_code(1003);
		cartsub.setP_code(1009);
		cartsub.setCs_cnt(5);
		mapper.insertsub(cartsub);
		log.info(cartsub);
	}
	
	//@Test
	public void testDeleteSub() {
		CartsubVO cartsub = new CartsubVO();
		cartsub.setCs_code(1005);
		mapper.deletesub(cartsub);
		cartsub.setCs_code(1006);
		mapper.deletesub(cartsub);
	}
	
	//@Test
	public void testDeleteMain() {
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(1003);
		mapper.deletemain(cartmain);
	}
	
	//@Test
	public void testCartdetailTest() {
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(1004);
		List<CartdetailDTO> cartdetail = mapper.getListCartDetail(cartmain);
		cartdetail.forEach(cd -> log.info(cd));
	}
	
	//@Test
	public void testCartTotal() {
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(1004);
		CartmemberDTO cartmember = mapper.getCartTotal(cartmain);
		log.info(cartmember);
	}

}
