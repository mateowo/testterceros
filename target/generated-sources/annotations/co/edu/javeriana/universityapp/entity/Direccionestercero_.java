package co.edu.javeriana.universityapp.entity;

import co.edu.javeriana.universityapp.entity.Ciudad;
import co.edu.javeriana.universityapp.entity.Tercero;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-29T11:40:48")
@StaticMetamodel(Direccionestercero.class)
public class Direccionestercero_ { 

    public static volatile SingularAttribute<Direccionestercero, Integer> iddireccion;
    public static volatile SingularAttribute<Direccionestercero, String> paginaweb;
    public static volatile SingularAttribute<Direccionestercero, String> sucursal;
    public static volatile SingularAttribute<Direccionestercero, String> direccion;
    public static volatile SingularAttribute<Direccionestercero, Ciudad> idciudad;
    public static volatile SingularAttribute<Direccionestercero, String> telefono;
    public static volatile SingularAttribute<Direccionestercero, Tercero> idtercero;

}