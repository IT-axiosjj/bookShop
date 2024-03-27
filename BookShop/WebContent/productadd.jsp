<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息的编辑页面</title>
<style type="text/css">
   table{
     width:600px;
     height:250px;
     background-color:#afd1f3
   }
   input{
    width:510px;
   }
   button{
    margin:0px 20px;
    width:80px;
   }
   button a{
   text-decoration:none;
   }
</style>
</head>
<body>
<p>商品信息的新增</p>
<hr />
<p>
    <form method="post" action="/BookShop/ProductAdd">
      
      <table border="1">
        <tr>
           <td>商品名称</td><td><input id="name" name="name"}"/></td>
        </tr><tr>
           <td>商品价格</td><td><input id="price" name="price" /></td>
        </tr><tr>
           <td>商品类别</td><td><input id="category" name="category" /></td>
        </tr><tr>
           <td>商品数量</td><td><input id="pnum" name="pnum" ></td>
        </tr><tr>
           <td>商品描述</td><td><input id="description" name="description" /></td>
        </tr><tr>
          <td colspan="2" align="center"><button type="submit">保存</button><button type="reset"><a href="Products">取消</a></button></td>
        </tr>
      </table>
    </form>
</p>

</body>
</html>