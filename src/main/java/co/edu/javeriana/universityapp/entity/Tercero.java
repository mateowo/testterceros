/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.universityapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariajosemendoza
 */
@Entity
@Table(name = "TERCERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tercero.findAll", query = "SELECT t FROM Tercero t")
    , @NamedQuery(name = "Tercero.findByIdtercero", query = "SELECT t FROM Tercero t WHERE t.idtercero = :idtercero")
    , @NamedQuery(name = "Tercero.findByIdentificacion", query = "SELECT t FROM Tercero t WHERE t.identificacion = :identificacion")
    , @NamedQuery(name = "Tercero.findByPrimernombre", query = "SELECT t FROM Tercero t WHERE t.primernombre = :primernombre")
    , @NamedQuery(name = "Tercero.findBySegundonombre", query = "SELECT t FROM Tercero t WHERE t.segundonombre = :segundonombre")
    , @NamedQuery(name = "Tercero.findByPrimeraprellido", query = "SELECT t FROM Tercero t WHERE t.primeraprellido = :primeraprellido")
    , @NamedQuery(name = "Tercero.findBySegundoapellido", query = "SELECT t FROM Tercero t WHERE t.segundoapellido = :segundoapellido")
    , @NamedQuery(name = "Tercero.findByCodigo", query = "SELECT t FROM Tercero t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tercero.findByObservacion", query = "SELECT t FROM Tercero t WHERE t.observacion = :observacion")
    , @NamedQuery(name = "Tercero.findByActivo", query = "SELECT t FROM Tercero t WHERE t.activo = :activo")
    , @NamedQuery(name = "Tercero.findByFechaCreacion", query = "SELECT t FROM Tercero t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Tercero.findByImagen", query = "SELECT t FROM Tercero t WHERE t.imagen = :imagen")
    , @NamedQuery(name = "Tercero.findByDescuento", query = "SELECT t FROM Tercero t WHERE t.descuento = :descuento")
    , @NamedQuery(name = "Tercero.findByPlazo", query = "SELECT t FROM Tercero t WHERE t.plazo = :plazo")})
public class Tercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTERCERO")
    private Integer idtercero;
    @Size(max = 20)
    @Column(name = "IDENTIFICACION")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRIMERNOMBRE")
    private String primernombre;
    @Size(max = 50)
    @Column(name = "SEGUNDONOMBRE")
    private String segundonombre;
    @Size(max = 50)
    @Column(name = "PRIMERAPRELLIDO")
    private String primeraprellido;
    @Size(max = 50)
    @Column(name = "SEGUNDOAPELLIDO")
    private String segundoapellido;
    @Size(max = 10)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 255)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private int activo;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Size(max = 50)
    @Column(name = "IMAGEN")
    private String imagen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCUENTO")
    private Double descuento;
    @Column(name = "PLAZO")
    private Integer plazo;
    @ManyToMany(mappedBy = "terceroList")
    private List<Tipotercero> tipoterceroList;
    @JoinTable(name = "CLASIFICACIONXTERCERO", joinColumns = {
        @JoinColumn(name = "IDTERCERO", referencedColumnName = "IDTERCERO")}, inverseJoinColumns = {
        @JoinColumn(name = "IDCLASIFICACION", referencedColumnName = "IDCLASIFICACION")})
    @ManyToMany
    private List<Clasificacion> clasificacionList;
    @OneToMany(mappedBy = "idtercero")
    private List<Contacto> contactoList;
    @JoinColumn(name = "IDCIUDAD", referencedColumnName = "IDCIUDAD")
    @ManyToOne
    private Ciudad idciudad;
    @JoinColumn(name = "IDTIPOCONTRIBUYENTE", referencedColumnName = "IDTIPOCONTRIBUYENTE")
    @ManyToOne
    private Tipocontribuyente idtipocontribuyente;
    @JoinColumn(name = "IDTIPO", referencedColumnName = "IDTIPO")
    @ManyToOne
    private Tipoidentificacion idtipo;
    @OneToMany(mappedBy = "idtercero")
    private List<Direccionestercero> direccionesterceroList;

    public Tercero() {
    }

    public Tercero(Integer idtercero) {
        this.idtercero = idtercero;
    }

    public Tercero(Integer idtercero, String primernombre, int activo) {
        this.idtercero = idtercero;
        this.primernombre = primernombre;
        this.activo = activo;
    }

    public Integer getIdtercero() {
        return idtercero;
    }

    public void setIdtercero(Integer idtercero) {
        this.idtercero = idtercero;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimeraprellido() {
        return primeraprellido;
    }

    public void setPrimeraprellido(String primeraprellido) {
        this.primeraprellido = primeraprellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    @XmlTransient
    public List<Tipotercero> getTipoterceroList() {
        return tipoterceroList;
    }

    public void setTipoterceroList(List<Tipotercero> tipoterceroList) {
        this.tipoterceroList = tipoterceroList;
    }

    @XmlTransient
    public List<Clasificacion> getClasificacionList() {
        return clasificacionList;
    }

    public void setClasificacionList(List<Clasificacion> clasificacionList) {
        this.clasificacionList = clasificacionList;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    public Tipocontribuyente getIdtipocontribuyente() {
        return idtipocontribuyente;
    }

    public void setIdtipocontribuyente(Tipocontribuyente idtipocontribuyente) {
        this.idtipocontribuyente = idtipocontribuyente;
    }

    public Tipoidentificacion getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tipoidentificacion idtipo) {
        this.idtipo = idtipo;
    }

    @XmlTransient
    public List<Direccionestercero> getDireccionesterceroList() {
        return direccionesterceroList;
    }

    public void setDireccionesterceroList(List<Direccionestercero> direccionesterceroList) {
        this.direccionesterceroList = direccionesterceroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtercero != null ? idtercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tercero)) {
            return false;
        }
        Tercero other = (Tercero) object;
        if ((this.idtercero == null && other.idtercero != null) || (this.idtercero != null && !this.idtercero.equals(other.idtercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.Tercero[ idtercero=" + idtercero + " ]";
    }
    
}
