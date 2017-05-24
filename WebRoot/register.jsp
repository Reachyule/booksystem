<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title><s:text name="图书管理系统|注册"></s:text></title>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
  </head>  
    
  <body>  
  	<h2>图书管理系统</h2>
    <s:form action="register" method="post"> 
    	<div class="signup">
    	
		<s:textfield name="stuid" placeholder="请输入学号" label="学号" cssClass="UN"></s:textfield>
		<s:textfield name="stuname" placeholder="请输入姓名" label="姓名" cssClass="UN"></s:textfield>
		<s:select name="stusex"  label="性别" list="{'男','女'}" />
		
		<s:textfield name="stuage" placeholder="请输入年龄" label="年龄" cssClass="UN"></s:textfield>
		
		<s:textfield name="stuclass" placeholder="请输入班级" label="班级" cssClass="UN"></s:textfield>
		<!--  <input type="text" name="userName" placeholder="请输入用户名"  required="">-->
		<s:password name="password1" placeholder="请输入密码"  label="密码" cssClass="PW"></s:password>
	 	<!--<input type="password" name="password1" placeholder="" required="">-->
	 	<s:password name="password2" placeholder="请重复密码" label="重复密码" cssClass="PW"></s:password>
	 	<!--  <input type="password" name="password2" placeholder="" required="">-->
	 	<s:submit cssClass="BT" value="注册"></s:submit>
	 	<s:a cssClass="A" href="http://localhost:8080/boy/login.jsp">返回登录</s:a>
        </div>
        </s:form>                     
  </body>  
</html>  
