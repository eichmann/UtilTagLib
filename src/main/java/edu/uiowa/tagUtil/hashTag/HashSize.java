package edu.uiowa.tagUtil.hashTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class HashSize extends TagSupport {
	static Logger logger = LogManager.getLogger(HashSize.class);

    HashTag hashTag = null;
    
    public int doStartTag() throws JspException {
	try {
	    hashTag = (HashTag)findAncestorWithClass(this, HashTag.class);
	    logger.debug("hashTag: " + hashTag);
	    pageContext.getOut().print(hashTag.cache.size());
	} catch (IOException e) {
	    logger.error("Can't find enclosing Hash for size tag ", e);
	    throw new JspTagException("Error: Can't find enclosing Hash for size tag ");
	}
	return SKIP_BODY;
    }

}
