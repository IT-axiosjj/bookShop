package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.ProductsDao;
import com.cswu.entity.Product;


/**
 * Servlet implementation class ProductEditServlet
 * @copyright:邓豪杰 0410190211
 */
@WebServlet("/ProductEditServlet")
public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取要编辑用户信息的用户id
		        request.setCharacterEncoding("utf-8"); 
				String id=request.getParameter("id");
				
				//2.读取数据库，返回用户信息（按id）
				ProductsDao productsDao=new ProductsDao();
				Product product=productsDao.find(Integer.parseInt(id));//按用户ID返回一条用户信息
				
				//3.将用户信息对象存储request中
				request.setAttribute("products", product);
				
				//4.转发到用户信息编辑页面(useredit.jsp)
				RequestDispatcher rd=request.getRequestDispatcher("productedit.jsp");
				rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
