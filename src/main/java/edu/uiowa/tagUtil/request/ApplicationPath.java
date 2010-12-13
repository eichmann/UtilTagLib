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

@SuppressWarnings("serial")
public class ApplicationPath extends TagSupport {
    String theURI = null;
    String applicationPath = null;

    public int doStartTag() throws JspTagException {
        // Note the misspelling of the actual header string value...
        theURI = ((HttpServletRequest)pageContext.getRequest()).getRequestURI();
        applicationPath = "http://" + pageContext.getRequest().getServerName() + ":" + pageContext.getRequest().getServerPort() + theURI.substring(0, theURI.indexOf('/', 1));

        //System.out.println("theURI: " + theURI + "\tapplicationPath: " + applicationPath);
        try {
            pageContext.getOut().print(applicationPath);
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

    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    private void clearServiceState() {
        theURI = null;
        applicationPath = null;
    }

}
