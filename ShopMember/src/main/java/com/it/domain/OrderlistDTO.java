package com.it.domain;

import lombok.Data;

@Data
public class OrderlistDTO {
	private String m_id;
	private int om_code;
	private int os_code;
	private int p_code;
	private String p_name;
	private String p_image;
	private int p_price;
	private int os_cnt;
	private int os_money;
}
