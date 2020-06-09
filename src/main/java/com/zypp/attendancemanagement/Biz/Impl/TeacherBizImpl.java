package com.zypp.attendancemanagement.Biz.Impl;

import com.zypp.attendancemanagement.Biz.TeacherBiz;
import com.zypp.attendancemanagement.Controllers.Requests.AttendanceRequest;
import com.zypp.attendancemanagement.Controllers.Requests.TeacherRequest;
import com.zypp.attendancemanagement.Entities.Attendance;
import com.zypp.attendancemanagement.Entities.Student;
import com.zypp.attendancemanagement.Entities.Teacher;
import com.zypp.attendancemanagement.Repositories.AttendanceRepository;
import com.zypp.attendancemanagement.Repositories.StudentRepository;
import com.zypp.attendancemanagement.Repositories.TeacherRepository;
import com.zypp.attendancemanagement.Utilities.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TeacherBizImpl implements TeacherBiz {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public Teacher addTeacher(TeacherRequest teacherRequest) throws Exception {
        if(teacherRequest.getName() == null || teacherRequest.getName().isEmpty()){
            throw new Exception("Empty Name field");
        }
        if(teacherRequest.getPassword() == null || teacherRequest.getPassword().isEmpty()){
            throw new Exception("Empty Password field");
        }
        if(teacherRequest.getUsername() == null || teacherRequest.getUsername().isEmpty()){
            throw new Exception("Empty Username field");
        }

        Teacher teacher = new Teacher();

        teacher.setName(teacherRequest.getName());
        teacher.setPassword(EncryptionUtils.stringEncryption(teacherRequest.getPassword()));
        teacher.setUsername(teacherRequest.getUsername());
        teacher.setRegistrationDate(LocalDate.now());

        teacher = teacherRepository.save(teacher);

        return teacher;
    }



    @Override
    public List<Attendance> markAttendance(String teacherUsername, String teacherPassword, AttendanceRequest attendanceRequestList) throws Exception {
        Teacher teacher = validateTeacherCred(teacherUsername,teacherPassword);
        List<Attendance> attendanceList = new ArrayList<>();

        for(Map.Entry<String,String> attendanceRequest: attendanceRequestList.getRequestsListId_Status().entrySet()){
            Attendance attendance = new Attendance();
            attendance.setDate(LocalDate.now());
            attendance.setStatus(attendanceRequest.getValue());
            attendance.setStudentId(Long.valueOf(attendanceRequest.getKey()));
            attendance.setCreatedByTeacherId(teacher.getId());
            attendance.setSugarId(EncryptionUtils.stringEncryption(LocalDate.now().toString()+attendance.getStudentId()));

            attendanceList.add(attendanceRepository.save(attendance));
        }

        return attendanceList;
    }

    @Override
    public List<Student> viewAll(String username, String password) throws Exception {


        validateTeacherCred(username,password);
        Iterable<Student> studentIterable  = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();

        for (Student student:studentIterable) {
            studentList.add(student);
        }

        return studentList;
    }


    private Teacher validateTeacherCred(String username, String password) throws Exception{

        if(username == null || username.isEmpty()){
            throw new Exception("Empty Username");
        }
        Teacher teacher = teacherRepository.findByUsername(username);

        if(teacher == null){
            throw new Exception("Wrong Username or Password");
        }

        if(!teacher.getPassword().equals(EncryptionUtils.stringEncryption(password))){
            throw new Exception("Wrong Username or Password");
        }

        return teacher;
    }
}
