<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title><s:text name="图书管理系统|登录"></s:text></title>  
    <link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/iconfont.css" />
	<link rel="stylesheet" href="css/login.css" />
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
      
  </head>  
   
  <body>  
  <div id="top-bar">
		<div class="wrap clearfix">
			<h1 id="logo" class="pull-left"><a href="###" title="">XXX</a></h1>
		</div>
	</div>
	<div id="login">
		<div class="wrap clearfix">
			<div class="login-img pull-left"></div>
			<div class="login-form pull-right">
				<div class="hd clearfix">
					<h2>学生登录</h2>
					<h2>管理登录</h2>
				</div>
				<div class="alert-error" class="alert alert-danger"><i class="iconfont">&#xe631;</i> <span></span></div>
				<div class="bd">
					<s:form id="login-form-stu" action="login1" method="post">
						<div class="input-group">
							<s:textfield name="stuid" placeholder="学号" cssClass="form-control"></s:textfield>
							<!-- <input type="text" class="form-control" placeholder="学号" name="userName"> -->
						</div>
						<div class="input-group">
							<!--<span class="input-group-addon iconfont">&#xe61c;</span>-->
							<s:password name="stupassword" placeholder="密码" cssClass="form-control"></s:password>
							<!--<input type="password" class="form-control" placeholder="密码" name="password">-->
						</div>
						<!--  <input type="hidden" name="flag" value="" />-->
						<!--  <button class="btn btn-warning btn-block" type="submit">登录</button>-->
						<s:submit cssClass="btn btn-warning btn-block" value="学生登录"></s:submit>
					</s:form>
				</div>
				<div class="bd">
					<s:form id="login-form-admin" action="login2" method="post">
						<div class="input-group">
							<s:textfield name="adminname" placeholder="管理员账号" cssClass="form-control"></s:textfield>
						</div>
						<div class="input-group">
							<s:password name="adminpassword" placeholder="管理员密码" cssClass="form-control"></s:password>
						</div>
						<s:submit cssClass="btn btn-warning btn-block" value="管理员登录"></s:submit>
					</s:form>
				</div>
				<div class="forget clearfix">
					<a class="pull-left" href="http://localhost:8080/boy/register.jsp" title="注册新用户" data-toggle="tooltip" data-placement="top">注册新用户</a>
					<a class="pull-right" href="###" title="通过验证信息找回密码" data-toggle="tooltip" data-placement="top">忘记密码</a>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<div class="wrap text-center">
	</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
    	(function() {
    		$("[data-toggle='tooltip']").tooltip();
            //点击刷新验证码
            var src = $(".verify").attr('src');
            $(".verify").click(function() {
                $(this).attr('src', src + '?random=' + Math.random());
            });
            //勾选
            $(".auto").change(function() {
            	if ($(this).prop('checked')) {
            		$(this).parent().parent().siblings('.auto-danger').stop(true).slideDown(300);
            	} else {
            		$(this).parent().parent().siblings('.auto-danger').stop(true).slideUp(300);
            	}
            });
            //tab
			var hd = $('.hd h2');
			var bd = $('.bd');
			hd.each(function(i) {
				$(this).hover(function() {
					$(this).addClass('on').siblings().removeClass('on');
					bd.eq(i).show().siblings('.bd').hide();
				});
			});
			hd.eq(0).trigger('mouseover');
        })();
    </script>
  </body>  
</html>  
