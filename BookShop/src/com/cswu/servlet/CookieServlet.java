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
 * 会话技术：Cookie技术
 * 
 *@copyright:邓豪杰 0410190211
 */
public class CookieServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		String lastTime=null;
		
		//获取浏览器中的Cookie列表，（key-value）
		Cookie[] myCookies=req.getCookies();//Cookies数组
		
		//遍历Cookie列表 
		for(int i=0;i<myCookies.length;i++){
			if(myCookies[i].getName().equals("lastAccess")){
				lastTime=myCookies[i].getValue();
				break;
			}
		}
		
		String str="";
		if(lastTime==null){
			str="<html><head></head><body>你是首次访问本站!!</body></html>";
		}else{
			str="<html><head></head><body>你上次的访问时间是："+lastTime+"</body></html>";
		}
		
		//输出中文
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		
		PrintWriter pw=resp.getWriter();
		pw.write(str);
		
		//获取当前系统时间
		String time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		
		Cookie cookie=new Cookie("lastAccess",time);
		cookie.setMaxAge(3000);//设置Cookie的有效时间，单位 ：秒
		resp.addCookie(cookie); //向浏览器输出Cookie
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}
}
