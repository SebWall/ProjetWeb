package utilisateurs.modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.metamodel.SingularAttribute;
import utilisateurs.modeles.Adresse;
/**
 *
 * @author sebastien
 */
@Entity
public class Utilisateur implements Serializable {
   
///////////// VARIABLES //////////////////////////////   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstname;  
    private String lastname;  
    private String login;  
    private String password;
    private String mail;
    private String tel;

    @OneToMany (mappedBy = "utilisateur")
    private ArrayList<Adresse> listeAdresse ;
    
//////////////////// CONSTRUCTEURS /////////////////////
    public Utilisateur() {  
    }  
    public Utilisateur( final String firstname, final String lastname,final String login, final String password, final String mail, final String tel) {  
        this.firstname = firstname; 
        this.lastname = lastname; 
        this.login = login;  
        this.password = password;
        this.mail=mail;
    }  
    //constructeur sans adresse
  public Utilisateur( final String firstname, final String lastname,final String login, final String password) {  
        this.firstname = firstname; 
        this.lastname = lastname; 
        this.login = login;  
        this.password = password;
    }  
// constructeurs avec les adresses
    public Utilisateur( final String firstname, final String lastname,final String login, final String password, final ArrayList<Adresse> listeAdresse ) {  
        this.firstname = firstname; 
        this.lastname = lastname; 
        this.login = login;  
        this.password = password;
        this.listeAdresse = listeAdresse;
    }  

    public Utilisateur(SingularAttribute<Utilisateur, String> firstname, SingularAttribute<Utilisateur, String> lastname, SingularAttribute<Utilisateur, String> login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(String nom, String prenom, String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/////// GETTER & SETTER /////////////////
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Adresse> getListeAdresse() {
        return listeAdresse;
    }

    public void setListeAdresse(ArrayList<Adresse> listeAdresse) {
        this.listeAdresse = listeAdresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
       public String getMail() {
        return mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
       
       
//////////////// METHODES /////////////////////////
  

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Utilisateur[ id=" + id + " ]";
    }

    public void setParameter(String param, String $ulogin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
