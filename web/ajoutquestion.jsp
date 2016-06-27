<%-- 
    Document   : ajoutquestion
    Created on : 27 juin 2016, 10:45:35
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
            <form method="post">
                Question 1 : <input type="text" name="q1"><br>
                rep 1 : <input type="text" name="r1"><br>
                rep 2 : <input type="text" name="r2"><br>
                rep 3 : <input type="text" name="r3"><br>
                rep 4 : <input type="text" name="r4"><br>
                Numéro de la bonne réponse : <input type="number" name="nrep" min="1" max="4"><br>                
                
                <input type="submit" value="Continuer">
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
