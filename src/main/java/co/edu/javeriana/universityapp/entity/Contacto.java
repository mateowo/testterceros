/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.universityapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariajosemendoza
 */
@Entity
@Table(name = "CONTACTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
    , @NamedQuery(name = "Contacto.findByIdcontacto", query = "SELECT c FROM Contacto c WHERE c.idcontacto = :idcontacto")
    , @NamedQuery(name = "Contacto.findByNombrecontacto", query = "SELECT c FROM Contacto c WHERE c.nombrecontacto = :nombrecontacto")
    , @NamedQuery(name = "Contacto.findByTercero", query = "SELECT c FROM Contacto c WHERE c.idtercero.idtercero = :idtercero")
    , @NamedQuery(name = "Contacto.findByTelefonocontacto", query = "SELECT c FROM Contacto c WHERE c.telefonocontacto = :telefonocontacto")
    , @NamedQuery(name = "Contacto.findByRelacion", query = "SELECT c FROM Contacto c WHERE c.relacion = :relacion")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONTACTO")
    private Integer idcontacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRECONTACTO")
    private String nombrecontacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEFONOCONTACTO")
    private String telefonocontacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RELACION")
    private String relacion;
    @JoinColumn(name = "IDTERCERO", referencedColumnName = "IDTERCERO")
    @ManyToOne
    private Tercero idtercero;

    public Contacto() {
    }

    public Contacto(Integer idcontacto) {
        this.idcontacto = idcontacto;
    }

    public Contacto(Integer idcontacto, String nombrecontacto, String telefonocontacto, String relacion) {
        this.idcontacto = idcontacto;
        this.nombrecontacto = nombrecontacto;
        this.telefonocontacto = telefonocontacto;
        this.relacion = relacion;
    }

    public Integer getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(Integer idcontacto) {
        this.idcontacto = idcontacto;
    }

    public String getNombrecontacto() {
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public String getTelefonocontacto() {
        return telefonocontacto;
    }

    public void setTelefonocontacto(String telefonocontacto) {
        this.telefonocontacto = telefonocontacto;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public Tercero getIdtercero() {
        return idtercero;
    }

    public void setIdtercero(Tercero idtercero) {
        this.idtercero = idtercero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontacto != null ? idcontacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idcontacto == null && other.idcontacto != null) || (this.idcontacto != null && !this.idcontacto.equals(other.idcontacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.Contacto[ idcontacto=" + idcontacto + " ]";
    }
    
}
