package com.zypp.attendancemanagement.Controllers.Requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRequest {
    String name;
    String username;
    String password;
}
