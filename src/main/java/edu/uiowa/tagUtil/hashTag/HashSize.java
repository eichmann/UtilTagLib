package edu.uiowa.tagUtil.hashTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class HashSize extends TagSupport {

    private static final Log log = LogFactory.getLog(HashSize.class);

    HashTag hashTag = null;
    
    public int doStartTag() throws JspException {
	try {
	    hashTag = (HashTag)findAncestorWithClass(this, HashTag.class);
	    log.debug("hashTag: " + hashTag);
	    pageContext.getOut().print(hashTag.cache.size());
	} catch (IOException e) {
	    log.error("Can't find enclosing Hash for size tag ", e);
	    throw new JspTagException("Error: Can't find enclosing Hash for size tag ");
	}
	return SKIP_BODY;
    }

}
