<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息的新增页面</title>
</head>
<body>
<p>用户信息的新增</p>
<hr />
<p>
    <form method="post" action="/BookShop/useradd">
      <table border="0">
        <tr>
           <td>用户名</td><td><input id="username" name="username" /></td>
        </tr><tr>
           <td>密码</td><td><input id="password" name="password" /></td>
        </tr><tr>
           <td>性别</td><td>
              <select id="gender" name="gender">
                 <option value="1">男</option>
                 <option value="0">女</option>
              </select>
           </td>
        </tr><tr>
           <td>email</td><td><input id="email" name="email" /></td>
        </tr><tr>
           <td>电话</td><td><input id="telephone" name="telephone" /></td>
        </tr><tr>
           <td>简介</td><td><input id="introduce" name="introduce" /></td>
        </tr>
        <tr><td>&nbsp;</td><td>
          <button type="submit" >保存</button>
        </td></tr>
      </table>
    </form>
</p>

</body>
</html>