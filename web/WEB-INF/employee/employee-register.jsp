<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/fragment/header.jsp"%>

<form action="/servlet-mvc/insert" method="POST">
    <table border="0" style="font-family:verdana;font-size:10pt;">
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" />
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastName"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>Contact:</td>
            <td><input type="text" name="contact"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"/></td>
        </tr>
        
    </table>
    <input type="submit" value="Register"/>      
</form>

<%@include file="/fragment/footer.jsp"%>