<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>

<style type="text/css">

  #DataGrid1{
     bordercolor:gray;
     border:1;
     border-right:gray 1px solid;
     border-top:gray 1px solid;
     border-left:gray 1px solid;
     width:100%;
     word-break:break-all;
     border-bottom:gray 1px solid;
     border-collapse:collapse;
     background-color:white;
     word-wrap:break-word;
     text-align:center;
  }
  #tr2 td {
     cursor:hand;
     height:22px;
     text-align:center;
  }
  #tr2 img{
    width:16px;
    height:16px;
    border:0;
  }
  .button1{
  width:100px;
  height:40px;
  background-color:black;
  border-color:black;
  border-radius:10px;
  font-weight:bold;
  font-size:12pt;
  
 
  }
  button a{
   text-decoration:none;
   color:white;
   
  }
  #tr1{
   font-weight:bold;
   font-size:12pt;
   height:35px;
   background-color:black;
   color:white;
  }
  #tr1 td{
   width:11%;
  }
  #boxxx{
   border:2px solid gray;
   width:99.7%;
   height:100px;
   text-align:center;
   line-height:50px;
   color:black;
  }
    #keyword{
			 border:1px solid gray;
			 border-top-left-radius:8px;
			 border-bottom-left-radius:8px;
			 width:200px;
             height: 25px;
             padding:0px;
             float:left;
		     /*提示字首行缩进*/
		     text-indent: 10px;
	         /*去掉蓝色高亮框*/
	         outline: none;
	         margin-top:10px;
	         margin-left:240px;
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
             background:black;
             /*去掉submit按钮默认边框*/
             border:0px;
	         color:white;/*搜索的字体颜色为白色*/
	         cursor:pointer;/*鼠标变为小手*/
	         margin-top:10px;
	         font-weight:bold;
			}
			#tr2 {
			 color:gray;
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
			#rightbox{
			width:40%;
            height:50px;
            float:left;
     
			}
			#leftbox{
			 width:60%;
			 height:50px;
			 float:left;
			}
			#navbox{
			 margin-bottom:10px;
			 height:50px;
			 width:99.7%;
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
        <input type="text" name="keyword" id="keyword" placeholder="按商品编号查询"/>
         <button type="submit" value="查询" id="keytext" name="keytext" />查询
      </form>  
   </div>
   </div>
<form  method="post" action="/BookShop/ProductSelect">
   <table cellspaceing="0" cellpadding="0" rules="all" id="DataGrid1">
     <tr id="boxxx">
        <td colspan="8"><h2 text-align="center">商品列表</h2></td>
     </tr>
     <tr id="tr1">
       <td align="center" >商品编号</td>
       <td align="center" >商品名称</td>
       <td align="center" >商品价格</td>
       <td align="center" >商品类别</td>
       <td align="center" >商品数量</td>
       <td align="center" >商品描述</td>
       <td align="center" >编辑</td>
       <td align="center" >删除</td>
     </tr>
     <c:forEach  var="p"  items="${p}">
     <tr onmouseover="this.style.backgroundColor='#F5FAFE'"  onmouseout="this.style.backgroundColor='white'" id="tr2"  >
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>${p.category}</td>
        <td>${p.pnum}</td>
        <td>${p.description}</td>
        <td>
          <a href="ProductEdit?id=${p.id }">
             <img alt="编辑" src="images/bianji.png" />
          </a>
        </td>
         <td>
          <a href="ProductDelete?id=${p.id}">
             <img alt="删除" src="images/删除筛选项.png" />
          </a>
        </td>
     </tr>
    </c:forEach>
   
   </table>
</form>
</body>
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
     
    
    
</script>
</html>