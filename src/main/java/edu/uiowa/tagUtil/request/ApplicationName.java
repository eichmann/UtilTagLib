/*
 * Created on Mar 2, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil.request;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class ApplicationName extends TagSupport {
	static Logger logger = LogManager.getLogger(ApplicationName.class);
	
    String theURI = null;
    String applicationName = null;

    public int doStartTag() throws JspTagException {
        // Note the misspelling of the actual header string value...
        theURI = ((HttpServletRequest)pageContext.getRequest()).getRequestURI();
        String thePath = ((HttpServletRequest)pageContext.getRequest()).getServletPath();
        if (theURI.equals(thePath) || theURI.length() < 2)
            applicationName = "";
        else
            applicationName = theURI.substring(1, theURI.indexOf('/', 1));

        logger.trace("theURI: " + theURI + "\tapplicationName:" + applicationName + "\t" + pageContext.getRequest().getServerName() + "\t" + pageContext.getRequest().getServerPort());
        logger.trace("servletPath: " + thePath);
        try {
            pageContext.getOut().print(applicationName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new JspTagException("Error generating application root.");
        }

        return SKIP_BODY;
    }

    public int doAfterBody() throws JspException {
        clearServiceState();
        return super.doEndTag();
    }
    
    public String getTheURI() {
        return theURI;
    }

    public void setTheURI(String theURI) {
        this.theURI = theURI;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    private void clearServiceState() {
        theURI = null;
        applicationName = null;
    }

}
