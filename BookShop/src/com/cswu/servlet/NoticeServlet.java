package com.cswu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.NoticesDao;

import com.cswu.entity.Notice;


/**
 * Servlet implementation class NoticeServlet
 * @copyright:邓豪杰 0410190211
 */
@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
		//1.读取数据库表Users中的所有数据
	    NoticesDao noticesDao = new NoticesDao();
	    
		List<Notice> notices=noticesDao.findAll();//返回所有的用户信息
				 
		//2.把数据保存在request  存储数据的方式：(page,request,session,application)
		request.setAttribute("Notices", notices);
				 
		//3.转发到JSP文件，
		RequestDispatcher rd=request.getRequestDispatcher("notices.jsp");
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
