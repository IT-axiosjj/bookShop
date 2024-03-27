package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu.dao.UsersDao;
import com.cswu.entity.User;

/**
 * �û���Ϣ����������
 *
 *@copyright:�˺��� 0410190211
 */
public class UserAddServlet  extends HttpServlet{
	
	@Override 
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		
	}
	
	@Override 
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		 req.setCharacterEncoding("utf-8");
		//1.��ȡǰ��ҳ���еı�����
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String telephone=req.getParameter("telephone");
		String introduce=req.getParameter("introduce");
		
		//2.����ת��Ϊ����
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setIntroduce(introduce);
		
		//3.��user������뵽���ݿ�
		UsersDao usersDao=new UsersDao();
		usersDao.insert(user);//��������뵽���ݿ���
		
		//4.��ת���û���Ϣ�б�userlist.jsp,ʵ���û����ݵ�ˢ�� 
		resp.sendRedirect("/BookShop/userlist");
	}

}
