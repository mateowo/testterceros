package co.edu.javeriana.universityapp.entity;

import co.edu.javeriana.universityapp.entity.Section;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-29T11:40:48")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Integer> credits;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, Long> id;
    public static volatile ListAttribute<Course, Section> courseSections;

}