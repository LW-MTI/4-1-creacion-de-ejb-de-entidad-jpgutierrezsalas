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
public class EventoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idevento")
    private int idevento;
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

    public EventoPK() {
    }

    public EventoPK(int idevento, int servicioIdservicio, int clientesIdclientes, int proveedorIdproveedor) {
        this.idevento = idevento;
        this.servicioIdservicio = servicioIdservicio;
        this.clientesIdclientes = clientesIdclientes;
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    public int getIdevento() {
        return idevento;
    }

    public void setIdevento(int idevento) {
        this.idevento = idevento;
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
        hash += (int) idevento;
        hash += (int) servicioIdservicio;
        hash += (int) clientesIdclientes;
        hash += (int) proveedorIdproveedor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoPK)) {
            return false;
        }
        EventoPK other = (EventoPK) object;
        if (this.idevento != other.idevento) {
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
        return "bdmti.EventoPK[ idevento=" + idevento + ", servicioIdservicio=" + servicioIdservicio + ", clientesIdclientes=" + clientesIdclientes + ", proveedorIdproveedor=" + proveedorIdproveedor + " ]";
    }
    
}
