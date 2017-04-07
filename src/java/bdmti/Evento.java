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
import javax.persistence.JoinColumns;
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
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByIdevento", query = "SELECT e FROM Evento e WHERE e.eventoPK.idevento = :idevento")
    , @NamedQuery(name = "Evento.findByFecinievento", query = "SELECT e FROM Evento e WHERE e.fecinievento = :fecinievento")
    , @NamedQuery(name = "Evento.findByFecfinevento", query = "SELECT e FROM Evento e WHERE e.fecfinevento = :fecfinevento")
    , @NamedQuery(name = "Evento.findByServicioIdservicio", query = "SELECT e FROM Evento e WHERE e.eventoPK.servicioIdservicio = :servicioIdservicio")
    , @NamedQuery(name = "Evento.findByClientesIdclientes", query = "SELECT e FROM Evento e WHERE e.eventoPK.clientesIdclientes = :clientesIdclientes")
    , @NamedQuery(name = "Evento.findByDesevento", query = "SELECT e FROM Evento e WHERE e.desevento = :desevento")
    , @NamedQuery(name = "Evento.findByProveedorIdproveedor", query = "SELECT e FROM Evento e WHERE e.eventoPK.proveedorIdproveedor = :proveedorIdproveedor")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventoPK eventoPK;
    @Size(max = 45)
    @Column(name = "fecinievento")
    private String fecinievento;
    @Size(max = 45)
    @Column(name = "fecfinevento")
    private String fecfinevento;
    @Size(max = 45)
    @Column(name = "desevento")
    private String desevento;
    @JoinColumn(name = "clientes_idclientes", referencedColumnName = "idcliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumns({
        @JoinColumn(name = "servicio_idservicio", referencedColumnName = "idservicio", insertable = false, updatable = false)
        , @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "proveedor_idproveedor", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Servicio servicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private Collection<Experiencia> experienciaCollection;

    public Evento() {
    }

    public Evento(EventoPK eventoPK) {
        this.eventoPK = eventoPK;
    }

    public Evento(int idevento, int servicioIdservicio, int clientesIdclientes, int proveedorIdproveedor) {
        this.eventoPK = new EventoPK(idevento, servicioIdservicio, clientesIdclientes, proveedorIdproveedor);
    }

    public EventoPK getEventoPK() {
        return eventoPK;
    }

    public void setEventoPK(EventoPK eventoPK) {
        this.eventoPK = eventoPK;
    }

    public String getFecinievento() {
        return fecinievento;
    }

    public void setFecinievento(String fecinievento) {
        this.fecinievento = fecinievento;
    }

    public String getFecfinevento() {
        return fecfinevento;
    }

    public void setFecfinevento(String fecfinevento) {
        this.fecfinevento = fecfinevento;
    }

    public String getDesevento() {
        return desevento;
    }

    public void setDesevento(String desevento) {
        this.desevento = desevento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @XmlTransient
    public Collection<Experiencia> getExperienciaCollection() {
        return experienciaCollection;
    }

    public void setExperienciaCollection(Collection<Experiencia> experienciaCollection) {
        this.experienciaCollection = experienciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventoPK != null ? eventoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.eventoPK == null && other.eventoPK != null) || (this.eventoPK != null && !this.eventoPK.equals(other.eventoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdmti.Evento[ eventoPK=" + eventoPK + " ]";
    }
    
}
