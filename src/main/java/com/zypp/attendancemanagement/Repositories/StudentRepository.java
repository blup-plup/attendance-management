package com.zypp.attendancemanagement.Repositories;

import com.zypp.attendancemanagement.Entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    public Student findByUsername(String username);

}
