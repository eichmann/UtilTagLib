/*
 * Created on Mar 2, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil.request;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uiowa.tagUtil.property.PropertyLoader;

@SuppressWarnings("serial")
public class ApplicationRoot extends TagSupport {
    public static final Log log = LogFactory.getLog(ApplicationRoot.class);
    static boolean propertyLoadAttempted = false;
    static Properties properties = null;
    static String container = null;
    
    String theURI = null;
    String applicationRoot = null;
    
    private static synchronized void loadProperties(String applicationName) {
	if (properties != null || propertyLoadAttempted)
	    return;
	propertyLoadAttempted = true;
	log.info("loading " + applicationName + ".properties");
	try {
	    properties = PropertyLoader.loadProperties(applicationName + ".properties");
	} catch (Exception e) {
	    log.info("load failed: " + applicationName + ".properties");
	}
	if (properties != null) {
	    container = properties.getProperty("applicationRoot", null);
	    log.info("container: " + container);
	}
    }

    public int doStartTag() throws JspTagException {
	// Note the misspelling of the actual header string value...
	theURI = ((HttpServletRequest) pageContext.getRequest()).getRequestURI();
	String thePath = ((HttpServletRequest) pageContext.getRequest()).getServletPath();
	if (theURI.equals(thePath) || theURI.length() < 2)
	    applicationRoot = "";
	else
	    applicationRoot = theURI.substring(0, theURI.indexOf('/', 1));
	loadProperties(applicationRoot.substring(1));
	if (container != null)
	    applicationRoot = container;

	log.trace("theURI: " + theURI + "\tapplicationRoot:" + applicationRoot + "\t" + pageContext.getRequest().getServerName() + "\t"
		+ pageContext.getRequest().getServerPort());
	log.trace("servletPath: " + thePath);
	try {
	    pageContext.getOut().print(applicationRoot);
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

    public String getApplicationRoot() {
	return applicationRoot;
    }

    public void setApplicationRoot(String applicationRoot) {
	this.applicationRoot = applicationRoot;
    }

    private void clearServiceState() {
	theURI = null;
	applicationRoot = null;
    }

}
