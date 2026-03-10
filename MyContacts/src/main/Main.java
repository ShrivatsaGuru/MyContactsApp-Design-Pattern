package main;

import java.util.Scanner;

import services.*;
import repository.*;
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
    }
}