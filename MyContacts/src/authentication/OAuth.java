package authentication;

import repository.UserRepository;
import exceptions.*;
import validation.*;
public class OAuth implements Authentication{

	public boolean authenticateUser(String email,String password) throws Exception
	{
		if(UserRepository.getUserByEmail(email)==null)
		{
			throw new InvalidUserData("Invalid User Credentials");
		}
		else
		{
			if(UserRepository.getUserByEmail(email).getHashedPassword().equals(
					PasswordHashing.hashPassword(password)))
				return true;
			else
				throw new InvalidUserData("Invalid Password");
		}
	}
}
