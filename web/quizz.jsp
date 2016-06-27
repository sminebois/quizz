<%-- 
    Document   : quizz
    Created on : 27 juin 2016, 13:16:21
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les Quizzs qui tuent</title>
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div><div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">     
            <h1>Les Quizz qui dépotent !</h1>
            <table>
                <tr>
                    <th>Nom</th>                    
                </tr>
                <c:forEach items="${lquizz}" var="q">
                    <tr>
                        <td>${q.nom}</td>
                    </tr>

                </c:forEach>
            </table>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
