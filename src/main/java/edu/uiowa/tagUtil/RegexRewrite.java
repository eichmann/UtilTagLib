/*
 * Created on Feb 13, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class RegexRewrite extends BodyTagSupport {
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    private String source = null;

    private String target = null;

    public void setBodyContent(BodyContent bc) {
        super.setBodyContent(bc);
        //System.out.println("RegexRewrite source: '" + source + "'\ttarget: '" + target + "'");
    }

    public int doAfterBody() throws JspTagException {
        try {
            BodyContent bodyContent = super.getBodyContent();
            String bodyString = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();

            out.print(bodyString.replaceAll(source,target));
            bodyContent.clear(); // empty buffer for next evaluation
        } catch (IOException e) {
            throw new JspTagException("Error in RegexRewrite: " + e.getMessage());
        } // end of catch

        return SKIP_BODY;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
