package sn.chain;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RequestCommand implements RequestChain {

	@Override
	public Object handle(HttpServletRequest request) throws Exception {
		return this.detectMaliciousWords(request);
	}

	private Object detectMaliciousWords(HttpServletRequest request){

		String path = request.getQueryString();
		
		List<String> trash_words = new ArrayList<>();

		trash_words.add("select");
		trash_words.add("insert");
		trash_words.add("delete");
		trash_words.add("update");
		trash_words.add("drop");
		trash_words.add("--");
		trash_words.add(";");
		
		for(String word : trash_words) {
			Boolean r = path.toLowerCase().contains(word.toLowerCase());
			if (r == true){
				return "Malicious Word has been detected";
			}
		}
		
		return null;
	} 

}
