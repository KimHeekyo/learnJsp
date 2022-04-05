<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!-- Begin Page Content -->
<div id="layoutSidenav_content">
	<div class="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">주문관리</h1>
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
								<th>주문번호</th>
								<th>ID</th>
								<th>주문상세번호</th>
								<th>상품명</th>
								<th>이미지</th>
								<th>단가</th>
								<th>수량</th>
								<th>금액</th>
								<th>주문날짜</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="ordersub">
								<tr>
									<td>${ordersub.om_code}</td>
									<td>${ordersub.m_id}</td>
									<td>${ordersub.os_code}</td>
									<td>${ordersub.p_name}</td>
									<td align="center"><img
										src="/resources/product2/${ordersub.p_image}" height="50"></td>
									<td>${ordersub.p_price}</td>
									<td>${ordersub.os_cnt}</td>
									<td>${ordersub.os_money}</td>
									<td>${ordersub.om_rdate}</td>
								</tr>
							</c:forEach>
							<tr>
							<td colspan="5">
								<c:if test="${pageview.prev}">
									<a href="/shop/orderlist?pageNum=1">[<<]</a>&nbsp;&nbsp;
									<a href="/shop/orderlist?pageNum=${pageview.startPage-1}">[이전 페이지]</a>&nbsp;&nbsp;
								</c:if>
								<c:forEach var="num" begin="${pageview.startPage}" end="${pageview.endPage}">
									<c:if test="${pageview.page.pageNum == num}"> <!-- 현재 페이지와 같다면 굵게 -->
										<b><a href="/shop/orderlist?pageNum=${num}">[${num}]</a></b>&nbsp;&nbsp;
									</c:if>
									<c:if test="${pageview.page.pageNum != num}"> <!-- 현재 페이지와 같지 않다면 굵지않게 -->
										<a href="/shop/orderlist?pageNum=${num}">[${num}]</a>&nbsp;&nbsp;
									</c:if>
								</c:forEach>
								<c:if test="${pageview.next}">
									<a href="/shop/orderlist?pageNum=${pageview.endPage+1}">[다음 페이지]</a>&nbsp;&nbsp;
									<a href="/shop/orderlist?pageNum=${pageview.realend}">[>>]</a>&nbsp;&nbsp;
								</c:if>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->
<%@include file="../include/footer.jsp"%>
