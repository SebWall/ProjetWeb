<%-- 
    Document   : menuDeroulant
    Created on : 8 avr. 2016, 08:10:48
    Author     : sebastien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="menuDeroulant"> 
            <ul id="menu-demo2">
                <li><a href="index.jsp">Accueil</a></li>

                <li><a href="gestionUtilisateurs.jsp">Utilisateurs</a>
                        <ul>
                                <li><a href="ServletUsers?action=listerLesUtilisateurs">Afficher tous les utilisateurs</a></li> 
                                <li><a href="gestionUtilisateurs.jsp">Gérer les utilisateurs</a></li> 
                        </ul>
                </li>
                <li><a href="gestionAdresses.jsp">Adresses</a>
                        <ul>
                                <li><a href="ServletUsers?action=listerLesAdresses">Afficher toutes les adresses</a></li>  
                                <li><a href="gestionAdresses.jsp">Gérer les adresses</a></li>
                        </ul>
                </li>
                <li><a href="#">Produits</a>
                        <ul>
                                <li><a href="#">Afficher tous les produits</a></li>
                                <li><a href="#">Gérer les produits</a></li>
                        </ul>
                </li>
            </ul>
         </div>
    </body>
</html>
