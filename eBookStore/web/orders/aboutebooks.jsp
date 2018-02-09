<%-- 
    Document   : aboutebooks
    Created on : Feb 8, 2018, 11:24:15 PM
    Author     : George
--%>

<%@ include file="../util/header.jsp" %>
<h1>Details about eBook</h1>
<%@ include file="../util/mainmenu.jsp" %>

<%--javascript with go back to previous page function--%>
<script>
function goBack() {
    window.history.back();
}
</script>

<c:choose>
    <%--check if user logged in--%>
    <c:when test="${validUser == true}">
        <sql:setDataSource
            var="myDB"
            driver="org.apache.derby.jdbc.ClientDriver"
            user="ebook"
            password="ebook"
            url="jdbc:derby://localhost:1527/EBOOKSTORE;create=true"/>
        <%--query JDBC for ebook details--%>
        <sql:query dataSource="${myDB}" var="ebook">
            SELECT * FROM EBOOKS WHERE ISBN='<c:out value="${ebookIsbn}"/>'
        </sql:query>
        <%--query JDBC for ebook orders--%>
        <sql:query dataSource="${myDB}" var="orders">
            SELECT COUNT(ISBN) AS COUNT FROM ORDERS WHERE ISBN='<c:out value="${ebookIsbn}"/>'
        </sql:query>
        <%--query JDBC for ebook rating--%>
        <sql:query dataSource="${myDB}" var="ratings">
            SELECT AVG(RATINGS.VALUE) AS RATING, COUNT(RATINGS.VALUE) AS COUNT FROM RATINGS JOIN EBOOK_RATINGS ON RATINGS.RATING=EBOOK_RATINGS.RATING WHERE EBOOK_RATINGS.ISBN='<c:out value="${ebookIsbn}"/>'
        </sql:query>
        <%--query JDBC for ebook rating--%>
        <sql:query  dataSource="${myDB}" var="ebookrating">
            SELECT RATING FROM RATINGS
        </sql:query>
        <%--go back to previous page button--%>
        <button class="button" onclick="goBack()">go Back</button>
        <br>
        <br>
        <%--create table to display ebook details stored in DB--%>
        <table class="tablecenteredwithroundborder" id="noborder" width="50%">
            <tr><th colspan="2" id="logincell">ABOUT EBOOK</th></tr>
            <%--iterate through ebook details DB--%>
            <c:forEach var="ebookrow" items="${ebook.rows}">
                <tr style="height: 30px"><td width="25%" style="text-align: center">ISBN</td><td>${ebookrow.ISBN}</td></tr>
                <tr style="height: 30px"><td style="text-align: center">TITLE</td><td>${ebookrow.TITLE}</td></tr>
                <tr style="height: auto"><td style="text-align: center">AUTHOR</td>
                    <td style="padding-bottom: 1%">
                        <c:set value="${ebookrow.ISBN}" var="isbn"/>
                        <%--query JDBC for CNP of author--%>
                        <sql:query dataSource="${myDB}" var="cnpforebook">
                            SELECT CNP FROM EBOOK_AUTHORS WHERE ISBN='<c:out value="${isbn}"/>'
                        </sql:query>
                        <%--iterate through all authors of a ebook--%>
                        <c:forEach var="cnp" items="${cnpforebook.rows}">
                            <c:set value="${cnp.CNP}" var="authorcnp"/>
                            <%--query JDBC for name of author--%>
                            <sql:query dataSource="${myDB}" var="nameforcnp">
                                SELECT FIRST_NAME, LAST_NAME FROM AUTHORS WHERE CNP='<c:out value="${authorcnp}"/>'
                            </sql:query>
                            <%--iterate through all names of authors--%>
                            <c:forEach var="completename" varStatus="loop" items="${nameforcnp.rows}">
                                <li style="list-style-type:none">${completename.FIRST_NAME} ${completename.LAST_NAME}</li>
                            </c:forEach>
                        </c:forEach>        
                    </td>
                </tr>
                <tr style="height: 30px"><td style="text-align: center">DESCRIPTION</td><td style="text-align: justify; padding-right: 3%">${ebookrow.DESCRIPTION}</td></tr>
                <tr style="height: 30px"><td style="text-align: center">GENRE</td><td>${ebookrow.GENRE}</td></tr>
                <tr style="height: 30px"><td style="text-align: center">FORMAT</td><td>${ebookrow.TYPE}</td></tr>
                <tr style="height: 30px"><td style="text-align: center">PAGE NO.</td><td>${ebookrow.PAGES}</td></tr>
                <tr style="height: 30px"><td style="text-align: center">USER RATING</td>
                    <td>
                        <%--display rating average for ebook--%>
                        <c:forEach var="rating" items="${ratings.rows}">
                            <c:choose>
                                <c:when test="${rating.RATING == null}">
                                    not rated
                                </c:when>
                                <c:otherwise>
                                    eBook has an average score of <b style="color: crimson">${rating.RATING} out of 5</b> from ${rating.COUNT} users
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </td>
                </tr>
                <tr style="height: 30px"><td style="text-align: center">PRICE</td><td>${ebookrow.PRICE}</td></tr>
                <tr style="height: 30px"><td style="text-align: center">RATE EBOOK</td>
                    <%--test and diplay if current user rated current ebook--%>
                    <td>
                        <%--create a form to pass rating values--%>
                        <form action="${pageContext.request.contextPath}/ratebook"  method="GET">
                        <%--pass value to servlet (if needed)--%>
                        <input type="hidden" name="useIsbn" value="${ebookIsbn}"/>
                        <c:choose>
                            <c:when test="${rated == false}">
                                <select name="aboutebookspg_rate">
                                    <c:forEach var="ebookratingrow" items="${ebookrating.rows}">
                                        <option value="${ebookratingrow.RATING}"><c:out value="${ebookratingrow.RATING}"/></option>
                                    </c:forEach>
                                        <input type="submit" value="&#10004;" style="border-style: none; background-color: inherit">
                                </select>
                            </c:when>
                            <c:otherwise>
                                eBook rated. Thank you!
                            </c:otherwise>
                        </c:choose>
                        </form>
                    </td>
                </tr>
                <tr style="height: 30px"><td style="text-align: center">INTEREST</td>
                    <td>
                        <%--display how many ebook orders--%>
                        <c:forEach var="count" items="${orders.rows}">
                            eBook was ordered <b style="color: crimson">${count.COUNT}</b> times so far
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <%--redirect if user didn't logged in--%>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>
</body>
</html>
