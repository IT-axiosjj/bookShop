package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * �˳���ǰ��¼��Servlet
 * 
 *@copyright:�˺��� 0410190211
 */
public class LogoutServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		 req.setCharacterEncoding("utf-8");
		//��ȡ��ǰҳ���Session���� 
		HttpSession session=req.getSession();
		//ɾ��Session�е��û���Ϣ
		session.removeAttribute("loginer");
		
		//��ת����ҳ
		resp.sendRedirect("/BookShop/index");
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		doGet(req,resp);
	}

}
