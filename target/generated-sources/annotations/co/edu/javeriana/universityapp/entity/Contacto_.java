package co.edu.javeriana.universityapp.entity;

import co.edu.javeriana.universityapp.entity.Tercero;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-29T11:40:48")
@StaticMetamodel(Contacto.class)
public class Contacto_ { 

    public static volatile SingularAttribute<Contacto, String> relacion;
    public static volatile SingularAttribute<Contacto, Integer> idcontacto;
    public static volatile SingularAttribute<Contacto, String> nombrecontacto;
    public static volatile SingularAttribute<Contacto, String> telefonocontacto;
    public static volatile SingularAttribute<Contacto, Tercero> idtercero;

}