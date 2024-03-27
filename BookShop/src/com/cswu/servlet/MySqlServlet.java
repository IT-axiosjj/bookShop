package com.cswu.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现Java连接Mysql的连接
 * 
 *@copyright:邓豪杰 0410190211
 */
public class MySqlServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		
		try{
		//Java访问Mysql数据库的步骤：
		//1.注册MySql的驱动程序 
		  Class.forName("com.mysql.jdbc.Driver");
		//2.创建一个数据库连接(Connection对象)
		  String url="jdbc:mysql://localhost:3306/students";
		  Connection conn=DriverManager.getConnection(url,"root","123456");
		//3.返回数据库连接的状态(Statement对象 )
		  Statement stmt=conn.createStatement();
		//4.通过Statement对象执行Sql语句 
		  boolean b=stmt.execute("insert into users ()Values()");//执行插入、删除、更新的语句，返回boolean
		  ResultSet result=stmt.executeQuery("select * from users");//执行查询语句，返回ResultSet结果集
		  
		  //遍历结果集
		  while(result.next()){
			  result.getString(0);//通过列的索引编号进行返回值 
			  result.getString("name");//通过字段名称返回值 
			  result.getInt("age");			  
		  }	  		  
		  
		//5.关闭连接，释放资源
		  result.close();
		  stmt.close();
		  conn.close();	  
		  
		}catch(Exception e){
			
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}

}
