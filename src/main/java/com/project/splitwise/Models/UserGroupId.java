package com.project.splitwise.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserGroupId implements Serializable {

    long usrId;

    long groupId;

    @Override
    public String toString() {
        return "UserGroupId{" +
                "usrId=" + usrId +
                ", groupId=" + groupId +
                '}';
    }
}
