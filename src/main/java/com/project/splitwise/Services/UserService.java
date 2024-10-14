package com.project.splitwise.Services;

import com.project.splitwise.Models.User;
import com.project.splitwise.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
//@Transactional
public class UserService {


    @Autowired
    private UserRepo userRepo;

    public User getUserByPhone(String phone)
    {
        Optional<User> userOptional=userRepo.findByPhoneNumber(phone);
        if (userOptional.isEmpty())
        {
            throw new RuntimeException("Invalid Phone Number");
        }
        return userOptional.get();
    }

    public User getUserById(long id)
    {
        Optional<User> userOptional=userRepo.findById(id);
        if (userOptional.isEmpty())
        {
            throw new RuntimeException("No user for User ID: "+id);
        }
        return userOptional.get();
    }

    public User registerUser(String name, String phone, String password)
    {
        Optional<User> userOptional=userRepo.findByPhoneNumber(phone);
        if (userOptional.isPresent())
        {
            throw new RuntimeException("User With This Phone Number Already Exists");
        }

        User user= new User();
        user.setName(name);
        user.setPhoneNumber(phone);
        user.setPassword(password);

        userRepo.save(user);
        return user;
    }
}
