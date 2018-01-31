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
        <title>-eBook STORE- Manage accounts</title>
        <link rel="stylesheet" type="text/css" href="./css/eBookStore.css">
    </head>
    <body>
        <h1><br></h1>
        <br>
        <table width="100%" class="tablewithborders" style="background-color: #D8D9D8">
            <tr>    
                <th width="4%">select</th>
                <th width="32%">USERNAME</th>
                <th width="32%">PASSWORD</th>
                <th width="32%">ROLE<button type"button" name="user_role" class="rolebutton">Admin</th>
            </tr>           
        </table>
        <table class="tablewithborders" width="100%">
            <tr>    
                <td width="4%"><input type="checkbox"></td>
                <td width="32%">admin</td>
                <td width="32%">admin</td>
                <td width="32%">admin</td>
            </tr>
            <tr>    
                <td width="4%"><input type="checkbox"></td>
                <td width="32%">coco</td>
                <td width="32%">marla</td>
                <td width="32%">admin</td>
            </tr>
        </table>
        <br>
        <table class="tablecenteredwithroundborder" id="noborder" width="20%"> 
            <form>
                <tr><td colspan="4" style="padding-left: 35%"><input type="text" class="inputbeigefield" name="username_field" value="admin"></td></tr>
                <tr><td colspan="4" style="padding-left: 35%"><input type="password" class="inputbeigefield"  name="password_field" value="admin"></td></tr>
                <tr><td colspan="4" style="padding-left: 35%">
                        <select>
                            <option value="admin">admin</option>
                            <option value="user">normal user</option>
                        </select>
                    </td></tr>
                <tr>
                    <td style="text-align: center"><input type="submit" class="button" name="insert" value="Insert"></td>
                    <td style="text-align: center"><input type="submit" class="button" name="update" value="Update"></td>
                    <td style="text-align: center"><input type="submit" class="button" name="delete" value="Delete"></td>
                    <td style="text-align: center"><input type="reset" class="button" name="cancel" value="Cancel"></td>
                </tr>
            </form>
        </table>
    </body>
    
</html>