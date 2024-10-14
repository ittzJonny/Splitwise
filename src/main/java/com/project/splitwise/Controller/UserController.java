package com.project.splitwise.Controller;

import com.project.splitwise.DTOs.*;
import com.project.splitwise.Models.User;
import com.project.splitwise.Models.UserGroup;
import com.project.splitwise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseFormat createUser(RegisterUserRequestDTO req) {
        ResponseFormat res=null;

        try {
            User user=userService.registerUser(req.getName(), req.getPhoneNumber(), req.getPassword());
            RegisterUserResponseDTO resp = new RegisterUserResponseDTO();
            resp.setUserId(user.getId());
            resp.setName(user.getName());
            resp.setPhoneNumber(user.getPhoneNumber());
            resp.setResponseStatus(ResponseStatus.SUCCESS);
            resp.setResponseMessage("User created successfully");
            res=resp;
        }
        catch (Exception e)
        {
            FailureResponse resp=new FailureResponse();
            resp.setResponseStatus(ResponseStatus.FAIL);
            resp.setMessage("User Creation Failed: "+e.getMessage());
            res=resp;
        }
        return res;
    }

    public ResponseFormat getUserByPhoneNumber(String phoneNumber) {
        try {
            User u=userService.getUserByPhone(phoneNumber);
            UserResponseDTO res=new UserResponseDTO();
            res.setPhoneNumber(u.getPhoneNumber());
            res.setName(u.getName());
            List<String> groups=new ArrayList<>();
            for (UserGroup ug:u.getGroupsList())
            {
                groups.add(ug.getGroup().getName());
            }
            res.setGroupList(groups);
            res.setResponseStatus(ResponseStatus.SUCCESS);
            res.setResponseMessage("User Retrieved Successfully");
            return res;
        }
        catch (Exception e) {
            FailureResponse resp=new FailureResponse();
            resp.setResponseStatus(ResponseStatus.FAIL);
            resp.setMessage("User Retrieve Failed: "+e.getMessage());
        }

        return null;
    }

}
