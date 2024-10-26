package com.project.splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
public class User extends BaseModel{
    private String name;
    private String password;

    @Column(unique=true)
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

                '}';
    }
}
