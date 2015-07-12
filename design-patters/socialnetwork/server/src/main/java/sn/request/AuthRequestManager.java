package sn.request;

import javax.servlet.http.HttpServletRequest;

import sn.session.SessionManager;
import xingu.container.Inject;

public class AuthRequestManager implements RequestManager {
	
	@Inject
	private SessionManager sessions;
	
	RequestManager request_manager;
	
	@Override
	public void setNext(RequestManager rm) {
		this.request_manager = rm;

	}

	@Override
	public void handleRequest(HttpServletRequest request) {
		String token = request.getParameter("token");
		long user = sessions.userFor(token);
		
		if ( user == 0 ){
			//Usuário inválido
		}
		
		this.request_manager.handleRequest(request);
		
		

	}

}
