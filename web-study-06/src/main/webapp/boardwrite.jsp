<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판 글쓰기</title>
<style type="text/css">
td
{
	border: 0;
}
#rowstyle{
	font-weight: bold;
	background-color: #e5e5e5;
	text-align: center;
}
</style>
</head>
<body>
<center>
<h2>게시판 글쓰기</h2>

<form method="post" action="boardwriteform.jsp">
<table border="1">
				<tr>
					<td id="rowstyle">작성자</td>
					<td><input type="text" name="name"></td>

				</tr>
				<tr>
					<td id="rowstyle">비밀번호</td>
					<td><input type="password" name="pwd">(게시물 수정 삭제시 필요합니다.)</td>
				</tr>
				<tr> 
					<td id="rowstyle">이메일</td>
					<td><input type="text" size="50" name="email"></td>
				</tr>
				<tr>
					<td id="rowstyle">글 제목</td>
					<td><input type="text" size="80" name="title"></td>
				</tr>
				<tr>
					<td id="rowstyle" height="100px">글 내용</td>
					<td>
					<textarea cols="80" rows="20" name="content"></textarea>
					</td>
				</tr>
				<tr>
			</table>
			<input type="submit" value="등록">
			<input type="reset" value="다시작성">
		</form>
	</center>
</body>
</html>