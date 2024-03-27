<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>pageContext测试</title>
</head>
<body>
   <% 
      pageContext.setAttribute("data1", "123",pageContext.PAGE_SCOPE);
   pageContext.setAttribute("data2", "123",pageContext.REQUEST_SCOPE);
   pageContext.setAttribute("data3", "123",pageContext.SESSION_SCOPE);
   pageContext.setAttribute("data4", "123",pageContext.APPLICATION_SCOPE);
   
   pageContext.getAttribute("data1",pageContext.PAGE_SCOPE);
   pageContext.removeAttribute("data1",pageContext.PAGE_SCOPE);
   
   
   %>
   
   <!-- 代码重用 -->
   <jsp:include page="welcome.jsp" />
   <%-- 跳转 
   <jsp:forward page="test.jsp">
     <jsp:param name="asdf" value="asdf" />
   </jsp:forward>
   --%>
</body>
</html>