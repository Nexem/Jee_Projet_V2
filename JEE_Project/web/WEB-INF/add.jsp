<%-- 
    Document   : add
    Created on : 15 déc. 2018, 11:39:11
    Author     : louge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add employee</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<script  src = "https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" > </script>
	<script  src = "C:\wamp\www\site\bootstrap\dist\js\bootstrap.min.js" > </script>
    </head>
    <body>
        <table align="right">
            <th style="color:blue">Your session is active</th>
            <td>
                <form action="Controller" method="POST">
                    <button type="submit" name="action" class="btn btn-default" aria-label="Left Align" value="Goodbye">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </button>
                </form>
            </td>
        </table>
        <form name="AddEmployee" action="Controller">
            <h1>Add a new employee</h1>
            <th>Nom </th><th><input type="text" name="nameField"/></th></br></br>
            <th>Prénom </th><th><input type="text" name="prenomField"/> </th></br></br>
            <th>Tél dom </th><th><input type="text" name="tel_domField"/> </th></br></br>
            <th>Tél mob </th><th><input type="text" name="tel_mobField"/> </th></br></br>
            <th>Tél pro </th><th><input type="text" name="tel_proField"/> </th></br></br>
            <th>Adresse </th><th><input type="text" name="adresseField"/> </th></br></br>
            <th>Code postal </th><th><input type="text" name="codepostalField"/> </th></br></br>
            <th>Ville </th><th><input type="text" name="villeField"/> </th></br></br>
            <th>Adresse e-mail </th><th><input type="text" name="emailField"/> </th></br></br>
            <input name="action" value="AddEmployee" type="submit"/>
            <input name= "action" value="Cancel" type="submit"/>
        </form>
    </body>
</html>
