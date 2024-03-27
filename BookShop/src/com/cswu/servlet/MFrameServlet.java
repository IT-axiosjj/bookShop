package com.cswu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.MenusDao;
import com.cswu.entity.Menu;

/**
 * 主框架页面
 * 
 *@copyright:邓豪杰 0410190211
 */
public class MFrameServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		 req.setCharacterEncoding("utf-8");
		//1.读取数据库表Menus中的所有数据
		MenusDao menusDao=new MenusDao();
		List<Menu> menusList=menusDao.findAll();//读取所有的菜单信息列表
		
		//2.把数据保存在request  存储数据的方式：(page,request,session,application)
		req.setAttribute("menus", menusList);
		
		//3.转发到JSP文件，
		RequestDispatcher rd=req.getRequestDispatcher("mainframe.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}
}
