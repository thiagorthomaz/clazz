package sn.server.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.chain.RequestChain;
import sn.chain.impl.RequestChainImpl;
import sn.request.AuthRequestManager;
import sn.request.LogRequestManager;
import sn.server.command.Command;
import sn.server.command.CommandMapper;
import sn.session.SessionManager;
import xingu.container.Inject;
import xingu.lang.SorryException;

public class ApiServlet
	extends SocialNetworkServletSupport
{
	@Inject
	private RequestChain chain;

	@Override
	protected Object process(HttpServletRequest request, HttpServletResponse response)
		throws Exception
	{
		return chain.handle(request);
		
		/*
		 * TODO: Trabalho
		 * Chain of responsability
		 * Implementar as seguintes operaçoes com Chain of Responsability
		 * 1. Verifica autenticação no sistema - ok
		 * 2. Verificar se o comando pode ser executado -ok
		 * 3. Logar a execucao do comando - ok
		 * 4. Verificar a presença de SQL Injection nos parametros antes da execucao do commando
		 *
		 */

	}
}