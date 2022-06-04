/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByFname", query = "SELECT e FROM Employee e WHERE e.fname = :fname")
    , @NamedQuery(name = "Employee.deleteJohn", query = "DELETE FROM Employee e where e.fname = 'john'")
    , @NamedQuery(name = "Employee.findByMinit", query = "SELECT e FROM Employee e WHERE e.minit = :minit")
    , @NamedQuery(name = "Employee.findByLname", query = "SELECT e FROM Employee e WHERE e.lname = :lname")
    , @NamedQuery(name = "Employee.findBySsn", query = "SELECT e FROM Employee e WHERE e.ssn = :ssn")
    , @NamedQuery(name = "Employee.findByBdate", query = "SELECT e FROM Employee e WHERE e.bdate = :bdate")
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address")
    , @NamedQuery(name = "Employee.findBySex", query = "SELECT e FROM Employee e WHERE e.sex = :sex")
    , @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary")})

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Fname")
    private String fname;
    @Column(name = "Minit")
    private Character minit;
    @Basic(optional = false)
    @Column(name = "Lname")
    private String lname;
    @Id
    @Basic(optional = false)
    @Column(name = "Ssn")
    private String ssn;
    @Column(name = "Bdate")
    @Temporal(TemporalType.DATE)
    private Date bdate;
    @Column(name = "Address")
    private String address;
    @Column(name = "Sex")
    private Character sex;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salary")
    private BigDecimal salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mgrssn")
    private List<Department> departmentList;
    @JoinColumn(name = "Dno", referencedColumnName = "Dno")
    @ManyToOne(optional = false)
    private Department dno;
    @OneToMany(mappedBy = "superssn")
    private List<Employee> employeeList;
    @JoinColumn(name = "Super_ssn", referencedColumnName = "Ssn")
    @ManyToOne
    private Employee superssn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Dependent> dependentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<WorksOn> worksOnList;

    public Employee() {
    }

    public Employee(String ssn) {
        this.ssn = ssn;
    }

    public Employee(String ssn, String fname, String lname) {
        this.ssn = ssn;
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Character getMinit() {
        return minit;
    }

    public void setMinit(Character minit) {
        this.minit = minit;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @XmlTransient
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Department getDno() {
        return dno;
    }

    public void setDno(Department dno) {
        this.dno = dno;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getSuperssn() {
        return superssn;
    }

    public void setSuperssn(Employee superssn) {
        this.superssn = superssn;
    }

    @XmlTransient
    public List<Dependent> getDependentList() {
        return dependentList;
    }

    public void setDependentList(List<Dependent> dependentList) {
        this.dependentList = dependentList;
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
        hash += (ssn != null ? ssn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Employee[ ssn=" + ssn + " ]";
    }
    
}
