package builder;
import user.User;
public class Builder 
{
	private int id;
	private String username;
	private String email;
	private String hashedPassword;
	private String type;
	public Builder setId(int id)
	{
		this.id=id;
		return this;
	}
	public Builder setUserName(String userName)
	{
		this.username=userName;
		return this;
	}
	public Builder setEmail(String email)
	{
		this.email=email;
		return this;
	}
	public Builder setHashedPassword(String hashedPassword)
	{
		this.hashedPassword=hashedPassword;
		return this;
	}
	public Builder setType(String type)
	{
		this.type=type;
		return this;
	}
	public User getUser()
	{
		return new User(id,username,email,hashedPassword,type);
	}
}
