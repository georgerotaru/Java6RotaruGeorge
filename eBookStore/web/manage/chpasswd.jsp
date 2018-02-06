<%-- 
    Document   : chpasswd
    Created on : Feb 4, 2018, 10:00:52 AM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<h1>Change your password</h1>
<%@ include file="../util/mainmenu.jsp" %>
<c:choose>
    <%--display message after successful password change--%>
    <c:when test="${validUser ==true && passwdChange == true}">
        <table class="tablecenteredwithroundborder" id="noborder" width="30%">
            <tr><th>PASSWORD CHANGE SUCCESSFUL</th></tr>
            <tr><td>Redirecting to home page..</td></tr>
        </table>
    </c:when>
    <%--test if user logged in and display options for password change--%>
    <c:when test="${validUser ==true}">
        <table class="tablecenteredwithroundborder" id="noborder" width="30%">
            <form action="${pageContext.request.contextPath}/chpasswd" method="POST">
                <tr><td><b>Enter current password: </b><div class="errorpass">${errorOldPasswd}</div></td></tr>
                <tr><td class="inputbeigefield" style="text-align: center"><input type="password" name="chpasswdpage_oldpass" placeholder="old password"></td></tr>
                <tr><td><b>Enter new password: </b><div class="errorpass">${errorNewPasswd}</div></td></tr>
                <tr><td class="inputbeigefield" style="text-align: center"><input type="password" name="chpasswdpage_newpass1" placeholder="new password"></td></tr> 
                <tr><td class="inputbeigefield" style="text-align: center"><input type="password" name="chpasswdpage_newpass2" placeholder="confirm new password"></td></tr>
                <tr><td style="text-align: center"><input type="submit" class="button" name="chpasswdpage_submit" value="Submit"></td></tr>
            </form>
        </table>
    </c:when>
    <%--redirect if user didn't logged in--%>
    <c:otherwise>
        <c:redirect url="../index.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>
