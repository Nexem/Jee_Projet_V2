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
                        <td><input type="radio" name="Sel" value="Sel"/><td>
                        <td><c:out value="${emp.name}"/></td>
                        <td><c:out value="${emp.firstName}"/></td>
                        <td><c:out value="${emp.homePhone}"/></td>
                        <td><c:out value="${emp.mobilePhone}"/></td>
                        <td><c:out value="${emp.workPhone}"/></td>
                        <td><c:out value="${emp.address}"/></td>
                        <td><c:out value="${emp.postalCode}"/></td>
                        <td><c:out value="${emp.city}"/></td>
                        <td><c:out value="${emp.email}"/></td>
                        
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