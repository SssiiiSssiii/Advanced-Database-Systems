/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elsis
 */
@Entity
@Table(name = "dependent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependent.findAll", query = "SELECT d FROM Dependent d")
    , @NamedQuery(name = "Dependent.findByEssn", query = "SELECT d FROM Dependent d WHERE d.dependentPK.essn = :essn")
    , @NamedQuery(name = "Dependent.findByDependentname", query = "SELECT d FROM Dependent d WHERE d.dependentPK.dependentname = :dependentname")
    , @NamedQuery(name = "Dependent.findBySex", query = "SELECT d FROM Dependent d WHERE d.sex = :sex")
    , @NamedQuery(name = "Dependent.findByBdate", query = "SELECT d FROM Dependent d WHERE d.bdate = :bdate")
    , @NamedQuery(name = "Dependent.findByRelationship", query = "SELECT d FROM Dependent d WHERE d.relationship = :relationship")})
public class Dependent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DependentPK dependentPK;
    @Column(name = "Sex")
    private Character sex;
    @Column(name = "Bdate")
    @Temporal(TemporalType.DATE)
    private Date bdate;
    @Column(name = "Relationship")
    private String relationship;
    @JoinColumn(name = "Essn", referencedColumnName = "Ssn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public Dependent() {
    }

    public Dependent(DependentPK dependentPK) {
        this.dependentPK = dependentPK;
    }

    public Dependent(String essn, String dependentname) {
        this.dependentPK = new DependentPK(essn, dependentname);
    }

    public DependentPK getDependentPK() {
        return dependentPK;
    }

    public void setDependentPK(DependentPK dependentPK) {
        this.dependentPK = dependentPK;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dependentPK != null ? dependentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependent)) {
            return false;
        }
        Dependent other = (Dependent) object;
        if ((this.dependentPK == null && other.dependentPK != null) || (this.dependentPK != null && !this.dependentPK.equals(other.dependentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Dependent[ dependentPK=" + dependentPK + " ]";
    }
    
}
