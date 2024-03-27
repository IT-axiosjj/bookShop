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
 * �û���Ϣ���б�
 * @copyright:�˺��� 0410190211
 *
 */
public class UserListServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		 req.setCharacterEncoding("utf-8");
		//1.��ȡ���ݿ��Users�е���������
		UsersDao usersDao=new UsersDao();
		List<User> usersList=usersDao.findAll();//�������е��û���Ϣ
				 
		//2.�����ݱ�����request  �洢���ݵķ�ʽ��(page,request,session,application)
		req.setAttribute("Users", usersList);
				 
		//3.ת����JSP�ļ���
		RequestDispatcher rd=req.getRequestDispatcher("userlist.jsp");
		rd.forward(req, resp);				 
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}
} 
