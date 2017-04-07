/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdmti;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanpedrogutierrezsalas
 */
@Entity
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByIdservicio", query = "SELECT s FROM Servicio s WHERE s.servicioPK.idservicio = :idservicio")
    , @NamedQuery(name = "Servicio.findByDesservicio", query = "SELECT s FROM Servicio s WHERE s.desservicio = :desservicio")
    , @NamedQuery(name = "Servicio.findByProveedorIdproveedor", query = "SELECT s FROM Servicio s WHERE s.servicioPK.proveedorIdproveedor = :proveedorIdproveedor")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicioPK servicioPK;
    @Size(max = 45)
    @Column(name = "desservicio")
    private String desservicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio")
    private Collection<Evento> eventoCollection;
    @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "idproveedor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedor proveedor;

    public Servicio() {
    }

    public Servicio(ServicioPK servicioPK) {
        this.servicioPK = servicioPK;
    }

    public Servicio(int idservicio, int proveedorIdproveedor) {
        this.servicioPK = new ServicioPK(idservicio, proveedorIdproveedor);
    }

    public ServicioPK getServicioPK() {
        return servicioPK;
    }

    public void setServicioPK(ServicioPK servicioPK) {
        this.servicioPK = servicioPK;
    }

    public String getDesservicio() {
        return desservicio;
    }

    public void setDesservicio(String desservicio) {
        this.desservicio = desservicio;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicioPK != null ? servicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.servicioPK == null && other.servicioPK != null) || (this.servicioPK != null && !this.servicioPK.equals(other.servicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdmti.Servicio[ servicioPK=" + servicioPK + " ]";
    }
    
}
