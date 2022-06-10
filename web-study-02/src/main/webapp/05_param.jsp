<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿</title>
<script type="text/javascript" src="param.js"></script>
</head>
<body>

	<form action="paramServlet" method="post" name="frm">
	
	<label for ="userid">아이디</label>
	<input type="text" name="id" id="uerid"><br>
	
		나 이 : <input type="text" name="age"> <br>
		<input type="submit" value="전송">
	</form>

</body>
</html>