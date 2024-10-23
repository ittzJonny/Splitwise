package com.project.splitwise.Services;

import com.project.splitwise.Models.Group;
import com.project.splitwise.Models.User;
import com.project.splitwise.Models.UserGroup;
import com.project.splitwise.Repositories.GroupRepo;
import com.project.splitwise.Repositories.UserGroupRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
//@Transactional
public class GroupService {

//    @PersistenceContext
//    private EntityManager em;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private UserGroupRepo userGroupRepo;

//    @Autowired
//    EntityManager entityManager;

    public Group getGroupById(long id)
    {
        Optional<Group> groupsOptional = groupRepo.findById(id);
        if (groupsOptional.isEmpty())
        {
            throw new RuntimeException("Invalid group id");
        }
        return groupsOptional.get();
    }

    @Transactional
    public Group getGroupByName(String Name)
    {
        System.out.println("Getting group by name");
        Optional<Group> groupsOptional = groupRepo.findByName(Name);
        if(groupsOptional.isEmpty())
        {
            throw new RuntimeException("Invalid group name");
        }
        return groupsOptional.get();
    }

    @Transactional
    public Group createGroup(String name, String phone)
    {

        // Check if Group Already Exists
        Group gp;
        try {
            gp = this.getGroupByName(name);
            System.out.println(gp.getName()+"     ============================     ");

        }
        catch (Exception e){
            gp=new Group();
        }

        if (gp.getName() != null) {
            throw new RuntimeException("Group Already Exists");
        }

        //Get Admin user details for Group
        User user = null;
        try {
            user=userService.getUserByPhone(phone);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        //Set Details in group
        gp.setAdmin(user);
        gp.setName(name);
        gp=groupRepo.save(gp);

        // save
//        this.addMemberInGroup(gp.getName(),user.getPhoneNumber());
        try {
            UserGroup userGroup= new UserGroup();
            userGroup.setUser(user);

            userGroup.setGroup(gp);

            userGroupRepo.save(userGroup);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error occured while adding admin to Group"+e.getMessage());
        }


        return gp;
    }



    @Transactional
    public Group addMemberInGroup(String groupName, String memberPhoneNumber)
    {



        System.out.println("Adding member -------------------------------------------------");
        try {
            Group gp=this.getGroupByName(groupName);
            User u=userService.getUserByPhone(memberPhoneNumber);

            UserGroup userGroup= new UserGroup();
            userGroup.setUser(u);
            userGroup.setGroup(gp);

            gp.getUserList().size();
            u.getGroupsList().size();

            if (gp.getUserList().parallelStream().anyMatch(spu->spu.getUser().getId()==u.getId()))
            {
                throw new RuntimeException("User Already Exists");
            }

            userGroupRepo.save(userGroup);

            System.out.println("here");

//            entityManager.refresh(gp);
            return getGroupByName(groupName);
        }
        catch (PersistenceException| DataIntegrityViolationException e){
            System.out.println("HERE");
            throw new RuntimeException("Member already exists in Group: "+e.getMessage());
        }
        catch (Exception e){
            System.out.println("Here");
            throw new RuntimeException("Cannot add member in Group: "+e.getMessage());
        }



    }



}
