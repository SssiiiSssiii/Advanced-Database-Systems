package newpackage;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import newpackage.Department;
import newpackage.Dependent;
import newpackage.Employee;
import newpackage.WorksOn;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-09T16:14:23")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> fname;
    public static volatile SingularAttribute<Employee, Date> bdate;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, Department> dno;
    public static volatile ListAttribute<Employee, Dependent> dependentList;
    public static volatile SingularAttribute<Employee, Character> sex;
    public static volatile SingularAttribute<Employee, Character> minit;
    public static volatile SingularAttribute<Employee, BigDecimal> salary;
    public static volatile ListAttribute<Employee, Department> departmentList;
    public static volatile SingularAttribute<Employee, String> ssn;
    public static volatile SingularAttribute<Employee, Employee> superssn;
    public static volatile SingularAttribute<Employee, String> lname;
    public static volatile ListAttribute<Employee, WorksOn> worksOnList;
    public static volatile ListAttribute<Employee, Employee> employeeList;

}