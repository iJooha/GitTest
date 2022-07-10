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

@WebServlet("/productUpdate.do")
public class productUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String code = request.getParameter("code");
	
	ProductDAO pDao = ProductDAO.getInstance();
	ProductVO pvo= pDao.selectProductBycode(code);
	
	request.setAttribute("product", pvo);
	RequestDispatcher dispatcher = request.getRequestDispatcher("product/productUpdate.jsp");
	dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		ServletContext context=getServletContext();
		String path=context.getRealPath("upload");
		String encType="utf-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi =new MultipartRequest(request, path, sizeLimit,encType, new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		
		if(pictureUrl==null) {
			pictureUrl = multi.getParameter("nonmakeImg");
		}
		
		ProductVO pvo = new ProductVO();
		pvo.setCode(Integer.parseInt(code));
		pvo.setPrice(price);
		pvo.setName(name);
		pvo.setDescription(description);
		pvo.setPictureurl(pictureUrl);
	
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.updateProduct(pvo);
		
		
		response.sendRedirect("productList.do");
	
	
	
	}

}
