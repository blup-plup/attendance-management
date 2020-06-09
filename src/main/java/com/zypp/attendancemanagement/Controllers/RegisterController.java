package com.zypp.attendancemanagement.Controllers;

import com.zypp.attendancemanagement.Controllers.Requests.UserRequest;
import org.springframework.http.ResponseEntity;

public interface RegisterController {

    public ResponseEntity register(UserRequest userRequest);
}
