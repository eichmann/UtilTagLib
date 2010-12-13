/*
 * Created on Mar 2, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil.referrer;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class Referrer extends TagSupport {
    String referrer = null;
    URL theURL = null;
    String serverName = null;
    String hostName = null;
    String pathName = null;

    public int doStartTag() throws JspTagException {
//        Enumeration theEnum = ((HttpServletRequest)pageContext.getRequest()).getHeaderNames();
//        while (theEnum.hasMoreElements()) {
//            String header = (String)theEnum.nextElement();
//            System.out.println("header: " + header + " - " + ((HttpServletRequest)pageContext.getRequest()).getHeader(header));
//        }
        
        // Note the misspelling of the actual header string value...
        referrer = ((HttpServletRequest)pageContext.getRequest()).getHeader("referer");
        // handle GoogleBot's special non-referring entry
        if (referrer != null && referrer.equals("-"))
            referrer = null;
        
        System.out.println("referrer: " + referrer);

        serverName = ((HttpServletRequest)pageContext.getRequest()).getHeader("host").toLowerCase();
        if (serverName.indexOf(':') >= 0)
            serverName = serverName.substring(0,serverName.indexOf(':'));

//        System.out.println("serverName: " + serverName);

        if (referrer != null) {
            try {
                theURL = new URL(referrer);
                hostName = theURL.getHost().toLowerCase();
                pathName = theURL.getPath();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new JspTagException(e);
            }
        }
        
        System.out.println("hostName: " + hostName);
        System.out.println("pathName: " + pathName);
        
        return EVAL_BODY_INCLUDE;
    }

    public int doAfterBody() throws JspException {
        clearServiceState();
        return super.doEndTag();
    }
    
    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public URL getTheURL() {
        return theURL;
    }

    public void setTheURL(URL theURL) {
        this.theURL = theURL;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
    
    public boolean internalReferrer() {
        if (referrer == null || hostName == null)
            return false;
        return hostName.equals(serverName);
    }
    
    public boolean localReferrer() {
        if (referrer == null || hostName == null)
            return false;
        return hostName.endsWith("uiowa.edu");
    }
    
    public boolean remoteReferrer() {
        return !internalReferrer() && !localReferrer();
    }

    private void clearServiceState() {
        referrer = null;
        theURL = null;
        hostName = null;
        pathName = null;
    }

}
