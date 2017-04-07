/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdmti;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanpedrogutierrezsalas
 */
@Entity
@Table(name = "experiencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencia.findAll", query = "SELECT e FROM Experiencia e")
    , @NamedQuery(name = "Experiencia.findByIdexperiencia", query = "SELECT e FROM Experiencia e WHERE e.experienciaPK.idexperiencia = :idexperiencia")
    , @NamedQuery(name = "Experiencia.findByFecexperiencia", query = "SELECT e FROM Experiencia e WHERE e.fecexperiencia = :fecexperiencia")
    , @NamedQuery(name = "Experiencia.findByComexperiencia", query = "SELECT e FROM Experiencia e WHERE e.comexperiencia = :comexperiencia")
    , @NamedQuery(name = "Experiencia.findByEventoIdevento", query = "SELECT e FROM Experiencia e WHERE e.experienciaPK.eventoIdevento = :eventoIdevento")
    , @NamedQuery(name = "Experiencia.findByServicioIdservicio", query = "SELECT e FROM Experiencia e WHERE e.experienciaPK.servicioIdservicio = :servicioIdservicio")
    , @NamedQuery(name = "Experiencia.findByClientesIdclientes", query = "SELECT e FROM Experiencia e WHERE e.experienciaPK.clientesIdclientes = :clientesIdclientes")
    , @NamedQuery(name = "Experiencia.findByProveedorIdproveedor", query = "SELECT e FROM Experiencia e WHERE e.experienciaPK.proveedorIdproveedor = :proveedorIdproveedor")})
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExperienciaPK experienciaPK;
    @Size(max = 45)
    @Column(name = "fecexperiencia")
    private String fecexperiencia;
    @Size(max = 45)
    @Column(name = "comexperiencia")
    private String comexperiencia;
    @JoinColumns({
        @JoinColumn(name = "evento_idevento", referencedColumnName = "idevento", insertable = false, updatable = false)
        , @JoinColumn(name = "servicio_idservicio", referencedColumnName = "servicio_idservicio", insertable = false, updatable = false)
        , @JoinColumn(name = "clientes_idclientes", referencedColumnName = "clientes_idclientes", insertable = false, updatable = false)
        , @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "proveedor_idproveedor", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Evento evento;

    public Experiencia() {
    }

    public Experiencia(ExperienciaPK experienciaPK) {
        this.experienciaPK = experienciaPK;
    }

    public Experiencia(int idexperiencia, int eventoIdevento, int servicioIdservicio, int clientesIdclientes, int proveedorIdproveedor) {
        this.experienciaPK = new ExperienciaPK(idexperiencia, eventoIdevento, servicioIdservicio, clientesIdclientes, proveedorIdproveedor);
    }

    public ExperienciaPK getExperienciaPK() {
        return experienciaPK;
    }

    public void setExperienciaPK(ExperienciaPK experienciaPK) {
        this.experienciaPK = experienciaPK;
    }

    public String getFecexperiencia() {
        return fecexperiencia;
    }

    public void setFecexperiencia(String fecexperiencia) {
        this.fecexperiencia = fecexperiencia;
    }

    public String getComexperiencia() {
        return comexperiencia;
    }

    public void setComexperiencia(String comexperiencia) {
        this.comexperiencia = comexperiencia;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (experienciaPK != null ? experienciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia) object;
        if ((this.experienciaPK == null && other.experienciaPK != null) || (this.experienciaPK != null && !this.experienciaPK.equals(other.experienciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdmti.Experiencia[ experienciaPK=" + experienciaPK + " ]";
    }
    
}
