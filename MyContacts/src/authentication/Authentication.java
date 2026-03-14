package authentication;

public interface Authentication 
{
	public boolean authenticateUser(String username,String password)throws Exception;
}
