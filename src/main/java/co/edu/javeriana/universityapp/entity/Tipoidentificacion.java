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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "TIPOIDENTIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoidentificacion.findAll", query = "SELECT t FROM Tipoidentificacion t")
    , @NamedQuery(name = "Tipoidentificacion.findByIdtipo", query = "SELECT t FROM Tipoidentificacion t WHERE t.idtipo = :idtipo")
    , @NamedQuery(name = "Tipoidentificacion.findByTipo", query = "SELECT t FROM Tipoidentificacion t WHERE t.tipo = :tipo")})
public class Tipoidentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPO")
    private Integer idtipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "idtipo")
    private List<Tercero> terceroList;

    public Tipoidentificacion() {
    }

    public Tipoidentificacion(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Tipoidentificacion(Integer idtipo, String tipo) {
        this.idtipo = idtipo;
        this.tipo = tipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoidentificacion)) {
            return false;
        }
        Tipoidentificacion other = (Tipoidentificacion) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.Tipoidentificacion[ idtipo=" + idtipo + " ]";
    }
    
}
