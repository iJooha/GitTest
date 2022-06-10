<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="ex06_01" class="com.mission.javabeans.ex06_01" />
	<jsp:setProperty property="*" name="ex06_01"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
#rowstyle
{
	text-align: center;
}
</style>
<body>
<h2> 입력완료된 정보</h2>


<table>

<tr>
			<td>작성자</td>
			<td><jsp:getProperty property="name" name="ex06_01"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><jsp:getProperty property="pwd" name="ex06_01"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><jsp:getProperty property="email" name="ex06_01"/></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><jsp:getProperty property="title" name="ex06_01"/></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><jsp:getProperty property="content" name="ex06_01"/></td>
		</tr>


</table>
<input type="submit" value="등록">
<input type="reset" value="다시작성">

</body>
</html>