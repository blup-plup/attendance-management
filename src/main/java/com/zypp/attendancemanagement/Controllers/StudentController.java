package com.zypp.attendancemanagement.Controllers;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface StudentController {

    public ResponseEntity viewAttendanceRecords(String username,String password);
    public ResponseEntity viewAttendanceRecordsByDate(String Date, String username, String password);
}
