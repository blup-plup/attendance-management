package com.zypp.attendancemanagement.Controllers.Requests;

import lombok.Data;

@Data
public class UserRequest {
    String name;
    String username;
    String password;
    String role;
}
