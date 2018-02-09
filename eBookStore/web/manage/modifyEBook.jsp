<%-- 
    Document   : modifyEBook
    Created on : Feb 8, 2018, 4:46:39 PM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<h1>Modify eBook</h1>
<%@ include file="../util/mainmenu.jsp" %>

<c:choose>
    <%--check if user logged in--%>
    <c:when test="${validUser == true}">
        <c:choose>
        <%--check if user logged in is administrator--%>
        <c:when test="${isAdmin == true}">
            <form action="${pageContext.request.contextPath}/ebooks" method="POST">
                <%--config connection to JDBC--%>
            <sql:setDataSource
                var="myDB"
                driver="org.apache.derby.jdbc.ClientDriver"
                user="ebook"
                password="ebook"
                url="jdbc:derby://localhost:1527/EBOOKSTORE;create=true"/>
            <%--query JDBC for ebook type--%>
            <sql:query dataSource="${myDB}" var="type">
                SELECT * FROM EBOOK_FORMAT
            </sql:query>
            <%--query JDBC for ebook genre--%>
            <sql:query dataSource="${myDB}" var="genre">
                SELECT * FROM BOOK_GENRES
            </sql:query>
            <%--retrive value for ebook ISBN from servlet--%>
            <input type="hidden" name="ebookspg__checkbox" value="${modifIsbn}">
            <%--display form for admin to modify ebook details loaded from servlet--%>
            <table class="tablecenteredwithroundborder" id="noborder" width="50%">
                <tr><th colspan="2" id="logincell">MODIFY EBOOK DETAILS</th></tr>
                <tr><td></td><td class="errorpass" style="text-align: center">${pgmsg}</td></tr>
                <tr><td style="text-align: center">Title</td><td><input type="text" class="inputbeigefield" name="modifebookpg_title" value="${modifTitle}" required></td></tr>
                <tr>
                    <td width="25%" style="text-align: center">Author</td>
                    <td><table>
                            <tr><td width="30%">First Name</td><td width="30%">Last Name</td><td width="40%">CNP</td></tr>
                            <tr><td><input type="text" class="inputbeigefield" name="modifebookpg_authorfname" value="${modifFName}"></td><td><input type="text" class="inputbeigefield" name="modifebookpg_authorlname" required value="${modifLName}"></td><td><input type="number" class="inputbeigefield" name="modifebookpg_authorcnp" value="${modifCnp}" required></td></tr>
                    </table></td>
                </tr>
                <tr><td style="text-align: center; vertical-align: top">Short description</td><td><textarea name="modifebookpg_description" class="inputbeigefield" rows="8" style="resize: none; font-family: Veranda; font-size: 14px">${modifDescription}</textarea></td></tr>
                <tr>
                    <td width="25%" style="text-align: center">Format</td>
                    <td>
                        <select name="modifebookpg_type">
                            <c:forEach var="rowtype" items="${type.rows}">
                                <option><c:out value="${rowtype.TYPE}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="25%" style="text-align: center">Genre</td>
                    <td>
                        <select name="modifebookpg_genre">
                            <c:forEach var="rowgenre" items="${genre.rows}">
                                <option><c:out value="${rowgenre.GENRE}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr><td width="25%" style="text-align: center">Page no.</td><td><input type="number" min="0" class="inputbeigefield" name="modifebookpg_pageno" value="${modifPages}"></td></tr>
                <tr><td width="25%" style="text-align: center">Price (lei)</td><td><input type="number" min="0" step=0.01 class="inputbeigefield" name="modifebookpg_price" value="${modifPrice}" required></td></tr>
            </table>
            <br>
            <%--create option table--%>
            <table class="tablecenteredwithroundborder" id="noborder" width="30%">
                <%--display form options--%>
                <tr><td style="text-align: center"><input type="submit" class="button" name="modifebookpg_update" value="Update"></td>
                    <td style="text-align: center"><input type="reset" class="button" name="modifebookpg_cancel" value="Cancel"></td></tr>
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
