package sn.request;

import javax.servlet.http.HttpServletRequest;

import sn.server.command.Command;

public interface RequestManager {
	
	public void setNext(RequestManager rm);
	public void handleRequest(HttpServletRequest request);

}
