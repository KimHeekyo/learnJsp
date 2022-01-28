<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>

<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공지사항 작성</h1>
	<p class="mb-4"></p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">
				<a href="/notice/list">공지사항 목록</a>
			</h6>
		</div>
		<div class="card-body">
			<form method="post" action="/notice/insert" class="user">
				<div class="form-group row">
					<div class="col-sm-6 mb-3 mb-sm-0">
						<label>제목</label>
						<input type="text" class="form-control" name="n_subject">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>작성자</label>
						<input type="text" class="form-control" name="n_name">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>내용</label>
						<textarea rows="15" class="form-control" name="n_contents"></textarea>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<input type="submit" class="form-control" value="등록">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>