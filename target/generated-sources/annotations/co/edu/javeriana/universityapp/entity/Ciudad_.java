package co.edu.javeriana.universityapp.entity;

import co.edu.javeriana.universityapp.entity.Direccionestercero;
import co.edu.javeriana.universityapp.entity.Tercero;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-29T11:40:48")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, String> ciudad;
    public static volatile ListAttribute<Ciudad, Tercero> terceroList;
    public static volatile ListAttribute<Ciudad, Direccionestercero> direccionesterceroList;
    public static volatile SingularAttribute<Ciudad, Integer> idciudad;

}