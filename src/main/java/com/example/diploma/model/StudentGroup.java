package com.example.diploma.model;



import com.example.diploma.model.users.School;
import com.example.diploma.model.users.Student;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "student_group")
public class StudentGroup {

    @Id
    @Column(name="group_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="school_id")
    private School school;

    @ManyToMany(mappedBy = "groups")
    private Collection<Student> students;

    public StudentGroup() {
        super();
    }

    public StudentGroup(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof StudentGroup) && this.id.equals(((StudentGroup) o).getId());
    }
}
