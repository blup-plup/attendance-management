package com.zypp.attendancemanagement.Controllers.Impl;

import com.zypp.attendancemanagement.Biz.StudentBiz;
import com.zypp.attendancemanagement.Controllers.Response.SimpleResponse;
import com.zypp.attendancemanagement.Controllers.StudentController;
import com.zypp.attendancemanagement.Entities.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentControllerImpl implements StudentController {

    @Autowired
    StudentBiz studentBiz;

    @Override
    @GetMapping("/viewAll")
    public ResponseEntity viewAttendanceRecords(@RequestParam String username,
                                                @RequestParam String password) {
        Map<String, String> attendanceMap = null;
        try{
            attendanceMap = studentBiz.viewAll(username,password);
        } catch(Exception e){
            return ResponseEntity.ok().body(new SimpleResponse(e.getMessage(),400,null));
        }
        return ResponseEntity.ok().body(new SimpleResponse("Success",200,attendanceMap));
    }

    @Override
    @GetMapping("/viewByDate")
    public ResponseEntity viewAttendanceRecordsByDate(@RequestParam String date,
                                                      @RequestParam String username,
                                                      @RequestParam String password) {
        Attendance attendance = null;
        try{
           attendance = studentBiz.viewByDate(date,username,password);
        } catch(Exception e){
            return ResponseEntity.ok().body(new SimpleResponse(e.getMessage(),400,null));
        }
        return ResponseEntity.ok().body(new SimpleResponse("Success",200,attendance));

    }
}
