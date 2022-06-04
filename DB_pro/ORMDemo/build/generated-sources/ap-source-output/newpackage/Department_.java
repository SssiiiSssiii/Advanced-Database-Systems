package newpackage;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import newpackage.DeptLocations;
import newpackage.Employee;
import newpackage.Project;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-09T16:14:23")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, Date> mgrstartdate;
    public static volatile ListAttribute<Department, Project> projectList;
    public static volatile ListAttribute<Department, DeptLocations> deptLocationsList;
    public static volatile SingularAttribute<Department, Integer> dno;
    public static volatile ListAttribute<Department, Employee> employeeList;
    public static volatile SingularAttribute<Department, Employee> mgrssn;
    public static volatile SingularAttribute<Department, String> dname;

}