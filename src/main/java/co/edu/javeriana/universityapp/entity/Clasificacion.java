/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.universityapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariajosemendoza
 */
@Entity
@Table(name = "CLASIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c")
    , @NamedQuery(name = "Clasificacion.findByIdclasificacion", query = "SELECT c FROM Clasificacion c WHERE c.idclasificacion = :idclasificacion")
    , @NamedQuery(name = "Clasificacion.findByClasificacion", query = "SELECT c FROM Clasificacion c WHERE c.clasificacion = :clasificacion")
    , @NamedQuery(name = "Clasificacion.findByNumeroclasificacion", query = "SELECT c FROM Clasificacion c WHERE c.numeroclasificacion = :numeroclasificacion")})
public class Clasificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLASIFICACION")
    private Integer idclasificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLASIFICACION")
    private String clasificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROCLASIFICACION")
    private int numeroclasificacion;
    @ManyToMany(mappedBy = "clasificacionList")
    private List<Tercero> terceroList;

    public Clasificacion() {
    }

    public Clasificacion(Integer idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public Clasificacion(Integer idclasificacion, String clasificacion, int numeroclasificacion) {
        this.idclasificacion = idclasificacion;
        this.clasificacion = clasificacion;
        this.numeroclasificacion = numeroclasificacion;
    }

    public Integer getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(Integer idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getNumeroclasificacion() {
        return numeroclasificacion;
    }

    public void setNumeroclasificacion(int numeroclasificacion) {
        this.numeroclasificacion = numeroclasificacion;
    }

    @XmlTransient
    public List<Tercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Tercero> terceroList) {
        this.terceroList = terceroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasificacion != null ? idclasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.idclasificacion == null && other.idclasificacion != null) || (this.idclasificacion != null && !this.idclasificacion.equals(other.idclasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.Clasificacion[ idclasificacion=" + idclasificacion + " ]";
    }
    
}
