/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elsis
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
    , @NamedQuery(name = "Department.findByDname", query = "SELECT d FROM Department d WHERE d.dname = :dname")
    , @NamedQuery(name = "Department.findByDno", query = "SELECT d FROM Department d WHERE d.dno = :dno")
    , @NamedQuery(name = "Department.findByMgrstartdate", query = "SELECT d FROM Department d WHERE d.mgrstartdate = :mgrstartdate")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Dname")
    private String dname;
    @Id
    @Basic(optional = false)
    @Column(name = "Dno")
    private Integer dno;
    @Column(name = "Mgr_start_date")
    @Temporal(TemporalType.DATE)
    private Date mgrstartdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<DeptLocations> deptLocationsList;
    @OneToMany(mappedBy = "dno")
    private List<Project> projectList;
    @JoinColumn(name = "Mgr_ssn", referencedColumnName = "Ssn")
    @ManyToOne(optional = false)
    private Employee mgrssn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dno")
    private List<Employee> employeeList;

    public Department() {
    }

    public Department(Integer dno) {
        this.dno = dno;
    }

    public Department(Integer dno, String dname) {
        this.dno = dno;
        this.dname = dname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public Date getMgrstartdate() {
        return mgrstartdate;
    }

    public void setMgrstartdate(Date mgrstartdate) {
        this.mgrstartdate = mgrstartdate;
    }

    @XmlTransient
    public List<DeptLocations> getDeptLocationsList() {
        return deptLocationsList;
    }

    public void setDeptLocationsList(List<DeptLocations> deptLocationsList) {
        this.deptLocationsList = deptLocationsList;
    }

    @XmlTransient
    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Employee getMgrssn() {
        return mgrssn;
    }

    public void setMgrssn(Employee mgrssn) {
        this.mgrssn = mgrssn;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dno != null ? dno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.dno == null && other.dno != null) || (this.dno != null && !this.dno.equals(other.dno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Department[ dno=" + dno + " ]";
    }
    
}
