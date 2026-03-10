package repository;
import java.util.*;
import java.util.Map.Entry;

import user.*;
public class UserRepository 
{
	static Map<String,User> byName=new HashMap<>();
	static Map<Integer,User> byId=new HashMap<>();

	public static void addUser(User u)
	{
		if(byName.containsKey(u.getUsername()))
		{
			System.out.println("Failed to add user. Already Exists");
		}
		else
		{
			byName.put(u.getUsername(), u);
			byId.put(u.getId(), u);
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
	public static User getUserByID(int id)
	{
		if(!byId.containsKey(id))
		{
			System.out.println("Invalid User Credentials");
			return null;
		}
		else
		{
			return byId.get(id);
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
