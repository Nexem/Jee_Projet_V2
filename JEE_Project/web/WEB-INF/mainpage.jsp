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

                <c:forEach items="${employeesList}" var="emp">
                    <tr>
                        <td align="center"><input type="radio" name="Sel" value="Sel"/></td>
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
                </c:forEach>
            </table>
            <%}
        %>
        </br>
        <table>
            <tr>
                <form name="DeleteForm" action="Controller">
                    <input value="Delete" type="submit"/>
                </form>
                <form name="DetailsForm" action="details">
                    <input value="Details" type="submit"/>
                </form>
                <form name="AddForm" action="add">
                    <input value="Add" type="submit"/>
                </form>
            </tr>
        </table>
    </body>
</html>