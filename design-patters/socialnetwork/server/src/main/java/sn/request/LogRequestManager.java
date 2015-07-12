package sn.request;

import javax.servlet.http.HttpServletRequest;

import sn.server.command.Command;

public class LogRequestManager implements RequestManager {

	RequestManager request_manager;
	
	@Override
	public void setNext(RequestManager rm) {
		this.request_manager = rm;

	}

	@Override
	public void handleRequest(HttpServletRequest request) {
		
		//gerar log
		

	}

}
