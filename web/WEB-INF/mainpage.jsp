<%-- 
    Document   : mainpage
    Created on : 14 déc. 2018, 09:00:56
    Author     : vince
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
    </head>
    <body>
        <h1>List of employees</h1>
        <% 
            if(session.getAttribute("employeesList") == null){
                %>
                <h2 color="blue"><b>The club has no member</b></h2>
        <%  }
            else{%>
            <table style="width:100%">
                <tr>
                    <th>Sél</th>
                    <th>NAME</th>
                    <th>FIRST NAME</th>
                    <th>HOME PHONE</th>
                    <th>MOBILE PHONE</th>
                    <th>WORK PHONE</th>
                    <th>ADDRESS</th>
                    <th>POSTAL CODE</th>
                    <th>CITY</th>
                    <th>EMAIL</th>
                </tr>

                <c:forEach items="${employeesList}" var="emp">
                    <tr>
                        <input type="radio" name="Sel" value="Sel"/>
                        <td><c:out value="${emp.NAME}"/></td>
                        <td><c:out value="${emp.FIRSTNAME}"/></td>
                        <td><c:out value="${emp.HOME_PHONE}"/></td>
                        <td><c:out value="${emp.MOBILE_PHONE}"/></td>
                        <td><c:out value="${emp.WORK_PHONE}"/></td>
                        <td><c:out value="${emp.ADDRESS}"/></td>
                        <td><c:out value="${emp.POSTAL_CODE}"/></td>
                        <td><c:out value="${emp.CITY}"/></td>
                        <td><c:out value="${emp.EMAIL}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <form name="DeleteForm" action="Controller">
                <button value="Delete"/>
            </form>
            <form name="DetailsForm" action="details">
                <button value="Details"/>
            </form>
            <form name="AddForm" action="add">
                <button value="Add"/>
            </form>
            <%}
        %>
        
    </body>
</html>
