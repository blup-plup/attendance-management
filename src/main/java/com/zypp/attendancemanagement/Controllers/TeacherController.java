package com.zypp.attendancemanagement.Controllers;

import com.zypp.attendancemanagement.Controllers.Requests.AttendanceRequest;
import com.zypp.attendancemanagement.Controllers.Requests.StudentRequest;
import com.zypp.attendancemanagement.Controllers.Requests.TeacherRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface TeacherController {

    public ResponseEntity getStudents(String username, String password);
    public ResponseEntity markAttendance(String username, String password, AttendanceRequest requestList);

}
