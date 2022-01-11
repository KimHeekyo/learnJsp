<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="./Ex0104_4.jsp">
		성명 : <input type="text" name="sname"><br>
		나이 : <input type="text" name="sage"><br>
		지역 : <select name="sarea">
			<option value="충북">충북</option>
			<option value="경기">경기</option>
			<option value="서울">서울</option>
		</select><br>
		<!-- 2000년부터 2030년까지 syear 변수로 전송할 수 있는 select 태그 구현 -->
		년도 :
		<select name = "syear">
			<option value ="년도">년도</option>
			<% for (int i = 2000; i <= 2030; i++) { %>
				<option value = "<%=i%>"><%=i%></option>
            <% } %>
		</select><br>
		취미 : <input type="radio" name="shobby" value="등산">등산&nbsp;&nbsp;&nbsp;
		<input type="radio" name="shobby" value="낚시" checked>낚시&nbsp;&nbsp;&nbsp;
		<input type="radio" name="shobby" value="축구">축구&nbsp;&nbsp;&nbsp;<br>
		<input type="submit" value="전송하기">
	</form>
</body>
</html>