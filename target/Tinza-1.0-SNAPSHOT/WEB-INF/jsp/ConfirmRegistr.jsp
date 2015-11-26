<%-- 
    Document   : ConfirmRegistr
    Created on : 2 oct. 2015, 16:53:18
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm registration</title>
    </head>
    <body>
         <form:form   method="POST" commandName="us" action="ConfirmRegistr.htm" >
             <table cellpadding="2" cellpacing="2" border="0">
            <tr>
                <td>Nom</td>
                <td><form:input path="nom" ng-model="us.nom"/></td>
                <td><form:errors path="nom" cssClass="error"></form:errors></td>
            </tr>  
            <tr>
                <td>Prenom</td>
                <td><form:input path="prenom"/></td>
                <td><form:errors path="prenom" cssClass="error"></form:errors></td>
            </tr>
            
            <tr>
                <td>Email</td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssClass="error"></form:errors></td>
            </tr>
            
            <tr>
                <td>Password</td>
                <td><form:password path="pwd"/></td>
                <td><form:errors path="pwd" cssClass="error"></form:errors></td>
            </tr>
            
            <tr>
                <td>Confirm password</td>
                <td><form:password path="confirmpwd"/></td>
                <td><form:errors path="confirmpwd" cssClass="error"></form:errors></td>
            </tr>
            
             <tr>
                 <td>&nbsp;</td>
                 <td colspan="2"><input type="submit" value="Confirm"></td>
            </tr>  
        </table>
            </form:form>
    </body>
</html>
