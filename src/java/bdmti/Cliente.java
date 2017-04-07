/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdmti;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author juanpedrogutierrezsalas
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente")
    , @NamedQuery(name = "Cliente.findByNomcliente", query = "SELECT c FROM Cliente c WHERE c.nomcliente = :nomcliente")
    , @NamedQuery(name = "Cliente.findByDircliente", query = "SELECT c FROM Cliente c WHERE c.dircliente = :dircliente")
    , @NamedQuery(name = "Cliente.findByTelcliente", query = "SELECT c FROM Cliente c WHERE c.telcliente = :telcliente")
    , @NamedQuery(name = "Cliente.findByEmacliente", query = "SELECT c FROM Cliente c WHERE c.emacliente = :emacliente")
    , @NamedQuery(name = "Cliente.findByCelcliente", query = "SELECT c FROM Cliente c WHERE c.celcliente = :celcliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcliente")
    private Integer idcliente;
    @Size(max = 45)
    @Column(name = "nomcliente")
    private String nomcliente;
    @Size(max = 45)
    @Column(name = "dircliente")
    private String dircliente;
    @Size(max = 45)
    @Column(name = "telcliente")
    private String telcliente;
    @Size(max = 45)
    @Column(name = "emacliente")
    private String emacliente;
    @Size(max = 45)
    @Column(name = "celcliente")
    private String celcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Evento> eventoCollection;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNomcliente() {
        return nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
    }

    public String getDircliente() {
        return dircliente;
    }

    public void setDircliente(String dircliente) {
        this.dircliente = dircliente;
    }

    public String getTelcliente() {
        return telcliente;
    }

    public void setTelcliente(String telcliente) {
        this.telcliente = telcliente;
    }

    public String getEmacliente() {
        return emacliente;
    }

    public void setEmacliente(String emacliente) {
        this.emacliente = emacliente;
    }

    public String getCelcliente() {
        return celcliente;
    }

    public void setCelcliente(String celcliente) {
        this.celcliente = celcliente;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdmti.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
