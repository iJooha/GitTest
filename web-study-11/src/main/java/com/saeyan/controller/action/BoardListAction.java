package com.saeyan.controller.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.BoardVO;
import com.seayan.dao.BoardDAO;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException{
		String url = "/board/boardList.jsp";
		
		BoardDAO bdao = BoardDAO.getInstance();
		
	List<BoardVO> boardList = bdao.selectAllBoards();
	request.setAttribute("boardList", boardList);

	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
	}

}
