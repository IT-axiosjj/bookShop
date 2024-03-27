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
 * @copyright:�˺��� 0410190211
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
		//1.��ȡҪ�༭�û���Ϣ���û�id
		        request.setCharacterEncoding("utf-8"); 
				String id=request.getParameter("id");
				
				//2.��ȡ���ݿ⣬�����û���Ϣ����id��
				ProductsDao productsDao=new ProductsDao();
				Product product=productsDao.find(Integer.parseInt(id));//���û�ID����һ���û���Ϣ
				
				//3.���û���Ϣ����洢request��
				request.setAttribute("products", product);
				
				//4.ת�����û���Ϣ�༭ҳ��(useredit.jsp)
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
