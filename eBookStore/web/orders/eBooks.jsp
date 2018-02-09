<%-- 
    Document   : eBooks
    Created on : Feb 7, 2018, 11:39:38 AM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<%--display different titles if user is admin or not--%>
<c:choose>
    <c:when test="${isAdmin == true}">
        <h1>Manage eBooks</h1>
    </c:when>
    <c:when test="${isAdmin == false}">
        <h1>eBooks book list</h1>
    </c:when>
</c:choose>
<%@ include file="../util/mainmenu.jsp" %>

<c:choose>
    <%--test if user logged in--%>
    <c:when test="${validUser == true}">
        <form action="${pageContext.request.contextPath}/ebooks" method="POST">
        <c:choose>
            <%--test if user has admin role and show options--%>
            <c:when test="${isAdmin == true}">
                <table class="tablecenteredwithroundborder" id="noborder" width="40%">
                    <%--display form options--%>
                    <tr><td style="text-align: center"><input type="submit" class="button" name="ebookspg_order" value="Order"></td>
                        <td style="text-align: center"><a href="/ebookstore/manage/insertEBook.jsp"><input type="button" class="button" value="Insert"></a></td>
                        <td style="text-align: center"><input type="submit" class="button" name="ebookspg_modify" value="Modify"></td>
                        <td style="text-align: center"><input type="submit" class="button" name="ebookspg_delete" value="Delete"></td>
                        <td style="text-align: center"><input type="reset" class="button" name="ebookspg_cancel" value="Cancel"></td></tr>
                </table>
            </c:when>
            <%--test if user has user role and show options--%>
            <c:when test="${isAdmin == false}">
                <table class="tablecenteredwithroundborder" id="noborder" width="30%">
                    <%--display form options--%>
                    <tr><td style="text-align: center"><input type="submit" class="button" name="ebookspg_order" value="Order"></td>
                        <td style="text-align: center"><input type="reset" class="button" name="ebookspg_cancel" value="Cancel"></td></tr>
                </table>
            </c:when>            
        </c:choose>
        <br>
        <%--display message from servlet--%>
        <div class="errorpass" style="background-color: azure"><b>${ebookadded}</b></div>
        <%--connect to JDBC--%>
        <sql:setDataSource
            var="myDB"
            driver="org.apache.derby.jdbc.ClientDriver"
            user="ebook"
            password="ebook"
            url="jdbc:derby://localhost:1527/EBOOKSTORE;create=true"/>
        <%--query JDBC for ebook details--%>
        <sql:query dataSource="${myDB}" var="ebooks">
            SELECT * FROM EBOOKS ORDER BY TITLE ASC
        </sql:query>
        <%--create table to display a list of all ebooks in DB--%>
        <table width="80%" align="center">
            <tr style="background-color: #D8D9D8"><th width="5%">select</th><th>Title</th><th width="20%">Authors</th><th width="6%">Type</th><th width="14%">Genre</th><th width="9%">Price (lei)</th><th width="8%">Ratings</th><th width="7%">more</th></tr>
            <%--for every row found in DB we will create and display a row for the user to see--%>
            <c:forEach var="ebooksrow" varStatus="loop" items="${ebooks.rows}">
                <tr>
                <td><input type="checkbox" name="ebookspg__checkbox" value="${ebooksrow.ISBN}"></td>
                <td><c:out value="${ebooksrow.TITLE}"/></td>
                <td>
                    <c:set value="${ebooksrow.ISBN}" var="ebookisbn"/>
                    <%--query JDBC for author CNP--%>
                    <sql:query dataSource="${myDB}" var="cnpforebook">
                        SELECT CNP FROM EBOOK_AUTHORS WHERE ISBN='<c:out value="${ebookisbn}"/>'
                    </sql:query>
                    <%--iterate through CNPs--%>
                    <c:forEach var="cnp" varStatus="loop" items="${cnpforebook.rows}">
                        <c:set value="${cnp.CNP}" var="authorcnp"/>
                        <%--query JDBC for author names--%>
                        <sql:query dataSource="${myDB}" var="nameforcnp">
                            SELECT FIRST_NAME, LAST_NAME FROM AUTHORS WHERE CNP='<c:out value="${authorcnp}"/>'
                        </sql:query>
                        <%--iterate through names of all authors--%>
                        <c:forEach var="completename" varStatus="loop" items="${nameforcnp.rows}">
                            <li style="list-style-type:none"><c:out value="${completename.FIRST_NAME} ${completename.LAST_NAME}"/></li>
                        </c:forEach>
                    </c:forEach>
                </td>
                <td><c:out value="${ebooksrow.TYPE}"/></td>
                <td><c:out value="${ebooksrow.GENRE}"/></td>
                <td><c:out value="${ebooksrow.PRICE}"/></td>
                <td>
                    <%--query JDBC for ebook rating--%>
                    <sql:query dataSource="${myDB}" var="ratings">
                        SELECT AVG(RATINGS.VALUE) AS RATING FROM RATINGS JOIN EBOOK_RATINGS ON RATINGS.RATING=EBOOK_RATINGS.RATING WHERE EBOOK_RATINGS.ISBN='<c:out value="${ebooksrow.ISBN}"/>'
                    </sql:query>
                    <%--display rating average for ebook--%>
                    <c:forEach var="rating" items="${ratings.rows}">
                        <c:choose>
                            <c:when test="${rating.RATING == null}">
                                not rated
                            </c:when>
                            <c:otherwise>
                                ${rating.RATING}/5
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </td>
                <td><button type="submit" style="border-style: none; background-color: inherit" onmouseover="this.style.cursor='pointer'" name="ebookspg_details" value="${ebooksrow.ISBN}">details</button></td>
            </tr>
            </c:forEach>
        </table>
    </form>
    </c:when>
    <%--redirect if user didn't logged in--%>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>
</body>
</html>
