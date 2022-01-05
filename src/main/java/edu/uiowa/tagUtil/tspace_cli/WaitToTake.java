package edu.uiowa.tagUtil.tspace_cli;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ibm.tspaces.Field;
import com.ibm.tspaces.Tuple;
import com.ibm.tspaces.TupleSpace;
import com.ibm.tspaces.TupleSpaceException;

public class WaitToTake {
	static Logger logger = LogManager.getLogger(WaitToTake.class);
	static TupleSpace ts = null;
	static final String host = null;

	public static void main(String[] args) throws TupleSpaceException {
		logger.info("waiting on: " + args[0] + " : " + args[1] + " : " + args[2] + (args.length > 3 ? "\tvalue: " + args[3] : ""));

		ts = new TupleSpace(args[1], args[0]);

		if (args.length > 3) {
				Tuple theTuple = ts.waitToTake(args[2] , new Field(String.class));
				if (theTuple != null) {
					String value = (String) theTuple.getField(0).getValue();
					logger.info("consuming " + args[2]  + "\t" +  value);
				} else  {
					
				}
		} else  {
			Tuple theTuple = ts.waitToTake(args[2]);
			if (theTuple != null) {
				logger.info("consuming " + args[2]);
			} else  {
				
			}			
		}
	}

}
