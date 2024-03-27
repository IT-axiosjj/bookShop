package com.cswu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.ProductsDao;
import com.cswu.entity.Product;


/**
 * Servlet implementation class ProductUpdateServlet
 * @copyright:�˺��� 0410190211
 */
@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		       request.setCharacterEncoding("utf-8");
		        //1.��ȡǰ��ҳ���еı�����
				String id=request.getParameter("id");
				String name=request.getParameter("name");
				String price=request.getParameter("price");
				String category=request.getParameter("category");
				String pnum=request.getParameter("pnum");
				String imgurl=request.getParameter("imgurl");
				String description=request.getParameter("description");
				
				
				//2.����ת��Ϊ����
			    Product product = new Product();
			    product.setId(Integer.parseInt(id));
			    product.setName(name);
			    product.setPrice(Integer.parseInt(price));
			    product.setCategory(category);
			    product.setPnum(Integer.parseInt(pnum));
			    product.setImgurl(imgurl);
			    product.setDescription(description);
				
				//3.��user������뵽���ݿ�
				ProductsDao productsDao = new ProductsDao();
				productsDao.update(product);//��������µ����ݿ���
				
				//4.��ת���û���Ϣ�б�userlist.jsp,ʵ���û����ݵ�ˢ�� 
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
