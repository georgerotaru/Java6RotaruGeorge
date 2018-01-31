<%-- 
    Document   : index
    Created on : Jan 22, 2018, 8:56:40 PM
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8"/>
        <meta name="eBookStore" author="George" content="A web application written in HTML and Java>"/>
        <title>-eBook STORE- Login</title>
        <link rel="stylesheet" type="text/css" href="./css/eBookStore.css">
    </head>
    <body>
        <h1>Welcome to Electronic Books Store</h1>
        <br>
        <table class="tablecenteredwithroundborder" id="noborder" width="20%">      
            <form>
                <tr><td style="padding-left: 35%"><input type="text" class="inputbeigefield" name="username_field" value="admin"></td></tr>
                <tr><td style="padding-left: 35%"><input type="password" class="inputbeigefield"  name="password_field" value="admin"></td></tr>
                <tr><td style="padding-left: 35%"><input type="button" class="button" name="submit_authentification"  onClick="location.href='./eBooksStore_MainPage.jsp'" value="Login"></td></tr>
            </form>
        </table>
    </body>
    
</html>