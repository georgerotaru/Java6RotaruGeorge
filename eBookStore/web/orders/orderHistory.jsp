<%-- 
    Document   : orderHistory
    Created on : Feb 7, 2018, 4:33:46 PM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<h1>My order history</h1>
<%@ include file="../util/mainmenu.jsp" %>

<c:choose>
    <%--test if user logged in--%>
    <c:when test="${validUser == true}">
        <%--display message from servlet--%>
        <div class="errorpass" style="background-color: azure"><b>${orderCompleted}</b></div>
        <%--config connection to JDBC--%>
        <sql:setDataSource
            var="myDB"
            driver="org.apache.derby.jdbc.ClientDriver"
            user="ebook"
            password="ebook"
            url="jdbc:derby://localhost:1527/EBOOKSTORE;create=true"/>
        <%--query JDBC for orders from current user--%>
        <sql:query dataSource="${myDB}" var="orders">
            SELECT * FROM ORDERS WHERE CNP = '<c:out value="${actualCnp}"/>'
        </sql:query>
        <%--create table to display order history--%>
        <table width="60%" align="center">
            <tr style="background-color: #D8D9D8"><th>Title</th><th width="15%">Type</th><th width="15%">Genre</th><th width="15%">Price (lei)</th><th width="15%">Status</th></tr>
            <%--for every row found in DB we will create and display a row for the user to see--%>
            <c:forEach var="orderrows" varStatus="loop" items="${orders.rows}">
            <tr>
                <td><c:out value="${orderrows.TITLE}"/></td>
                <td><c:out value="${orderrows.TYPE}"/></td>
                <td><c:out value="${orderrows.GENRE}"/></td>
                <td><c:out value="${orderrows.PRICE}"/></td>
                <td>bought</td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <%--query JDBC for total count of user orders--%>
        <sql:query dataSource="${myDB}" var="totalebooksbought">
            SELECT COUNT(ISBN) AS COUNT FROM ORDERS WHERE CNP = '<c:out value="${actualCnp}"/>'
        </sql:query>
        <%--query JDBC for total sum spent on ebooks by current user--%>
        <sql:query dataSource="${myDB}" var="totalmoneyspent">
            SELECT CAST(SUM(PRICE) AS INT) AS TOTAL FROM ORDERS WHERE CNP = '<c:out value="${actualCnp}"/>'
        </sql:query>
        <%--display order count and money spent--%>
        <table align="center" width="35%">
            <tr><td>Total eBooks bought</td>
                <td><c:forEach var="row" items="${totalebooksbought.rows}"><c:out value="${row.COUNT}"/></c:forEach></td></tr>
            <tr><td>Total money spent</td>
                <td><c:forEach var="row" items="${totalmoneyspent.rows}"><c:out value="${row.TOTAL} lei"/></c:forEach></td></tr>
        </table>
    </c:when>
    <%--redirect if user didn't logged in--%>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>
</body>
</html>