package com.seayan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.seayan.dto.ProductVO;

@WebServlet("/ProductWriter.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher dispatcher = request.getRequestDispatcher("product/productWrite.jsp");
	dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.setCharacterEncoding("utf-8");
	
	ServletContext context=getServletContext();
	String path=context.getRealPath("upload");
	String encType="utf-8";
	int sizeLimit = 20*1024*1024;
	
	MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,encType,new DefaultFileRenamePolicy());
	
	String name = multi.getParameter("name");
	int price = Integer.parseInt(multi.getParameter("price"));
	String description = multi.getParameter("description");
	String pictureUrl =multi.getFilesystemName("pictureUrl");
	
	ProductVO pvo = new ProductVO();
	pvo.setName(name);
	pvo.setPrice(price);
	pvo.setDescription(description);
	pvo.setPictureurl(pictureUrl);
	
	ProductDAO pDao = ProductDAO.getInstance();
	int result =pDao.insertProduct(pvo);
	
	if(result==1) {
		response.sendRedirect("productList.do");
	}else
		response.sendRedirect("/product/productWrite.jsp");
	}

}
