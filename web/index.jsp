<%-- 
    Document   : index
    Created on : 24-Mar-2019, 21:20:35
    Author     : Saman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@include file="/header.jsp"%>

<center>
    <div align="center" class="jumbotron">
        <table border="1" cellpadding="5" class="table table-dark">
            <caption><h2>List of menu</h2></caption>
            <tr>
                <th>ID</th>
                <th>Dish Item</th>
                <th>Price</th>
                <th>Type</th>
                <th>Image</th>
                </tr>
            <c:forEach var="menu" items="${menus}">
                <tr>
                    <td><c:out value="${menu.id}" /></td>
                    <td><c:out value="${menu.dish_item}" /></td>
                    <td><c:out value="${menu.price}" /></td>
                    <td><c:out value="${menu.type}" /></td>
                    <td><c:out value="${menu.image}" /></td>
                    <td><c:out value="${menu.email}" /></td>
                    <td>
                        
                    <a href="/resturantSystem/edit?id=<c:out value='${menu.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/resturantSystem/delete?id=<c:out value='${menu.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   

</center>
        </body>
</html>