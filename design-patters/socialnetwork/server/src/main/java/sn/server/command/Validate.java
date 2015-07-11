package sn.server.command;

import sn.session.SessionManager;
import xingu.container.Inject;

public class Validate
	implements Command
{
	@Inject
	private SessionManager session;
	
	private String token;
	
	@Override
	public Object execute()
		throws Exception
	{
		long user = session.userFor(token);
		return user > 0 ? new ValidateReply(token) : "";
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}
}
