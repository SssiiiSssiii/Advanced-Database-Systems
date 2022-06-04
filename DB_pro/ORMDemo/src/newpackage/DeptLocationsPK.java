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
public class DeptLocationsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Dno")
    private int dno;
    @Basic(optional = false)
    @Column(name = "Dlocation")
    private String dlocation;

    public DeptLocationsPK() {
    }

    public DeptLocationsPK(int dno, String dlocation) {
        this.dno = dno;
        this.dlocation = dlocation;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public String getDlocation() {
        return dlocation;
    }

    public void setDlocation(String dlocation) {
        this.dlocation = dlocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dno;
        hash += (dlocation != null ? dlocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptLocationsPK)) {
            return false;
        }
        DeptLocationsPK other = (DeptLocationsPK) object;
        if (this.dno != other.dno) {
            return false;
        }
        if ((this.dlocation == null && other.dlocation != null) || (this.dlocation != null && !this.dlocation.equals(other.dlocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.DeptLocationsPK[ dno=" + dno + ", dlocation=" + dlocation + " ]";
    }
    
}
