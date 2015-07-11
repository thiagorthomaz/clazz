package sn.session.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import sn.session.SessionManager;

public class SessionManagerImpl
	implements SessionManager
{
	private Map<String, Long> userByToken = new HashMap<>();
	
	@Override
	public long userFor(String token)
	{
		Long result = userByToken.get(token);
		return result == null ? 0 : result;
	}

	@Override
	public String newSessionFor(long userId)
	{
		String token = RandomStringUtils.randomAlphanumeric(32);
		userByToken.put(token, userId);
		return token;
	}
}