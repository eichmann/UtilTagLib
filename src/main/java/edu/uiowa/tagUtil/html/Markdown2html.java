package edu.uiowa.tagUtil.html;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.github.rjeschke.txtmark.Processor;

public class Markdown2html extends BodyTagSupport {
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    public void setBodyContent(BodyContent bc) {
	super.setBodyContent(bc);
    }

    public int doAfterBody() throws JspTagException {
	try {
	    BodyContent bodyContent = super.getBodyContent();
	    String bodyString = bodyContent.getString();
	    JspWriter out = bodyContent.getEnclosingWriter();

	    out.print(Processor.process(bodyString));

	    bodyContent.clear(); // empty buffer for next evaluation
	} catch (IOException e) {
	    throw new JspTagException("Error in Unicode2html: " + e.getMessage(), e);
	} // end of catch

	return SKIP_BODY;
    }

}
