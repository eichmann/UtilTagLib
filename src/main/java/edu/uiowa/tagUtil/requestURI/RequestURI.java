package edu.uiowa.tagUtil.requestURI;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author rrlorent
 */
public class RequestURI extends TagSupport {

	private static final long serialVersionUID = 6694236545114396133L;
	static Logger logger = LogManager.getLogger(RequestURI.class);
	
	public int doStartTag(){
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			pageContext.getOut().print( request.getRequestURI() );
		} catch (IOException e) {
			logger.error("error getting request URI",e);
		}
		return EVAL_PAGE;
	}
	
}
