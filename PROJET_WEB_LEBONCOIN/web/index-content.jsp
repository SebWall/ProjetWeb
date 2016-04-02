<%-- 
    Document   : index
    Created on : 12 févr. 2016, 14:32:02
    Author     : sebastien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  
  
<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>  
    
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Gestionnaire d'utilisateurs</title>  
</head>  
<body>  
    
    <div id="message">    
        <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->  
        <c:if test="${!empty param['message']}">  
            <h2>Message : ${param.message}</h2>  
        </c:if>  
            
    </div>
    
    <div id="deconnexion">
        <a href="ServletUsers?action=deconnexion">Déconnexion</a>
    </div>
    
    <div id="menu">
        <h2>Menu de gestion des utilisateurs</h2>  
        <ul>  
            <li><a href="ServletUsers?action=listerLesUtilisateurs">Afficher TOUS les utilisateurs</a></li>  
            <p>  
        </ul>  
           <!--Liste des fonctionnalités à implémenter dans la Servlet (note : après chaque action cette page sera  
                rappelée par la servlet avec la liste des utilisateurs raffraichie et un message de confirmation--> 
        <ol>  
            <li><a href="ServletUsers?action=creerUtilisateursDeTest">Créer 4 utilisateurs de test</a></li>  
            <li><a href="ServletUsers?action=creer30UtilisateursDeTest">Créer 30 utilisateurs de test</a></li>   
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
  </div>
        <!-- Fin du menu -->  
    <div id="adresse">
        <li>    Ajouter une adresse :
        <form action="ServletUsers" method="get">  
                login utilisateur : <input type="text" name="login" value="${a.UTILISATEUR_ID}"/><br> 
                Numero de rue : <input type="number" name="numRue" value="${a.numeroRue}"/><br>  
                Nom de la rue : <input type="text" name="nomRue" value=" ${a.nomRue}"/><br>  
                Code Postal : <input type="number" name="cd" value="${a.codePostal} "/><br> 
                Ville : <input type="text" name="Ville" value="${a.nomVille} "/><br> 
                Pays : <input type="text" name="Pays" value="${a.nomPays} "/><br> 
                <input type="hidden" name="action" value="ajouterAdresse"/>  
                <input type="submit" value="Ajouter" name="submit"/>  
         </form> 
        </li>     
                <li><a href="ServletUsers?action=listerLesAdresses">Lister les adresses :</a></li>  
           <li> Lister les adresses pour un utilisateur :    
           <form action="ServletUsers" method="get">  
                login utilisateur : <input type="text" name="login" value="${u.login}"/><br>  
                <input type="hidden" name="action" value="AdresseUser"/>  
                <input type="submit" value="Chercher" name="submit"/>  
         </form>  
           </li>    
                
    </div>        
        <!-- Numero de page -->
        
        <div id="numPage">
            <h2> Affichage des pages </h2>
            <a href="ServletUsers?action=pagination1a10">1-10</a>
            <a href="ServletUsers?action=pagination11a20">11-20</a>
            <a href="ServletUsers?action=pagination21a30">21-30</a>
            <a href="ServletUsers?action=pagination31a40">31-40</a>
            <a href="ServletUsers?action=pagination41a50">41-50</a>   
        </div>
   
        
        <!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->  
       
        <div id="tableau">
        <table class="listing">  
                        
        <c:if test="${param['action'] == 'listerLesUtilisateurs'}" >  
            <h2>Liste des utilisateurs</h2>  
            <tr>  
                <th>Login</th>  
                <th>Prénom</th>  
                <th>Nom</th>  
                <th>Adresse(s)</th>
            </tr>  
                <!-- La ligne de titre du tableau des comptes -->  
                <!-- Ici on affiche les lignes, une par utilisateur -->  
                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                <c:set var="total" value="0"/>  
  
                <c:forEach var="u" items="${requestScope['listeDesUsers']}">  
                    <tr>  
                        <td>${u.login}</td>  
                        <td>${u.firstname}</td>  
                        <td>${u.lastname}</td>  
                      
                        <!-- On compte le nombre de users -->  
                        <c:set var="total" value="${total+1}"/>  
                    </tr>  
                </c:forEach>  
  
                <!-- Affichage du solde total dans la dernière ligne du tableau -->  
                <tr><td><b>TOTAL</b></td><td><b>${total}</b></td><td></td></tr>  
  
        </c:if>  
        </table>
        </div>   
        
        <div id="tableauAdresse">
        <table class="listing">  
                        
        <c:if test="${param['action'] == 'listerLesAdresses'}" >  
            <h2>Liste des adresses</h2>  
            <tr>  
                <th>Numero de rue</th>  
                <th>Nom de la rue</th>  
                <th>Code Postal</th>  
                <th>Ville</th>
                <th>Pays</th>
                <th>Login utilisateur</th>
            </tr>  
                <!-- La ligne de titre du tableau des comptes -->  
                <!-- Ici on affiche les lignes, une par utilisateur -->  
                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                <c:set var="total" value="0"/>  
  
                <c:forEach var="a" items="${requestScope['listeDesAdresses']}">  
                    <tr>  
                        <td>${a.numeroRue}</td>  
                        <td>${a.nomRue}</td>  
                        <td>${a.codePostal}</td> 
                        <td>${a.nomVille}</td> 
                        <td>${a.nomPays}</td> 
                        <td>${a.loginUser}</td> 
                        <!-- On compte le nombre de users -->  
                        <c:set var="total" value="${total+1}"/>  
                    </tr>  
                </c:forEach>  
  
                <!-- Affichage du solde total dans la dernière ligne du tableau -->  
                <tr><td><b>TOTAL</b></td><td><b>${total}</b></td><td></td></tr>  
  
        </c:if>  
        </table>
        </div>   
            
    </body>  
</html>  
