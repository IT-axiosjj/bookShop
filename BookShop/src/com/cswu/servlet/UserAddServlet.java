package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.UsersDao;
import com.cswu.entity.User;

/**
 * 用户信息的新增功能
 *
 *@copyright:邓豪杰 0410190211
 */
public class UserAddServlet  extends HttpServlet{
	
	@Override 
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		
	}
	
	@Override 
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		 req.setCharacterEncoding("utf-8");
		//1.获取前端页面中的表单数据
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String telephone=req.getParameter("telephone");
		String introduce=req.getParameter("introduce");
		
		//2.数据转化为对象
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setIntroduce(introduce);
		
		//3.将user对象插入到数据库
		UsersDao usersDao=new UsersDao();
		usersDao.insert(user);//将对象插入到数据库中
		
		//4.跳转到用户信息列表userlist.jsp,实现用户数据的刷新 
		resp.sendRedirect("/BookShop/userlist");
	}

}
