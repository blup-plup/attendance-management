package com.zypp.attendancemanagement.Repositories;

import com.zypp.attendancemanagement.Entities.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    public Teacher findByUsername(String username);
}
