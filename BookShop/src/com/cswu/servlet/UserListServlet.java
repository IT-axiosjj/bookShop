package com.cswu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.UsersDao;
import com.cswu.entity.User;
 

/**
 * 用户信息的列表
 * @copyright:邓豪杰 0410190211
 *
 */
public class UserListServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		 req.setCharacterEncoding("utf-8");
		//1.读取数据库表Users中的所有数据
		UsersDao usersDao=new UsersDao();
		List<User> usersList=usersDao.findAll();//返回所有的用户信息
				 
		//2.把数据保存在request  存储数据的方式：(page,request,session,application)
		req.setAttribute("Users", usersList);
				 
		//3.转发到JSP文件，
		RequestDispatcher rd=req.getRequestDispatcher("userlist.jsp");
		rd.forward(req, resp);				 
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}
} 
