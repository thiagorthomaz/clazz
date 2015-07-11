package sn.server.command;

public class ValidateReply
{
	private String	value;

	public ValidateReply(String token)
	{
		this.value = token;
	}

	public String getValue()
	{
		return value;
	}
}
