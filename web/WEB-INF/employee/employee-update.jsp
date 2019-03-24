<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="/fragment/header.jsp"%>

<form action="/servlet-mvc/update" method="POST">
    <table border="0" style="font-family:verdana;font-size:10pt;">
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" value = 
                       "<c:out value='${employee.firstName}' />" />
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastName" value = "<c:out value='${employee.lastName}' />"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value = "<c:out value='${employee.address}' />"/></td>
        </tr>
        <tr>
            <td>Contact:</td>
            <td><input type="text" name="contact" value= "<c:out value='${employee.contact}' />"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="<c:out value='${employee.email}' />"/></td>
        </tr>
        <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
    </table>
    <input type="submit" value="Register"/>      
</form>

<%@include file="/fragment/footer.jsp"%>