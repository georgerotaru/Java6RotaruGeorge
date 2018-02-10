<%-- 
    Document   : adminEBooksInventory
    Created on : Feb 9, 2018, 6:00:13 PM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<h1>Summary</h1>
<%@ include file="../util/mainmenu.jsp" %>

<c:choose>
    <%--check if user logged in--%>
    <c:when test="${validUser == true}">
        <c:choose>
        <%--check if user logged in is administrator--%>
        <c:when test="${isAdmin == true}">
            <table width="30%" align="center">
                <tr><th colspan="2" style="background-color: #D8D9D8">3 most sold eBooks</th></tr>
                <tr><td><b>TITLE</b></td><td><b>TOTAL (lei)</b></td></tr>
                <%--retrieve data, parse and display information row by row--%>
                <c:forEach var="ebook" items="${ebooks}">
                    <tr><td><c:out value="${ebook.ebookTitle}"/></td><td><c:out value="${ebook.ebookSum}"/></td></tr>
                </c:forEach>
            </table>
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
