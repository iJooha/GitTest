package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		//1. Spring 컨테이너 구동
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		

	//2. Spring 컨테이너로 부터 BoardServiceImpl객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		//BoardService boardService = container.getBean("boardService", BoardService);
		
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("불멸의 이순신");
		vo.setWriter("이순신");
		vo.setContent("임진왜란............");
		
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("----->" + board.toString());
		}
		
		
		
		 container.close();
	}

}
