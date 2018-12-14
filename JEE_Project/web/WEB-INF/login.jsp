<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>       
        <form name="LoginForm" action="Controller">
            <table>
                <tr>
                    <th>Login : </th><th><input type="text" name="loginField"/> </th>
                    <span class="focus-input100" data-placeholder="Login"></span>
                </tr>
                <tr> 
                    <th>Password : </th><th><input type="text" name="pwdField"/></th>
                    <span class="focus-input100" data-placeholder="Password"></span>
                </tr>
            </table>
            <input type="submit" name="validateBtn" value="Send"/>

        </form>
    </body>
</html>