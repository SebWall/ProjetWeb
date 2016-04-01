/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.Collection;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.SessionBean;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilisateurs.gestionnaires.GestionnaireUtilisateurs;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author sebastien
 */
@WebServlet(name = "ServletUsers", urlPatterns = {"/ServletUsers"})
public class ServletUsers extends HttpServlet {

    @EJB

    private GestionnaireUtilisateurs gestionnaireUtilisateurs;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");
        String forwardTo = "";
        String message = "";
        
        if (action != null) {
 ///////////////////////// lister, creer, chercher, supprimer, modifier ...           
            if (action.equals("listerLesUtilisateurs")) {
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response); 
            } 
            else if (action.equals("creerUtilisateursDeTest")) {
                gestionnaireUtilisateurs.creerUtilisateursDeTest();
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response);   
            } 
            else if (action.equals("creer30UtilisateursDeTest")) {
                gestionnaireUtilisateurs.creer30UtilisateursDeTest();
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response);   
            } 
            else if (action.equals("creerUnUtilisateur")) {
                String lastName = request.getParameter("nom");
                String firstName = request.getParameter("prenom");
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                gestionnaireUtilisateurs.creeUtilisateur(firstName, lastName, login, password);
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response);
                
            } 
            else if (action.equals("chercherParLogin")) {
                String login = request.getParameter("login");
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.chercherParLogin(login);
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs avec le login";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response);
                
            } 
            else if (action.equals("deleteUtilisateur")) {
                String login = request.getParameter("login");
                gestionnaireUtilisateurs.deleteUser(login);
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "L'utilisateur a été supprimé, voici la liste actualisée :";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response);
                
            } 
            else if (action.equals("updateUtilisateur")) {
                String lastName = request.getParameter("nom");
                String firstName = request.getParameter("prenom");
                String login = request.getParameter("login");
                gestionnaireUtilisateurs.updateUtilisateur(firstName, lastName, login);
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.chercherParLogin(login);
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Utilisateur modifié";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response);        
            } 
///////////////////////////////////////// PAGINATION ////////////////////////////////////////
            else if (action.equals("pagination1a10")) {
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.pagination1a10();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des 10 premiers utilisateurs";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response); 
            } 
            else if (action.equals("pagination11a20")) {
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.pagination11a20();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs 11 à 20";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response); 
            } 
            else if (action.equals("pagination21a30")) {
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.pagination21a30();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs 21 à 30";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response); 
            } 
            else if (action.equals("pagination31a40")) {
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.pagination31a40();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs 31 à 40";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response); 
            } 
             else if (action.equals("pagination41a50")) {
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.pagination41a50();
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "index.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs 41 à 50";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response); 
            } 
//////////////////////////////////////////// CONNEXION ///////////////////////////////////////////////////
            else if (action.equals("connecterUtilisateur")) {
                String login = request.getParameter("login");
                String password = request.getParameter("motdepasse");
                boolean lo = gestionnaireUtilisateurs.testLogin(login);
                boolean pa = gestionnaireUtilisateurs.testPassword(login, password);

                Collection<Utilisateur> liste = gestionnaireUtilisateurs.chercherParLogin(login);
                request.setAttribute("listeDesUsers", liste);

                if (lo == true && pa == true) { //log et password correcte
                    System.out.println("SERVLET USER: log/pass corrects");
                    message = "Login/Password correcte. Bienvenue, vous etes connecté avec le login : "+login;
                    HttpSession session = request.getSession(true); // création d'une session
                    session.setAttribute("connecte", true);
                    forwardTo = "index.jsp?action=listerLesUtilisateurs";
                    RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                    dp.forward(request, response);
                } 
                else if (lo == true && pa == false) {
                    System.out.println("SERVLET USER: user ok pass incorrect");
                    message = "Message : Login correcte, password invalide";
                    HttpSession session = request.getSession();
                    session.setAttribute("connecte", null);
                    response.sendRedirect("connexion.jsp?message="+message);
                } 
                else if (lo == false) {
                    message = "Message : Login invalide";
                    HttpSession session = request.getSession();
                    session.setAttribute("connecte", null);
                    response.sendRedirect("connexion.jsp?message="+message);
                }
            } 
            else if (action.equals("deconnexion")) {
                String login = request.getParameter("login");
                message = " Vous etes deconnecte";
                HttpSession session = request.getSession();
                session.setAttribute("connecte", null);
                response.sendRedirect("connexion.jsp?message="+message);
               
            } 
            else {
                forwardTo = "index.jsp?action=todo";
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";
                RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
                dp.forward(request, response);
            }
        }

        // Après un forward, plus rien ne peut être exécuté après !  
    }

////////////////////////////////////// METHODES //////////////////
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        // On récupère le contenu du formulaire  
        String lastName = request.getParameter("nom");
        String firstName = request.getParameter("prenom");
        String login = request.getParameter("login");

        response.setHeader("Pragma", "No-cache"); //empeche le cache, empeche de voir l'ancien etat d'une page
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
