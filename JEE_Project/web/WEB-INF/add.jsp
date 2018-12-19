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
        <table align="right">
            <th style="color:blue">Your session is active</th>
            <td>
                <form action="Controller" method="POST">
                    <button type="submit" name="OffButton" value="goodbye">Disconnect</button>
                    <!--input type="image" src="../../../image.jpg" name="OffButton" value="goodbye" width="100" height="100"-->
                </form>
            </td>
        </table>
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
        <form name="AddForm" action="Controller">
            <input value="Save" type="submit"/>
            <input value="Cancel" type="submit"/>
        </form>
    </body>
</html>
