<%-- 
    Document   : register
    Created on : 29 sept. 2015, 16:49:17
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html ng-app>
    <head>
         <script data-require="angular.js@*" data-semver="2.0.0-alpha.31" src="https://code.angularjs.org/2.0.0-alpha.31/angular.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register New Account</title>
        <link href="/css/style.css" rel="stylesheet" type="text/css">
        <style>
.error {
color: #ff0000;
font-style: italic;
}
input.ng-invalid {
  border: 1px solid red;
}
input.ng-valid {
  border: 1px solid green;
}
</style>
    </head>
    <body>
        <form:form   method="POST" commandName="us" action="register.htm" >
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
                 <td colspan="2"><input type="submit" value="Save"></td>
            </tr>  
        </table>
            </form:form>
    </body>
</html>

