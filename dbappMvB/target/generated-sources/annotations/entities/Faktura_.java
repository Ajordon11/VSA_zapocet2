package entities;

import entities.Polozka;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-26T22:20:12")
@StaticMetamodel(Faktura.class)
public class Faktura_ { 

    public static volatile SingularAttribute<Faktura, String> zakaznik;
    public static volatile SingularAttribute<Faktura, Date> aktualizacia;
    public static volatile SingularAttribute<Faktura, Integer> id;
    public static volatile ListAttribute<Faktura, Polozka> polozky;

}