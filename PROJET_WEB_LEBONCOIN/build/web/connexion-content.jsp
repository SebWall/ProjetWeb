<%-- 
    Document   : connexion
    Created on : 2 mars 2016, 14:42:23
    Author     : sebastien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        
         <div id="connexion">    
         <form action="ServletUsers" method="post">  
                <legend>Connexion</legend>
                <label for="nom">Login <span class="requis"></span></label>
                <input type="login" id="login" name="login" value="${u.login}" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['login']}</span>
                <br />
                <label for="motdepasse">Mot de passe <span class="requis"></span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="${u.password}" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />
                <input type="hidden" name="action" value="connecterUtilisateur"/>  
                <input type="submit" value="Connexion" name="submit" class="sansLabel" />
                <br /> 
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
        </form>
    </div>    
        
        <c:if test="${!empty param['message']}">  
            <h2>${param.message}</h2>  
        </c:if>  
    
    </body>
</html>
