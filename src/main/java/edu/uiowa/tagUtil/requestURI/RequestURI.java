package edu.uiowa.tagUtil.requestURI;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author rrlorent
 */
public class RequestURI extends TagSupport {

	private static final long serialVersionUID = 6694236545114396133L;
	private static final Log log = LogFactory.getLog(RequestURI.class);
	
	public int doStartTag(){
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			pageContext.getOut().print( request.getRequestURI() );
		} catch (IOException e) {
			log.error("error getting request URI",e);
		}
		return EVAL_PAGE;
	}
	
}
