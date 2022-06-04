package newpackage;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import newpackage.Employee;
import newpackage.Project;
import newpackage.WorksOnPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-09T16:14:23")
@StaticMetamodel(WorksOn.class)
public class WorksOn_ { 

    public static volatile SingularAttribute<WorksOn, BigDecimal> hours;
    public static volatile SingularAttribute<WorksOn, WorksOnPK> worksOnPK;
    public static volatile SingularAttribute<WorksOn, Project> project;
    public static volatile SingularAttribute<WorksOn, Employee> employee;

}