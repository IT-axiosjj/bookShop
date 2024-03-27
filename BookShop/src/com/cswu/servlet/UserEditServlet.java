package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.UsersDao;
import com.cswu.entity.User;

/**
 * 获取编辑的用户信息
 *@copyright:邓豪杰 0410190211
 *
 */
public class UserEditServlet extends HttpServlet{
	
	@Override 
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		 req.setCharacterEncoding("utf-8");
		//1.获取要编辑用户信息的用户id
		String id=req.getParameter("id");
		
		//2.读取数据库，返回用户信息（按id）
		UsersDao usersDao=new UsersDao();
		User user=usersDao.find(Integer.parseInt(id));//按用户ID返回一条用户信息
		
		//3.将用户信息对象存储request中
		req.setAttribute("User", user);
		
		//4.转发到用户信息编辑页面(useredit.jsp)
		RequestDispatcher rd=req.getRequestDispatcher("useredit.jsp");
		rd.forward(req, resp);
	}
	
	@Override 
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		 
	}

}
