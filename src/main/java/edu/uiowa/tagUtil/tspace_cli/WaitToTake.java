package edu.uiowa.tagUtil.tspace_cli;

import com.ibm.tspaces.Field;
import com.ibm.tspaces.Tuple;
import com.ibm.tspaces.TupleSpace;
import com.ibm.tspaces.TupleSpaceException;

public class WaitToTake {
	static TupleSpace ts = null;
	static final String host = null;

	public static void main(String[] args) throws TupleSpaceException {
		System.out.println("host: " + args[0]);
		System.out.println("tuple space: " + args[1]);
		System.out.println("tuple: " + args[2] + (args.length > 3 ? "\tvalue: " + args[3] : ""));

		ts = new TupleSpace(args[1], args[0]);

		if (args.length > 3) {
				Tuple theTuple = ts.waitToTake(args[2] , new Field(String.class));
				if (theTuple != null) {
					String value = (String) theTuple.getField(1).getValue();
					System.out.println("consuming " + args[2]  + "\t" +  value);
				} else  {
					
				}
		} else  {
			Tuple theTuple = ts.waitToTake(args[2]);
			if (theTuple != null) {
				System.out.println("consuming " + args[2]);
			} else  {
				
			}			
		}
	}

}
