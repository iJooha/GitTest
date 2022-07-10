<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
   <h1>글 등록</h1>
   <a href="logout.do">Log-out</a>
   <hr>
   <!-- <form action="insertBoard_proc.jsp" method="post"> -->
   <form action="insertBoard.do" method="post">
   <table border="1" cellpadding="0" cellspacing="0">
      <tr>
         <td bgcolor="orange" width="70">제목</td>
         <td align="left"><input name="title" type="text"/></td>
      </tr>
      <tr>
         <td bgcolor="orange" width="70">작성자</td>
         <td align="left"><input name="writer" type="text"/></td>
      </tr>
      <tr>
         <td bgcolor="orange">내용</td><td align="left"><textarea rows="10" cols="40" name="content"></textarea></td>
      </tr>
      <tr>
         <td colspan="2" align="center">
            <input type="submit" value="글 추가"/>
         </td>
      </tr>
   </table>
   </form>
   <hr>
   <a href="getBoardList.do">글 목록 가기</a>
   </center>
</body>
</html>