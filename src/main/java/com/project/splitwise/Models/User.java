package com.project.splitwise.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String password;
    private String phoneNumber;

//    @ManyToMany
//    private List<Groups> groupsList;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    Set<UserGroup> groupsList;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", groupsList=" + groupsList +
                '}';
    }
}
