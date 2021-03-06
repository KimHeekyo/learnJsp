<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>

<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">회원가입</h1>
	<p class="mb-4"></p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">
				<a href="/member/list">회원목록</a>
			</h6>
		</div>
		<div class="card-body">
			<form method="post" action="/member/insert" class="user">
				<div class="form-group row">
					<div class="col-sm-6 mb-3 mb-sm-0">
						<label>아이디</label>
						<input type="text" class="form-control" name="m_id">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>비밀번호</label>
						<input type="text" class="form-control" name="m_passwd">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>이름</label>
						<input type="text" class="form-control" name="m_name">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<input type="submit" class="form-control" value="가입">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>