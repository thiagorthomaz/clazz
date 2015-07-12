package sn.chain;

import javax.servlet.http.HttpServletRequest;

import sn.session.SessionManager;
import xingu.container.Inject;

public class CheckAuth implements RequestChain {

	@Inject
	private SessionManager sessions;
	
	@Override
	public Object handle(HttpServletRequest request) {
		String path = request.getPathInfo();
		if("/validate".equals(path) || "/auth".equals(path)) {
			return null;
		}
		
		String token = request.getParameter("token");
		long user = sessions.userFor(token);
		if(user > 0)
		{
			return null;
		}

		return "Auth Required";
	
	}

}
