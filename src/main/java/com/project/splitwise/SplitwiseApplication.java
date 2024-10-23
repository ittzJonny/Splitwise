package com.project.splitwise;

import com.project.splitwise.Controller.GroupController;
import com.project.splitwise.Controller.UserController;
import com.project.splitwise.DTOs.AddMemberInGroupRequestDTO;
import com.project.splitwise.DTOs.CreateGroupRequestDTO;
import com.project.splitwise.DTOs.RegisterUserRequestDTO;
import com.project.splitwise.Models.Expense;
import com.project.splitwise.Models.UserExpenseType;
import com.project.splitwise.Services.ExpenseService;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	@Autowired
	UserController userController;

	@Autowired
	GroupController groupController;

	@Autowired
	ExpenseService es;


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

//		System.out.println(userController.getUserByPhoneNumber("2234567890"));


//		System.out.println(userController.createUser(new RegisterUserRequestDTO( "user T1", "7082232323", "password1" ))
//		);
//		System.out.println(userController.createUser(new RegisterUserRequestDTO( "user T2", "7082232334", "password1" )));
//
//
//		CreateGroupRequestDTO cr1= new CreateGroupRequestDTO();
//		cr1.setPhoneNumber("7082232334");
//		cr1.setGroupName("HeHeGroup1");
////
//		System.out.println("Creating Group Main =================================================");
//		System.out.println( groupController.createGroup(cr1));
////
//		System.out.println("Adding Member Main =================================================");
//		AddMemberInGroupRequestDTO amg1= new AddMemberInGroupRequestDTO();
//		amg1.setMemberPhoneNumber("7082232323");
//		amg1.setGroupName("HeHeGroup1");
//
//		System.out.println( groupController.addMember(amg1));

//		System.out.println("Creating new User =================================================");
//		System.out.println(userController.createUser(new RegisterUserRequestDTO( "user T3", "12352467859", "password1" )));
//
//		System.out.println("Adding Member Main =================================================");
//		AddMemberInGroupRequestDTO amg1= new AddMemberInGroupRequestDTO();
//		amg1.setMemberPhoneNumber("12352467859");
//		amg1.setGroupName("HeHeGroup1");
//
//		System.out.println( groupController.addMember(amg1));
//
//
//		System.out.println(groupController.getGroupByName("HeHeGroup1"));



//		createUsers();
//		createGroup();
//		addingMembersInGroup();
		createExpense();



	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}


	private void createUsers()
	{
		//Create Users

		//Creating user 1==============================================================================
		RegisterUserRequestDTO req1= new RegisterUserRequestDTO();
		req1.setName("User 1");
		req1.setPassword("1234");
		req1.setPhoneNumber("1234567890");
		System.out.println(userController.createUser(req1));

		//Creating user 2==============================================================================
		RegisterUserRequestDTO req2= new RegisterUserRequestDTO();
		req2.setName("User 2");
		req2.setPassword("1234");
		req2.setPhoneNumber("1234567880");
		System.out.println(userController.createUser(req2));


		//Creating user 3==============================================================================
		RegisterUserRequestDTO req3= new RegisterUserRequestDTO();
		req3.setName("User 3");
		req3.setPassword("1234");
		req3.setPhoneNumber("1234567870");
		System.out.println(userController.createUser(req3));


		//Creating user 4==============================================================================
		RegisterUserRequestDTO req4= new RegisterUserRequestDTO();
		req4.setName("User 4");
		req4.setPassword("1234");
		req4.setPhoneNumber("1234567860");
		System.out.println(userController.createUser(req4));


	}


	private void createGroup(){


		//Create Group1 with admin User3
		CreateGroupRequestDTO req1= new CreateGroupRequestDTO();
		req1.setGroupName("Group 1");
		req1.setPhoneNumber("1234567870");

		System.out.println(groupController.createGroup(req1));

	}

	private void addingMembersInGroup()
	{

		//Adding User1 in group1
		AddMemberInGroupRequestDTO req1= new AddMemberInGroupRequestDTO();
		req1.setMemberPhoneNumber("1234567890");
		req1.setGroupName("Group 1");
		System.out.println(groupController.addMember(req1));

		//Adding User2 in group1
		AddMemberInGroupRequestDTO req2= new AddMemberInGroupRequestDTO();
		req2.setMemberPhoneNumber("1234567880");
		req2.setGroupName("Group 1");
		System.out.println(groupController.addMember(req2));


		//Adding User4 in group1
		AddMemberInGroupRequestDTO req4= new AddMemberInGroupRequestDTO();
		req4.setMemberPhoneNumber("1234567860");
		req4.setGroupName("Group 1");
		System.out.println(groupController.addMember(req4));
	}


	private void createExpense()
	{
		List<Integer> userExpenseAmounts= new ArrayList<>(List.of(500,500,
				250,250,250,250));
		List<UserExpenseType> userExpenseTypes=new ArrayList<>(List.of(UserExpenseType.PAID_BY,UserExpenseType.PAID_BY,
				UserExpenseType.PAID_FOR,UserExpenseType.PAID_FOR,UserExpenseType.PAID_FOR,UserExpenseType.PAID_FOR));
		List<String> userPhones= new ArrayList<>(List.of("1234567890","1234567880",
				"1234567890","1234567880","1234567870","1234567860"));

		String expensCreatedByUser_phone="1234567880";
		String desc=" Bam Bam Bhole !!";
		String groupName="Group 1";

		Expense expense=es.addExpense(expensCreatedByUser_phone,groupName,desc,userExpenseAmounts,userPhones,userExpenseTypes);
//		System.out.println(expense);
	}



}
