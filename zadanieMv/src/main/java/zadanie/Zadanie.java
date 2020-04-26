package zadanie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class Zadanie {
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zadaniePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Prednaska prednaska = new Prednaska();
        prednaska.setNazov("VSA");
        prednaska.setAutori(Arrays.asList("Kossacky", "Antal"));
        em.persist(prednaska);
        
        Akcia konferencia = new Akcia();
        konferencia.setNazov("VSA super konf");
        konferencia.setTermin(new SimpleDateFormat("dd/MM/yyyy").parse("28/04/2020"));
        konferencia.setPrednasky(Collections.singletonList(prednaska));
        prednaska.setKonferencia(konferencia);
        
        em.persist(konferencia);
        em.getTransaction().commit();
        maprednasku("VSA super konf", "Kossacky");
    }

    public static int pocet(String nazov) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zadaniePU");
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Prednaska.countByName", Long.class)
                .setParameter("nazov", nazov)
                .getSingleResult()
                .intValue();
        }

    public static boolean maprednasku(String akcia, String autor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zadaniePU");
        EntityManager em = emf.createEntityManager();
        
        try {   
            Akcia result = em.createNamedQuery("Akcia.getPrednaskyFromAkciaByAutor", Akcia.class)
                .setParameter("nazov", akcia)
                .getSingleResult();
            for (Prednaska p : result.getPrednasky()) {
                if (p.getAutori().contains(autor)) {
                    return true;
                }
            }
            return false;
        } catch (NoResultException e) {
            System.out.println("fuck you");
            return false;
        }
    }
}
