<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			out.print("*");
		}
		out.print("<br>");
	}
%>
<%
	// 구구단 출력
	out.print("<table border='1'>");
	for (int i = 1; i <= 9; i++) {
		out.print("<tr>");
		for (int j = 1; j <= 9; j++) {
			out.print("<td>" + i + "x" + j + "=" + (i*j) + "</td>");
		}
		out.print("</tr>");
	}
	out.print("</table>");
%>
	<table border="1">
	<% for (int i = 1; i <= 9; i++) { %>
		<tr>
      		<% for (int j = 1; j <= 9; j++) { %>
         	<td><%=i%>*<%=j%>=<%=i*j%></td>
      		<% } %>
    	</tr>
	<% } %>
	</table>
<%
	out.print("<font size='10'>");
	out.print("웹프로그래밍");
	out.print("</font><br>");
%>
<font size="10"><%="웹프로그래밍" %></font><br>


</body>
</html>