<%-- 
    Document   : details
    Created on : 15 déc. 2018, 11:45:28
    Author     : louge
--%>

<%@page import="jee.model.EmployeeBean"%>
<%@page import="jee.model.constants"%>
<%@page import="jee.model.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    if(session.getAttribute("ID_user_details") != null){
        String ID = (String)session.getAttribute("ID_user_details");
        session.removeAttribute("ID_user_details");
        DataAccess db = new DataAccess();

        String details_query = constants.QUERY_DETAILS_ID + ID;
        EmployeeBean emp = db.getEmployee(db.getResultSet(db.getStatement(db.getConnection()), details_query));

    }
    
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details</title>
    </head>
    <body>
        <form name="DetailsForm" method ="POST" action="Controller">
        <h1>Details of employee : ${emp.name} ${emp.firstName}</h1>
        <th>Nom</th><th><input type="text" name="nameField" value="${emp.name}"/></th>
        <th>Prénom</th><th><input type="text" name="prenomField" value="${emp.firstName}"/> </th>
        <th>Tél dom</th><th><input type="text" name="tel_domField" value="${emp.homePhone}"/> </th>
        <th>Tél mob</th><th><input type="text" name="tel_mobField" value="${emp.mobilePhone}"/> </th>
        <th>Tél pro</th><th><input type="text" name="tel_proField" value="${emp.workPhone}"/> </th>
        <th>Adresse</th><th><input type="text" name="adresseField" value="${emp.address}"/> </th>
        <th>Code postal</th><th><input type="text" name="codepostalField" value="${emp.postalCode}"/> </th>
        <th>Ville</th><th><input type="text" name="villeField" value="${emp.city}"/> </th>
        <th>Adresse e-mail</th><th><input type="text" name="emailField" value="${emp.email}"/> </th>
        <input value="Save" name="SaveDetails" type="submit"/>
            <input value="Cancel" name="Cancel" type="submit"/>
        </form>
    </body>
</html>


