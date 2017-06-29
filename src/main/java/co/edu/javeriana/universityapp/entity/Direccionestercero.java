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
@Table(name = "DIRECCIONESTERCERO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccionestercero.findAll", query = "SELECT d FROM Direccionestercero d")
    , @NamedQuery(name = "Direccionestercero.findByIddireccion", query = "SELECT d FROM Direccionestercero d WHERE d.iddireccion = :iddireccion")
    , @NamedQuery(name = "Direccionestercero.findByDireccion", query = "SELECT d FROM Direccionestercero d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "Direccionestercero.findBySucursal", query = "SELECT d FROM Direccionestercero d WHERE d.sucursal = :sucursal")
    , @NamedQuery(name = "Direccionestercero.findByTelefono", query = "SELECT d FROM Direccionestercero d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Direccionestercero.findByPaginaweb", query = "SELECT d FROM Direccionestercero d WHERE d.paginaweb = :paginaweb")})
public class Direccionestercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDIRECCION")
    private Integer iddireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 59)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 50)
    @Column(name = "SUCURSAL")
    private String sucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAGINAWEB")
    private String paginaweb;
    @JoinColumn(name = "IDCIUDAD", referencedColumnName = "IDCIUDAD")
    @ManyToOne
    private Ciudad idciudad;
    @JoinColumn(name = "IDTERCERO", referencedColumnName = "IDTERCERO")
    @ManyToOne
    private Tercero idtercero;

    public Direccionestercero() {
    }

    public Direccionestercero(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public Direccionestercero(Integer iddireccion, String direccion, String telefono, String paginaweb) {
        this.iddireccion = iddireccion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaweb = paginaweb;
    }

    public Integer getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(Integer iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
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
        hash += (iddireccion != null ? iddireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccionestercero)) {
            return false;
        }
        Direccionestercero other = (Direccionestercero) object;
        if ((this.iddireccion == null && other.iddireccion != null) || (this.iddireccion != null && !this.iddireccion.equals(other.iddireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.universityapp.entity.Direccionestercero[ iddireccion=" + iddireccion + " ]";
    }
    
}
