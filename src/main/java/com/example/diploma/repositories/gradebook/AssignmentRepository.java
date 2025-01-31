package com.example.diploma.repositories.gradebook;

import com.example.diploma.model.gradebook.Assignment;
import com.example.diploma.model.gradebook.Gradebook;
import com.example.diploma.model.schedulegrid.CalendarDay;
import com.example.diploma.model.schedulegrid.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    public Assignment findByGradebookAndAndDayAndTimeslot(Gradebook gradebook, CalendarDay day, Timeslot timeslot);
    public List<Assignment> findAllByGradebookAndIsHomework(Gradebook gradebook, boolean isHomework);
}
