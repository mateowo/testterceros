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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "TIPOTERCERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotercero.findAll", query = "SELECT t FROM Tipotercero t")
    , @NamedQuery(name = "Tipotercero.findByIdtipotercero", query = "SELECT t FROM Tipotercero t WHERE t.idtipotercero = :idtipotercero")
    , @NamedQuery(name = "Tipotercero.findByTipotercero", query = "SELECT t FROM Tipotercero t WHERE t.tipotercero = :tipotercero")})
public class Tipotercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOTERCERO")
    private Integer idtipotercero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPOTERCERO")
    private String tipotercero;
    @JoinTable(name = "TERCEROXTIPOTERCERO", joinColumns = {
        @JoinColumn(name = "IDTIPOTERCERO", referencedColumnName = "IDTIPOTERCERO")}, inverseJoinColumns = {
        @JoinColumn(name = "IDTERCERO", referencedColumnName = "IDTERCERO")})
    @ManyToMany
    private List<Tercero> terceroList;

    public Tipotercero() {
    }

    public Tipotercero(Integer idtipotercero) {
        this.idtipotercero = idtipotercero;
    }

    public Tipotercero(Integer idtipotercero, String tipotercero) {
        this.idtipotercero = idtipotercero;
        this.tipotercero = tipotercero;
    }

    public Integer getIdtipotercero() {
        return idtipotercero;
    }

    public void setIdtipotercero(Integer idtipotercero) {
        this.idtipotercero = idtipotercero;
    }

    public String getTipotercero() {
        return tipotercero;
    }

    public void setTipotercero(String tipotercero) {
        this.tipotercero = tipotercero;
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
        hash += (idtipotercero != null ? idtipotercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotercero)) {
            return false;
        }
        Tipotercero other = (Tipotercero) object;
        if ((this.idtipotercero == null && other.idtipotercero != null) || (this.idtipotercero != null && !this.idtipotercero.equals(other.idtipotercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.Tipotercero[ idtipotercero=" + idtipotercero + " ]";
    }
    
}
