package com.project.splitwise.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@Entity
@Table(name = "grp")
public class Group extends BaseModel {


    private String name;

//    @ManyToMany(mappedBy = "groupsList", fetch = FetchType.EAGER)
//    private List<User> userList;

    @OneToMany(mappedBy = "group",fetch = FetchType.EAGER)
    private Set<UserGroup> userList;

    @ManyToOne
    private User admin;

    @OneToMany(mappedBy = "group")
    private List<Expense> expenseList;

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", userList=" + userList +
                ", admin=" + admin +
                ", expenseList=" + expenseList +
                '}';
    }

    public Group()
    {
        userList = new TreeSet<>();
        expenseList= new ArrayList<>();


    }

}
