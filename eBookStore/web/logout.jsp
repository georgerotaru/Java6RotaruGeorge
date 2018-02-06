<%-- 
    Document   : logout
    Created on : Feb 4, 2018, 7:29:28 AM
    Author     : George
--%>

<%@ include file="./util/header.jsp" %>
<c:choose>
    <%--Check if user logged in--%>
    <c:when test="${validUser == true}"> 
        <c:set var="validUser" value="false" scope="session"></c:set>
        <c:set var="actualUser" value="" scope="session"></c:set>  
        <c:set var="isAdmin" value=""scope="session" ></c:set>
        <h1>THANK YOU FOR VISITING OUR WEBSITE</h1>
        <br>
        <table class="tablecenteredwithroundborder" id="noborder" width="30%">        
            <tr class="tablecenteredwithroundborder" id="logincell"><td><b>LOGOUT SUCCESSFUL</b></td></tr>
            <tr><td><br></td></tr>
            <tr><td><br></td></tr>
            <td style="text-align: center"><a href="./index.jsp"><button class="button">RETURN TO LOGIN</button></a></td>
            <tr><td><br></td></tr>
            <tr><td><br></td></tr>
        </table>
    </c:when>
    <%--Redirect if user was not logged in--%>
    <c:otherwise>
        <c:redirect url="./index.jsp"/>
    </c:otherwise>
</c:choose>

</body>
</html>
