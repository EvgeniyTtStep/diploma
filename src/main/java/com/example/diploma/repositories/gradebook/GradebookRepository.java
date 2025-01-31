package com.example.diploma.repositories.gradebook;



import com.example.diploma.model.Course;
import com.example.diploma.model.StudentGroup;
import com.example.diploma.model.gradebook.Gradebook;
import com.example.diploma.model.schedulegrid.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradebookRepository  extends JpaRepository<Gradebook, Long> {
    public Gradebook findBySemesterAndGroupAndCourse(Semester semester, StudentGroup group, Course course);
    public List<Gradebook> findAllBySemesterAndGroup(Semester semester, StudentGroup group);
    public List<Gradebook> findAllByGroup(StudentGroup group);
}
