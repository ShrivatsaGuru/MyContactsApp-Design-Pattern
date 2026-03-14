/**
 * Main class that serves as the entry point to the my contacts application.
 * 
 * @author shrivatsa Guru
 * @version 2.0
 */
package main;

import java.util.Scanner;

import services.*;
import repository.*;
import authentication.*;
import session.*;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		RegistrationService registrationService = new RegistrationService();
		UserRepository userRepository = new UserRepository();
		try {
			System.out.print("Enter User id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter UserName: ");
			String username=sc.nextLine();

			System.out.print("Enter Email: ");
			String email = sc.nextLine();

			System.out.print("Enter Password: ");
			String password = sc.nextLine();

			System.out.print("Enter User Type: ");
			String typeInput = sc.nextLine();

			RegistrationService.registerUser(id,username,email,password,typeInput);
			System.out.println("Registration Successful!");
			System.out.print("Registration details: ");

			userRepository.printAllUsers();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n====== USER LOGIN =======");
		System.out.println("Select method to login:\n1)BasicAuth\n2)OAuth");
		int choice =sc.nextInt();
		sc.nextLine();
		if(choice==1)
		{
			Authentication auth=new BasicAuth();

			try {
				System.out.print("Enter UserName: ");
				String username=sc.nextLine();
				System.out.print("Enter Password: ");
				String password = sc.nextLine();

				if(auth.authenticateUser(username, password)) {
					System.out.println("User Login Successfull");

					SessionManager session=SessionManager.getInstance();
					session.loginUser(userRepository.getUserByName(username));
				}
				else
				{
					System.out.println("User Login failed");
				}
			} catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			Authentication auth=new OAuth();

			try {
				System.out.print("Enter Email: ");
				String email=sc.nextLine();

				System.out.print("Enter Password: ");
				String password = sc.nextLine();

				if(auth.authenticateUser(email, password)) {
					System.out.println("User Login Successful");
					SessionManager session=SessionManager.getInstance();
					session.loginUser(userRepository.getUserByEmail(email));
				}
				else
				{
					System.out.println("User Login failed");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}