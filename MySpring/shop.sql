/* 쇼핑몰 구현 */
use webjava;

/*
데이터베이스 생성
create database webjava default character set utf8;
데이터베이스 오픈

show databases;
use webjava;
유저 생성 및 암호 지정
grant all privileges on webjava.* to javauser@localhost identified by 'webjava';
*/

/* tblboard 테이블 */
create table tblboard (
 b_num int not null primary key AUTO_INCREMENT,
 b_subject varchar(100) not null,
 b_contents varchar(2000) not null,
 b_name varchar(50) not null,
 b_date datetime not null default sysdate()
);

select * from tblboard;
INSERT INTO tblboard (b_subject, b_name, b_contents) VALUES ('제목이다','홍길동','jsp프로그래밍');

/* tblnotice 테이블 */
create table tblnotice (
 n_num int not null primary key AUTO_INCREMENT,
 n_subject varchar(100) not null,
 n_contents varchar(2000) not null,
 n_name varchar(50) not null,
 n_date datetime not null default sysdate()
);

select * from tblnotice;
INSERT INTO tblnotice (n_subject, n_name, n_contents) VALUES ('제목이다','홍길동','jsp프로그래밍');

/* 고객테이블 */
create table tblmember (
	m_id varchar(50) not null primary key, -- 아이디
	m_passwd varchar(50) not null,	-- 비밀번호
	m_name varchar(50) not null, -- 성명
	m_rdate datetime not null default sysdate(),
	m_udate datetime not null default sysdate()
);

/* 상품 테이블 */
create table tblproduct (
	p_code int not null primary key auto_increment,
	p_name varchar(100) not null,
	p_price int not null,
	p_rdate datetime not null default sysdate(),
	p_udate datetime not null default sysdate()
);
alter table tblproduct auto_increment=1001; -- 자릿수를 고정시켜주기 위함


/* 장바구니 main */
create table tblcartmain (
	cm_code int not null primary key auto_increment,
	m_id varchar(50) not null,
	cm_rdate datetime not null default sysdate(),
	cm_udate datetime not null default sysdate(),
	foreign key (m_id) references tblmember(m_id)
);
alter table tblcartmain auto_increment=1001;


/* 장바구니 sub */
create table tblcartsub (
	cs_code int not null primary key auto_increment,
	cm_code int not null, -- foreignkey
	p_code int not null, -- foreignkey
	cs_cnt int not null, -- 수량
	cs_rdate datetime not null default sysdate(),
	cs_udate datetime not null default sysdate(),
	foreign key (cm_code) references tblcartmain(cm_code),
	foreign key (p_code) references tblproduct(p_code)
);
alter table tblcartsub auto_increment=1001;


/* 주문 main */
create table tblordermain (
	om_code int not null primary key auto_increment,
	m_id varchar(50) not null, -- foreignkey
	om_rdate datetime not null default sysdate(),
	om_udate datetime not null default sysdate(),
	foreign key (m_id) references tblmember(m_id)
);
alter table tblordermain auto_increment=1001;


/* 주문 sub */
create table tblordersub (
	os_code int not null primary key auto_increment,
	om_code int not null,
	p_code int not null,
	os_cnt int not null,
	os_rdate datetime not null default sysdate(),
	os_udate datetime not null default sysdate(),
	foreign key (om_code) references tblordermain(om_code),
	foreign key (p_code) references tblproduct(p_code)
);
alter table tblordersub auto_increment=1001;

/* 전체 테이블 삭제 */
--drop table tblordersub;
--drop table tblordermain;
--drop table tblcartsub;
--drop table tblcartmain;
--drop table tblproduct;
--drop table tblmember;

insert into tblmember (m_id, m_name, m_passwd) values ('tiger', '홍길동', '1234');
insert into tblmember (m_id, m_name, m_passwd) values ('lion', '김삿갓', '1234');
select * from tblmember;

