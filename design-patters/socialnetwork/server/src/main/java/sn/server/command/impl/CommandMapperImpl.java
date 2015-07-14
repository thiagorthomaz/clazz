package sn.server.command.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.avalon.framework.activity.Initializable;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sn.server.command.Auth;
import sn.server.command.Command;
import sn.server.command.CommandMapper;
import sn.server.command.AppendPost;
import sn.server.command.UnknownCommand;
import sn.server.command.Validate;
import xingu.container.Inject;
import xingu.factory.Factory;

public class CommandMapperImpl
	implements CommandMapper, Initializable
{
	@Inject
	private Factory factory;
	
	private Map<String, Command> commandByPath = new HashMap<>();

	@Override
	public void initialize()
		throws Exception
	{
		commandByPath.put("/validate", factory.create(Validate.class));
		commandByPath.put("/auth", factory.create(Auth.class));
		commandByPath.put("/post", factory.create(AppendPost.class));
	}

	@Override
	public Command translate(HttpServletRequest request)
		throws Exception
	{
		String path = request.getPathInfo();
		

		Command cmd = commandByPath.get(path);
		if(cmd != null)
		{
			Map params = request.getParameterMap();
			BeanUtils.populate(cmd, params);
		}
		else
		{
			cmd = new UnknownCommand();
		}
		
		return cmd;
	}
}