package com.example.diploma.repositories;



import com.example.diploma.model.schedulegrid.CalendarDay;
import com.example.diploma.model.schedulegrid.RotationDay;
import com.example.diploma.model.schedulegrid.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface CalendarDayRepository extends JpaRepository<CalendarDay, Long> {
    public List<CalendarDay> findAllBySemester(Semester semester);
    public List<CalendarDay> findAllBySemesterAndRotationday(Semester semester, RotationDay rotationDay);
    public CalendarDay findBySemesterAndDate(Semester semester, Date date);
}
