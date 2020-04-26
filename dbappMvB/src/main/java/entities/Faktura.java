/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
//import javax.persistence.Temporal;

/**
 *
 * @author vsa
 */
@NamedQueries({
    @NamedQuery(name = "Faktura.count", query = "SELECT COUNT(f) FROM Faktura f WHERE f.zakaznik = :zakaznik"),
    @NamedQuery(name = "Faktura.getById", query = "SELECT f FROM Faktura f WHERE f.id = :id"),
//    @NamedQuery(name = "Faktura.updateDate", query = "UPDATE Faktura f SET f.aktualizacia = CURRENT_DATE")
})
@Entity
public class Faktura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String zakaznik;

    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date aktualizacia;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "faktura")
    private List<Polozka> polozky;

    public String getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(String zakaznik) {
        this.zakaznik = zakaznik;
    }

    public Date getAktualizacia() {
        return aktualizacia;
    }

    public void setAktualizacia(Date aktualizacia) {
        this.aktualizacia = aktualizacia;
    }

    public List<Polozka> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<Polozka> polozky) {
        this.polozky = polozky;
    }
    
    public Faktura() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faktura)) {
            return false;
        }
        Faktura other = (Faktura) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Faktura[ id=" + id + " ]";
    }
    
}
