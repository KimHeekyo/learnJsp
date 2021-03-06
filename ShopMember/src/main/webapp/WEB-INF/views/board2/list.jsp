<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!-- Begin Page Content -->
<div id="layoutSidenav_content">
<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">리스트</h1>
	<p class="mb-4"></p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">
				<a href="/board2/insert">게시판글쓰기</a><!-- &nbsp;${user}&nbsp;${age} -->
			</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" width="100%" cellspacing="0">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>첨부파일</td>
							<td>작성일</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="board">
							<tr>
								<td>${board.b_num}</td>
								<td><a href="/board2/view?b_num=${board.b_num}&pageNum=${pageview.page.pageNum}">${board.b_subject}</a></td>
								<td>${board.b_name}</td>
								<td><a href="/board2/download?b_num=${board.b_num}">${board.b_file}</a></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.b_date}" /></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5">
								<c:if test="${pageview.prev}">
									<a href="/board2/list?pageNum=1">[<<]</a>&nbsp;&nbsp;
									<a href="/board2/list?pageNum=${pageview.startPage-1}">[이전 페이지]</a>&nbsp;&nbsp;
								</c:if>
								<c:forEach var="num" begin="${pageview.startPage}" end="${pageview.endPage}">
									<c:if test="${pageview.page.pageNum == num}"> <!-- 현재 페이지와 같다면 굵게 -->
										<b><a href="/board2/list?pageNum=${num}">[${num}]</a></b>&nbsp;&nbsp;
									</c:if>
									<c:if test="${pageview.page.pageNum != num}"> <!-- 현재 페이지와 같지 않다면 굵지않게 -->
										<a href="/board2/list?pageNum=${num}">[${num}]</a>&nbsp;&nbsp;
									</c:if>
								</c:forEach>
								<c:if test="${pageview.next}">
									<a href="/board2/list?pageNum=${pageview.endPage+1}">[다음 페이지]</a>&nbsp;&nbsp;
									<a href="/board2/list?pageNum=${pageview.realend}">[>>]</a>&nbsp;&nbsp;
								</c:if>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
</div>
<!-- /.container-fluid -->
<%@include file="../include/footer.jsp"%>
