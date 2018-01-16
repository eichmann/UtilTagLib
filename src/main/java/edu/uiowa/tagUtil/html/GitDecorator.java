package edu.uiowa.tagUtil.html;

import com.github.rjeschke.txtmark.DefaultDecorator;

public class GitDecorator extends DefaultDecorator {
    int downLevel = 3;
    
    public GitDecorator() {
    }

    public GitDecorator(int downLevel) {
	this.downLevel = downLevel;
    }

    public void openHeadline(final StringBuilder out, final int level) {
	out.append("<h");
	out.append(level+downLevel);
	// not sure what they do, but this just shows up in the output if it executes: out.append(">");
    }

    public void closeHeadline(final StringBuilder out, final int level) {
	out.append("</h");
	out.append(level+downLevel);
	out.append(">\n");
    }
}
