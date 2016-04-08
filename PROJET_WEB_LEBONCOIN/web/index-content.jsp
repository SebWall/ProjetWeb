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
    <title>Le bon coin des étudiants</title>  
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
    
        <!-- Fin du menu -->  
       
        <!-- Numero de page -->
        <c:if test="${param['action'] == 'listerLesUtilisateurs'}" >  
            <div id="numPage">
                <h2> Affichage des pages </h2>
                <a href="ServletUsers?action=pagination1a10">1-10</a>
                <a href="ServletUsers?action=pagination11a20">11-20</a>
                <a href="ServletUsers?action=pagination21a30">21-30</a>
                <a href="ServletUsers?action=pagination31a40">31-40</a>
                <a href="ServletUsers?action=pagination41a50">41-50</a>   
            </div>
        </c:if>  
        
        <!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->  
       
        <div id="tableau">
            <table class="listing">  

                <c:if test="${param['action'] == 'listerLesUtilisateurs'}" >  

                    <tr>  
                        <th>Numero</th>
                        <th>Login</th>  
                        <th>Prénom</th>  
                        <th>Nom</th>  
                        <th>Mail</th>
                        <th>Telephone</th>
                        <th>Adresse(s)</th>
                    </tr>  
                        <!-- La ligne de titre du tableau des comptes -->  
                        <!-- Ici on affiche les lignes, une par utilisateur -->  
                        <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                        <c:set var="total" value="1"/>  
                        <c:forEach var="u" items="${requestScope['listeDesUsers']}">  
                            <tr>  
                                <td>${total}</td> 
                                <td>${u.login}</td>  
                                <td>${u.firstname}</td>  
                                <td>${u.lastname}</td>  
                                <td>${u.mail}</td>
                                <td>${u.tel}</td>
                                <td> 
                                    <c:set var="login" value="${u.login}"/>
                                    <!--<a href="ServletUsers?action=AdresseUser">Chercher :</a>-->
                                    <a href="ServletUsers?login=${u.login}&action=AdresseUser&submit=Chercher">Voir :</a>
                                </td>



                                <!-- On compte le nombre de users -->  
                                <c:set var="total" value="${total+1}"/>  
                            </tr>  
                        </c:forEach>  

                        <!-- Affichage du solde total dans la dernière ligne du tableau -->  
                        <tr><td><b>TOTAL</b></td><td><b>${total-1}</b></td></tr>  

                </c:if>  
            </table>
        </div>   
        
        <div id="tableauAdresse">
            <table class="listing">  

                <c:if test="${param['action'] == 'listerLesAdresses'}" >  

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
                                <td>
                                <a href="ServletUsers?login=${a.loginUser}&action=chercherParLogin&submit=Chercher">${a.loginUser}</a>
                                </td> 
                                <!-- On compte le nombre de users -->  
                                <c:set var="total" value="${total+1}"/>  
                            </tr>  
                        </c:forEach>  

                        <!-- Affichage du solde total dans la dernière ligne du tableau -->  
                        <tr><td><b>TOTAL</b></td><td><b>${total}</b></td></tr>  

                </c:if>  
            </table>
        </div>   
        
        <div id="tableauProduit">
            <table class="listing">  

                <c:if test="${param['action'] == 'listerLesProduits'}" >  

                    <tr>  
                        <th>Type d'annonce</th>  
                        <th>Titre de l'annonce</th>  
                        <th>Catégorie</th>  
                        <th>Description</th>  
                        <th>Date de dépot</th>
                        <th>Date de fin</th>
                        <th>Prix</th>
                        <th>Vendeur/Chercheur</th>
                    </tr>  
                        <!-- La ligne de titre du tableau des comptes -->  
                        <!-- Ici on affiche les lignes, une par utilisateur -->  
                        <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                        <c:set var="total" value="0"/>  

                        <c:forEach var="p" items="${requestScope['listeDesProduits']}">  
                            <tr>  
                                <td>${p.type}</td>  
                                <td>${p.titre}</td>  
                                <td>${p.categorie}</td> 
                                <td>${p.description}</td> 
                                <td>${p.dateDepot}</td> 
                                <td>${p.dateFin}</td>
                                <td>${p.prix}</td>
                                <td>
                                <a href="ServletUsers?login=${p.loginUser}&action=chercherParLogin&submit=Chercher">${p.loginUser}</a>
                                </td> 
                                <!-- On compte le nombre de users -->  
                                <c:set var="total" value="${total+1}"/>  
                            </tr>  
                        </c:forEach>  

                        <!-- Affichage du solde total dans la dernière ligne du tableau -->  
                        <tr><td><b>TOTAL</b></td><td><b>${total}</b></td></tr>  

                </c:if>  
            </table>
        </div>   
            
    </body>  
</html>  
