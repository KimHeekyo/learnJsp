<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<div id="layoutSidenav_content">
	<div class="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">상품정보</h1>
		<p class="mb-4"></p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">
					<a href="/shop/list">상품목록</a>
				</h6>
			</div>
			<div class="card-body">
				<div class="form-group row">
					<div class="col-sm-6 mb-3 mb-sm-0">
						<input type="hidden" class="form-control"
							value="${product.p_code}" readonly>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-6 mb-3 mb-sm-0">
						<label>상품명</label> <input type="text" class="form-control"
							value="${product.p_name}" readonly>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>단가</label> <input type="text" class="form-control"
							value="${product.p_price}" readonly>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-6">
						<label>상품사진</label></br> <img
							src="/resources/product2/${product.p_image}" height="200">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>