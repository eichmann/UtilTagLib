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
public class RequestingHost extends TagSupport {
    String theHost = null;

    public int doStartTag() throws JspTagException {
        // Note the misspelling of the actual header string value...
        theHost = ((HttpServletRequest)pageContext.getRequest()).getHeader("X-FORWARDED-FOR");
        
        if (theHost == null || theHost.equals(""))
            theHost = ((HttpServletRequest)pageContext.getRequest()).getRemoteHost();

        //System.out.println("theURI: " + theURI + "\tapplicationPath: " + applicationPath);
        try {
            pageContext.getOut().print(theHost);
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
    
    public String getTheHost() {
        return theHost;
    }

    public void setTheHost(String theHost) {
        this.theHost = theHost;
    }

    private void clearServiceState() {
        theHost = null;
    }

}
