package com.project.splitwise.Models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class UserGroup
{
    @EmbeddedId
    UserGroupId userGroupId=new UserGroupId();

    @ManyToOne
    @MapsId("usrId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    Group group;

    @Override
    public String toString() {
        return "UserGroup{" +
                "userGroupId=" + userGroupId +
                ", user=" + user.getName() +
                ", group=" + group.getName() +
                '}';
    }
}
