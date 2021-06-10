package edu.uiowa.tagUtil.tspace_cli;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ibm.tspaces.Field;
import com.ibm.tspaces.Tuple;
import com.ibm.tspaces.TupleSpace;
import com.ibm.tspaces.TupleSpaceException;

public class WaitToTake {
    static Logger logger = Logger.getLogger(WaitToTake.class);
	static TupleSpace ts = null;
	static final String host = null;

	public static void main(String[] args) throws TupleSpaceException {
		PropertyConfigurator.configure(args[0]);
		logger.info("waiting on: " + args[1] + " : " + args[2] + " : " + args[3] + (args.length > 4 ? "\tvalue: " + args[4] : ""));

		ts = new TupleSpace(args[2], args[1]);

		if (args.length > 4) {
				Tuple theTuple = ts.waitToTake(args[3] , new Field(String.class));
				if (theTuple != null) {
					String value = (String) theTuple.getField(1).getValue();
					logger.info("consuming " + args[3]  + "\t" +  value);
				} else  {
					
				}
		} else  {
			Tuple theTuple = ts.waitToTake(args[3]);
			if (theTuple != null) {
				logger.info("consuming " + args[3]);
			} else  {
				
			}			
		}
	}

}
