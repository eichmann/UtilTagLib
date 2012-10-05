package edu.uiowa.tagUtil.grantParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nih {
	
	static {
		System.out.println("\n\n\t\t*** nih loaded! ***\n");
	}
	
	/* Application type Ð Activity code Ð Institute Ð Serial no. Ð Suffix (Year Ð Amendment -Supplement)
	 * 1 R01 AI 83723 01 A1 S1 
	 */
	
	private static Pattern awardPattern = Pattern.compile("([1-9]?)[\\- ]*([A-Z][0-9][0-9])?[\\- ]*([A-Z][A-Z])[\\- ]*([0-9]+)[\\- ]*([0-9]*)[\\- ]*([A][0-9])?[\\- ]*([S][0-9])?");
	
	private static String match(String source, int position) {
		if (source == null)
			return null;
		Matcher theMatcher = awardPattern.matcher(source);
		if (theMatcher.matches())
			return theMatcher.group(position);
		else
			return null;
	}
	
	public static Integer applicationType(String grant) {
		String type = match(grant, 1);
		if (type == null || type.length() != 1)
			return null;
		else
			return new Integer(type);
	}

	public static String activityCode(String grant) {
		return match(grant, 2);
	}

	public static String institute(String grant) {
		return match(grant, 3);
	}

	public static Integer serialNumber(String grant) {
		String serialNumber = match(grant, 4);
		if (serialNumber == null || serialNumber.length() > 6)
			return null;
		else
			return new Integer(serialNumber);
	}

	public static Integer year(String grant) {
		String year = match(grant, 5);
		if (year == null || year.length() != 2)
			return null;
		else
			return new Integer(year);
	}

	public static String amendment(String grant) {
		return match(grant, 6);
	}

	public static String supplement(String grant) {
		return match(grant, 7);
	}
	
	public static boolean matches(String grant1, String grant2) {
		return matches(grant1, grant2, 1);
	}
	
	public static boolean matches(String grant1, String grant2, int level) {
		int serialNumber1 = serialNumber(grant1);
		int serialNumber2 = serialNumber(grant2);

		if (serialNumber1 == serialNumber2)
			return true;
		return false;
	}
	
	public static String testing() {
		return "tested";
	}
	
	public static void main(String[] args) {
		test("1 R01 AI 83723 01 A1 S1");
		test("5-K08-DK02548-04");
		test("2 R01 DK051315-11A1");
		test("3R01DK073990-02S1");
	}

	private static void test(String grant) {
		System.out.println("\ngrant string : " + grant);
		System.out.println("\tapplication type: " + applicationType(grant));
		System.out.println("\tactivity code   : " + activityCode(grant));
		System.out.println("\tinstitute       : " + institute(grant));
		System.out.println("\tserial number   : " + serialNumber(grant));
		System.out.println("\tyear            : " + year(grant));
		System.out.println("\tamendment       : " + amendment(grant));
		System.out.println("\tsupplement      : " + supplement(grant));
	}
}
