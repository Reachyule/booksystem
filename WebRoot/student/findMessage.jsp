<%@page import="java.util.ArrayList"%>  
<%@page import="PO.Stuinfo"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib  prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title><s:text name="学生信息管理系统-修改"/></title>  
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
        <s:form action="findMessageAction" method="post">  
        <table align="center" width="40%" border="5">  
            <tr>  
                <td>  
                    请选择要修改学生的学号：  
                </td>  
                <td>  
                    <select name="id">  
                         <%  
                            ArrayList list=(ArrayList)session.getAttribute("allInfo");  
                            if(list.isEmpty()){  
                                %>  
                                <option value="null">null</option>  
                                <%  
                            }else{  
                                for(int i=0;i<list.size();i++){  
                                    Stuinfo info=(Stuinfo)list.get(i);  
                                    %>  
                                        <option value="<%=info.getId()%>"><%=info.getId()%></option>  
                                    <%  
                                    }  
                                }  
                            %>  
                    </select>  
                </td>  
                <td>  
                    <s:submit value="确定"></s:submit>  
                </td>  
            </tr>  
        </table>  
        </s:form>  
    </body>  
</html>  
