<%-- 
    Document   : adminUserRoles
    Created on : Feb 5, 2018, 3:17:03 PM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<h1>Change user roles</h1>
<%@ include file="../util/mainmenu.jsp" %>
<c:choose>
    <%--check if user logged in--%>
    <c:when test="${validUser == true}">
        <c:choose>
        <%--check if user logged in is administrator--%>
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
                SELECT USERNAME, IS_ADMIN FROM USERS ORDER BY USERNAME ASC
            </sql:query>
                <%--create form to update user roles--%>
                <form action="${pageContext.request.contextPath}/changeUserRoles" method="POST">
                <%--create table to display commands for user roles--%>
                <table class="tablecenteredwithroundborder" id="noborder" width="20%"> 
                    <tr><td colspan="2" style="text-align: center"><b>Set role for selected users:</b></td></tr>
                    <tr><td colspan="2" style="padding-left: 35%">
                            <%--create list with available user roles and values to be used in servlet--%>
                            <select name="adminuserrolepg_role">
                                <option value="true">admin</option>
                                <option value="false">user</option>
                            </select>
                    </td></tr>
                    <tr>
                        <td style="text-align: center"><input type="submit" class="button" name="adminuserrolepg_update" value="Update"></td>
                        <td style="text-align: center"><input type="reset" class="button" name="adminuserrolepg_cancel" value="Cancel"></td>
                    </tr>
                </table>
                <br>
                <%--create dinamic table in which to display user list and roles--%>
                <table width="60%" align="center">
                    <tr style="background-color: #D8D9D8"><th>select</th><th>user</th><th>role</th></tr>
                    <%--for every row found in DB we will create and display a row for the user to see--%>
                    <c:forEach var="row" varStatus="loop" items="${result.rows}">
                        <tr><c:choose>
                                <%--don't display checkboxes neither for user named admin nor current user--%>
                                <c:when test="${row.USERNAME == 'admin' || row.USERNAME == actualUser}">
                                    <td width="10%"></td>
                                </c:when>
                                <c:otherwise>
                                    <%--give to every checkbox the value found in column USERNAME in DB--%>
                                    <td width="10%"><input type="checkbox" name="adminuserrolepg__checkbox" value="${row.USERNAME}"></td>
                                </c:otherwise>
                            </c:choose>
                            <td><c:out value="${row.USERNAME}"/></td>
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