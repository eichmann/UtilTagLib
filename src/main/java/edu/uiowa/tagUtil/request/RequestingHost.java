/*
 * Created on Mar 2, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil.request;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class RequestingHost extends TagSupport {
	String mode = null;
    String theHost = null;

    public int doStartTag() throws JspTagException {
        // Note the misspelling of the actual header string value...
        theHost = ((HttpServletRequest)pageContext.getRequest()).getHeader("X-FORWARDED-FOR");
        
        if (theHost == null || theHost.equals(""))
            theHost = ((HttpServletRequest)pageContext.getRequest()).getRemoteHost();

        //System.out.println("theURI: " + theURI + "\tapplicationPath: " + applicationPath);
        try {
            if (mode != null && mode.toLowerCase().equals("domain-name")) {
            	InetAddress addr = InetAddress.getByAddress(theHost, getBytes(theHost));
            	theHost = addr.getCanonicalHostName();
            }
            
            pageContext.getOut().print(theHost);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new JspTagException("Error generating requesting host.");
        }

        return SKIP_BODY;
    }

    public int doAfterBody() throws JspException {
        clearServiceState();
        return super.doEndTag();
    }
    
    byte[] getBytes(String theAddress) {
    	String[] octetArray = theAddress.split("\\.");
    	assert octetArray.length == 4;
    	byte[] ipAddressBytes = new byte[4];
    	for (int i = 0; i < 4; ++i) {
    	    ipAddressBytes[i] = Integer.valueOf(octetArray[i]).byteValue();
    	}
    	return ipAddressBytes;
    }
    
    public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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
