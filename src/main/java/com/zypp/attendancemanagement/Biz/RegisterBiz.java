package com.zypp.attendancemanagement.Biz;

import com.zypp.attendancemanagement.Controllers.Requests.UserRequest;

public interface RegisterBiz {

    public Object registerUser(UserRequest userRequest) throws Exception;
}
