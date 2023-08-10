package edu.uiowa.tagUtil.html;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class Markdown2html extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	int offset = 0;

	// initialize the markdown engine

	MutableDataSet options = null;;
	Parser parser = null;
	HtmlRenderer renderer = null;

	{
		options = new MutableDataSet();
		options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));
		parser = Parser.builder(options).build();
		renderer = HtmlRenderer.builder(options).build();
	}

	public void setBodyContent(BodyContent bc) {
		super.setBodyContent(bc);
	}

	public int doAfterBody() throws JspTagException {
		try {
			BodyContent bodyContent = super.getBodyContent();
			String bodyString = bodyContent.getString();
			JspWriter out = bodyContent.getEnclosingWriter();

			out.print(renderer.render(parser.parse(bodyString)));

			bodyContent.clear(); // empty buffer for next evaluation
		} catch (IOException e) {
			throw new JspTagException("Error in Unicode2html: " + e.getMessage(), e);
		} // end of catch

		return SKIP_BODY;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
