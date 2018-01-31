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
        <title>-eBook STORE- Main Page</title>
        <link rel="stylesheet" type="text/css" href="./css/eBookStore.css">
    </head>
    <body>
        <h1>In Main Page!</h1>
        <br>
        <table class="tableformenu" id="noborder" width="100%">
            <tr>    
                <td width="10%"><input type="button" class="menubutton" name="manage_screen button"  onClick="location.href='./eBooksStore_ManageUsersPage.jsp'" value="Manage"></td>
                <td width="10%"><input type="button" class="menubutton" name="orders_screen_button"  onClick="location.href=''" value="Orders"></td>
                <td width="10%"><input type="button" class="menubutton" name="logout_button"  onClick="location.href=''" value="Log out"></td>
                <td width="70%"></td>
            </tr>
        </table>
    </body>
    
</html>