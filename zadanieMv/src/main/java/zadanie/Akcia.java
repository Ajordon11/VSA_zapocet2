package zadanie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.AUTO;

@NamedQuery(name = "Akcia.getPrednaskyFromAkciaByAutor", query = "SELECT a FROM Akcia a "
        + "WHERE a.nazov = :nazov")
@Entity
public class Akcia implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = AUTO)
    private long id;
    @Basic
    @Column(name = "NAZOV", nullable = false, length = 256)
    private String nazov;
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "TERMIN", nullable = false)
    private Date termin;
    @OneToMany(mappedBy = "konferencia", cascade = PERSIST)
    private List<Prednaska> prednasky;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Akcia akcia = (Akcia) o;
        return id == akcia.id &&
                Objects.equals(nazov, akcia.nazov) &&
                Objects.equals(termin, akcia.termin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazov, termin);
    }

    public List<Prednaska> getPrednasky() {
        return prednasky;
    }

    public void setPrednasky(List<Prednaska> prednasky) {
        this.prednasky = prednasky;
    }

    public Akcia() {
    }

    @Override
    public String toString() {
        return "Akcia{" + "id=" + id + ", nazov=" + nazov + ", termin=" + termin + ", prednasky=" + prednasky + '}';
    }
    
    
}
