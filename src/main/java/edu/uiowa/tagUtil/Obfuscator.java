package edu.uiowa.tagUtil;


import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")

public class Obfuscator extends TagSupport {

    public static Integer obfuscateID(Integer ID) {
        return 1000000 - ID + 1354;
    }
    
    public static Integer deobfuscateID(Integer ID) {
        return 1000000 - (ID - 1354);
    }
    
}
