package zadanie;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zadanie.Prednaska;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-26T16:32:33")
@StaticMetamodel(Akcia.class)
public class Akcia_ { 

    public static volatile ListAttribute<Akcia, Prednaska> prednasky;
    public static volatile SingularAttribute<Akcia, String> nazov;
    public static volatile SingularAttribute<Akcia, Date> termin;
    public static volatile SingularAttribute<Akcia, Long> id;

}