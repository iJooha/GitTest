<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<form action ="infoResult.jsp" method ="post">
 		id : <input type ="text" name=id><br>
 		pw : <input type="password" name = "pw"> <br>
 		<textarea name ="dec" cols="50" rows ="4"></textarea><br>
 		<input type ="submit" value="전송">
 		<input type ="reset" value="취소">
 	
 	</form>
</body>
</html>