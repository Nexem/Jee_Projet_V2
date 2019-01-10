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
                <h1>Details of employee : <%out.print(emp.getName()); out.print(("  " + emp.getFirstName()));%> </h1>
                
                <input type="text" name="ID" value="<%out.print(id);%>" disabled="disabled"/></br></br>
                Nom <input type="text" name="nameField" value="<%out.print(emp.getName());%>"/></br></br>
                Prénom <input type="text" name="prenomField" value="<%out.print(emp.getFirstName());%>"/> </br></br>
                Tél dom <input type="text" name="tel_domField" value="<%out.print(emp.getHomePhone());%>"/> </br></br>
                Tél mob <input type="text" name="tel_mobField" value="<%out.print(emp.getMobilePhone());%>"/> </br></br>
                Tél pro <input type="text" name="tel_proField" value="<%out.print(emp.getWorkPhone());%>"/> </br></br>
                Adresse <input type="text" name="adresseField" value="<%out.print(emp.getAddress());%>"/> </br></br>
                Code postal <input type="text" name="codepostalField" value="<%out.print(emp.getPostalCode());%>"/> </br></br>
                Ville <input type="text" name="villeField" value="<%out.print(emp.getCity());%>"/> </br></br>
                Adresse e-mail <input type="text" name="emailField" value="<%out.print(emp.getEmail());%>"/> </br></br>  
            </table>
        </form>
        <form name="DetailsButtonsForm" method ="POST" action="Controller">
            <input value="Save modifications" name="action" type="submit"/>
            <input value="Cancel modifications" name="action" type="submit"/>
        </form>
    </body>
</html>


