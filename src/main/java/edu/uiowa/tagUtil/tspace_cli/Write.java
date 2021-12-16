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
		logger.info("writing: " + args[1] + " : " + args[2] + " : " + args[3] + (args.length > 4 ? "\tvalue: " + args[4] : ""));

		ts = new TupleSpace(args[2], args[1]);

		if (args.length > 4) {
			ts.write(args[3], args[4]);
		} else  {
			ts.write(args[3]);
		}
	}

}
