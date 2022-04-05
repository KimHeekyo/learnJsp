<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Mytest</title>
</head>
<body>

<h1>
	Hello world!🌮🌮🌭🌭🛴🚲🛹🦼❤🧡🎂🍪🍩🍩🥣🍮🌏
</h1>
<h3>변수 처리</h3>
<%-- <c:set var="mynum" value="101" /> 컨트롤러에서 넘겨줄 수 있음 --%>
<h3>${mynum}</h3>
<h3><c:out value="${mynum}" /></h3>
<h3>제어구조</h3>
<c:choose>
	<c:when test="${mynum % 2 == 0}">
		<h3>${mynum}은 짝수</h3>
	</c:when>
	<c:otherwise>
		<h3>${mynum}은 홀수</h3>	
	</c:otherwise>
</c:choose>
<h3>구구단</h3>
<c:forEach var="i" begin="1" end="9">
	<c:forEach var="j" begin="1" end="9">
		${i}*${j}=${i*j}&nbsp;
	</c:forEach>
	<br>
</c:forEach>
</body>
</html>
