/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbapp;

import entities.Faktura;
import entities.Polozka;
import java.util.Date;
import static java.util.Objects.isNull;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vsa
 */
public class Dbapp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
        EntityManager em = emf.createEntityManager();
    }
    
    public static int pocetFaktur(String zakaznik) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
        EntityManager em = emf.createEntityManager();
        try {
            int pocet =  em.createNamedQuery("Faktura.count", Long.class)
                    .setParameter("zakaznik", zakaznik)
                    .getSingleResult()
                    .intValue();
            return pocet;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static void pridajPolozku(int id, String produkt, double cena) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Faktura faktura = em.createNamedQuery("Faktura.getById", Faktura.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (isNull(faktura)) {
                return;
            } 
            Polozka polozka = new Polozka();
            polozka.setCena(cena);
            polozka.setFaktura(faktura);
            polozka.setProdukt(produkt);
            
            em.persist(polozka);
            faktura.setAktualizacia(new Date());
            em.persist(faktura);
            em.getTransaction().commit();
        } catch (Exception e) {
            return;
        }
    }
}
