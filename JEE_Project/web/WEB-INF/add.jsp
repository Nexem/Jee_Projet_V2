<%-- 
    Document   : add
    Created on : 15 déc. 2018, 11:39:11
    Author     : louge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add employee</title>
    </head>
    <body>
        <h1>Add a new employee</h1>
        <th>Nom</th><th><input type="text" name="nameField"/></th>
        <th>Prénom</th><th><input type="text" name="prenomField"/> </th>
        <th>Tél dom</th><th><input type="text" name="tel_domField"/> </th>
        <th>Tél mob</th><th><input type="text" name="tel_mobField"/> </th>
        <th>Tél pro</th><th><input type="text" name="tel_proField"/> </th>
        <th>Adresse</th><th><input type="text" name="adresseField"/> </th>
        <th>Code postal</th><th><input type="text" name="codepostalField"/> </th>
        <th>Ville</th><th><input type="text" name="villeField"/> </th>
        <th>Adresse e-mail</th><th><input type="text" name="emailField"/> </th>
        <form name="SaveForm" action="Controller">
            <input value="Save" type="submit"/>
        </form>
        <form name="CancelForm" action="mainpage">
            <input value="Cancel" type="submit"/>
        </form>
    </body>
</html>
