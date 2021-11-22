package edu.uiowa.tagUtil.grantParser;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class NIHGrantParser extends TagSupport {
	public static final Log log = LogFactory.getLog(NIHGrantParser.class);

	String grantNumber = null;
	String component = null;

	public int doStartTag() throws JspTagException {
		try {
			switch (component) {
			case "application_type":
				pageContext.getOut().print(nih.applicationType(grantNumber));
				break;
			case "activity_code":
				pageContext.getOut().print(nih.activityCode(grantNumber));
				break;
			case "institute":
				pageContext.getOut().print(nih.institute(grantNumber));
				break;
			case "serial_number":
				pageContext.getOut().print(nih.serialNumber(grantNumber));
				break;
			case "year":
				pageContext.getOut().print(nih.year(grantNumber));
				break;
			case "amendment":
				pageContext.getOut().print(nih.amendment(grantNumber));
				break;
			case "supplement":
				pageContext.getOut().print(nih.supplement(grantNumber));
				break;
			default:
				throw new JspTagException("Unknown NIH grant number component: " + component);
			}
		} catch (IOException e) {
			throw new JspTagException("Error generating application root.");
		}

		return SKIP_BODY;
	}

	public String getGrantNumber() {
		return grantNumber;
	}

	public void setGrantNumber(String grantNumber) {
		this.grantNumber = grantNumber;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

}
