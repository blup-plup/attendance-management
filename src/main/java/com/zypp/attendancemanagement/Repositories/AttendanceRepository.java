package com.zypp.attendancemanagement.Repositories;

import com.zypp.attendancemanagement.Entities.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttendanceRepository extends CrudRepository<Attendance,Long> {

    public List<Attendance> findByStudentId(Long StudentId);
    public Attendance findBySugarId(String sugarId);
}
