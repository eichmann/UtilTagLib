package edu.uiowa.tagUtil.log;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class LogTag extends BodyTagSupport {
	
	public static final Log log = LogFactory.getLog(LogTag.class);
	
	private static final String DEBUG = "DEBUG";
	private static final String INFO = "INFO";
	private static final String ERROR = "ERROR";
	
	private String page;
	private String level;
	private String message;
	
	public int doStartTag(){
		
		if( DEBUG.equalsIgnoreCase(level) ){
			log.debug( page + " - " + message );
		} else if( INFO.equalsIgnoreCase(level) ) {
			log.info( page + " - " + message );
		} else if( ERROR.equalsIgnoreCase(level) ){
			log.error( page + " - " + message );
		}
		
		return EVAL_PAGE;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}