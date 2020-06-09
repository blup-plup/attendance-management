package com.zypp.attendancemanagement.Biz.Impl;

import com.zypp.attendancemanagement.Biz.StudentBiz;
import com.zypp.attendancemanagement.Controllers.Requests.StudentRequest;
import com.zypp.attendancemanagement.Entities.Attendance;
import com.zypp.attendancemanagement.Entities.Student;
import com.zypp.attendancemanagement.Repositories.AttendanceRepository;
import com.zypp.attendancemanagement.Repositories.StudentRepository;
import com.zypp.attendancemanagement.Utilities.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentBizImpl implements StudentBiz {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public Map<String, String> viewAll(String username, String password) throws Exception {
        Student student = validateStudent(username,password);

        List<Attendance> attendanceList = attendanceRepository.findByStudentId(student.getId());
        Map<String,String> attendanceMap = new HashMap<>();

        for(Attendance attendance: attendanceList){
            attendanceMap.put(attendance.getDate().toString(),attendance.getStatus());
        }

        return attendanceMap;
    }


    @Override
    public Attendance viewByDate(String date, String username, String password) throws Exception {
        Student student = validateStudent(username,password);
        String sugarId = EncryptionUtils.stringEncryption(date+username);
        Attendance attendance = attendanceRepository.findBySugarId(sugarId);

        return attendance;
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) throws Exception {

        if(studentRequest.getName()== null || studentRequest.getName().isEmpty())
        {
            throw new Exception("Empty Name field");
        }

        Student student = new Student();

        student.setName(studentRequest.getName());
        student.setPassword(EncryptionUtils.stringEncryption(studentRequest.getPassword()));
        student.setUsername(studentRequest.getUsername());
        student.setRegistrationDate(LocalDate.now());
        return studentRepository.save(student);

    }

    private Student validateStudent(String username, String password) throws Exception {
        if(username == null || username.isEmpty()){
            throw new Exception("Invalid username");
        }

        Student student = studentRepository.findByUsername(username);

        if(!student.getPassword().equals(EncryptionUtils.stringEncryption(password))){
            throw new Exception("Invalid Password");
        }

        return student;
    }
}
