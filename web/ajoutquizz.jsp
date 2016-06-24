<%-- 
    Document   : ajoutquizz
    Created on : 24 juin 2016, 15:11:14
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
                Nom : <input type="text" name="nom"><br>
                Nombre de questions (min 3) : <input type="number" name="nb" min="1"><br>
                
                Question 1 : <input type="text" name="q1"><br>
                rep 1 : <input type="text" name="r1"><br>
                rep 2 : <input type="text" name="r2"><br>
                rep 3 : <input type="text" name="r3"><br>
                
                
                <input type="submit" value="Continuer">
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>