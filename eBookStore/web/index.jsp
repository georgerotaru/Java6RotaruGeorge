<%-- 
    Document   : index
    Created on : Jan 22, 2018, 8:56:40 PM
    Author     : George
--%>

<%@ include file="./util/header.jsp" %>
<c:set var="activePage" value="index" scope="session"></c:set><%--don't know what id does--%>
<h1>Welcome to eBook Web App</h1>
<br>
<table class="tablecenteredwithroundborder" id="noborder" width="30%">      
    <form action="${pageContext.request.contextPath}/login" method="POST">
        <tr class="tablecenteredwithroundborder" id="logincell"><td colspan="2"><b>LOGIN  TO  EBOOK  APP</b></td></tr>
        <tr><td width="25%"></td><td style="padding-left: 2%; text-align: left"><b>USERNAME</b></td></tr>
        <tr><td width="25%"></td><td style="padding-left: 2%; text-align: left"><input type="text" class="inputbeigefield" name="authpage_username" placeholder="input your username"></td></tr>
        <tr><td width="25%"></td><td style="padding-left: 2%; text-align: left"><b>PASSWORD</b></td></tr>
        <tr><td width="25%"></td><td style="padding-left: 2%; text-align: left"><input type="password" class="inputbeigefield"  name="authpage_password" placeholder="input your password"></td></tr>               
        <c:choose>
            <%--If wrong username or password input, display error message--%>
            <c:when test="${loginError == true}">
            <tr><td colspan="2" style="text-align: center; color: #FF0000; font-size: 12px">Invalid credentials! Please try again!</td></tr>
            </c:when>
        </c:choose>
        <tr><td colspan="2" style="text-align: center"><input type="submit" class="button" name="authpage_submit" value="Login"></td></tr>
    </form>
</table>
    </body>
</html>