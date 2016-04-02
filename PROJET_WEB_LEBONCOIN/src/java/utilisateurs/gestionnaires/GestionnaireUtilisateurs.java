package utilisateurs.gestionnaires;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import utilisateurs.modeles.Adresse;
import utilisateurs.modeles.Utilisateur;


@Stateless  // permet d'utiliser la classe sans faire de new (injection de code)
public class GestionnaireUtilisateurs {
        // Ici injection de code : on n'initialise pas. L'entity manager sera créé  
    // à partir du contenu de persistence.xml  

    @PersistenceContext
    private EntityManager em;

    public Collection<Utilisateur> getAllUsers() {
        // Exécution d'une requête équivalente à un select *  
        Query q = em.createQuery("select u from Utilisateur u");
        return q.getResultList();
    }
    public Collection<Adresse> getAllAdresses() {
        Query q = em.createQuery("select a from Adresse a");
        return q.getResultList();
    }
    
    public void creerUtilisateursDeTest() {
        creeUtilisateur("John", "Lennon", "jlennon","mdp");
        creeUtilisateur("Paul", "Mac Cartney", "pmc","mdp");
        creeUtilisateur("Ringo", "Starr", "rstarr","mdp");
        creeUtilisateur("Georges", "Harisson", "georgesH","mdp");
    }
    public void creer30UtilisateursDeTest() {
        creeUtilisateur("Damian", "Marley", "ut1","mdp");
        creeUtilisateur("Marvin", "Renollet", "ut2","mdp");
        creeUtilisateur("Calvin", "Vilmon", "ut3","mdp");
        creeUtilisateur("Leo", "Amelot", "ut4","mdp");
        creeUtilisateur("Maxime", "Dhaussy", "ut5","mdp");
        creeUtilisateur("Serena", "Waldorf", "ut6","mdp");
        creeUtilisateur("Blair", "Van Der Woodsen","ut7","mdp");
        creeUtilisateur("David", "Starr", "ut8","mdp");
        creeUtilisateur("Enzo", "Ford", "ut9","mdp");
        creeUtilisateur("Ben", "Humfrey", "ut10","mdp");
        creeUtilisateur("John", "Sanchez", "ut11","mdp");
        creeUtilisateur("Jean", "Tex", "ut12","mdp");
        creeUtilisateur("Nou", "Riche", "ut13","mdp");
        creeUtilisateur("Chuck", "Bass", "ut14","mdp");
        creeUtilisateur("Nate", "Harchibald", "ut15","mdp");
        creeUtilisateur("Levelly", "Blake", "ut16","mdp");
        creeUtilisateur("Marc", "MichMich", "ut17","mdp");
        creeUtilisateur("Franck", "Jean", "ut18","mdp");
        creeUtilisateur("Sebastien", "Wallart", "ut19","mdp");
        creeUtilisateur("Aurelien", "Souville", "ut20","mdp");
        creeUtilisateur("Olive", "Dutrou", "ut21","mdp");
        creeUtilisateur("Victor", "Billie", "ut22","mdp");
        creeUtilisateur("Xavier", "Farrant", "ut23","mdp");
        creeUtilisateur("Cyril", "Hanouna", "ut24","mdp");
        creeUtilisateur("Jack", "Chirac", "ut25","mdp");
        creeUtilisateur("Walter", "White", "ut26","mdp");
        creeUtilisateur("Tuco", "Salamanca", "ut27","mdp");
        creeUtilisateur("Mitch", "Lucker", "ut28","mdp");
        creeUtilisateur("Si", "Nock", "ut29","mdp");
        creeUtilisateur("Oliver", "Mine", "ut30","mdp");
    }
   
    public Utilisateur creeUtilisateur(String nom, String prenom, String login, String password) {
        Utilisateur u = new Utilisateur(nom, prenom, login, password );
        em.persist(u);
        return u;
    }

     public Adresse creeAdresse (String numRue, String nomRue, String codePostal, String Ville, String Pays) {
        Adresse a = new Adresse(numRue, nomRue, codePostal, Ville, Pays);
        em.persist(a);
        return a;
    }
     
    public void updateUtilisateur(String prenom, String nom, String login) {
        Query q = em.createQuery("select distinct u from Utilisateur u where u.login='" + login + "'");
        Utilisateur u = (Utilisateur) q.getSingleResult();
        // il est synchronisé avec la bd
        u.setFirstname(prenom);
        u.setLastname(nom);
    }
    public void deleteUser( String login) {
        Query q = em.createQuery("select distinct u from Utilisateur u where u.login='" + login + "'");
        Utilisateur u = (Utilisateur) q.getSingleResult(); // il est necessaire de caster la reponse q de type requête en type Utilisateur
        em.remove(u);
    }

    public Collection<Utilisateur> chercherParLogin(String login) {
        Query q = em.createQuery("select distinct u from Utilisateur u where u.login='" + login + "'");
        return q.getResultList();
    }
     public Collection<Adresse> getAdresseUser(String login) {
        Query q = em.createQuery("select a from Adresse a where a.loginUser='" + login + "'");
        return q.getResultList();
    }
     
//////////////////////////// TEST LOGIN PASSWORD //////////////////////////////
    public boolean testLogin(String login ) {
       
        //On teste de récuperer l'utilisateur correspondant au login envoyé par l'utilisateur
       try{
           Query q = em.createQuery("select distinct u from Utilisateur u where u.login='" + login + "'");
           Utilisateur u = (Utilisateur) q.getSingleResult();
           String logU = u.getLogin();
           
           if(logU.equals(login)){
                System.out.println("Login correcte -->");
               return true; 
           }
           else{
                System.out.println("Login error -->");
               return false;
           }
           
       }
       catch(Exception e){ 
           e.printStackTrace();
            System.out.println("Login error -->");
           return false;
       }
    }
        public boolean testPassword(String login, String password ) {
       
        //On teste de récuperer l'utilisateur correspondant au password envoyé par l'utilisateur
       try{
           Query q = em.createQuery("select distinct u from Utilisateur u where u.login='" + login + "'");
           Utilisateur u = (Utilisateur) q.getSingleResult();
           String passwordU = u.getPassword();
           
           if(passwordU.equals(password)){
               System.out.println("Password correcte -->");
               return true;
           }
           else{
               System.out.println("Password error -->");
               return false;
           }
       }
       catch(Exception e){ 
           e.printStackTrace();
           System.out.println("Password error -->");
           return false;
       }

    }
///////////////////////// PAGINATION ///////////////////////////////////////////        
    public Collection<Utilisateur> pagination1a10(){
        Query q = em.createQuery("select u from Utilisateur u");
        q.setMaxResults(10);
        q.setFirstResult(0);
        return q.getResultList();
    }
    public Collection<Utilisateur> pagination11a20(){
        Query q = em.createQuery("select u from Utilisateur u");
        q.setMaxResults(10);
        q.setFirstResult(10);
        return q.getResultList();
    }
    public Collection<Utilisateur> pagination21a30(){
        Query q = em.createQuery("select u from Utilisateur u");
        q.setMaxResults(10);
        q.setFirstResult(20);
        return q.getResultList();
    }
     public Collection<Utilisateur> pagination31a40(){
        Query q = em.createQuery("select u from Utilisateur u");
        q.setMaxResults(10);
        q.setFirstResult(30);
        return q.getResultList();
    }
      public Collection<Utilisateur> pagination41a50(){
        Query q = em.createQuery("select u from Utilisateur u");
        q.setMaxResults(10);
        q.setFirstResult(40);
        return q.getResultList();
    }
    
    public void businessMethod() {
    }

    public Collection<Adresse> getAdresseUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
