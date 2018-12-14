<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>       
        <form name="LoginForm" action="Controller">
            Login : <input type="text" name="loginField"/> <br/>
            Password : <input type="text" name="pwdField"/>
            <input type="submit" name="validateBtn" value="Send"/>
        </form>
    </body>
</html>