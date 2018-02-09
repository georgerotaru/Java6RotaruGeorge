<%-- 
    Document   : ./main.jps
    Created on : Feb 2, 2018, 10:58:46 AM
    Author     : George
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <%--test if user logged in--%>
    <c:when test="${validUser == true}">
        <ul id="nav">
        <c:choose>
            <%--check if user has admin or user credentials and display menu accordingly--%>
            <c:when test="${isAdmin == false || isAdmin == true}">
                <li><a href="#"><b>Manage</b></a>
                    <ul>
                        <li><a href="/ebookstore/manage/chpasswd.jsp">Change password</a></li>
                        <c:choose>
                            <c:when test="${isAdmin == true}">
                                <li><a href="/ebookstore/manage/adminUsers.jsp">Users</a></li>
                                <li><a href="/ebookstore/manage/adminUserRoles.jsp">User roles</a></li>
                                <li><a href="/ebookstore/orders/eBooks.jsp">eBooks</a></li>
                            </c:when>
                        </c:choose>                              
                    </ul>
                </li>
            </c:when>
        </c:choose>        
        <c:choose>
            <c:when test="${isAdmin == false || isAdmin == true}">
                <li><a href="#"><b>Orders</b></a>
                    <ul>
                        <li><a href="/ebookstore/orders/eBooks.jsp">eBooks list</a></li>
                        <li><a href="/ebookstore/orders/orderHistory.jsp">My orders</a></li>
                        <c:choose>
                            <c:when test="${isAdmin == true}">
                                <li><a href="/ebookstore/orders/adminEBooksInventory.jsp">Inventory</a></li>
                            </c:when>
                        </c:choose>
                    </ul>
                </li>    
            </c:when>
        </c:choose>
                <li><a href="/ebookstore/logout.jsp"><b>Log out</b></a></li>
        <c:choose>
            <c:when test="${isAdmin == true}">
                <li style="width: auto; font-size: 12px; border-style: none; float: right"><b>logged in as: <c:out value="${actualUser}"/> (administrator)</b></li>
            </c:when>
            <c:when test="${isAdmin == false}">
                <li style="width: auto; font-size: 12px; border-style: none; float: right"><b>logged in as: <c:out value="${actualUser}"/> (user)</b></li>
            </c:when>
        </c:choose>
        </ul>
    </c:when>
    <%--redirect if user didn't logged in--%>
    <c:otherwise>
        <c:redirect url="../index.jsp"/>
    </c:otherwise>
</c:choose>