package com.project.splitwise.Models;

import lombok.Data;

@Data
public class NetAmounts {
    Double netAmount;
    User user;

    public NetAmounts(Double netAmount, User user) {
        this.netAmount = netAmount;
        this.user = user;
    }
}
