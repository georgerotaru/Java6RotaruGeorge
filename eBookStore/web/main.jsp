<%-- 
    Document   : index
    Created on : Jan 22, 2018, 8:56:40 PM
    Author     : George
--%>

<%@ include file="./util/header.jsp" %>
<h1>MAIN PAGE</h1>
<%-- test if a valid user is logged in --%>
<c:choose>
    <c:when test="${validUser == true}">
        <%-- if a valid user is logged than display page --%>
        <%@ include file="./util/mainmenu.jsp" %>
    </c:when>
    <%--redirect if user is not logged in--%>
    <c:otherwise>
        <c:redirect url="./index.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>