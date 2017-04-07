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
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByIdpersonal", query = "SELECT p FROM Personal p WHERE p.personalPK.idpersonal = :idpersonal")
    , @NamedQuery(name = "Personal.findByNompersonal", query = "SELECT p FROM Personal p WHERE p.nompersonal = :nompersonal")
    , @NamedQuery(name = "Personal.findByDirpersonal", query = "SELECT p FROM Personal p WHERE p.dirpersonal = :dirpersonal")
    , @NamedQuery(name = "Personal.findByTelpersonal", query = "SELECT p FROM Personal p WHERE p.telpersonal = :telpersonal")
    , @NamedQuery(name = "Personal.findByProveedorIdproveedor", query = "SELECT p FROM Personal p WHERE p.personalPK.proveedorIdproveedor = :proveedorIdproveedor")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonalPK personalPK;
    @Size(max = 45)
    @Column(name = "nompersonal")
    private String nompersonal;
    @Size(max = 45)
    @Column(name = "dirpersonal")
    private String dirpersonal;
    @Size(max = 45)
    @Column(name = "telpersonal")
    private String telpersonal;
    @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "idproveedor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedor proveedor;

    public Personal() {
    }

    public Personal(PersonalPK personalPK) {
        this.personalPK = personalPK;
    }

    public Personal(int idpersonal, int proveedorIdproveedor) {
        this.personalPK = new PersonalPK(idpersonal, proveedorIdproveedor);
    }

    public PersonalPK getPersonalPK() {
        return personalPK;
    }

    public void setPersonalPK(PersonalPK personalPK) {
        this.personalPK = personalPK;
    }

    public String getNompersonal() {
        return nompersonal;
    }

    public void setNompersonal(String nompersonal) {
        this.nompersonal = nompersonal;
    }

    public String getDirpersonal() {
        return dirpersonal;
    }

    public void setDirpersonal(String dirpersonal) {
        this.dirpersonal = dirpersonal;
    }

    public String getTelpersonal() {
        return telpersonal;
    }

    public void setTelpersonal(String telpersonal) {
        this.telpersonal = telpersonal;
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
        hash += (personalPK != null ? personalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.personalPK == null && other.personalPK != null) || (this.personalPK != null && !this.personalPK.equals(other.personalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdmti.Personal[ personalPK=" + personalPK + " ]";
    }
    
}
