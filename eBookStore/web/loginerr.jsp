<%-- 
    Document   : loginerr
    Created on : Feb 1, 2018, 10:43:50 PM
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8"/>
        <meta name="eBookStore" author="George" content="A web application written in HTML and Java>"/>
        <title>Uhh-Ohh...</title>
        <link rel="stylesheet" type="text/css" href="./css/eBookStore.css">
    </head>
    <body>
        <h1 style="text-shadow: 1px 1px #ff0000">Uhh - Ohh ! Wrong username or password.. please try again!</h1>
        <br>
        <table class="tablecenteredwithroundborder" id="noborder" width="30%">      
            <form action="login" method="POST">
                <tr class="tablecenteredwithroundborder" id="logincell"><td colspan="2"><b>LOGIN  TO  EBOOK  APP</b></td></tr>
                <tr><td width="25%"></td><td style="padding-left: 2%; text-align: left"><b>USERNAME</b></td></tr>
                <tr><td width="25%"></td><td style="padding-left: 2%; text-align: left"><input type="text" class="inputbeigefield" name="username_field" placeholder="input your username"></td></tr>
                <tr><td width="25%"></td><td style="padding-left: 2%; text-align: left"><b>PASSWORD</b></td></tr>
                <tr><td width="25%"></td><td style="padding-left: 2%; text-align: left"><input type="password" class="inputbeigefield"  name="password_field" placeholder="input your password"></td></tr>
                <tr><td colspan="2" style="text-align: center"><input type="submit" class="button" name="submit_authentification" value="Login"></td></tr>
            </form>
        </table>
    </body>
</html>