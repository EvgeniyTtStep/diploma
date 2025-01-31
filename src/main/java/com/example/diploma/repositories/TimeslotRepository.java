package com.example.diploma.repositories;



import com.example.diploma.model.schedulegrid.Semester;
import com.example.diploma.model.schedulegrid.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeslotRepository extends JpaRepository<Timeslot, Long> {
    List<Timeslot> findAllBySemester(Semester semester);
}
