<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!-- Begin Page Content -->

<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">주문정보</h1>
	<p class="mb-4"></p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">
				<a href="/shop/list">상품리스트</a>&nbsp;&nbsp;
			</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>상세코드</th>
							<th>상품코드</th>
							<th>상품명</th>
							<th>이미지</th>
							<th>단가</th>
							<th>수량</th>
							<th>금액</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="ordersub">
							<tr>
								<td>${ordersub.os_code}</td>
								<td>${ordersub.p_code}</td>
								<td>${ordersub.p_name}</td>
								<td align="center"><img
									src="/resources/product/${ordersub.p_code}.jpg" height="50"></td>
								<td>${ordersub.p_price}</td>
								<td>${ordersub.os_cnt}</td>
								<td>${ordersub.os_money}</td>
							</tr>
						</c:forEach>
				</table>
				<table class="table table-bordered" width="100%" cellspacing="0">
					<tr align="center">
						<th>총가격</th>
						<td><fmt:formatNumber value="${ordertotal.om_total}" pattern="#, ###" />원</td>
					</tr>
				</table>
				<h2 align="right">주문이 완료되었습니다.</h2>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
<%@include file="../include/footer.jsp"%>
