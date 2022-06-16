package com.saeyan.controller.action;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seayan.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException, ServletException {

			String num =request.getParameter("num");
			
			BoardDAO bdao = BoardDAO.getInstance();
			bdao.deleteBoard(num);
			
			new BoardListAction().execute(request, response);
	}

}
