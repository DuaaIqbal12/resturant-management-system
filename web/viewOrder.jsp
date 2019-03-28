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
            <caption><h2>List of order</h2></caption>
            <tr>
                <th>ID</th>
                <th>dish name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Category</th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td><c:out value="${order.id}" /></td>
                    <td><c:out value="${order.dish_name}" /></td>
                    <td><c:out value="${order.price}" /></td>
                    <td><c:out value="${order.quantity}" /></td>
                    <td><c:out value="${order.category}" /></td>
                    <td>
                        
                    <a href="/servlet-mvc/edit?id=<c:out value='${order.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/servlet-mvc/delete?id=<c:out value='${order.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   

</center>
        </body>
</html>