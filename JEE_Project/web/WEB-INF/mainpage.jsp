<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
    </head>
    <body>
        <table align="right">
            <th style="color:blue">Your session is active</th>
            <td>
                <form action="Controller" method="POST">
                    <button type="submit" name="OffButton" value="goodbye">Disconnect</button>
                    <!--input type="image" src="../../../image.jpg" name="OffButton" value="goodbye" width="100" height="100"-->
                </form>
            </td>
        </table>
        <h1>List of employees</h1>
        <% 
            if(session.getAttribute("employeesList") == null){
                %>
                <h2 color="blue"><b>The club has no member</b></h2>
                </br>
                <form name="AddForm" action="Controller">
                    <input value="Add" name="button" type="submit"/>
                </form>
        <%  }
            else{
                if (session.getAttribute("message")!= null){
                    out.println(session.getAttribute("message"));
                    session.removeAttribute("message");
                }  
        %>
        <form name="ListForm"  method ="GET" action="Controller">    
            <table style="width:98%; table-layout:fixed">
                <tr>
                    <th style="width:3%">Sél</th>
                    <th align="center">NAME</th>
                    <th align="center">FIRST NAME</th>
                    <th align="center">HOME PHONE</th>
                    <th align="center">MOBILE PHONE</th>
                    <th align="center">WORK PHONE</th>
                    <th align="center">ADDRESS</th>
                    <th align="center">POSTAL CODE</th>
                    <th align="center">CITY</th>
                    <th align="center">EMAIL</th>
                </tr>

                <%
                    int i = 1;
                    %>
                <c:forEach items="${employeesList}" var="emp">
                    <tr>
                        <td align="center"><input type="radio" name="ID" value="<% out.print(i); %>"/></td>
                        <td align="center"><c:out value="${emp.name}"/></td>
                        <td align="center"><c:out value="${emp.firstName}"/></td>
                        <td align="center"><c:out value="${emp.homePhone}"/></td>
                        <td align="center"><c:out value="${emp.mobilePhone}"/></td>
                        <td align="center"><c:out value="${emp.workPhone}"/></td>
                        <td align="center"><c:out value="${emp.address}"/></td>
                        <td align="center"><c:out value="${emp.postalCode}"/></td>
                        <td align="center"><c:out value="${emp.city}"/></td>
                        <td align="center"><c:out value="${emp.email}"/></td>

                    </tr>
                    <%
                    i ++;
                %>
                </c:forEach>
                
            </table>
            </br>
        <table>
            <tr>
                <input value="Delete" name="button" type="submit"/>
                <input value="Details" name="button" type="submit"/>
                <input value="Add" name="button" type="submit"/>
            </tr>
        </table>
            </form>
            <%}
        %>
        
    </body>
</html>