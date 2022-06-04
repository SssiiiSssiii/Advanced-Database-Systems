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
public class WorksOnPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Essn")
    private String essn;
    @Basic(optional = false)
    @Column(name = "Pnumber")
    private int pnumber;

    public WorksOnPK() {
    }

    public WorksOnPK(String essn, int pnumber) {
        this.essn = essn;
        this.pnumber = pnumber;
    }

    public String getEssn() {
        return essn;
    }

    public void setEssn(String essn) {
        this.essn = essn;
    }

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (essn != null ? essn.hashCode() : 0);
        hash += (int) pnumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorksOnPK)) {
            return false;
        }
        WorksOnPK other = (WorksOnPK) object;
        if ((this.essn == null && other.essn != null) || (this.essn != null && !this.essn.equals(other.essn))) {
            return false;
        }
        if (this.pnumber != other.pnumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.WorksOnPK[ essn=" + essn + ", pnumber=" + pnumber + " ]";
    }
    
}
