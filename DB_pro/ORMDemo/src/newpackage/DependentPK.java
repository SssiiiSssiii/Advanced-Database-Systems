/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author elsis
 */
@Embeddable
public class DependentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Essn")
    private String essn;
    @Basic(optional = false)
    @Column(name = "Dependent_name")
    private String dependentname;

    public DependentPK() {
    }

    public DependentPK(String essn, String dependentname) {
        this.essn = essn;
        this.dependentname = dependentname;
    }

    public String getEssn() {
        return essn;
    }

    public void setEssn(String essn) {
        this.essn = essn;
    }

    public String getDependentname() {
        return dependentname;
    }

    public void setDependentname(String dependentname) {
        this.dependentname = dependentname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (essn != null ? essn.hashCode() : 0);
        hash += (dependentname != null ? dependentname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependentPK)) {
            return false;
        }
        DependentPK other = (DependentPK) object;
        if ((this.essn == null && other.essn != null) || (this.essn != null && !this.essn.equals(other.essn))) {
            return false;
        }
        if ((this.dependentname == null && other.dependentname != null) || (this.dependentname != null && !this.dependentname.equals(other.dependentname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.DependentPK[ essn=" + essn + ", dependentname=" + dependentname + " ]";
    }
    
}
