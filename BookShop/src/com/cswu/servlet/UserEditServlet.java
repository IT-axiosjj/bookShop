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
 * ��ȡ�༭���û���Ϣ
 *@copyright:�˺��� 0410190211
 *
 */
public class UserEditServlet extends HttpServlet{
	
	@Override 
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		 req.setCharacterEncoding("utf-8");
		//1.��ȡҪ�༭�û���Ϣ���û�id
		String id=req.getParameter("id");
		
		//2.��ȡ���ݿ⣬�����û���Ϣ����id��
		UsersDao usersDao=new UsersDao();
		User user=usersDao.find(Integer.parseInt(id));//���û�ID����һ���û���Ϣ
		
		//3.���û���Ϣ����洢request��
		req.setAttribute("User", user);
		
		//4.ת�����û���Ϣ�༭ҳ��(useredit.jsp)
		RequestDispatcher rd=req.getRequestDispatcher("useredit.jsp");
		rd.forward(req, resp);
	}
	
	@Override 
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		 
	}

}
