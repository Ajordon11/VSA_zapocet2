package zadanie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import static javax.persistence.GenerationType.AUTO;

@Entity
@NamedQueries({
    @NamedQuery(name = "Prednaska.countByName", query = "SELECT COUNT(p) FROM Prednaska p WHERE p.nazov = :nazov")
})
public class Prednaska implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = AUTO)
    private long id;
    @Basic
    @Column(name = "NAZOV", nullable = false, length = 256)
    private String nazov;
    @ManyToOne
    @JoinColumn(name = "ID_AKCIA", referencedColumnName = "ID")
    private Akcia konferencia;
    @ElementCollection
    private List<String> autori;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prednaska prednaska = (Prednaska) o;
        return id == prednaska.id &&
                Objects.equals(nazov, prednaska.nazov);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazov);
    }

    public Akcia getKonferencia() {
        return konferencia;
    }

    public void setKonferencia(Akcia akcia) {
        this.konferencia = akcia;
    }

    public List<String> getAutori() {
        return autori;
    }

    public void setAutori(List<String> autori) {
        this.autori = autori;
    }

    public Prednaska() {
    }

    @Override
    public String toString() {
        return "Prednaska{" + "id=" + id + ", nazov=" + nazov + ", konferencia=" + konferencia + ", autori=" + autori + '}';
    }
}
