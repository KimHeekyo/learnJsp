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
	Hello world!๐ฎ๐ฎ๐ญ๐ญ๐ด๐ฒ๐น๐ฆผโค๐งก๐๐ช๐ฉ๐ฉ๐ฅฃ๐ฎ๐
</h1>
<h3>๋ณ์ ์ฒ๋ฆฌ</h3>
<%-- <c:set var="mynum" value="101" /> ์ปจํธ๋กค๋ฌ์์ ๋๊ฒจ์ค ์ ์์ --%>
<h3>${mynum}</h3>
<h3><c:out value="${mynum}" /></h3>
<h3>์ ์ด๊ตฌ์กฐ</h3>
<c:choose>
	<c:when test="${mynum % 2 == 0}">
		<h3>${mynum}์ ์ง์</h3>
	</c:when>
	<c:otherwise>
		<h3>${mynum}์ ํ์</h3>	
	</c:otherwise>
</c:choose>
<h3>๊ตฌ๊ตฌ๋จ</h3>
<c:forEach var="i" begin="1" end="9">
	<c:forEach var="j" begin="1" end="9">
		${i}*${j}=${i*j}&nbsp;
	</c:forEach>
	<br>
</c:forEach>
</body>
</html>
