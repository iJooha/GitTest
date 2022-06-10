<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>second page</h1>


<%= pageContext.getAttribute("name") %> <br>
<%= request.getAttribute("name") %> <br>
<%= session.getAttribute("name") %> <br>
<%= application.getAttribute("name") %> <br>

<a href ="07_thirdPage.jsp">또 다른 페이지 </a>


</body>
</html>