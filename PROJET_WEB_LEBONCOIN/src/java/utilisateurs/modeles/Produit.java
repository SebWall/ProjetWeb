package utilisateurs.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sebastien
 */
@Entity
public class Produit implements Serializable {
    
////////////////////VARIABLES/////////////////////////////////////////////
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type; //JE CHERCHE OU JE VENDS
    private String titre;
    private String categorie;
    private String description;
    private String dateDepot;
    private String dateFin;
    private String Prix;
    private String loginUser;
    
 /////////////////CONSTRUCTEURS/////////////////////////////////////////////  

    public Produit() {
    }

    public Produit(Long id, String type, String titre, String categorie, String description, String dateDepot, String dateFin, String Prix, String loginUser) {
        this.id = id;
        this.type = type;
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.dateDepot = dateDepot;
        this.dateFin = dateFin;
        this.Prix = Prix;
        this.loginUser = loginUser;
    }
        //CONSTRUCTEUR POUR LES PRODUITS EN VENTES
    public Produit(String type, String titre, String categorie, String description, String dateDepot, String dateFin, String Prix, String loginUser) {
        this.type = type;
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.dateDepot = dateDepot;
        this.dateFin = dateFin;
        this.Prix = Prix;
        this.loginUser = loginUser;
    }
    //CONSTRUCTEUR POUR LES PRODUITS RECHERCHE
    public Produit(String type, String titre, String categorie, String description, String loginUser) {
        this.type = type;
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.loginUser = loginUser;
    }
    
///////////////////GETTER & SETTER ///////////////////////////////////////

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public String getTitre() {
        return titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }

    public String getDateDepot() {
        return dateDepot;
    }

    public String getDateFin() {
        return dateFin;
    }

    public String getPrix() {
        return Prix;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDepot(String dateDepot) {
        this.dateDepot = dateDepot;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setPrix(String Prix) {
        this.Prix = Prix;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
////////////////////METHODES/////////////////////////////
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateurs.modeles.Produit[ id=" + id + " ]";
    }
    
}
