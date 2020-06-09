package com.zypp.attendancemanagement.Controllers.Impl;

import com.zypp.attendancemanagement.Biz.TeacherBiz;
import com.zypp.attendancemanagement.Controllers.Requests.AttendanceRequest;
import com.zypp.attendancemanagement.Controllers.Requests.StudentRequest;
import com.zypp.attendancemanagement.Controllers.Requests.TeacherRequest;
import com.zypp.attendancemanagement.Controllers.Response.SimpleResponse;
import com.zypp.attendancemanagement.Controllers.TeacherController;
import com.zypp.attendancemanagement.Entities.Attendance;
import com.zypp.attendancemanagement.Entities.Student;
import com.zypp.attendancemanagement.Entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherControllerImpl implements TeacherController {

    @Autowired
    TeacherBiz teacherBiz;




    @Override
    @GetMapping("/student/list")
    public ResponseEntity getStudents(@RequestParam String username, @RequestParam String password) {

        List<Student> studentList = new ArrayList<>();
        try{
            studentList =  teacherBiz.viewAll(username,password);
        } catch( Exception e){
            return ResponseEntity.ok().body(new SimpleResponse(e.getMessage(),400,null));
        }

        return ResponseEntity.ok().body(new SimpleResponse("Success",200,studentList));
    }


    @Override
    @PostMapping("/markattendance")
    public ResponseEntity markAttendance(@RequestParam String teacherUsername,
                                         @RequestParam String teacherPassword,
                                         @RequestBody AttendanceRequest requestList) {
        List<Attendance> attendanceList = null;
        try{
            attendanceList = teacherBiz.markAttendance(teacherUsername,teacherPassword,requestList);
        } catch(Exception e){
            return ResponseEntity.ok().body(new SimpleResponse(e.getMessage(),400,null));
        }

        return ResponseEntity.ok().body(new SimpleResponse("Success",200,attendanceList));
    }
}
