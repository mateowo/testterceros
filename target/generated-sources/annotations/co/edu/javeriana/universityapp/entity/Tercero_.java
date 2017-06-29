package co.edu.javeriana.universityapp.entity;

import co.edu.javeriana.universityapp.entity.Ciudad;
import co.edu.javeriana.universityapp.entity.Clasificacion;
import co.edu.javeriana.universityapp.entity.Contacto;
import co.edu.javeriana.universityapp.entity.Direccionestercero;
import co.edu.javeriana.universityapp.entity.Tipocontribuyente;
import co.edu.javeriana.universityapp.entity.Tipoidentificacion;
import co.edu.javeriana.universityapp.entity.Tipotercero;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-29T11:40:48")
@StaticMetamodel(Tercero.class)
public class Tercero_ { 

    public static volatile SingularAttribute<Tercero, Tipocontribuyente> idtipocontribuyente;
    public static volatile SingularAttribute<Tercero, String> codigo;
    public static volatile SingularAttribute<Tercero, Double> descuento;
    public static volatile SingularAttribute<Tercero, Integer> plazo;
    public static volatile SingularAttribute<Tercero, String> primernombre;
    public static volatile ListAttribute<Tercero, Direccionestercero> direccionesterceroList;
    public static volatile SingularAttribute<Tercero, String> imagen;
    public static volatile ListAttribute<Tercero, Tipotercero> tipoterceroList;
    public static volatile SingularAttribute<Tercero, String> identificacion;
    public static volatile SingularAttribute<Tercero, Ciudad> idciudad;
    public static volatile SingularAttribute<Tercero, Tipoidentificacion> idtipo;
    public static volatile SingularAttribute<Tercero, Integer> idtercero;
    public static volatile SingularAttribute<Tercero, String> segundoapellido;
    public static volatile SingularAttribute<Tercero, String> primeraprellido;
    public static volatile ListAttribute<Tercero, Clasificacion> clasificacionList;
    public static volatile ListAttribute<Tercero, Contacto> contactoList;
    public static volatile SingularAttribute<Tercero, Date> fechaCreacion;
    public static volatile SingularAttribute<Tercero, String> segundonombre;
    public static volatile SingularAttribute<Tercero, String> observacion;
    public static volatile SingularAttribute<Tercero, Integer> activo;

}