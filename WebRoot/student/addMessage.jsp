<%@page contentType="text/html" pageEncoding="UTF-8" %>  
<%@taglib  prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title><s:text name="学生信息管理系统-增加"/></title>  
    </head>  
    <body bgcolor="pink">  
        <s:div align="center">  
            <hr color="red"/>  
        <br/>  
        <table align="center" width="80%">  
            <tr>  
                <td width="25%">  
                    <s:a href="http://localhost:8080/boy/student/lookMessage.jsp">查看学生信息</s:a>  
                </td>  
                <td width="25%">  
                    添加学生信息  
                </td>  
                <td width="25%">  
                    <s:a href="http://localhost:8080/boy/student/findMessage.jsp">修改学生信息</s:a>  
                </td>  
                <td width="25%">  
                    <s:a href="http://localhost:8080/boy/student/deleteMessage.jsp">删除学生信息</s:a>  
                </td>  
            </tr>  
        </table>  
         <br/>  
        <hr color="red"/>         
        <center><font color="red" size="6">添加学生信息</font></center>  
        </s:div>  
        <s:form action="addMessageAction" method="post">  
            <table align="center" width="30%" bgcolor="gray" border="5">  
                <tr>  
                    <td>  
                        <s:textfield name="id" label="学号" maxLength="16"></s:textfield>  
                    </td>  
                    <td>  
                        <s:textfield name="name" label="姓名" maxLength="16"/>  
                    </td>  
                    <td>  
                        <s:select name="sex" label="性别" list="{'男','女'}"/>  
                    </td>  
                    <td>  
                        <s:textfield name="age" label="年龄"/>  
                    </td>  
                    <td>  
                        <s:textfield name="weight" label="体重"/>  
                    </td>  
                    <td colspan="2">  
                        <s:submit value="提交"/>  
                        <s:reset value="清除"/>  
                    </td>  
                </tr>  
            </table>  
        </s:form>  
    </body>  
</html>  
