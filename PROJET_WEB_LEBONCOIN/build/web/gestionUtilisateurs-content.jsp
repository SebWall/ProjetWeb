<%-- 
    Document   : gestionUtilisateurs-content
    Created on : 8 avr. 2016, 08:00:33
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
       <div id="menu">
                <ul>
                <h3>Gestion des utilisateurs</h3>  

                    <li><a href="ServletUsers?action=listerLesUtilisateurs">Afficher TOUS les utilisateurs</a></li>  
                    <p>  

                   <!--Liste des fonctionnalités à implémenter dans la Servlet (note : après chaque action cette page sera  
                        rappelée par la servlet avec la liste des utilisateurs raffraichie et un message de confirmation--> 
                <ol>  
                  <!--  <li><a href="ServletUsers?action=creerUtilisateursDeTest">Créer 4 utilisateurs de test</a></li>  
                    <li><a href="ServletUsers?action=creer30UtilisateursDeTest">Créer 30 utilisateurs de test</a></li>   -->
                    <li>Créer un utilisateur</li>  
                    <form action="ServletUsers" method="get">  
                        Prénom : <input type="text" name="prenom" id=""prenom" value=" ${u.firstname}"/><br>  
                        Nom : <input type="text" name="nom" id="nom" value="${u.lastname}"/><br>  
                        Login : <input type="text" name="login" id=login" value=" ${u.login}"/><br>  
                        Password : <input type="text" name="password" id=password" value=" ${u.password}"/><br>  
                        <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
                        <input type="hidden" name="action" value="creerUnUtilisateur"/>  
                        <input type="submit" value="Créer l'utilisateur" name="submit"/>  
                    </form>  

                    <li>Afficher les détails d'un utilisateur</li>  
                    <form action="ServletUsers" method="get">  
                        login : <input type="text" name="login" value="${u.login}"/><br>  
                        <input type="hidden" name="action" value="chercherParLogin"/>  
                        <input type="submit" value="Chercher" name="submit"/>  
                    </form>  

                    <li>Supprimer un utilisateur</li>  
                    <form action="ServletUsers" method="get">  
                        login : <input type="text" name="login" value="${u.login}"/><br>  
                        <input type="hidden" name="action" value="deleteUtilisateur"/>  
                        <input type="submit" value="Supprimer" name="submit"/>  
                    </form>  

                    <li>Modifier les détails d'un utilisateur :</li>  
                    <form action="ServletUsers" method="get">  
                        Login : <input type="text" name="login" value="${u.login}"/><br>  
                        Prénom : <input type="text" name="prenom" value=" ${u.firstname}"/><br>  
                        Nom : <input type="text" name="nom" value="${u.lastname} "/><br> 
                        <input type="hidden" name="action" value="updateUtilisateur"/>  
                        <input type="submit" value="Mettre à jour" name="submit"/>  
                    </form>  
                </ol> 
            </ul>        
        </div>
                        
                 
    </body>
</html>
