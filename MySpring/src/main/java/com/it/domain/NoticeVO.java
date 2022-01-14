package com.it.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	
	public int n_num;
	public String n_subject;
	public String n_name;
	public String n_contents;
	public Date n_date;

}
