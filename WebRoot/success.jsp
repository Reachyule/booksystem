<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title><s:text name="基于SH的登录和注册系统"></s:text></title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
      
  </head>  
    
  <body bgcolor="#CCCCFF">  
    <hr>  
    <table border="0" align="center" bgcolor="#AABBCCDD">  
        <tr><td>欢迎${userName },登录成功！</td></tr>  
    </table>  
          
  </body>  
</html>  