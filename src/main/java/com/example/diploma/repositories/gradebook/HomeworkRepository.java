package com.example.diploma.repositories.gradebook;


import com.example.diploma.model.gradebook.Assignment;
import com.example.diploma.model.gradebook.Gradebook;
import com.example.diploma.model.gradebook.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
    public Homework findByAssignment(Assignment assignment);
    public List<Homework> findAllByGradebookAndDuedateAfterAndDuedateBefore(Gradebook gradebook, Date after, Date before);
    public List<Homework> findAllByGradebook(Gradebook gradebook);
}
