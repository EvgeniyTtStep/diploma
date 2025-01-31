package com.example.diploma.repositories;


import com.example.diploma.model.schedulegrid.Semester;
import com.example.diploma.model.users.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
    public List<Semester> findAllBySchoolAndStartDateBeforeAndEndDateAfter(School school, Date start_date, Date end_date);
    public List<Semester> findAllBySchoolAndEndDateAfter(School school, Date endDate);
}
