<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cswu.entity.Loginer" %>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
     String str="Hello,Lee";
     int a=10,b=33;
  
    Loginer myloginer=new Loginer();
    myloginer.setUsername("leeeeeeeeeeeee");
    
     out.print("这是一行文本内容");     
     pageContext.getOut().print("xxxxxxxxxxxx");
     pageContext.getSession();
     pageContext.getRequest();
     pageContext.getResponse();
     
  %>
  <p>欢迎访问,<%=myloginer.getUsername() %></p>
  <p><%=a+b %></p>
  
  
  <%
     //内置对象 
      String name=request.getParameter("name");  
      PrintWriter pw=response.getWriter();//输出流
      pw.write("XXXXXXXXXXXXXXXXXXXXXXXXX");
  %>
  <p>name值为：<%=name %> </p>
  
  <%
     out.print(config.getServletName());
  %>
  
  <%
    Loginer loginer=(Loginer)session.getAttribute("loginer");
  
     //application.getAttribute(arg0)
  %>
  
     <p>当前登录的用户是：<%=loginer.getUsername() %></p>
  
  
</body>
</html>