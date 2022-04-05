<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<div id="layoutSidenav_content">
	<div class="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">회원정보 상세보기</h1>
		<p class="mb-4"></p>
		
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			
			<div class="card-body">
				<div class="form-group row">
					<div class="col-sm-6 mb-3 mb-sm-0">
						<label>아이디</label> <input type="text" class="form-control"
							value="${member.m_id}" readonly>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>이름</label> <input type="text" class="form-control"
							value="${member.m_name}" readonly>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>가입날짜</label> <input type="text" class="form-control"
							value="${member.m_rdate}" readonly>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>수정날짜</label> <input type="text" class="form-control"
							value="${member.m_udate}" readonly>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<a href="/member/update?m_id=${member.m_id}">[수정]</a>
						&nbsp;&nbsp;&nbsp; <a href="/member/delete?m_id=${member.m_id}">[탈퇴]</a>
					</div>
					<div>
						<a href="/member/logout">로그아웃</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>