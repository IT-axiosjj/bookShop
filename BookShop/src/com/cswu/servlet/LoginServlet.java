package com.cswu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cswu.dao.UsersDao;
import com.cswu.entity.Loginer;
import com.cswu.entity.User;

/**
 * 用户登录Servlet
 * 
 *@copyright:邓豪杰 0410190211
 */
public class LoginServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) {
		
		String uname=req.getParameter("username");
		String psword=req.getParameter("password");
		
		try{
		
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		
		UsersDao usersDao=new UsersDao();
		User user=usersDao.findByUserName(uname); 
		
		if(user!=null&&psword.equals(user.getPassword())){
			 req.setCharacterEncoding("utf-8");
			//创建登录用户信息的对象 
			Loginer loginer=new Loginer();
			loginer.setUsername(uname);
			loginer.setPassword(psword);
			String time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			loginer.setSigntime(time);
			
			//获取当前页面的Session对象，并将user保存到Session中
			HttpSession session=req.getSession();
			session.setAttribute("loginer", loginer);			
			
			resp.sendRedirect("/BookShop/mainframe");
		}else{
			resp.sendRedirect("/BookShop/login.html");
		}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
