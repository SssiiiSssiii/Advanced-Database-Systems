/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elsis
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    , @NamedQuery(name = "Project.findByPnumber", query = "SELECT p FROM Project p WHERE p.pnumber = :pnumber")
    , @NamedQuery(name = "Project.findByPname", query = "SELECT p FROM Project p WHERE p.pname = :pname")
    , @NamedQuery(name = "Project.findByPlocation", query = "SELECT p FROM Project p WHERE p.plocation = :plocation")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Pnumber")
    private Integer pnumber;
    @Basic(optional = false)
    @Column(name = "Pname")
    private String pname;
    @Basic(optional = false)
    @Column(name = "Plocation")
    private String plocation;
    @JoinColumn(name = "Dno", referencedColumnName = "Dno")
    @ManyToOne
    private Department dno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<WorksOn> worksOnList;

    public Project() {
    }

    public Project(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Project(Integer pnumber, String pname, String plocation) {
        this.pnumber = pnumber;
        this.pname = pname;
        this.plocation = plocation;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPlocation() {
        return plocation;
    }

    public void setPlocation(String plocation) {
        this.plocation = plocation;
    }

    public Department getDno() {
        return dno;
    }

    public void setDno(Department dno) {
        this.dno = dno;
    }

    @XmlTransient
    public List<WorksOn> getWorksOnList() {
        return worksOnList;
    }

    public void setWorksOnList(List<WorksOn> worksOnList) {
        this.worksOnList = worksOnList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pnumber != null ? pnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.pnumber == null && other.pnumber != null) || (this.pnumber != null && !this.pnumber.equals(other.pnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Project[ pnumber=" + pnumber + " ]";
    }
    
}
