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
	request.setCharacterEncoding("utf-8");	// 인코딩 방식 설정(선두에 작성)
	String sname = request.getParameter("sname");	// 전송문자열 저장
	String sage = request.getParameter("sage");
	String sarea = request.getParameter("sarea");
	String syear = request.getParameter("syear");
	String shobby = request.getParameter("shobby");
	
	
	int iage = 0;	// 전역변수
	boolean flag = true;	// 나이가 정상으로 넘어온다고 가정
	if (sname.trim().length() < 2) {
		flag = false;
	}
	try {
		iage = Integer.parseInt(sage);	// 정수형태의 문자열을 정수로 형변환
		
	} catch (Exception e) {	// 예외가 발생했을 경우 처리할 내용
		//iage = 25;
		flag = false;	// 예외 발생
	}
	
	if (flag == false) { // 예외가 발생했을 경우
%>
		<script>
			alert("입력이 잘못되었습니다.");
			history.back();	// 직전 페이지로 이동
		</script>
<%
	} else {	// 정상일 경우
		out.print(sname + "<br>");
		out.print(sage + "<br>");
		out.print(sarea + "<br>");
		out.print(syear + "<br>");
		out.print(shobby + "<br>");
		out.print(iage + "<br>");
	}
	
%>
</body>
</html>