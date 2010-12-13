/*
 * Created on Mar 2, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil.referrer;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

@SuppressWarnings("serial")
public class RemoteReferrer extends BodyTagSupport {

    public int doStartTag() throws JspTagException {
        Referrer theReferrer = (Referrer)findAncestorWithClass(this, Referrer.class);
//        System.out.println("\t containing reference: " + theReferrer);
        
        if (theReferrer == null)
            return SKIP_BODY;
        
        if (theReferrer.remoteReferrer()) {
//            System.out.println("\tremote referrer...");
            return EVAL_BODY_INCLUDE;
        } else
            return SKIP_BODY;
        
    }

    public int doAfterBody() throws JspTagException {
        clearServiceState();
        return SKIP_BODY;
    }
    
    private void clearServiceState() {
    }

}
