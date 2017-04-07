/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdmti;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author juanpedrogutierrezsalas
 */
@Embeddable
public class ExperienciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idexperiencia")
    private int idexperiencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evento_idevento")
    private int eventoIdevento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "servicio_idservicio")
    private int servicioIdservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientes_idclientes")
    private int clientesIdclientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proveedor_idproveedor")
    private int proveedorIdproveedor;

    public ExperienciaPK() {
    }

    public ExperienciaPK(int idexperiencia, int eventoIdevento, int servicioIdservicio, int clientesIdclientes, int proveedorIdproveedor) {
        this.idexperiencia = idexperiencia;
        this.eventoIdevento = eventoIdevento;
        this.servicioIdservicio = servicioIdservicio;
        this.clientesIdclientes = clientesIdclientes;
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    public int getIdexperiencia() {
        return idexperiencia;
    }

    public void setIdexperiencia(int idexperiencia) {
        this.idexperiencia = idexperiencia;
    }

    public int getEventoIdevento() {
        return eventoIdevento;
    }

    public void setEventoIdevento(int eventoIdevento) {
        this.eventoIdevento = eventoIdevento;
    }

    public int getServicioIdservicio() {
        return servicioIdservicio;
    }

    public void setServicioIdservicio(int servicioIdservicio) {
        this.servicioIdservicio = servicioIdservicio;
    }

    public int getClientesIdclientes() {
        return clientesIdclientes;
    }

    public void setClientesIdclientes(int clientesIdclientes) {
        this.clientesIdclientes = clientesIdclientes;
    }

    public int getProveedorIdproveedor() {
        return proveedorIdproveedor;
    }

    public void setProveedorIdproveedor(int proveedorIdproveedor) {
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idexperiencia;
        hash += (int) eventoIdevento;
        hash += (int) servicioIdservicio;
        hash += (int) clientesIdclientes;
        hash += (int) proveedorIdproveedor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaPK)) {
            return false;
        }
        ExperienciaPK other = (ExperienciaPK) object;
        if (this.idexperiencia != other.idexperiencia) {
            return false;
        }
        if (this.eventoIdevento != other.eventoIdevento) {
            return false;
        }
        if (this.servicioIdservicio != other.servicioIdservicio) {
            return false;
        }
        if (this.clientesIdclientes != other.clientesIdclientes) {
            return false;
        }
        if (this.proveedorIdproveedor != other.proveedorIdproveedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdmti.ExperienciaPK[ idexperiencia=" + idexperiencia + ", eventoIdevento=" + eventoIdevento + ", servicioIdservicio=" + servicioIdservicio + ", clientesIdclientes=" + clientesIdclientes + ", proveedorIdproveedor=" + proveedorIdproveedor + " ]";
    }
    
}
