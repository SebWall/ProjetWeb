<%-- 
    Document   : newjspgestionAdresse-content
    Created on : 8 avr. 2016, 08:24:48
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
        <div id="adresse">
        <h2>Gestion des adresses</h2> 
        <li>   <h3> Ajouter une adresse :</h3>
                <form action="ServletUsers" method="get">  
                        login utilisateur : <input type="text" name="loginUser" value="${a.loginUser}"/><br> 
                        Numero de rue : <input type="number" name="numRue" value="${a.numeroRue}"/><br>  
                        Nom de la rue : <input type="text" name="nomRue" value=" ${a.nomRue}"/><br>  
                        Code Postal : <input type="number" name="cd" value="${a.codePostal} "/><br> 
                        Ville : <input type="text" name="Ville" value="${a.nomVille} "/><br> 
                        Pays : <input type="text" name="Pays" value="${a.nomPays} "/><br> 
                        <input type="hidden" name="action" value="ajouterAdresse"/>  
                        <input type="submit" value="Ajouter" name="submit"/>  
                 </form> 
                </li>     
                <li><h3> Lister les adresses d'un utilisateur :   </h3> 
                   <form action="ServletUsers" method="get">  
                        login utilisateur : <input type="text" name="login" value="${u.login}"/><br>  
                        <input type="hidden" name="action" value="AdresseUser"/>  
                        <input type="submit" value="Chercher" name="submit"/>  
                 </form>  
               </li>    
                
    </div>     
    </body>
</html>
