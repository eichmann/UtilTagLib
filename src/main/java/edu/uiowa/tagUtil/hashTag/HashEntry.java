package edu.uiowa.tagUtil.hashTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class HashEntry extends TagSupport {
	static Logger logger = LogManager.getLogger(HashEntry.class);

    String key = null;
    String value = null;

    public int doStartTag() throws JspException {
	HashTag hashTag = (HashTag)findAncestorWithClass(this, HashTag.class);
	logger.debug("hashTag: " + hashTag);
	logger.debug("HashTag entry: " + key +  " : " + value);
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
