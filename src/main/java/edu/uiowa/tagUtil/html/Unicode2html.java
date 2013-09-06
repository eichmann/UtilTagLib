package edu.uiowa.tagUtil.html;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Unicode2html extends BodyTagSupport {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;

	public void setBodyContent(BodyContent bc) {
		super.setBodyContent(bc);
		// System.out.println("RegexRewrite source: '" + source + "'\ttarget: '" + target + "'");
	}

	public int doAfterBody() throws JspTagException {
		try {
			BodyContent bodyContent = super.getBodyContent();
			String bodyString = bodyContent.getString();
			JspWriter out = bodyContent.getEnclosingWriter();

			// out.print(theEntities.unicode2html(bodyString));
			bodyContent.clear(); // empty buffer for next evaluation
		} catch (IOException e) {
			throw new JspTagException("Error in Unicode2html: " + e.getMessage(), e);
		} // end of catch

		return SKIP_BODY;
	}

}
