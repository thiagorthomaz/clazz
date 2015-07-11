package sn.server.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.server.command.Command;
import sn.server.command.CommandMapper;
import sn.session.SessionManager;
import xingu.container.Inject;
import xingu.lang.SorryException;

public class ApiServlet
	extends SocialNetworkServletSupport
{
	@Inject
	private CommandMapper mapper;
	
	@Inject
	private SessionManager sessions;
	
	@Override
	protected Object process(HttpServletRequest request, HttpServletResponse response)
		throws Exception
	{
		/*
		 * TODO: Trabalho
		 * Chain of responsability
		 * Implementar as seguintes operaçoes com Chain of Responsability
		 * 1. Verificar se o comando pode ser executado
		 * 2. Logar a execucao do comando
		 * 3. Verificar a presença de SQL Injection nos parametros antes da execucao do commando
		 *
		 */
		boolean bypass = false;
		long user = 0;
		String path = request.getPathInfo();
		switch(path)
		{
			case "/validate":
			case "/auth":
				bypass = true;
				break;

			default:
				String token = request.getParameter("token");
				user = sessions.userFor(token);
				break;
		}
		if(bypass || user > 0)
		{
			Command command = mapper.translate(request);
			return command.execute();
		}
		else
		{
			throw new SorryException("Sorry :)");
		}

	}
}