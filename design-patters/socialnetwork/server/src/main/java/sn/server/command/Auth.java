package sn.server.command;

import sn.session.SessionManager;
import xingu.container.Inject;

public class Auth
	implements Command
{
	@Inject
	private SessionManager session;

	private String username;
	
	private String password;
	
	@Override
	public Object execute()
		throws Exception
	{
		boolean valid = "zzz".equals(username) && "zzz".equals(password);
		if(valid)
		{
			String token = session.newSessionFor(1);
			return new AuthReply(token);
		}
		return new AuthReply(null);
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}