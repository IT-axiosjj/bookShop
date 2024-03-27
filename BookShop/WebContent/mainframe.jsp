<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>春华园三舍书城管理系统</title>
		<style >
			body{
				margin:0;
				padding:0;
				font-size:12px;
				background-color: gray;
			}
			.clearit{
				clear:both;
			}
			
			#leftwrap{
				margin:0;
				padding:0;
				float:left;
				width:200px; /*固定宽度*/
				background: url(images/topv1.png) no-repeat top center;
				min-height: 600px;
				background-color: white;
			}
			/*后代选择器*/
			#leftwrap .logo{
				margin: 30px auto 40px;/*左右设置为auto居中*/
				padding:0;	
				text-align: center;
			}
			#leftwrap .logo span{
				margin:0;
				padding:0;
				position: relative;/*相对定位*/
				top:-8px; 
			}
			
			#leftwrap .logo span{
				font-size:22px;	
				color:white;
			}
			
			#leftwrap .user{
				margin:10px auto;/*左右设置为auto居中*/
				padding:0;
				text-align: center;
				border-radius: 50% 50%; /*画圆*/
				width:80px;
				height:80px;
				border: 1px solid white;
				background-color: white;
				overflow: hidden;/*隐藏超出部分*/
			}
			
			#leftwrap .subtitle {
				margin:0;
				padding:0;
				text-align: center;
				font-size: 16px;
			}
			
			#leftwrap ul{
				margin:10px 0;
				padding:0;
				list-style: none;
			}
			#leftwrap ul a{
				margin:0;
				padding:10px;
				font-size:18px;
				text-align: center;
				color:royalblue;
				display: block;  /*转化为块元素*/
				text-decoration: none;/*去掉下划线*/
			}
			#leftwrap ul a:hover{
				background-color: royalblue;
				color:white;
			}
			
			#rightwrap{
				margin:0;
				padding:0;
				float:left;
			}
			
			#rightwrap .topmenu{
				margin:0;
				padding:10px;
				background-color: white;
			}
			
			
			#rightwrap .lefticons{
				margin:0;
				padding:0;
				float:left;
				width:30%;
			}
			
			#rightwrap .searchbox{
				margin:0;
				padding:0;
				padding-top:6px; /*设置行高，内容垂直居中*/
				float:left;
				width:40%;
			}
			.searchbox #keyword{
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
			}
			.searchbox #keyword:hover{
			 border-color:#438AFE;
			}
			.searchbox #keytext{
			 border-top-right-radius:8px;
			 border-bottom-right-radius:8px;
			 float:left;
			 width:60px;
             height: 27px;
             background:#438AFE;
             /*去掉submit按钮默认边框*/
             border:0px;
	         color:white;/*搜索的字体颜色为白色*/
	         cursor:pointer;/*鼠标变为小手*/
			}
			
			#rightwrap .navwrap{
				margin:0;
				padding:0;
				float:right;
				width:140px;
			}
			.navwrap img{
			 margin-left:15px;
			 margin-top:10px;
			}
			#rightwrap .contentwrap{
				margin: 15px;
				padding:10px;
				background-color: white;
				min-height: 500px;
			}
			
			.lefticons img{
			  margin-left:5px;
			  margin-top:10px;
			  position:relative;
			}
			
		</style>
	<body>
		<div id="leftwrap">
			<div class="logo">
				<img src="images/logo2.png" alt="logo图片" width="30" height="30" />
				<span>书城管理系统</span>
			</div>
			<div class="user">
				<img src="images/logo21.JPG" alt="当前登录用户头像"  width="80" height="80" /> 
			</div>
			<div class="subtitle">
				欢迎访问书城管理系统
			</div>
			<ul>
			  <!-- 标签库中的遍历标签实现动态数据的显示  -->
			  <c:forEach items="${menus}" var="menu">
				<li><a href="${menu.url}" target="contentwrap" >${menu.name}</a></li>
			  </c:forEach>
			</ul>
			<div class="clearit"></div>
		</div>
		<div id="rightwrap">
			<div class="topmenu">
				<div class="lefticons">
					<img src="images/菜单.png" width="25" height="20" />
					<img src="images/工具.png" width="20" height="20" />
				</div>
				<div class="searchbox">
					<form>
						<input type="text" id="keyword" name="keyword" placeholder="请输入搜索内容"/>
						<input type="button" value="搜索" id="keytext" />
					</form>
				</div>
				<div class="navwrap">
					<a href="#" ><img src="images/云.png" width="20" height="20"  /></a>
					<a href="#" ><img src="images/通知.png" width="20" height="20"  /></a>
					<a href="/BookShop/logout" ><img src="images/退出.png" width="20" height="20"  /></a>
				</div>
			    <div class="clearit"></div>
			</div>
			<iframe id="contentwrap" name="contentwrap" src="welcome.jsp" class="contentwrap">
			</iframe>
		</div>
	    <div class="clearit"></div>
	</body>
	<script>
		//定义函数变量
		let fun=function(){
			
			let w=window.innerWidth;
			let h=window.innerHeight;			
			
			console.log("宽度："+w+"，高度："+h)		
				
		    let leftbox=document.getElementById("leftwrap");//左侧盒子的对象 
			leftbox.style.height=h+"px";  //设置左侧盒子的高度
			
			let rightbox=document.getElementById("rightwrap");
			rightbox.style.width=(w-leftbox.clientWidth-18)+"px";//设置右侧盒子的宽度		
			
			
			let workbox=document.getElementById("contentwrap");
			workbox.style.width=(w-260)+"px";//设置工作区盒子的宽度
			workbox.style.height=(h-110)+"px";//设置工作区盒子的高度		
		}
		
		//页面加载完成后触发onload事件
		window.onload=fun;   		
		//当浏览器大小改变时触发onresise事件
		window.onresize=fun;
	</script>
</html>
