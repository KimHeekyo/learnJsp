package com.it.domain;

import lombok.Data;

@Data
public class PageDTO {
	private int pageNum;	// 현재 페이지
	private int pageAmount;	// 한 화면에 보여지는 레코드의 양
	
	public PageDTO() {	// xml에서 #는 문자열처리만 되지만 $은 연산처리도 가능하다.(하지만 보안상의 이유로 권장하지 않음)
		this(1,10);
	}
	
	public PageDTO(int pageNum, int pageAmount) {	// 아무것도없이 넘기는 것을 처리 가능하기 위함
		this.pageNum = pageNum;
		this.pageAmount = pageAmount;
	}
	
	
}
