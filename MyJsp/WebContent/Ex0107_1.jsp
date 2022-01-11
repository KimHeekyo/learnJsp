<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>JDBC 테스트</h1>
<%
   Connection conn = null;   //접속 객체
   PreparedStatement pstmt = null;   // 쿼리 객체 선언
   ResultSet rs = null;   // 쿼리 결과(레코드집합) 객체
   String query = "";   //SQL 문법
   try {
      Class.forName("com.mysql.jdbc.Driver");   //JDBC 드라이버 로드
      //out.print("드라이버 로드 성공");
      String url = "jdbc:mysql://localhost:3306/mysql";   // 접속 url
      String user = "root";
      String passwd = "";
      conn = DriverManager.getConnection(url, user, passwd);   //디비에 연결
      //out.print(conn);
      query = "select * from tblboard";
      pstmt = conn.prepareStatement(query);   //쿼리 객체 생성
      rs = pstmt.executeQuery();   //쿼리 실행해서 결과를 rs에 반환 받음
      //rs 객체는 여러 개의 레코드가 포함되어 있을 수 있음(반복 구문 필요)
      while (rs.next()) {   //참일 경우 레코드가 반환됨
         int b_num = rs.getInt("b_num");
      String b_subject = rs.getString("b_subject");
      out.print(b_num + "===" + b_subject + "<br>");
      }
   }catch (Exception e) {
      out.print(e);
   } finally {
	   try {
		   if (rs != null)
			   rs.close();
		   if (pstmt != null)
			   pstmt.close();
		   if (conn !=null)
			   conn.close();
	   } catch (Exception ex) {
		   out.print(ex);
	   }
   }
%>
   
</body>
</html>