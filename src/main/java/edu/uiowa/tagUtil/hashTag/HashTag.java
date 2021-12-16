package edu.uiowa.tagUtil.hashTag;

import java.util.Hashtable;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class HashTag extends TagSupport {
	static Logger logger = LogManager.getLogger(HashTag.class);
    static HashTag currentHashTag = null;

    public static Boolean keyExists (String ID) throws JspTagException {
	logger.debug("containing tag: " + currentHashTag + " : " + ID);
	if (ID == null)
		return false;
	return currentHashTag.cache.containsKey(ID);
    }

    String cacheName = null;
    Hashtable<String, String> cache = null;

    public int doStartTag() throws JspException {
	currentHashTag = this;
	cache = new Hashtable<String, String>();
	logger.debug("Hashtable initialized: " + cacheName);
	pageContext.setAttribute(cacheName, cache);

	return EVAL_PAGE;
    }

    public int doEndTag() throws JspException {
	clearServiceState();
	return super.doEndTag();
    }

    public String getCacheName () {
	return cacheName;
    }

    public void setCacheName (String  cacheName) {
	this.cacheName = cacheName;
    }
    
    public void addEntry(String key, String value) {
	logger.debug("addEntry: " + cache + " : " + key + " : " + value);
	cache.put(key, (value == null ? key : value));
    }

    private void clearServiceState () {
	currentHashTag = null;
	this.cacheName =  null;
	this.cache = null;
    }

}
