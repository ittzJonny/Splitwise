package com.project.splitwise.Controller;

import com.project.splitwise.DTOs.*;
import com.project.splitwise.Services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {

    @Autowired
    SettleUpService settleUpService;

    public ResponseFormat settleUpGroup(SettleUpRequestDTO req) {

        ResponseFormat resp=null;
        try {
            SettleUpResponseDTO res= new SettleUpResponseDTO();
            res.setTransactionList(settleUpService.settleUpGroup(req.getGroupId()));
            res.setResponseStatus(ResponseStatus.SUCCESS);
            resp=res;
        }
        catch(Exception e) {
            FailureResponse res= new FailureResponse();
            res.setResponseStatus(ResponseStatus.FAIL);
            res.setMessage(e.getMessage());
            resp=res;
        }

        return resp;

    }

}
