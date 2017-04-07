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
public class PersonalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idpersonal")
    private int idpersonal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proveedor_idproveedor")
    private int proveedorIdproveedor;

    public PersonalPK() {
    }

    public PersonalPK(int idpersonal, int proveedorIdproveedor) {
        this.idpersonal = idpersonal;
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    public int getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
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
        hash += (int) idpersonal;
        hash += (int) proveedorIdproveedor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalPK)) {
            return false;
        }
        PersonalPK other = (PersonalPK) object;
        if (this.idpersonal != other.idpersonal) {
            return false;
        }
        if (this.proveedorIdproveedor != other.proveedorIdproveedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdmti.PersonalPK[ idpersonal=" + idpersonal + ", proveedorIdproveedor=" + proveedorIdproveedor + " ]";
    }
    
}
