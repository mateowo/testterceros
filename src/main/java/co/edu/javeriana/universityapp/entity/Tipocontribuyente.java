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
@Table(name = "TIPOCONTRIBUYENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocontribuyente.findAll", query = "SELECT t FROM Tipocontribuyente t")
    , @NamedQuery(name = "Tipocontribuyente.findByIdtipocontribuyente", query = "SELECT t FROM Tipocontribuyente t WHERE t.idtipocontribuyente = :idtipocontribuyente")
    , @NamedQuery(name = "Tipocontribuyente.findByTipocontribuyente", query = "SELECT t FROM Tipocontribuyente t WHERE t.tipocontribuyente = :tipocontribuyente")})
public class Tipocontribuyente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOCONTRIBUYENTE")
    private Integer idtipocontribuyente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPOCONTRIBUYENTE")
    private String tipocontribuyente;
    @OneToMany(mappedBy = "idtipocontribuyente")
    private List<Tercero> terceroList;

    public Tipocontribuyente() {
    }

    public Tipocontribuyente(Integer idtipocontribuyente) {
        this.idtipocontribuyente = idtipocontribuyente;
    }

    public Tipocontribuyente(Integer idtipocontribuyente, String tipocontribuyente) {
        this.idtipocontribuyente = idtipocontribuyente;
        this.tipocontribuyente = tipocontribuyente;
    }

    public Integer getIdtipocontribuyente() {
        return idtipocontribuyente;
    }

    public void setIdtipocontribuyente(Integer idtipocontribuyente) {
        this.idtipocontribuyente = idtipocontribuyente;
    }

    public String getTipocontribuyente() {
        return tipocontribuyente;
    }

    public void setTipocontribuyente(String tipocontribuyente) {
        this.tipocontribuyente = tipocontribuyente;
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
        hash += (idtipocontribuyente != null ? idtipocontribuyente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocontribuyente)) {
            return false;
        }
        Tipocontribuyente other = (Tipocontribuyente) object;
        if ((this.idtipocontribuyente == null && other.idtipocontribuyente != null) || (this.idtipocontribuyente != null && !this.idtipocontribuyente.equals(other.idtipocontribuyente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.Tipocontribuyente[ idtipocontribuyente=" + idtipocontribuyente + " ]";
    }
    
}
