package sn.chain;

import javax.servlet.http.HttpServletRequest;

import sn.server.command.Command;
import sn.server.command.CommandMapper;
import xingu.container.Inject;

public class ProcessCommand implements RequestChain {

	@Inject
	private CommandMapper mapper;
	
	@Override
	public Object handle(HttpServletRequest request) throws Exception {
		Command command = mapper.translate(request);
		return command.execute();
	}

}
