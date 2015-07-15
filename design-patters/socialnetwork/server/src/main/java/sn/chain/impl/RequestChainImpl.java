package sn.chain.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.avalon.framework.activity.Initializable;

import sn.chain.CheckAuth;
import sn.chain.LogCommand;
import sn.chain.ProcessCommand;
import sn.chain.RequestChain;
import sn.chain.RequestCommand;
import xingu.container.Inject;
import xingu.factory.Factory;

public class RequestChainImpl  implements RequestChain, Initializable {

	@Inject
	private Factory factory;
	
	private List<RequestChain> nodes = new ArrayList<>();

	@Override
	public void initialize() throws Exception {
		nodes.add(factory.create(LogCommand.class));
		nodes.add(factory.create(RequestCommand.class));
		nodes.add(factory.create(CheckAuth.class));
		nodes.add(factory.create(ProcessCommand.class));
	}

	
	@Override
	public Object handle(HttpServletRequest request) throws Exception {
		for(RequestChain chain : nodes) {
			Object result = chain.handle(request);
			if(result != null) {
				return result;
			}
		}
		return null;
	}
}
