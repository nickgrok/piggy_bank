import java.util.*;
import java.io.*;

class Account
{
	private String name;
	private String password;
	private double balance;
	private int number;

	Account()
	{
		this.name = "";
		this.balance = 0.0;
		this.number = 0;
	}

	Account(String n, String pw)
	{
		String line = "";
		this.name = n;
		this.password = pw;
		File f = new File("dat/" + n + ".dat");

		try
		{
			Scanner file = new Scanner(f);

			while(file.hasNextDouble())
			{
				//line = file.nextLine();
				this.balance = file.nextDouble();
			}

		}
		catch(IOException e)
		{
			System.out.println("Error accessing " + n);
			System.exit(1);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Invalid input line: " + line);
			System.exit(1);
		}
	
	}

	public void withdraw(double d)
	{
		if(this.balance - d >= 0.0)
		{
			this.balance -= d;
		}
	}

	public void deposit(double d)
	{
		if(this.balance + d >= 0.0)
		{
			this.balance += d;
		}
	}

	public void writeBalance()
	{
		File f = new File(this.name + ".dat");	
		StringBuilder out = new StringBuilder();
		String d;

		try
		{
			Scanner file = new Scanner(f);

			while(file.hasNext())
			{
				d = file.next();
				out.append(d);
				out.append("\n");
			}

			out.append(Double.toString(this.balance));
		}
		catch(IOException e)
		{
			System.out.println("Error accessing " + this.name);
			System.exit(1);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Invalid input line.");
			System.exit(1);
		}

		try
		{
			String output = out.toString();
			PrintWriter write = new PrintWriter(this.name + ".dat");
			write.println(output);
			write.close();
		}
		catch(IOException e)
		{
			System.out.println("Output file invalid.");
			System.exit(1);
		}
		

	}

	public String getName()
	{
		return this.name;
	}

	public boolean getPW()
	{
		return this.password.equals("admin");
	}

	public double getBalance()
	{
		return this.balance;
	}


}