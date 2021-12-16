package edu.uiowa.tagUtil.log;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class LogTag extends BodyTagSupport {
	static Logger logger = LogManager.getLogger(LogTag.class);
	
	private static final String DEBUG = "DEBUG";
	private static final String INFO = "INFO";
	private static final String ERROR = "ERROR";
	
	private String page;
	private String line;
	private String level = DEBUG;
	private String message;
	
	public int doStartTag(){
		
		if( DEBUG.equalsIgnoreCase(level) ){
			logger.debug( page + ":" + line + " - " + message );
		} else if( INFO.equalsIgnoreCase(level) ) {
			logger.info( page + ":" + line + " - " + message );
		} else if( ERROR.equalsIgnoreCase(level) ){
			logger.error( page + ":" + line + " - " + message );
		}
		
		clear();
		
		return EVAL_PAGE;
	}
	
	// reset to defaults
	private void clear() {
		this.level = DEBUG;
		this.line = null;
		this.message = null;
		this.page = null;
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

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
}