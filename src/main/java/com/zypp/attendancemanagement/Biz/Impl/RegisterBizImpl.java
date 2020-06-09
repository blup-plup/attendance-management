package com.zypp.attendancemanagement.Biz.Impl;

import com.zypp.attendancemanagement.Biz.RegisterBiz;
import com.zypp.attendancemanagement.Biz.StudentBiz;
import com.zypp.attendancemanagement.Biz.TeacherBiz;
import com.zypp.attendancemanagement.Controllers.Requests.StudentRequest;
import com.zypp.attendancemanagement.Controllers.Requests.TeacherRequest;
import com.zypp.attendancemanagement.Controllers.Requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterBizImpl implements RegisterBiz {

    @Autowired
    TeacherBiz teacherBiz;

    @Autowired
    StudentBiz studentBiz;


    @Override
    public Object registerUser(UserRequest userRequest) throws Exception {
        if(userRequest.getRole().equalsIgnoreCase("teacher")){
            TeacherRequest teacherRequest = new TeacherRequest();
            teacherRequest.setUsername(userRequest.getUsername());
            teacherRequest.setName(userRequest.getName());
            teacherRequest.setPassword(userRequest.getPassword());

            return teacherBiz.addTeacher(teacherRequest);

        }

        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setName(userRequest.getName());
        studentRequest.setUsername(userRequest.getUsername());
        studentRequest.setPassword(userRequest.getPassword());

        return studentBiz.addStudent(studentRequest);
    }
}
