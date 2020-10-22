package edu.uiowa.tagUtil.hashTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class HashEntry extends TagSupport {

    private static final Log log = LogFactory.getLog(HashEntry.class);

    String key = null;
    String value = null;

    public int doStartTag() throws JspException {
	HashTag hashTag = (HashTag)findAncestorWithClass(this, HashTag.class);
	log.debug("hashTag: " + hashTag);
	log.debug("HashTag entry: " + key +  " : " + value);
	hashTag.addEntry(key, value);

	return EVAL_PAGE;
    }

    public int doEndTag() throws JspException {
	clearServiceState();
	return super.doEndTag();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private void clearServiceState () {
	this.key =  null;
	this.value = null;
    }

}
