package factory;
import user.*;
public class UserFactory
{
	public static User returnUser(User user)
	{
		if(user.getType().equalsIgnoreCase("free"))
		{
			return new FreeUser(user.getId(),user.getUsername(),user.getEmail(),user.getHashedPassword(),user.getType());
		}
		else
		{
			return new PremiumUser(user.getId(),user.getUsername(),user.getEmail(),user.getHashedPassword(),user.getType());
		}
	}
}
