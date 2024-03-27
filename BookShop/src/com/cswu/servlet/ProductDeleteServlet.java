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
 * @copyright:�˺��� 0410190211
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
		//1.��ȡǰ�˴��ݵĲ���
		String id=request.getParameter("id");
		
		//2.�����ݿ���ɾ���û���Ϣ(��id)
		ProductsDao productsDao = new ProductsDao();
	    productsDao.delete(Integer.parseInt(id));
		//���û�idɾ����¼
		
		//3.��ת���û���Ϣ�б�ҳ�棬ʵ�� ҳ��ˢ�� 
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
