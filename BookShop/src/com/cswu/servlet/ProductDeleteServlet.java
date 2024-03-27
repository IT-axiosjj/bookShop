package com.cswu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.ProductsDao;
import com.cswu.dao.UsersDao;
import com.cswu.entity.Product;

/**
 * Servlet implementation class ProductDeleteServlet
 * @copyright:邓豪杰 0410190211
 */
@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
		//1.获取前端传递的参数
		String id=request.getParameter("id");
		
		//2.从数据库中删除用户信息(按id)
		ProductsDao productsDao = new ProductsDao();
	    productsDao.delete(Integer.parseInt(id));
		//按用户id删除记录
		
		//3.跳转到用户信息列表页面，实现 页面刷新 
		response.sendRedirect("/BookShop/Products");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
