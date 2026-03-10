package services;

import repository.*;
import validation.*;
import factory.*;
import builder.*;
import user.*;
public class RegistrationService 
{
	public static void registerUser(int id,String name,String email,String password,String type) throws InterruptedException
	{

        System.out.println("Registering User ...");

		Builder build =new Builder();
		String hashed=PasswordHashing.hashPassword(password);
		User user=UserFactory.returnUser(build.setUserName(name).setHashedPassword(hashed).setEmail(email).setId(id).setType(type).getUser());
		UserRepository.addUser(user);
	}
}
