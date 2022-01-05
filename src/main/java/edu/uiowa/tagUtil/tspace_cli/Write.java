package edu.uiowa.tagUtil.tspace_cli;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ibm.tspaces.TupleSpace;
import com.ibm.tspaces.TupleSpaceException;

public class Write {
	static Logger logger = LogManager.getLogger(Write.class);
	static TupleSpace ts = null;
	static final String host = null;

	public static void main(String[] args) throws TupleSpaceException {
		logger.info("writing: " + args[0] + " : " + args[1] + " : " + args[2] + (args.length > 3 ? "\tvalue: " + args[3] : ""));

		ts = new TupleSpace(args[1], args[0]);

		if (args.length > 3) {
			ts.write(args[2], args[3]);
		} else  {
			ts.write(args[2]);
		}
	}

}
