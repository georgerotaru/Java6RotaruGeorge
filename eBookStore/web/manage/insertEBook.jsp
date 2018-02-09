<%-- 
    Document   : insertEBook
    Created on : Feb 7, 2018, 11:00:43 PM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<h1>Insert new eBook</h1>
<%@ include file="../util/mainmenu.jsp" %>

<c:choose>
    <%--check if user logged in--%>
    <c:when test="${validUser == true}">
        <c:choose>
        <%--check if user logged in is administrator--%>
        <c:when test="${isAdmin == true}">
            <form action="${pageContext.request.contextPath}/ebooks" method="POST">
            <%--config JDBC connection--%>
            <sql:setDataSource
                var="myDB"
                driver="org.apache.derby.jdbc.ClientDriver"
                user="ebook"
                password="ebook"
                url="jdbc:derby://localhost:1527/EBOOKSTORE;create=true"/>
            <%--query JDBC for ebook types--%>
            <sql:query dataSource="${myDB}" var="type">
                SELECT * FROM EBOOK_FORMAT
            </sql:query>
            <%--query JDBC for ebook genres--%>
            <sql:query dataSource="${myDB}" var="genre">
                SELECT * FROM BOOK_GENRES
            </sql:query>
            <%--display form for admin to input new ebook details--%>
            <table class="tablecenteredwithroundborder" id="noborder" width="50%">
                <tr><th colspan="2" id="logincell">INSERT NEW EBOOK</th></tr>
                <tr><td></td><td class="errorpass" style="text-align: center"><b>${pgmsg}</b></td></tr>
                <tr><td width="25%" style="text-align: center">ISBN</td><td width="60%"><input type="text" class="inputbeigefield" name="insertebookpg_isbn" required></td></tr>
                <tr><td style="text-align: center">Title</td><td><input type="text" class="inputbeigefield" name="insertebookpg_title" required></td></tr>
                <tr>
                    <td width="25%" style="text-align: center">Author</td>
                    <td><table>
                            <tr><td width="33%">First Name</td><td width="33%">Last Name</td><td width="33%">CNP</td></tr>
                            <tr><td><input type="text" class="inputbeigefield" name="insertebookpg_authorfname"></td><td><input type="text" class="inputbeigefield" name="insertebookpg_authorlname" required></td><td><input type="number" class="inputbeigefield" name="insertebookpg_authorcnp" required></td></tr>
                    </table></td>
                </tr>
                <tr><td style="text-align: center; vertical-align: top">Short description</td><td><textarea name="insertebookpg_description" class="inputbeigefield" rows="8" style="resize: none; font-family: Veranda; font-size: 14px"></textarea></td></tr>
                <tr>
                    <td width="25%" style="text-align: center">Format</td>
                    <td>
                        <%--create a list of ebook types--%>
                        <select name="insertebookpg_type">
                            <c:forEach var="rowtype" items="${type.rows}">
                                <option value="${rowtype.TYPE}"><c:out value="${rowtype.TYPE}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="25%" style="text-align: center">Genre</td>
                    <td>
                        <%--create  alist of ebook genres--%>
                        <select name="insertebookpg_genre">
                            <c:forEach var="rowgenre" items="${genre.rows}">
                                <option value="${rowgenre.GENRE}"><c:out value="${rowgenre.GENRE}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr><td width="25%" style="text-align: center">Page no.</td><td><input type="number" min="0" class="inputbeigefield" name="insertebookpg_pageno"></td></tr>
                <tr><td width="25%" style="text-align: center">Price (lei)</td><td><input type="number" min="0" step=0.01 class="inputbeigefield" name="insertebookpg_price" required></td></tr>
            </table>
            <br>
            <%--create options menu--%>
            <table class="tablecenteredwithroundborder" id="noborder" width="30%">
                <%--display form options--%>
                <tr><td style="text-align: center"><input type="submit" class="button" name="insertebookpg_insert" value="Insert"></td>
                    <td style="text-align: center"><input type="reset" class="button" name="insertebookpg_cancel" value="Cancel"></td></tr>
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