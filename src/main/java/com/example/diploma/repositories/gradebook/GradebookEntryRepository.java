package com.example.diploma.repositories.gradebook;

import com.example.diploma.model.gradebook.Assignment;
import com.example.diploma.model.gradebook.Gradebook;
import com.example.diploma.model.gradebook.GradebookEntry;
import com.example.diploma.model.users.Student;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface GradebookEntryRepository extends JpaRepository<GradebookEntry, Long> {
    public GradebookEntry findByAssignmentAndStudent(Assignment assignment, Student student);
    public List<GradebookEntry> findAllByGradebookAndStudent(Gradebook gradebook, Student student);
}
