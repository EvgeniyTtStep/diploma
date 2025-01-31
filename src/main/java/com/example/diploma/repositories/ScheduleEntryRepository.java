package com.example.diploma.repositories;


import com.example.diploma.model.Course;
import com.example.diploma.model.StudentGroup;
import com.example.diploma.model.schedulegrid.RotationDay;
import com.example.diploma.model.schedulegrid.ScheduleEntry;
import com.example.diploma.model.schedulegrid.Semester;
import com.example.diploma.model.schedulegrid.Timeslot;
import com.example.diploma.model.users.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleEntryRepository extends JpaRepository<ScheduleEntry, Long> {
    public List<ScheduleEntry> findAllBySemesterAndGroupAndRotationDay(Semester semester, StudentGroup group, RotationDay rotationDay);
    public List<ScheduleEntry> findAllBySemesterAndTeacherAndRotationDay(Semester semester, Teacher teacher, RotationDay rotationDay);
    public ScheduleEntry findBySemesterAndTeacherAndRotationDayAndTimeslot(Semester semester, Teacher teacher, RotationDay rotationDay, Timeslot timeslot);
    public ScheduleEntry findBySemesterAndGroupAndRotationDayAndTimeslot(Semester semester, StudentGroup group, RotationDay rotationDay, Timeslot timeslot);
    public List<ScheduleEntry> findAllBySemesterAndGroup(Semester semester, StudentGroup group);
    public List<ScheduleEntry> findAllBySemesterAndTeacher(Semester semester, Teacher teacher);
    public List<ScheduleEntry> findAllByTeacher(Teacher teacher);
    public List<ScheduleEntry> findAllByGroup(StudentGroup group);
    public List<ScheduleEntry> findAllBySemesterAndGroupAndCourse(Semester semester, StudentGroup group, Course course);
}
