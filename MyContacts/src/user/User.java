package user;

public class User {
	private int id;
	private String username;
	private String email;
	private String hashedPassword;
	private String type;
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public String getType()
	{
		return type;
	}
	public User(int id, String username, String email, String hashedPassword,String type) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.type=type;
		this.hashedPassword = hashedPassword;
	}
	
}
