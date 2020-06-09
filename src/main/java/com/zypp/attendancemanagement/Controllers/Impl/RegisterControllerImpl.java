package com.zypp.attendancemanagement.Controllers.Impl;


import com.zypp.attendancemanagement.Biz.RegisterBiz;
import com.zypp.attendancemanagement.Controllers.Requests.UserRequest;
import com.zypp.attendancemanagement.Controllers.RegisterController;
import com.zypp.attendancemanagement.Controllers.Response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class RegisterControllerImpl implements RegisterController {

    @Autowired
    RegisterBiz registerBiz;

    @Override
    @PostMapping("/add")
    public ResponseEntity register(@RequestBody UserRequest userRequest) {
        Object user = null;
        try{
            user = registerBiz.registerUser(userRequest);
        } catch (Exception e){
            return ResponseEntity.ok().body(new SimpleResponse(e.getMessage(),400,null));
        }
        return ResponseEntity.ok().body(new SimpleResponse("Success",200,user));
    }
}
