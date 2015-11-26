<%-- 
    Document   : success
    Created on : 29 sept. 2015, 12:57:17
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account information</title>
    </head>
    <body>
        <p>Hi ${us.nom}</p>
        <p>Check your inbox</p>
        <table cellpadding="2" cellpacing="2" border="0">
            <tr>
                <td>Nom</td>
                 <td>${us.nom}</td>
            </tr> 
            <tr>
                <td>Prenom</td>
                 <td>${us.prenom}</td>
            </tr> 
        </table>
    </body>
</html>
