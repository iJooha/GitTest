<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.seayan.javabeans.MemberBean"/> 	<!-- 객체 생성 -->

	자바 빈 객체 생성 후 저장된 정보 출력하기 <br><br>
	이름 : <%=member.getName() %>
	아이디 : <%=member.getUserid() %>
	
	<h1>정보 변경 후</h1>
	
	<%
	member.setName("전수민");
	member.setUserid("pinksubin");
	%>
	
	이름 : <%=member.getName() %>
	아이디 : <%=member.getUserid() %>
	
	
</body>
</html>