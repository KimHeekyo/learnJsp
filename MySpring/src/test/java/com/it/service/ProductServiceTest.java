package com.it.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.domain.ProductVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductServiceTest {
	@Setter(onMethod_ = @Autowired)
	private ProductService service;

	//@Test
	public void testRead() {
		ProductVO product = new ProductVO();
		product.setP_code(1008);
		product = service.read(product);
		log.info(product);
	}

	// @Test
	public void testGetList() {
		service.getList().forEach(product -> log.info(product));
	}

	// @Test
	public void testInsert() {
		ProductVO product = new ProductVO();
		product.setP_name("건조기");
		product.setP_price(800000);
		service.insert(product);
		log.info(product);
	}

	// @Test
	public void testUpdate() {
		ProductVO product = new ProductVO();
		product.setP_code(1006);
		product.setP_name("건조기");
		product.setP_price(900000);
		service.update(product);
		log.info(product);
	}

	// @Test
	public void testDelete() {
		ProductVO product = new ProductVO();
		product.setP_code(1005);
		service.delete(product);
		log.info(product);
	}

}
