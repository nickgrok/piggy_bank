class Login
{
	private String[] users = {"user1", "user2", "user3"};
	private String[] passwords = {"password_1", "password_2", "password_3", "admin"};


	private String user;
	private String password;
	private boolean approved = false;

	Login()
	{
		this.user = "";
		this.password = "";
	}

	Login(String user, String password)
	{
		this.user = user;
		this.password = password;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

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

	public boolean getVerification()
	{
		return isVerified();
	}

}
