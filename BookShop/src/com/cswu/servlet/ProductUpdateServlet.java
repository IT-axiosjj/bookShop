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
 * @copyright:邓豪杰 0410190211
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
		        //1.获取前端页面中的表单数据
				String id=request.getParameter("id");
				String name=request.getParameter("name");
				String price=request.getParameter("price");
				String category=request.getParameter("category");
				String pnum=request.getParameter("pnum");
				String imgurl=request.getParameter("imgurl");
				String description=request.getParameter("description");
				
				
				//2.数据转化为对象
			    Product product = new Product();
			    product.setId(Integer.parseInt(id));
			    product.setName(name);
			    product.setPrice(Integer.parseInt(price));
			    product.setCategory(category);
			    product.setPnum(Integer.parseInt(pnum));
			    product.setImgurl(imgurl);
			    product.setDescription(description);
				
				//3.将user对象插入到数据库
				ProductsDao productsDao = new ProductsDao();
				productsDao.update(product);//将对象更新到数据库中
				
				//4.跳转到用户信息列表userlist.jsp,实现用户数据的刷新 
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
