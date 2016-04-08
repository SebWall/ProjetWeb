/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateurs.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author sebastien
 */
@Entity
public class Adresse implements Serializable {

    ///////////// VARIABLES //////////////////////////////   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String numeroRue;  
    private String nomRue;  
    private String codePostal;  
    private String nomVille;
    private String nomPays;
    private String loginUser;
   // private String UTILISATEUR_ID;
    
    @ManyToOne
    private Utilisateur utilisateur;
////////////////////////CONSTRUCTEURS///////////////////////////////////////////////
    //constructeur par défaut
     public Adresse( ) {

    }
    public Adresse(String numeroRue, String nomRue, String codePostal, String nomVille, String nomPays) {
        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.nomVille = nomVille;
        this.nomPays = nomPays;
    }
     
     //constructeur avec loginUser
     public Adresse( String numeroRue, String nomRue, String codePostal, String nomVille, String nomPays, String loginUser) {

        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.nomVille = nomVille;
        this.nomPays = nomPays;
        this.loginUser = loginUser;
    }
     //constructeur avec login et utilisateurID
   /*  public Adresse( String numeroRue, String nomRue, String codePostal, String nomVille, String nomPays, String loginUser, String UTILISATEUR_ID) {
        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.nomVille = nomVille;
        this.nomPays = nomPays;
        this.loginUser = loginUser;
        this.UTILISATEUR_ID = UTILISATEUR_ID;
    }*/
/////////////////////////GETTER & SETTER//////////////////////////////////////////////////

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getNumeroRue() {
        return numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getNomVille() {
        return nomVille;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public void setCodePostal(String CodePostal) {
        this.codePostal = codePostal;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
/*
    public String getUTILISATEUR_ID() {
        return UTILISATEUR_ID;
    }

    public void setUTILISATEUR_ID(String UTILISATEUR_ID) {
        this.UTILISATEUR_ID = UTILISATEUR_ID;
    }
*/

////////////////////////////////METHODES/////////////////////////////////////
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Adresse[ id=" + id + " ]";
    }
    
}
