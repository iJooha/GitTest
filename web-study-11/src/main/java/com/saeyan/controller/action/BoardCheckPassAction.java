package com.saeyan.controller.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.BoardVO;
import com.seayan.dao.BoardDAO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException, ServletException {
		
		String url =null;
		String num =request.getParameter("num");
		String pass = request.getParameter("pass");
		
		
		BoardDAO bdao = BoardDAO.getInstance();
		BoardVO bvo = bdao.selectOneBoardByNum(num);
		
		if(bvo.getPass().equals(pass)) { //성공
			url ="/board/checkSuccess.jsp";
		}else {//실패
			url="/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
