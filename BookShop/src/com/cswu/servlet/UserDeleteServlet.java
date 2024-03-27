package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.UsersDao;
 
/**
 * 用户信息的删除（按用户ID）
 * @copyright:邓豪杰 0410190211
 *
 */

public class UserDeleteServlet extends HttpServlet{
	
	@Override 
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		//1.获取前端传递的参数
		String id=req.getParameter("id");
		
		//2.从数据库中删除用户信息(按id)
		UsersDao usersDao=new UsersDao();
		usersDao.delete(Integer.parseInt(id));//按用户id删除记录
		
		//3.跳转到用户信息列表页面，实现 页面刷新 
		resp.sendRedirect("/BookShop/userlist");
	}
	
	@Override 
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		 
	}

}
