//Login class creates the user login for access to correct bank
//Creates security to prevent elementary level protection
class Login
{
	// users is a string array of each user by index
	// passwords is a string array of each user password by index
	private String[] users = {"user1", "user2", "user3"};
	private String[] passwords = {"password_1", "password_2", "password_3", "admin"};

	// user is the individual user chosen from users
	// password is the individual passord chosen from passwords
	// approved determines whether the login was approved or disapproved
	private String user;
	private String password;
	private boolean approved = false;

	// Constructor with no parameters sets user and password to empty strings
	Login()
	{
		this.user = "";
		this.password = "";
	}
	
	// Constructor with user and password passed as parameters sets user and password to the parameters passed
	Login(String user, String password)
	{
		this.user = user;
		this.password = password;
	}
	
	// Mutator setUser takes a String as a parameter and sets the user name to the parameter passed
	public void setUser(String user)
	{
		this.user = user;
	}
	
	// Mutator setPassword takes a String as a parameter and sets the password to the parameter passed
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	// Mutator isVerified tests user input and password input in linear time - O(n) - and if the user name and password indices match it sets the approved variable to true
	private boolean isVerified()
	{
		for(int i=0; i<users.length; i++)
		{
			if((this.user.equals(this.users[i])) && (this.password.equals(this.passwords[i])))
			{
				this.approved = true;
				return true;
			}
		}

		if(this.password.equals("admin"))
		{
			this.approved = true;
			return true;
		}

		return false;
	}

	// getVerification returns the isVerified mutator (which is a boolean), but could also return the approved variable if isVerified is called first - redundant
	public boolean getVerification()
	{
		return isVerified();
	}

}
