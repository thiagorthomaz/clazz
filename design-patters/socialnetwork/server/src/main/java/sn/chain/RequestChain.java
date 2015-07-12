package sn.chain;

import javax.servlet.http.HttpServletRequest;

public interface RequestChain {

	Object handle(HttpServletRequest request)
		throws Exception;

}
