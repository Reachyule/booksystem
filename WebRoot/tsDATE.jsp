<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/app.v2.css" type="text/css" />
	<link rel="stylesheet" href="js\calendar/bootstrap_calendar.css" type="text/css" cache="false" />
  </head>
  
  <body>
    <section class="vbox">
  <header class="bg-dark dk header navbar navbar-fixed-top-xs">
    <div class="navbar-header aside-md"> <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen" data-target="#nav"> <i class="fa fa-bars"></i> </a> <a href="#" class="navbar-brand" data-toggle="fullscreen"><img src="images/logo.png" class="m-r-sm">图书管理</a> <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user"> <i class="fa fa-cog"></i> </a> </div>     
    </ul>
  </header>
  <section>
    <section class="hbox stretch"> 
<!-- .aside -->
      <aside class="bg-dark lter aside-md hidden-print" id="nav">
        <section class="vbox">
          
          <section class="w-f scrollable">
            <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="5px" data-color="#333333"> 
               <!-- 左侧导航 -->
              <nav class="nav-primary hidden-xs" style="height:500px">
                <ul class="nav">
                  <li class="active"> <a href="http://localhost:8080/boy/index.jsp" class="active"> <i class="fa fa-file-text icon"> <b class="bg-primary"></b> </i> <span>主页</span> </a> </li>
                  <li > <a href="...." > <i class="fa fa-columns icon"> <b class="bg-warning"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>图书信息管理</span> </a>
                    <ul class="nav lt">
                    	<li > <a href="tsquery" > <i class="fa fa-angle-right"></i> <span>查询图书信息</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/tsadd.jsp" > <i class="fa fa-angle-right"></i> <span>增加图书信息</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/tsrevise.jsp" > <i class="fa fa-angle-right"></i> <span>修改图书信息</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/tsdel.jsp" > <i class="fa fa-angle-right"></i> <span>删除图书信息</span> </a> </li>
                    </ul>
                  </li>
                  <li > <a href="....." > <i class="fa fa-file-text icon"> <b class="bg-primary"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>读者信息管理</span> </a>
                    <ul class="nav lt">
                    	<li > <a href="stuQuery" > <i class="fa fa-angle-right"></i> <span>查询读者信息</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/stuadd.jsp" > <i class="fa fa-angle-right"></i> <span>注册读者信息</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/sturevise.jsp" > <i class="fa fa-angle-right"></i> <span>修改读者信息</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/studel.jsp" > <i class="fa fa-angle-right"></i> <span>删除读者信息</span> </a> </li>
                    </ul>
                  </li>
                  <li > <a href="......" > <i class="fa fa-file-text icon"> <b class="bg-primary"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>管理员信息管理</span> </a>
                    <ul class="nav lt">
                    	<li > <a href="adminQuery" > <i class="fa fa-angle-right"></i> <span>查询管理员</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/adminadd.jsp" > <i class="fa fa-angle-right"></i> <span>注册管理员</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/adminrevise.jsp" > <i class="fa fa-angle-right"></i> <span>修改管理员</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/admindel.jsp" > <i class="fa fa-angle-right"></i> <span>删除管理员</span> </a> </li>
                      
                    </ul>
                  </li>
                   <li > <a href="......" > <i class="fa fa-file-text icon"> <b class="bg-primary"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>图书借阅管理</span> </a>
                    <ul class="nav lt">
                      <li > <a href="http://localhost:8080/boy/Loan.jsp" > <i class="fa fa-angle-right"></i> <span>借书管理</span> </a> </li>
                      <li > <a href="http://localhost:8080/boy/return.jsp" > <i class="fa fa-angle-right"></i> <span>还书管理</span> </a> </li> 
                    </ul>
                  </li>    
                </ul>
              </nav>
               </div>
          </section>
          <footer class="footer lt hidden-xs b-t b-dark">
            <div id="chat" class="dropup">
              <section class="dropdown-menu on aside-md m-l-n">
                <section class="panel bg-white">
                  <header class="panel-heading b-b b-light">Active chats</header>
                  <div class="panel-body animated fadeInRight">
                    <p class="text-sm">No active chats.</p>
                    <p><a href="#" class="btn btn-sm btn-default">Start a chat</a></p>
                  </div>
                </section>
              </section>
            </div>
            <div id="invite" class="dropup">
              <section class="dropdown-menu on aside-md m-l-n">
                <section class="panel bg-white">
                  <header class="panel-heading b-b b-light"> John <i class="fa fa-circle text-success"></i> </header>
                  <div class="panel-body animated fadeInRight">
                    <p class="text-sm">No contacts in your lists.</p>
                    <p><a href="#" class="btn btn-sm btn-facebook"><i class="fa fa-fw fa-facebook"></i> Invite from Facebook</a></p>
                  </div>
                </section>
              </section>
            </div>
            <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-dark btn-icon"> <i class="fa fa-angle-left text"></i> <i class="fa fa-angle-right text-active"></i> </a>
            <div class="btn btn-icon btn-sm btn-dark">
              <a href="....." > <i class=".nav-primary ul.nav>li>a"></i> <span>退出</span> </a> 
            </div>
          </footer>
        </section>
      </aside>
      <section id="content">
        <section class="vbox">
          <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
              <li><a href="http://localhost:8080/boy/index.jsp"><i class="fa fa-home"></i> Home</a></li>
              <li class="active">主页</li>
            </ul>
            <div class="m-b-md">
              <h3 class="m-b-none">图书管理系统</h3>
              <small>借阅信息查询</small> </div>
             
          </section>
        </section>
        <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a> </section>
      <aside class="bg-light lter b-l aside-md hide" id="notes">
        <div class="wrapper">Notification</div>
      </aside>
    </section>
  </section>
</section>
<script src="js/app.v2.js"></script> <!-- Bootstrap -->  <script src="js/charts/easypiechart/jquery.easy-pie-chart.js" cache="false"></script> <script src="js/charts/sparkline/jquery.sparkline.min.js" cache="false"></script> <script src="js/charts/flot/jquery.flot.min.js" cache="false"></script> <script src="js/charts/flot/jquery.flot.tooltip.min.js" cache="false"></script> <script src="js/charts/flot/jquery.flot.resize.js" cache="false"></script> <script src="js/charts/flot/jquery.flot.grow.js" cache="false"></script> <script src="js/charts/flot/demo.js" cache="false"></script> <script src="js/calendar/bootstrap_calendar.js" cache="false"></script> <script src="js/calendar/demo.js" cache="false"></script> <script src="js/sortable/jquery.sortable.js" cache="false"></script>
  </body>
</html>
