package co.edu.javeriana.universityapp.entity;

import co.edu.javeriana.universityapp.entity.Course;
import co.edu.javeriana.universityapp.entity.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-29T11:40:48")
@StaticMetamodel(Section.class)
public class Section_ { 

    public static volatile SingularAttribute<Section, Course> course;
    public static volatile ListAttribute<Section, Student> students;
    public static volatile SingularAttribute<Section, String> semester;
    public static volatile SingularAttribute<Section, Long> id;

}