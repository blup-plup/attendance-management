package com.zypp.attendancemanagement.Biz;

import com.zypp.attendancemanagement.Controllers.Requests.StudentRequest;
import com.zypp.attendancemanagement.Entities.Attendance;
import com.zypp.attendancemanagement.Entities.Student;

import java.util.Map;

public interface StudentBiz {

    public Map<String,String> viewAll(String studentId, String password) throws Exception;
    public Attendance viewByDate(String Date, String studentId, String password) throws Exception;
    public Student addStudent(StudentRequest studentRequest) throws Exception;
}
