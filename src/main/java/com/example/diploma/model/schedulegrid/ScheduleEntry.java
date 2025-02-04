package com.example.diploma.model.schedulegrid;


import com.example.diploma.model.Course;
import com.example.diploma.model.StudentGroup;
import com.example.diploma.model.users.Teacher;

import javax.persistence.*;

@Entity
@Table(name = "schedule_entry")
public class ScheduleEntry implements Comparable<ScheduleEntry> {

    @Id
    @Column(name="schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="semester_id")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name="rotation_day_id")
    private RotationDay rotationDay;

    @ManyToOne
    @JoinColumn(name="timeslot_id")
    private Timeslot timeslot;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="group_id")
    private StudentGroup group;

    public ScheduleEntry() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public RotationDay getRotationDay() {
        return rotationDay;
    }

    public void setRotationDay(RotationDay rotationDay) {
        this.rotationDay = rotationDay;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    @Override
    public int compareTo(ScheduleEntry o) {
        return this.timeslot.compareTo(o.getTimeslot());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ScheduleEntry && ((ScheduleEntry) o).getId().equals(this.id);
    }
}
