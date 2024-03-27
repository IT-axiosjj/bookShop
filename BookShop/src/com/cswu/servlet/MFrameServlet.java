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
 * �����ҳ��
 * 
 *@copyright:�˺��� 0410190211
 */
public class MFrameServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		 req.setCharacterEncoding("utf-8");
		//1.��ȡ���ݿ��Menus�е���������
		MenusDao menusDao=new MenusDao();
		List<Menu> menusList=menusDao.findAll();//��ȡ���еĲ˵���Ϣ�б�
		
		//2.�����ݱ�����request  �洢���ݵķ�ʽ��(page,request,session,application)
		req.setAttribute("menus", menusList);
		
		//3.ת����JSP�ļ���
		RequestDispatcher rd=req.getRequestDispatcher("mainframe.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}
}