insert into tblproduct (p_name, p_price) values ('삼성냉장고200리터', 1000000);
insert into tblproduct (p_name, p_price) values ('엘지세탁기10리터', 800000);
insert into tblproduct (p_name, p_price) values ('농심새우깡', 2000);
insert into tblproduct (p_name, p_price) values ('롯데콘칩', 1000);
select * from tblproduct;

insert into tblcartmain (m_id) values ('tiger');
insert into tblcartmain (m_id) values ('lion');
select * from tblcartmain;

insert into tblcartsub (cm_code, p_code, cs_cnt) values (1001, 1001, 1);
insert into tblcartsub (cm_code, p_code, cs_cnt) values (1001, 1003, 5);
insert into tblcartsub (cm_code, p_code, cs_cnt) values (1002, 1002, 1);
insert into tblcartsub (cm_code, p_code, cs_cnt) values (1002, 1004, 3);

select * from tblcartsub;

/* tiger의 장바구니 내역을 조회 */
select cm.cm_code, cm.m_id, m.m_name, cs.p_code, p.p_name,
		p.p_price, cs.cs_cnt, p.p_price * cs.cs_cnt
	from tblcartmain cm, tblcartsub cs, tblproduct p, tblmember m
	where cm.cm_code = cs.cm_code
		and p.p_code = cs.p_code
		and m.m_id = cm.m_id
		and cm.m_id = 'tiger';
		
-- lion의 장바구니 내역 조회		
select cm.cm_code, cm.m_id, m.m_name, cs.p_code, p.p_name,
		p.p_price, cs.cs_cnt, p.p_price * cs.cs_cnt
	from tblcartmain cm, tblcartsub cs, tblproduct p, tblmember m
	where cm.cm_code = cs.cm_code
		and p.p_code = cs.p_code
		and m.m_id = cm.m_id
		and cm.m_id = 'lion';

/* tiger의 장바구니 합계 */
-- select sum(p_price) from tblproduct; 테이블에 존재하는 모든 수의 합 
select sum(p.p_price * cs.cs_cnt)
	from tblcartmain cm, tblcartsub cs, tblproduct p
	where cm.cm_code = cs.cm_code
		and p.p_code = cs.p_code
		and cm.m_id = 'tiger';
		
-- lion의 장바구니 합계
select sum(p.p_price * cs.cs_cnt)
	from tblcartmain cm, tblcartsub cs, tblproduct p
	where cm.cm_code = cs.cm_code
		and p.p_code = cs.p_code
		and cm.m_id = 'lion';

/* 장바구니의 tiger가 저장한 모든 내용을 구매 */
insert into tblordermain (m_id) values ('tiger');
select * from tblordermain;
insert into tblordersub (om_code, p_code, os_cnt)
	select 1001, p_code, cs_cnt from tblcartsub
	where cm_code = (select cm_code from tblcartmain where m_id = 'tiger');
-- subquery, 부질의

desc tblmember;
--lion의 장바구니에 담긴 물건 구매
insert into tblordermain (m_id) values ('lion');

insert into tblordersub (om_code, p_code, os_cnt)
	select 1002, p_code, cs_cnt from tblcartsub
	where cm_code = (select cm_code from tblcartmain where m_id = 'lion');

	
	
/* tiger가 가장 최근에 구매한 내역 */
-- 가장 최근에 tiger가 주문한 주문번호
select om_code from tblordermain where m_id = 'tiger'
	order by om_code desc limit 1;

select om.om_code, om.m_id, os.p_code, os.os_cnt,
	p.p_price * os.os_cnt
	from tblordermain om, tblordersub os, tblproduct p
	where om.om_code = os.om_code
		and p.p_code = os.p_code
		and om.om_code =
		(select om_code from tblordermain where m_id = 'tiger'
		order by om_code desc limit 1);
-- tiger가 가장 최근에 구매한 금액 총합계 조회
select sum(p.p_price * os.os_cnt)
	from tblordermain om, tblordersub os, tblproduct p
	where om.om_code = os.om_code
		and p.p_code = os.p_code
		and om.om_code =
		(select om_code from tblordermain where m_id = 'tiger'
		order by om_code desc limit 1);






