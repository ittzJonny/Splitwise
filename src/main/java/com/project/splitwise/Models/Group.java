package com.project.splitwise.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@Entity
@ToString
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

    public Group()
    {
        userList = new TreeSet<>((o1,o2)-> o1.getUser().getName().compareTo(o2.getUser().getName()));
        expenseList= new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", userList=" + userList +
                ", admin=" + admin +
                ", expenseList=" + expenseList +
                '}';
    }



}
