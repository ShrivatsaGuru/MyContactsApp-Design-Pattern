package authentication;

import repository.UserRepository;
import exceptions.*;
import validation.*;
public class BasicAuth implements Authentication{

	public boolean authenticateUser(String name,String password) throws Exception
	{
		if(UserRepository.getUserByName(name)==null)
		{
			throw new InvalidUserData("Invalid User Credentials");
		}
		else
		{
			if(UserRepository.getUserByName(name).getHashedPassword().equals(
					PasswordHashing.hashPassword(password)))
				return true;
			else
				throw new InvalidUserData("Invalid Password");
		}
	}
}
