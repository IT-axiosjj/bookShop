<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息</title>

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
  }
   td{
    text-align:center;
    color:gray;
  }
  .tr1 td{
   color:white;
    height:30px;
  }
 
  .box td{
   color:black;
   text-align:center;
  background-color:white;
  
  }
</style>
</head>
<body>
   <table cellspaceing="0" cellpadding="0" rules="all" id="DataGrid1">
    <tr class="box">
    <td colspan="8"><h2>订单信息</h2></td>
   </tr>
     <tr style="font-weight:bold;font-size:12pt;height:25px;background-color:black;" class="tr1">
       <td align="center" >商品编号</td>
       <td align="center" >订单编号</td>
       <td align="center" >总价</td>
       <td align="center" >支付状态</td>
       <td align="center" >收件人</td>
       <td align="center" >地址</td>
       <td align="center" >联系电话</td>
       <td align="center" >购买时间</td>
     </tr>
     <c:forEach items="${orders}" var="order" >
     <tr onmouseover="this.style.backgroundColor='#F5FAFE'"  onmouseout="this.style.backgroundColor='white'" id="tr2">
        <td>${order.id}</td>
        <td>${order.user_id}</td>
        <td>${order.money}</td>
        <td>${order.pay_state}</td>
        <td>${order.guest_name}</td>
        <td>${order.guest_address}</td>
        <td>${order.guest_phone}</td>
        <td>${order.order_time}</td>
        
     </tr>
    </c:forEach>
   
   </table>
</body>
</html>