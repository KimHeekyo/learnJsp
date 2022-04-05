<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!-- Begin Page Content -->
<div id="layoutSidenav_content">
	<div class="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">${m_name}님의
			${cm_code}번 장바구니목록</h1>
		<p class="mb-4"></p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">
					<a href="/shop/list">상품리스트</a>
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
							<c:forEach items="${list}" var="cartsub">
								<tr>
									<td>${cartsub.cs_code}</td>
									<td>${cartsub.p_code}</td>
									<td>${cartsub.p_name}</td>
									<td align="center"><img
										src="/resources/product2/${cartsub.p_image}" height="50"></td>
									<td>${cartsub.p_price}</td>
									<td>
										<form method="post" action="/shop/cartupdate">
											<input type="hidden" name="cs_code"
												value="${cartsub.cs_code}"> <select name="cs_cnt">
												<c:forEach var="count" begin="1" end="30" step="1">
													<!-- step은 생략 가능 -->
													<c:if test="${count == cartsub.cs_cnt}">
														<option value="${count}" selected>${count}</option>
														<!-- selected는 현재의 개수의 맞게 표시해준다 -->
													</c:if>
													<c:if test="${count != cartsub.cs_cnt}">
														<option value="${count}">${count}</option>
													</c:if>
												</c:forEach>
											</select> <input type="submit" value="수정">
										</form> &nbsp;<a
										href="/shop/cartdelete?cs_code=${cartsub.cs_code}&cm_code=${cm_code}">삭제</a>
									</td>
									<td>${cartsub.cs_money}</td>
								</tr>
							</c:forEach>
					</table>
					<table class="table table-bordered" width="100%" cellspacing="0">
						<tr align="center">
							<th>장바구니번호</th>
							<td>${carttotal.cm_code}</td>
						</tr>
						<tr align="center">
							<th>총가격</th>
							<td><fmt:formatNumber value="${carttotal.cm_total}"
									pattern="#, ###" />원</td>

							<c:if test="${not empty cm_code}">
							&nbsp;&nbsp;<a href="/shop/cartdeleteall?cm_code=${cm_code}">모두삭제</a>
							&nbsp;&nbsp;<a href="/shop/orderinfo?cm_code=${cm_code}">주문</a>
							</c:if>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->
<%@include file="../include/footer.jsp"%>
