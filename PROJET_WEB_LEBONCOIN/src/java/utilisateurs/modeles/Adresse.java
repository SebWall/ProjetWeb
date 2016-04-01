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
    
    private int numeroRue;  
    private String nomRue;  
    private int CodePostal;  
    private String nomVille;
     private String nomPays;
////////////////////////CONSTRUCTEURS///////////////////////////////////////////////
    public Adresse( int numeroRue, String nomRue, int CodePostal, String nomVille, String nomPays) {

        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.CodePostal = CodePostal;
        this.nomVille = nomVille;
        this.nomPays = nomPays;
    }
/////////////////////////GETTER & SETTER//////////////////////////////////////////////////

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public int getCodePostal() {
        return CodePostal;
    }

    public String getNomVille() {
        return nomVille;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public void setCodePostal(int CodePostal) {
        this.CodePostal = CodePostal;
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
        return "entity.Adresse[ id=" + id + " ]";
    }
    
}
