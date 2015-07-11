package sn.session;

public interface SessionManager
{
	long userFor(String token);

	String newSessionFor(long userId);
}
