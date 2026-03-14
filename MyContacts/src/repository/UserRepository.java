package repository;
import java.util.*;
import java.util.Map.Entry;

import user.*;
public class UserRepository 
{
	static Map<String,User> byName=new HashMap<>();
	static Map<String,User> byEmail=new HashMap<>();

	public static void addUser(User u)
	{
		if(byName.containsKey(u.getUsername()))
		{
			System.out.println("Failed to add user. Already Exists");
		}
		else
		{
			byName.put(u.getUsername(), u);
			byEmail.put(u.getEmail(), u);
		}
	}
	public static User getUserByName(String name)
	{
		if(!byName.containsKey(name))
		{
			System.out.println("Invalid User Credentials");
			return null;
		}
		else
		{
			return byName.get(name);
		}
	}
	public static User getUserByEmail(String email)
	{
		if(!byEmail.containsKey(email))
		{
			System.out.println("Invalid User Credentials");
			return null;
		}
		else
		{
			return byEmail.get(email);
		}
	}
	public void printAllUsers()
	{
		for(Entry<String, User> entry : byName.entrySet())
		{
			System.out.println(entry.getKey());
		}
	}

}
