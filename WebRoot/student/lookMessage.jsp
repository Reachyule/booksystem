<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList,PO.Stuinfo"%>  
<%@taglib  prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>学生信息管理系统-查看</title>  
    </head>  
    <body bgcolor="pink">  
        <s:div align="center">  
        <hr color="red"/>  
        <br/>  
        <table align="center" width="80%">  
            <tr>  
                <td width="25%">  
                    查看学生信息  
                </td>  
                <td width="25%">  
                    <s:a href="http://localhost:8080/boy/student/addMessage.jsp">添加学生信息</s:a>  
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
        <br/><br/><br/>  
        <span>你要查询的数据表中共有<%=request.getSession().getAttribute("count")%>人</span>  
        </s:div>  
        <table align="center" width="80%" border="5">  
            <tr>  
                <th>记录条数</th>  
                <th>学号</th>  
                <th>姓名</th>  
                <th>性别</th>  
                <th>年龄</th>  
                <th>体重</th>  
            </tr>  
            <%  
                ArrayList list=(ArrayList)session.getAttribute("allInfo");  
                if(list.isEmpty()){  
                    %>  
                    <tr>  
                        <td align="center">  
                            <span>暂无学生信息!</span>  
                        </td>  
                    </tr>  
                    <%  
                }else{  
                    for(int i=0;i<list.size();i++){  
                        Stuinfo info=(Stuinfo)list.get(i);  
                        %>  
                        <tr>  
                            <td align="center"><%=i+1%></td>  
                            <td><%=info.getId()%></td>  
                            <td><%=info.getName()%></td>  
                            <td><%=info.getSex()%></td>  
                            <td><%=info.getAge()%></td>  
                            <td><%=info.getWeight()%></td>  
                        </tr>  
                        <%  
                    }  
                }  
            %>  
        </table>  
    </body>  
</html>  
