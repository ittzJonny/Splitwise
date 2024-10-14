package com.project.splitwise;

import com.project.splitwise.Controller.GroupController;
import com.project.splitwise.Controller.UserController;
import com.project.splitwise.DTOs.AddMemberInGroupRequestDTO;
import com.project.splitwise.DTOs.CreateGroupRequestDTO;
import com.project.splitwise.DTOs.RegisterUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	@Autowired
	UserController userController;

	@Autowired
	GroupController groupController;

	@Override
	public void run(String... args) throws Exception {

		//Create Users
//		RegisterUserRequestDTO req= new RegisterUserRequestDTO();
//		req.setName("James");
//		req.setPassword("1234");
//		req.setPhoneNumber("1234567890");
//		System.out.println(userController.createUser(req));
//
//		RegisterUserRequestDTO req1= new RegisterUserRequestDTO();
//		req1.setName("Nat");
//		req1.setPassword("1234");
//		req1.setPhoneNumber("2234567890");
//		System.out.println(userController.createUser(req1));
//
//		RegisterUserRequestDTO req2= new RegisterUserRequestDTO();
//		req2.setName("Steve");
//		req2.setPassword("1234");
//		req2.setPhoneNumber("3234567890");
//		System.out.println(userController.createUser(req2));
//
//		// Create group
//		CreateGroupRequestDTO req3= new CreateGroupRequestDTO();
//		req3.setGroupName("Trip Expense");
//		req3.setPhoneNumber("3234567890");
//		System.out.println(groupController.createGroup(req3));
//
////		System.out.println(groupController.getGroupByName("Trip Expense"));
//
////		Add Users in the group
//		AddMemberInGroupRequestDTO req4=new AddMemberInGroupRequestDTO();
//		req4.setGroupName("Trip Expense");
//		req4.setMemberPhoneNumber("2234567890");
//		System.out.println(groupController.addMember(req4));
//		System.out.println(groupController.getGroupByName("Trip Expense"));

		System.out.println(userController.getUserByPhoneNumber("2234567890"));


	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

}
