<%-- 
    Document   : demarrer
    Created on : 28 juin 2016, 12:03:03
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
            <h3>Quizz : ${quizz.nom}</h3>
            Question ${numQuestion + 1}/${nbQuestion}<br>
            ${lquestions[numQuestion].titre}
            
            <form method="post">
                <input type="submit" value="Question suivante">
            </form>
            
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>