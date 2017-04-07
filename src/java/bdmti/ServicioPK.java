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
public class ServicioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idservicio")
    private int idservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proveedor_idproveedor")
    private int proveedorIdproveedor;

    public ServicioPK() {
    }

    public ServicioPK(int idservicio, int proveedorIdproveedor) {
        this.idservicio = idservicio;
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
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
        hash += (int) idservicio;
        hash += (int) proveedorIdproveedor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioPK)) {
            return false;
        }
        ServicioPK other = (ServicioPK) object;
        if (this.idservicio != other.idservicio) {
            return false;
        }
        if (this.proveedorIdproveedor != other.proveedorIdproveedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdmti.ServicioPK[ idservicio=" + idservicio + ", proveedorIdproveedor=" + proveedorIdproveedor + " ]";
    }
    
}
