<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<script src="/resources/js/my.js"></script>
<div id="layoutSidenav_content">
	<div class="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">글쓰기</h1>
		<p class="mb-4"></p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">
					<a href="/board2/list">게시판리스트</a>
				</h6>
			</div>
			<div class="card-body">
				<form enctype="multipart/form-data" class="user" name="writefrm">
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label>제목</label> <input type="text" id="id_subject"
								class="form-control" name="b_subject">
						</div>
					</div>

					<div class="form-group row">
						<div class="col-sm-6">
							<label>작성자</label> <input type="text" class="form-control"
								name="b_name" value="${a_id}" readonly>
						</div>
					</div>

					<div class="form-group row">
						<div class="col-sm-6">
							<label>내용</label>
							<textarea rows="15" class="form-control" name="b_contents"></textarea>
						</div>
					</div>
					<br>
					<div class="form-group row">
						<div class="col-sm-6">
							<input type="file" class="form-control"
								name="b_file">
						</div>
					</div>
					<br>
					<div class="form-group row">
						<div class="col-sm-6">
							<input type="button" class="form-control" value="작성"
								onclick="writeform();">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>