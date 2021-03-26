package edu.uiowa.tagUtil.tspace_cli;

import com.ibm.tspaces.TupleSpace;
import com.ibm.tspaces.TupleSpaceException;

public class Write {
	static TupleSpace ts = null;
	static final String host = null;

	public static void main(String[] args) throws TupleSpaceException {
		System.out.println("host: " + args[0]);
		System.out.println("tuple space: " + args[1]);
		System.out.println("tuple: " + args[2] + (args.length > 3 ? "\tvalue: " + args[3] : ""));

		ts = new TupleSpace(args[1], args[0]);

		if (args.length > 3) {
			ts.write(args[2], args[3]);
		} else  {
			ts.write(args[2]);
		}
	}

}
