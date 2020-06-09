package com.zypp.attendancemanagement.Controllers.Requests;


import lombok.Data;
import java.util.HashMap;

@Data
public class AttendanceRequest {

    HashMap<String,String> requestsListId_Status;

}
