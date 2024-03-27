package com.cswu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �Ự������Cookie����
 * 
 *@copyright:�˺��� 0410190211
 */
public class CookieServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		String lastTime=null;
		
		//��ȡ������е�Cookie�б���key-value��
		Cookie[] myCookies=req.getCookies();//Cookies����
		
		//����Cookie�б� 
		for(int i=0;i<myCookies.length;i++){
			if(myCookies[i].getName().equals("lastAccess")){
				lastTime=myCookies[i].getValue();
				break;
			}
		}
		
		String str="";
		if(lastTime==null){
			str="<html><head></head><body>�����״η��ʱ�վ!!</body></html>";
		}else{
			str="<html><head></head><body>���ϴεķ���ʱ���ǣ�"+lastTime+"</body></html>";
		}
		
		//�������
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		
		PrintWriter pw=resp.getWriter();
		pw.write(str);
		
		//��ȡ��ǰϵͳʱ��
		String time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		
		Cookie cookie=new Cookie("lastAccess",time);
		cookie.setMaxAge(3000);//����Cookie����Чʱ�䣬��λ ����
		resp.addCookie(cookie); //����������Cookie
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}
}
