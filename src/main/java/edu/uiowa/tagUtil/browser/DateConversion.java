package edu.uiowa.tagUtil.browser;

import java.sql.Timestamp;
import java.util.Date;

public class DateConversion {
	static long timeOffset = (new Date("1 Jan 2001 00:00:00 GMT")).getTime();
	
	static {
		System.out.println("\n\t\t*** browser predicates loaded! ***\n");
	}
	
	public static void main(String[] args) {
		System.out.println("Firefox timestamp 1350330325264712: " + firefox_timestamp("1350330325264712"));
		System.out.println("Firefox timestamp 1349884649873988: " + firefox_timestamp("1349884649873988"));
		System.out.println();
		System.out.println("Safari timestamp 372025757.1: " + safari_timestamp("372025757.1"));
		System.out.println("Safari timestamp 372013314.8: " + safari_timestamp("372013314.8"));
	}
	
	public static Timestamp firefox_timestamp(String timestamp) {
		if ("0".equals(timestamp.trim()))
			return null;
		
		return new Timestamp(Long.parseLong(timestamp) / 1000);
	}

	public static Timestamp safari_timestamp(String timestamp) {
		return new Timestamp(timeOffset + Long.parseLong(timestamp.substring(0,timestamp.indexOf("."))+timestamp.charAt(timestamp.length()-1))*100);
	}

}
