package com.zypp.attendancemanagement.Entities;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    LocalDate Date;
    Long studentId;
    Long createdByTeacherId;
    String status;
    @Column(unique = true)
    String sugarId;

    public String getSugarId() {
        return sugarId;
    }

    public void setSugarId(String sugarId) {
        this.sugarId = sugarId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getCreatedByTeacherId() {
        return createdByTeacherId;
    }

    public void setCreatedByTeacherId(Long createdByTeacherId) {
        this.createdByTeacherId = createdByTeacherId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
