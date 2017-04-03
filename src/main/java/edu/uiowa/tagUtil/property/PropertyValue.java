/*
 * Created on Mar 2, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.uiowa.tagUtil.property;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class PropertyValue extends TagSupport {
	public static final Log log = LogFactory.getLog(PropertyValue.class);
	
    String theURI = null;
    String applicationName = null;
    String name = null;
    String propertyValue = null;
    Properties properties = null;

    public int doStartTag() throws JspTagException {
	initialize();
	
        try {
            pageContext.getOut().print(properties.get(name));
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
    
    void initialize() {
        // Note the misspelling of the actual header string value...
        theURI = ((HttpServletRequest)pageContext.getRequest()).getRequestURI();
        String thePath = ((HttpServletRequest)pageContext.getRequest()).getServletPath();
        if (theURI.equals(thePath) || theURI.length() < 2)
            applicationName = "";
        else
            applicationName = theURI.substring(1, theURI.indexOf('/', 1));
        
        properties = PropertyLoader.loadProperties(applicationName + ".properties");
        log.trace("theURI: " + theURI + "\tpropertyValue:" + propertyValue + "\t" + pageContext.getRequest().getServerName() + "\t" + pageContext.getRequest().getServerPort());
        log.trace("servletPath: " + thePath);
    }
    
    public String getTheURI() {
        return theURI;
    }

    public void setTheURI(String theURI) {
        this.theURI = theURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue(String name) {
	initialize();
        return properties.getProperty(name);
    }

    public void setValue(String value) {
        this.propertyValue = value;
    }

    private void clearServiceState() {
        theURI = null;
        propertyValue = null;
    }

}
