<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息列表页</title>
<style type="text/css">
    table
        {
            border-collapse: collapse;
            border-spacing: 0;
            margin: 0 auto;
            text-align: center;
        }
     th {
     background-color: #000000;
     color: white;
        }
     body a{
      text-decoration:none;
      color:#000000;
     }
     table td, table th
        {
            border: 1px solid gray;
            color: #666;
            height: 30px;
        }
      table th{
       color:white;
       width:14%;
       height:35px;
      }
      #rightbox{
      
       width:40%;
       height:50px;
       float:left;
     
      }
      #keyword{
			 border:1px solid gray;
			 border-top-left-radius:8px;
			 border-bottom-left-radius:8px;
			 width:240px;
             height: 25px;
             padding:0px;
             float:left;
		    /*提示字首行缩进*/
		     text-indent: 10px;
	        /*去掉蓝色高亮框*/
	        outline: none;
	        margin-top:10px;
	        margin-left:200px;
	      
			}
			 #keyword:hover{
			 border-color:#438AFE;
			}
			 #keytext{
			 border-top-right-radius:8px;
			 border-bottom-right-radius:8px;
			 float:left;
			 width:60px;
             height: 27px;
             background:#000000;
             /*去掉submit按钮默认边框*/
             border:0px;
	         color:white;/*搜索的字体颜色为白色*/
	         cursor:pointer;/*鼠标变为小手*/
	         margin-top:10px;
	        
			}
			#navbox{
			
			 width:100%;
			 height:50px;
			}
			#leftbox{
			 
			 width:60%;
			 height:50px;
			 float:left;
			}
			#leftbox button{
			 width:60px;
			 height:30px;
			 background-color:#000000;
			 margin-top:10px;
			 border-radius:6px;
			 cursor:pointer;/*鼠标变为小手*/
			}
			#leftbox a{
			  color:white;
			  font-weight:bold;
			}
			
</style>
</head>
<body>
<div id="navbox">
    <div id="leftbox">
      <button><a href="useradd.jsp">添&nbsp;&nbsp;&nbsp;加</a></button>
   </div>
   <div id="rightbox">
      <form action="" method="post">
        <input type="text" name="keyword" id="keyword">
        <input type="submit" value="查询" id="keytext" />
      </form>  
   </div>
   </div>
   <hr />
   <p>
      <table  style="width:100%;">
         <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>编辑信息</th>
            <th>删除信息</th>
         </tr>
         <c:forEach var="user" items="${Users}">
         <tr>
            <td>${user.id }</td>
            <td>${user.username }</td>
            <td>${user.gender }</td>
            <td>${user.email }</td>
            <td>${user.telephone }</td>
            <td><a href="useredit?id=${user.id }" >编辑</a></td>
            <td><a href="userdelete?id=${user.id }">删除</a></td>
          
         </tr>
         </c:forEach>
      </table>
   </p>
</body>
</html>