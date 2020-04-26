package zadanie;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zadanie.Akcia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-26T16:32:33")
@StaticMetamodel(Prednaska.class)
public class Prednaska_ { 

    public static volatile SingularAttribute<Prednaska, String> nazov;
    public static volatile SingularAttribute<Prednaska, Akcia> konferencia;
    public static volatile SingularAttribute<Prednaska, Long> id;
    public static volatile ListAttribute<Prednaska, String> autori;

}