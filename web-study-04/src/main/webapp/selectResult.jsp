<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 당신의 학력,소속국가 및 관심분야는 다음과 같습니다<br><br>
 <%
 String edu = request.getParameter("edu");
 String na = request.getParameter("na");
 String[] like = request.getParameterValues("like");
 	%>
 	
 	<b><%=edu %></b>
 	<b><%=na %></b><br><br>
 	<b><%for(int i=0; i<like.length; i++)
  {%><b>
  <%=like[i] %>
  </b><br> <%}
 		
 		%>
 	
</body>
</html>