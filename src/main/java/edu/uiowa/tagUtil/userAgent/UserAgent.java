/*
 * Created on Mar 2, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil.userAgent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings( "serial" )
public class UserAgent extends TagSupport {
	String userAgent = null;

	public int doStartTag() throws JspTagException {
		// Note the misspelling of the actual header string value...
		userAgent = ( (HttpServletRequest) pageContext.getRequest() ).getHeader( "user-agent" );
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		clearServiceState();
		return super.doEndTag();
	}

	public boolean crawlerUserAgent() {
		return userAgent.startsWith( "gsa-crawler" ) || userAgent.startsWith( "msnbot" ) || userAgent.indexOf( "Googlebot" ) >= 0;
	}

	public boolean browserUserAgent() {
		return !crawlerUserAgent();
	}

	private void clearServiceState() {
		userAgent = null;
	}

}
