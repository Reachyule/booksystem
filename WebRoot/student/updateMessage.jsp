<%@page import="PO.Stuinfo"%>  
<%@page import="java.util.ArrayList"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib  prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>学生信息管理系统-修改</title>  
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
                    <s:a href="http://localhost:8080/boy/student/addMessage.jsp">添加学生信息</s:a>  
                </td>  
                <td width="25%">  
                    修改学生信息  
                </td>  
                <td width="25%">  
                    <s:a href="http://localhost:8080/boy/student/deleteMessage.jsp">删除学生信息</s:a>  
                </td>  
            </tr>  
        </table>  
        <br/>  
        <hr color="red"/>  
        <br/><br/><br/>  
        <font size="5">修改学生信息</font>  
        </s:div>  
        <s:form action="updateMessageAction" method="post">  
            <table align="center" width="30%" bgcolor="gray" border="5">  
                <%  
                ArrayList list=(ArrayList)session.getAttribute("oneInfo");  
                Stuinfo info=(Stuinfo)list.get(0);  
                %>  
                    <tr>  
                        <td>  
                            学号  
                        </td>  
                        <td>  
                            <input name="id" value="<%=info.getId()%>" readonly="readonly"/>  
                        </td>  
                    </tr>  
                    <tr>  
                        <td>  
                            姓名  
                        </td>  
                        <td>  
                            <input name="name" value="<%=info.getName()%>"/>  
                        </td>  
                    </tr>  
                    <tr>  
                        <td>  
                            性别  
                        </td>  
                        <td>  
                            <input name="sex" value="<%=info.getSex()%>"/>  
                        </td>  
                    </tr>  
                    <tr>  
                        <td>  
                            年龄  
                        </td>  
                        <td>  
                            <input name="age" value="<%=info.getAge()%>"/>  
                        </td>  
                    </tr>  
                    <tr>  
                        <td>  
                            体重  
                        </td>  
                        <td>  
                            <input name="weight" value="<%=info.getWeight()%>"/>  
                        </td>  
                    </tr>  
                    <tr>  
                        <td colspan="2">  
                            <s:submit value="提交"></s:submit>  
                        </td>  
                    </tr>  
                    <tr>  
                        <td align="center" colspan="2">  
                            <s:a href="http://localhost:8080/boy/student/findMessage.jsp">返回</s:a>  
                        </td>  
                    </tr>  
            </table>  
        </s:form>  
    </body>  
</html>  