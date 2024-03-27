package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.UsersDao;
 
/**
 * �û���Ϣ��ɾ�������û�ID��
 * @copyright:�˺��� 0410190211
 *
 */

public class UserDeleteServlet extends HttpServlet{
	
	@Override 
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		//1.��ȡǰ�˴��ݵĲ���
		String id=req.getParameter("id");
		
		//2.�����ݿ���ɾ���û���Ϣ(��id)
		UsersDao usersDao=new UsersDao();
		usersDao.delete(Integer.parseInt(id));//���û�idɾ����¼
		
		//3.��ת���û���Ϣ�б�ҳ�棬ʵ�� ҳ��ˢ�� 
		resp.sendRedirect("/BookShop/userlist");
	}
	
	@Override 
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		 
	}

}
