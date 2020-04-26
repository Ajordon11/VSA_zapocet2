package entities;

import entities.Faktura;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-26T22:20:12")
@StaticMetamodel(Polozka.class)
public class Polozka_ { 

    public static volatile SingularAttribute<Polozka, String> produkt;
    public static volatile SingularAttribute<Polozka, Integer> id;
    public static volatile SingularAttribute<Polozka, Double> cena;
    public static volatile SingularAttribute<Polozka, Faktura> faktura;

}