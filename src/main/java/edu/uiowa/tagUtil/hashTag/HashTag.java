package edu.uiowa.tagUtil.hashTag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class HashTag extends TagSupport {

    private static final Log log = LogFactory.getLog(HashTag.class);

    public Boolean keyExists (String ID) throws JspTagException {
	HashTag helper = new HashTag();
	HashTag theCache = (HashTag)findAncestorWithClass(helper, HashTag.class);
	return theCache.cache.containsKey(ID);
    }

    String cacheName = null;
    Hashtable<String, String> cache = new Hashtable<String, String>();

    public int doStartTag() throws JspException {
	log.info("Hashtable initialized: " + cacheName);
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
	cache.put(key, (value == null ? key : value));
    }

    private void clearServiceState () {
	this.cacheName =  null;
	this.cache = null;
    }

}
