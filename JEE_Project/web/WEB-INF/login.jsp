<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>  
        <h3 style="color:red">
        <%
          if (session.getAttribute("message")!= null){
              out.println(session.getAttribute("message"));
              session.removeAttribute("message");
          }  
        %>
        </h3>
        <div class="content">
            <form method="POST" action="Controller">
                <div class="form-group">
                    <label for="exampleInputEmail1">Login :</label>
                    <input type="name" name="loginField" class="form-control" data-placeholder="Login" required='required'>
		</div>
		<div class="form-group">
                    <label for="exampleInputPassword1">Password :</label>
                    <input type="Password" name="pwdField" class="form-control"  data-placeholder="Password" required='required'>
		</div>
		<button name="action" type="submit" class="btn btn-primary btn-lg" value="Send">Submit</button>
                <button name="action" type="reset" class="btn btn-primary btn-lg">Reset</button>
            </form>
        </div>
    </body>
</html>