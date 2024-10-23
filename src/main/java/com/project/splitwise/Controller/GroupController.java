package com.project.splitwise.Controller;

import com.project.splitwise.DTOs.*;
import com.project.splitwise.Models.Group;
import com.project.splitwise.Models.UserGroup;
import com.project.splitwise.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    @Autowired
    GroupService groupService;

    public ResponseFormat addMember(AddMemberInGroupRequestDTO req)
    {
        ResponseFormat resp;
        try {
            Group group=groupService.addMemberInGroup(req.getGroupName(),req.getMemberPhoneNumber());
            AddMemberInGroupResponseDTO res=new AddMemberInGroupResponseDTO();
//            System.out.println(group);
            res.setMessage("User Added Successfully");
            res.setResponseStatus(ResponseStatus.SUCCESS);
            resp=res;
        }
        catch(Exception e)
        {
            FailureResponse res=new FailureResponse();
//            e.printStackTrace();
            res.setMessage("Error while adding member: "+e.getMessage());
            res.setResponseStatus(ResponseStatus.FAIL);
            resp=res;
        }
        return  resp;
    }

    public ResponseFormat createGroup(CreateGroupRequestDTO req) {
        ResponseFormat result ;
        try {
            Group group = groupService.createGroup(req.getGroupName(), req.getPhoneNumber());
            group=groupService.getGroupById(group.getId());
            GroupResponseDTO res= new GroupResponseDTO();
//            res= new CreateGroupResponseDTO();
            res.setGroupId(group.getId());
            res.setGroupName(group.getName());
            res.setGroupAdmin(group.getAdmin().getName());
            res.setGroupAdminPhoneNumber(group.getAdmin().getPhoneNumber());
            res.setResponseStatus(ResponseStatus.SUCCESS);
            res.setResponseMessage("Group created successfully");
            for (UserGroup u:group.getUserList())
            {
                res.getMemberList().add(u.getUser().getName());
                res.getMemberPhoneList().add(u.getUser().getPhoneNumber());
            }
            result=res;
        }
        catch (Exception e) {
//            e.printStackTrace();
            FailureResponse res = new FailureResponse();
            res.setResponseStatus(ResponseStatus.FAIL);
            res.setMessage("Group Creation Failed: "+e.getMessage());
            result=res;
        }

        return result;
    }


    public ResponseFormat getGroupByName(String groupName) {
        ResponseFormat result =null;
        try {
            Group group = groupService.getGroupByName(groupName);

            GroupResponseDTO res= new GroupResponseDTO();
            res.setGroupId(group.getId());
            res.setGroupName(group.getName());
            res.setGroupAdmin(group.getAdmin().getName());
            res.setGroupAdminPhoneNumber(group.getAdmin().getPhoneNumber());
            for (UserGroup u:group.getUserList())
            {
                res.getMemberList().add(u.getUser().getName());
                res.getMemberPhoneList().add(u.getUser().getPhoneNumber());
            }
            res.setResponseStatus(ResponseStatus.SUCCESS);
            res.setResponseMessage("Group getByName successfully");

            result=res;
        }
        catch (Exception e) {
            FailureResponse res = new FailureResponse();
            res.setResponseStatus(ResponseStatus.FAIL);
            res.setMessage("Group GetByName Failed"+e.getMessage());
            result=res;
        }

        return result;
    }



}
