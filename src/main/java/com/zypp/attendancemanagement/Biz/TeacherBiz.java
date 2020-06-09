package com.zypp.attendancemanagement.Biz;

import com.zypp.attendancemanagement.Controllers.Requests.AttendanceRequest;
import com.zypp.attendancemanagement.Controllers.Requests.TeacherRequest;
import com.zypp.attendancemanagement.Entities.Attendance;
import com.zypp.attendancemanagement.Entities.Student;
import com.zypp.attendancemanagement.Entities.Teacher;

import java.util.List;


public interface TeacherBiz {

    public Teacher addTeacher(TeacherRequest teacherRequest) throws Exception;
    public List<Attendance> markAttendance(String username, String password, AttendanceRequest attendanceRequestList) throws Exception;
    public List<Student> viewAll(String username, String password) throws Exception;
}
