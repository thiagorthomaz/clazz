package sn.chain;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogCommand implements RequestChain {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Object handle(HttpServletRequest request) {
		String path = request.getPathInfo();
		logger.info("Mapping command to: '{}'", path);
		return null;
	}

}
