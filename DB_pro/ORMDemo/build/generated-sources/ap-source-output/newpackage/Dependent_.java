package newpackage;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import newpackage.DependentPK;
import newpackage.Employee;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-09T16:14:23")
@StaticMetamodel(Dependent.class)
public class Dependent_ { 

    public static volatile SingularAttribute<Dependent, DependentPK> dependentPK;
    public static volatile SingularAttribute<Dependent, Date> bdate;
    public static volatile SingularAttribute<Dependent, Character> sex;
    public static volatile SingularAttribute<Dependent, String> relationship;
    public static volatile SingularAttribute<Dependent, Employee> employee;

}