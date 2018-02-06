<%-- 
    Document   : adminUsers
    Created on : Feb 6, 2018, 12:02:33 PM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<h1>Administrate application's user list</h1>
<%@ include file="../util/mainmenu.jsp" %>

<%--create script to use in command table for hiding and showing rows--%>
<script type="text/javascript">
function toggleCNP() {
    document.getElementById("hideCNP").style.display = '';
    document.getElementById("hidePassword").style.display = 'none';
    document.getElementById("hideRole").style.display = 'none';
    document.getElementById("updateUserList").reset();
}
function togglePassword() {
    document.getElementById("hidePassword").style.display = '';
    document.getElementById("hideCNP").style.display = 'none';
    document.getElementById("hideRole").style.display = 'none';
    document.getElementById("updateUserList").reset();
}
function toggleNewUser() {
    document.getElementById("hidePassword").style.display = '';
    document.getElementById("hideCNP").style.display = '';
    document.getElementById("hideRole").style.display = '';
    document.getElementById("updateUserList").reset();
}
</script>
<c:choose>
    <%--test if user logged in--%>
    <c:when test="${validUser == true}">
        <c:choose>
            <%--test if user has admin role--%>
            <c:when test="${isAdmin == true}">
                <%--connect to JDBC--%>
                <sql:setDataSource
                    var="myDB"
                    driver="org.apache.derby.jdbc.ClientDriver"
                    user="ebook"
                    password="ebook"
                    url="jdbc:derby://localhost:1527/EBOOKSTORE;create=true"/>
                <%--query JDBC--%>
                <sql:query dataSource="${myDB}" var="result">
                    SELECT * FROM USERS ORDER BY USERNAME ASC
                </sql:query>
                <%--create form to update user list--%>
                <form id="updateUserList" action="${pageContext.request.contextPath}/adminUsers" method="POST">
                <%--create table to display commands for user list--%>
                <table class="tablecenteredwithroundborder" id="noborder" width="40%"> 
                        <%--displays command options which use functions from above script--%>
                    <tr><td style="text-align: center"><span onmouseover="this.style.cursor='pointer'" onclick="toggleNewUser();">Insert new user</span></td>
                        <td style="text-align: center"><span onmouseover="this.style.cursor='pointer'" onclick="toggleCNP();">Update CNP</span></td>
                        <td style="text-align: center"><span onmouseover="this.style.cursor='pointer'" onclick="togglePassword();">Update password</span></td></tr>
                        <%--create a row in which to display messages from scriplet--%>
                    <tr><td colspan="3" style="text-align: center"><div class="errorpass"><b>${adminuserpg_message}</b></div></td></tr>
                        <%--create fields to input user information--%>
                    <tr><td style="text-align: right; padding-right: 5px">username</td><td colspan="2" style="text-align: left"><input type="text" class="inputbeigefield" name="adminuserspg_username" style="font-size: 14px"></td></tr>
                    <tr style="display: none" id="hideCNP"><td style="text-align: right; padding-right: 5px">CNP</td><td colspan="2" style="text-align: left"><input type="text" class="inputbeigefield" name="adminuserspg_cnp" style="font-size: 14px"></td></tr>
                    <tr style="display: none" id="hidePassword"><td style="text-align: right; padding-right: 5px">password</td><td colspan="2" style="text-align: left"><input type="password" class="inputbeigefield" name="adminuserspg_pass" style="font-size: 14px"></td></tr>
                    <tr style="display: none" id="hideRole"><td style="text-align: right; padding-right: 5px">user role</td><td colspan="2" style="text-align: left"><select name="adminuserspg_role">
                                                                                                                                                                        <option value="true">admin</option>
                                                                                                                                                                        <option value="false">user</option>
                                                                                                                                                                    </select></td></tr>
                    <%--display form options--%>
                    <tr><td width="33%" style="text-align: center"><input type="submit" class="button" name="adminuserpg_submit" value="Submit"></td>
                        <td width="33%" style="text-align: center"><input type="submit" class="button" name="adminuserpg_delete" value="Delete"></td>
                        <td width="33%" style="text-align: center"><input type="reset" class="button" name="adminuserpg_cancel" value="Cancel"></td></tr>
                </table>
                <br>
                <%--create dinamic table in which to display user list and information--%>
                <table width="60%" align="center">
                    <tr style="background-color: #D8D9D8"><th>user</th><th>CNP</th><th>role</th></tr>
                    <%--for every row found in DB we will create and display a row for the user to see--%>
                    <c:forEach var="row" varStatus="loop" items="${result.rows}">
                    <tr><td><c:out value="${row.USERNAME}"/></td>
                        <td><c:out value="${row.CNP}"/></td>
                        <td><c:choose>
                            <c:when test="${row.IS_ADMIN == true}">admin</c:when>
                            <c:when test="${row.IS_ADMIN == false}">user</c:when>                                
                            </c:choose>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                </form>
            </c:when>
            <%--to display if current user has no admin role--%>
            <c:when test="${isAdmin == false}">
                <div style="color: #FF0000; background-color: whitesmoke; width: 30%">
                    <h2>Not enough credentials!</h2>
                </div>
            </c:when>
        </c:choose>
    </c:when>
    <%--redirect if user didn't logged in--%>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>
</body>
</html>