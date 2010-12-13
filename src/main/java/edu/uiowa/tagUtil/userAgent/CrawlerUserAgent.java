/*
 * Created on Mar 2, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil.userAgent;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

@SuppressWarnings("serial")
public class CrawlerUserAgent extends BodyTagSupport {

    public int doStartTag() throws JspTagException {
        UserAgent theUserAgent = (UserAgent)findAncestorWithClass(this, UserAgent.class);
//        System.out.println("\t containing reference: " + theReferrer);
        
        if (theUserAgent == null)
            return SKIP_BODY;
        
        if (theUserAgent.crawlerUserAgent()) {
//            System.out.println("\tinternal referrer...");
            return EVAL_BODY_INCLUDE;
        } else
            return SKIP_BODY;
        
    }

    public int doAfterBody() throws JspException {
        clearServiceState();
        return super.doEndTag();
    }
    
    private void clearServiceState() {
    }

}
