<%-- 
    Document   : details
    Created on : 15 déc. 2018, 11:45:28
    Author     : louge
--%>

<%@page import="jee.model.EmployeeBean"%>
<%@page import="Utils.constants"%>
<%@page import="jee.model.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String id = (String)session.getAttribute("ID_user_details");
    String name = "";
    String firstname ="";
    EmployeeBean emp = null;
    if(id != null){
        session.removeAttribute("ID_user_details");
        DataAccess db = new DataAccess();

        String details_query = constants.QUERY_DETAILS_ID + id;
        emp = db.getEmployee(db.getResultSet(db.getStatement(db.getConnection()), details_query));
        name = emp.getName();
        firstname = emp.getFirstName();
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details <%out.print(name);%></title>
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
        <form name="DetailsForm" method ="POST" action="Controller">
            <table align="right">
                <h1>Details of employee : <%out.print(emp.getName()); out.print(("  " + emp.getFirstName()));%> </h1>
                <th>Nom</th><th><input type="text" name="nameField" value="<%out.print(emp.getName());%>"/></th>
                <th>Prénom</th><th><input type="text" name="prenomField" value="<%out.print(emp.getFirstName());%>"/> </th>
                <th>Tél dom</th><th><input type="text" name="tel_domField" value="<%out.print(emp.getHomePhone());%>"/> </th>
                <th>Tél mob</th><th><input type="text" name="tel_mobField" value="<%out.print(emp.getMobilePhone());%>"/> </th>
                <th>Tél pro</th><th><input type="text" name="tel_proField" value="<%out.print(emp.getWorkPhone());%>"/> </th>
                <th>Adresse</th><th><input type="text" name="adresseField" value="<%out.print(emp.getAddress());%>"/> </th>
                <th>Code postal</th><th><input type="text" name="codepostalField" value="$<%out.print(emp.getPostalCode());%>"/> </th>
                <th>Ville</th><th><input type="text" name="villeField" value="<%out.print(emp.getCity());%>"/> </th>
                <th>Adresse e-mail</th><th><input type="text" name="emailField" value="<%out.print(emp.getEmail());%>"/> </th>
                <input value="Save" name="SaveDetails" type="submit"/>
                <input value="Cancel" name="Cancel" type="submit"/>
            </table>
        </form>
    </body>
</html>


