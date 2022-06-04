package newpackage;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import newpackage.Department;
import newpackage.WorksOn;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-09T16:14:23")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile ListAttribute<Project, WorksOn> worksOnList;
    public static volatile SingularAttribute<Project, Department> dno;
    public static volatile SingularAttribute<Project, String> plocation;
    public static volatile SingularAttribute<Project, String> pname;
    public static volatile SingularAttribute<Project, Integer> pnumber;

}