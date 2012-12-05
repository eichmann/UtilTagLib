package edu.uiowa.tagUtil.grantParser;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nih {
	
	static Hashtable<String,String> activityHash = new Hashtable<String,String>();
	static Hashtable<String,String> instituteHash = new Hashtable<String,String>();
	
	static {
		activityHash.put("A03", "A03");
		activityHash.put("A11", "A11");
		activityHash.put("A19", "A19");
		activityHash.put("A22", "A22");
		activityHash.put("A23", "A23");
		activityHash.put("A24", "A24");
		activityHash.put("B01", "B01");
		activityHash.put("B08", "B08");
		activityHash.put("B09", "B09");
		activityHash.put("C06", "C06");
		activityHash.put("D10", "D10");
		activityHash.put("D14", "D14");
		activityHash.put("D15", "D15");
		activityHash.put("D18", "D18");
		activityHash.put("D19", "D19");
		activityHash.put("D21", "D21");
		activityHash.put("D23", "D23");
		activityHash.put("D24", "D24");
		activityHash.put("D28", "D28");
		activityHash.put("D30", "D30");
		activityHash.put("D31", "D31");
		activityHash.put("D32", "D32");
		activityHash.put("D33", "D33");
		activityHash.put("D34", "D34");
		activityHash.put("D35", "D35");
		activityHash.put("D36", "D36");
		activityHash.put("D37", "D37");
		activityHash.put("D38", "D38");
		activityHash.put("D39", "D39");
		activityHash.put("D42", "D42");
		activityHash.put("D43", "D43");
		activityHash.put("D71", "D71");
		activityHash.put("DP1", "DP1");
		activityHash.put("DP2", "DP2");
		activityHash.put("DP3", "DP3");
		activityHash.put("DP4", "DP4");
		activityHash.put("DP5", "DP5");
		activityHash.put("E03", "E03");
		activityHash.put("E10", "E10");
		activityHash.put("E11", "E11");
		activityHash.put("F05", "F05");
		activityHash.put("F06", "F06");
		activityHash.put("F15", "F15");
		activityHash.put("F18", "F18");
		activityHash.put("F19", "F19");
		activityHash.put("F21", "F21");
		activityHash.put("F30", "F30");
		activityHash.put("F31", "F31");
		activityHash.put("F32", "F32");
		activityHash.put("F33", "F33");
		activityHash.put("F34", "F34");
		activityHash.put("F35", "F35");
		activityHash.put("F36", "F36");
		activityHash.put("F37", "F37");
		activityHash.put("F38", "F38");
		activityHash.put("G07", "G07");
		activityHash.put("G08", "G08");
		activityHash.put("G11", "G11");
		activityHash.put("G12", "G12");
		activityHash.put("G13", "G13");
		activityHash.put("G19", "G19");
		activityHash.put("G20", "G20");
		activityHash.put("G94", "G94");
		activityHash.put("H07", "H07");
		activityHash.put("H13", "H13");
		activityHash.put("H1N", "H1N");
		activityHash.put("H1S", "H1S");
		activityHash.put("H23", "H23");
		activityHash.put("H25", "H25");
		activityHash.put("H28", "H28");
		activityHash.put("H2N", "H2N");
		activityHash.put("H50", "H50");
		activityHash.put("H54", "H54");
		activityHash.put("H57", "H57");
		activityHash.put("H62", "H62");
		activityHash.put("H64", "H64");
		activityHash.put("H75", "H75");
		activityHash.put("H79", "H79");
		activityHash.put("H84", "H84");
		activityHash.put("H86", "H86");
		activityHash.put("H87", "H87");
		activityHash.put("HD1", "HD1");
		activityHash.put("HD4", "HD4");
		activityHash.put("HD5", "HD5");
		activityHash.put("HD7", "HD7");
		activityHash.put("HD8", "HD8");
		activityHash.put("HR1", "HR1");
		activityHash.put("HR2", "HR2");
		activityHash.put("HS1", "HS1");
		activityHash.put("HS2", "HS2");
		activityHash.put("HS4", "HS4");
		activityHash.put("HS5", "HS5");
		activityHash.put("HS6", "HS6");
		activityHash.put("I01", "I01");
		activityHash.put("I21", "I21");
		activityHash.put("IK1", "IK1");
		activityHash.put("IK2", "IK2");
		activityHash.put("IP1", "IP1");
		activityHash.put("K01", "K01");
		activityHash.put("K02", "K02");
		activityHash.put("K04", "K04");
		activityHash.put("K05", "K05");
		activityHash.put("K06", "K06");
		activityHash.put("K07", "K07");
		activityHash.put("K08", "K08");
		activityHash.put("K09", "K09");
		activityHash.put("K10", "K10");
		activityHash.put("K11", "K11");
		activityHash.put("K12", "K12");
		activityHash.put("K14", "K14");
		activityHash.put("K15", "K15");
		activityHash.put("K16", "K16");
		activityHash.put("K17", "K17");
		activityHash.put("K18", "K18");
		activityHash.put("K20", "K20");
		activityHash.put("K21", "K21");
		activityHash.put("K22", "K22");
		activityHash.put("K23", "K23");
		activityHash.put("K24", "K24");
		activityHash.put("K25", "K25");
		activityHash.put("K26", "K26");
		activityHash.put("K30", "K30");
		activityHash.put("K99", "K99");
		activityHash.put("KD1", "KD1");
		activityHash.put("KL1", "KL1");
		activityHash.put("KL2", "KL2");
		activityHash.put("KM1", "KM1");
		activityHash.put("L16", "L16");
		activityHash.put("L17", "L17");
		activityHash.put("L18", "L18");
		activityHash.put("L30", "L30");
		activityHash.put("L32", "L32");
		activityHash.put("L40", "L40");
		activityHash.put("L50", "L50");
		activityHash.put("L60", "L60");
		activityHash.put("M01", "M01");
		activityHash.put("N01", "N01");
		activityHash.put("N02", "N02");
		activityHash.put("N03", "N03");
		activityHash.put("N43", "N43");
		activityHash.put("N44", "N44");
		activityHash.put("P01", "P01");
		activityHash.put("P09", "P09");
		activityHash.put("P20", "P20");
		activityHash.put("P30", "P30");
		activityHash.put("P40", "P40");
		activityHash.put("P41", "P41");
		activityHash.put("P42", "P42");
		activityHash.put("P50", "P50");
		activityHash.put("P51", "P51");
		activityHash.put("P60", "P60");
		activityHash.put("P76", "P76");
		activityHash.put("PL1", "PL1");
		activityHash.put("PN1", "PN1");
		activityHash.put("PN2", "PN2");
		activityHash.put("R00", "R00");
		activityHash.put("R01", "R01");
		activityHash.put("R03", "R03");
		activityHash.put("R04", "R04");
		activityHash.put("R06", "R06");
		activityHash.put("R09", "R09");
		activityHash.put("R10", "R10");
		activityHash.put("R12", "R12");
		activityHash.put("R13", "R13");
		activityHash.put("R15", "R15");
		activityHash.put("R17", "R17");
		activityHash.put("R18", "R18");
		activityHash.put("R19", "R19");
		activityHash.put("R21", "R21");
		activityHash.put("R22", "R22");
		activityHash.put("R23", "R23");
		activityHash.put("R24", "R24");
		activityHash.put("R25", "R25");
		activityHash.put("R29", "R29");
		activityHash.put("R30", "R30");
		activityHash.put("R33", "R33");
		activityHash.put("R34", "R34");
		activityHash.put("R35", "R35");
		activityHash.put("R36", "R36");
		activityHash.put("R37", "R37");
		activityHash.put("R41", "R41");
		activityHash.put("R42", "R42");
		activityHash.put("R43", "R43");
		activityHash.put("R44", "R44");
		activityHash.put("R49", "R49");
		activityHash.put("R55", "R55");
		activityHash.put("R56", "R56");
		activityHash.put("R90", "R90");
		activityHash.put("RC1", "RC1");
		activityHash.put("RC2", "RC2");
		activityHash.put("RC3", "RC3");
		activityHash.put("RC4", "RC4");
		activityHash.put("RF1", "RF1");
		activityHash.put("RL1", "RL1");
		activityHash.put("RL2", "RL2");
		activityHash.put("RL5", "RL5");
		activityHash.put("RL9", "RL9");
		activityHash.put("RS1", "RS1");
		activityHash.put("S03", "S03");
		activityHash.put("S06", "S06");
		activityHash.put("S07", "S07");
		activityHash.put("S10", "S10");
		activityHash.put("S11", "S11");
		activityHash.put("S14", "S14");
		activityHash.put("S15", "S15");
		activityHash.put("S21", "S21");
		activityHash.put("S22", "S22");
		activityHash.put("SC1", "SC1");
		activityHash.put("SC2", "SC2");
		activityHash.put("SC3", "SC3");
		activityHash.put("SI2", "SI2");
		activityHash.put("T01", "T01");
		activityHash.put("T02", "T02");
		activityHash.put("T03", "T03");
		activityHash.put("T06", "T06");
		activityHash.put("T09", "T09");
		activityHash.put("T14", "T14");
		activityHash.put("T15", "T15");
		activityHash.put("T16", "T16");
		activityHash.put("T22", "T22");
		activityHash.put("T23", "T23");
		activityHash.put("T24", "T24");
		activityHash.put("T32", "T32");
		activityHash.put("T34", "T34");
		activityHash.put("T35", "T35");
		activityHash.put("T36", "T36");
		activityHash.put("T37", "T37");
		activityHash.put("T42", "T42");
		activityHash.put("T90", "T90");
		activityHash.put("TL1", "TL1");
		activityHash.put("TU2", "TU2");
		activityHash.put("U01", "U01");
		activityHash.put("U09", "U09");
		activityHash.put("U10", "U10");
		activityHash.put("U11", "U11");
		activityHash.put("U13", "U13");
		activityHash.put("U14", "U14");
		activityHash.put("U17", "U17");
		activityHash.put("U18", "U18");
		activityHash.put("U19", "U19");
		activityHash.put("U1A", "U1A");
		activityHash.put("U1B", "U1B");
		activityHash.put("U1Q", "U1Q");
		activityHash.put("U1S", "U1S");
		activityHash.put("U1V", "U1V");
		activityHash.put("U21", "U21");
		activityHash.put("U22", "U22");
		activityHash.put("U23", "U23");
		activityHash.put("U24", "U24");
		activityHash.put("U26", "U26");
		activityHash.put("U27", "U27");
		activityHash.put("U2G", "U2G");
		activityHash.put("U2R", "U2R");
		activityHash.put("U30", "U30");
		activityHash.put("U32", "U32");
		activityHash.put("U34", "U34");
		activityHash.put("U36", "U36");
		activityHash.put("U38", "U38");
		activityHash.put("U40", "U40");
		activityHash.put("U41", "U41");
		activityHash.put("U42", "U42");
		activityHash.put("U43", "U43");
		activityHash.put("U44", "U44");
		activityHash.put("U45", "U45");
		activityHash.put("U47", "U47");
		activityHash.put("U48", "U48");
		activityHash.put("U49", "U49");
		activityHash.put("U50", "U50");
		activityHash.put("U51", "U51");
		activityHash.put("U52", "U52");
		activityHash.put("U53", "U53");
		activityHash.put("U54", "U54");
		activityHash.put("U55", "U55");
		activityHash.put("U56", "U56");
		activityHash.put("U57", "U57");
		activityHash.put("U58", "U58");
		activityHash.put("U59", "U59");
		activityHash.put("U60", "U60");
		activityHash.put("U61", "U61");
		activityHash.put("U62", "U62");
		activityHash.put("U65", "U65");
		activityHash.put("U66", "U66");
		activityHash.put("U69", "U69");
		activityHash.put("U75", "U75");
		activityHash.put("U76", "U76");
		activityHash.put("U79", "U79");
		activityHash.put("U81", "U81");
		activityHash.put("U82", "U82");
		activityHash.put("U83", "U83");
		activityHash.put("U84", "U84");
		activityHash.put("U87", "U87");
		activityHash.put("U88", "U88");
		activityHash.put("U90", "U90");
		activityHash.put("U94", "U94");
		activityHash.put("U95", "U95");
		activityHash.put("U96", "U96");
		activityHash.put("U97", "U97");
		activityHash.put("U98", "U98");
		activityHash.put("UA1", "UA1");
		activityHash.put("UA5", "UA5");
		activityHash.put("UC1", "UC1");
		activityHash.put("UC2", "UC2");
		activityHash.put("UC3", "UC3");
		activityHash.put("UC4", "UC4");
		activityHash.put("UC6", "UC6");
		activityHash.put("UC7", "UC7");
		activityHash.put("UD1", "UD1");
		activityHash.put("UD3", "UD3");
		activityHash.put("UD5", "UD5");
		activityHash.put("UD6", "UD6");
		activityHash.put("UD7", "UD7");
		activityHash.put("UD8", "UD8");
		activityHash.put("UE1", "UE1");
		activityHash.put("UE2", "UE2");
		activityHash.put("UH1", "UH1");
		activityHash.put("UH2", "UH2");
		activityHash.put("UH3", "UH3");
		activityHash.put("UL1", "UL1");
		activityHash.put("UM1", "UM1");
		activityHash.put("UP5", "UP5");
		activityHash.put("UR1", "UR1");
		activityHash.put("UR3", "UR3");
		activityHash.put("UR6", "UR6");
		activityHash.put("UR8", "UR8");
		activityHash.put("US3", "US3");
		activityHash.put("US4", "US4");
		activityHash.put("UT1", "UT1");
		activityHash.put("UT2", "UT2");
		activityHash.put("Ul1", "Ul1");
		activityHash.put("VF1", "VF1");
		activityHash.put("X01", "X01");
		activityHash.put("X02", "X02");
		activityHash.put("X06", "X06");
		activityHash.put("X98", "X98");
		activityHash.put("X99", "X99");
		activityHash.put("Y01", "Y01");
		activityHash.put("Y02", "Y02");
		activityHash.put("Z01", "Z01");
		activityHash.put("Z02", "Z02");
		activityHash.put("ZIA", "ZIA");
		activityHash.put("ZIB", "ZIB");
		activityHash.put("ZIC", "ZIC");
		activityHash.put("ZID", "ZID");
		activityHash.put("ZIE", "ZIE");
		activityHash.put("ZIF", "ZIF");
		activityHash.put("ZIG", "ZIG");
		activityHash.put("ZIH", "ZIH");
		activityHash.put("ZII", "ZII");
		activityHash.put("ZIJ", "ZIJ");
		activityHash.put("ZIK", "ZIK");
		
		instituteHash.put("AA", "AA");
		instituteHash.put("AD", "AD");
		instituteHash.put("AE", "AE");
		instituteHash.put("AG", "AG");
		instituteHash.put("AH", "AH");
		instituteHash.put("AI", "AI");
		instituteHash.put("AM", "AM");
		instituteHash.put("AO", "AO");
		instituteHash.put("AR", "AR");
		instituteHash.put("AT", "AT");
		instituteHash.put("BA", "BA");
		instituteHash.put("BB", "BB");
		instituteHash.put("BC", "BC");
		instituteHash.put("BD", "BD");
		instituteHash.put("BE", "BE");
		instituteHash.put("BF", "BF");
		instituteHash.put("BG", "BG");
		instituteHash.put("BH", "BH");
		instituteHash.put("BI", "BI");
		instituteHash.put("BJ", "BJ");
		instituteHash.put("BK", "BK");
		instituteHash.put("BL", "BL");
		instituteHash.put("BM", "BM");
		instituteHash.put("BN", "BN");
		instituteHash.put("BO", "BO");
		instituteHash.put("BP", "BP");
		instituteHash.put("BQ", "BQ");
		instituteHash.put("BR", "BR");
		instituteHash.put("BS", "BS");
		instituteHash.put("BT", "BT");
		instituteHash.put("BU", "BU");
		instituteHash.put("BX", "BX");
		instituteHash.put("CA", "CA");
		instituteHash.put("CB", "CB");
		instituteHash.put("CC", "CC");
		instituteHash.put("CD", "CD");
		instituteHash.put("CE", "CE");
		instituteHash.put("CH", "CH");
		instituteHash.put("CI", "CI");
		instituteHash.put("CK", "CK");
		instituteHash.put("CL", "CL");
		instituteHash.put("CM", "CM");
		instituteHash.put("CN", "CN");
		instituteHash.put("CO", "CO");
		instituteHash.put("CP", "CP");
		instituteHash.put("CT", "CT");
		instituteHash.put("CX", "CX");
		instituteHash.put("DA", "DA");
		instituteHash.put("DC", "DC");
		instituteHash.put("DD", "DD");
		instituteHash.put("DE", "DE");
		instituteHash.put("DH", "DH");
		instituteHash.put("DK", "DK");
		instituteHash.put("DP", "DP");
		instituteHash.put("DS", "DS");
		instituteHash.put("EB", "EB");
		instituteHash.put("EH", "EH");
		instituteHash.put("EP", "EP");
		instituteHash.put("ES", "ES");
		instituteHash.put("EY", "EY");
		instituteHash.put("FD", "FD");
		instituteHash.put("FP", "FP");
		instituteHash.put("GD", "GD");
		instituteHash.put("GH", "GH");
		instituteHash.put("GM", "GM");
		instituteHash.put("HB", "HB");
		instituteHash.put("HC", "HC");
		instituteHash.put("HD", "HD");
		instituteHash.put("HG", "HG");
		instituteHash.put("HH", "HH");
		instituteHash.put("HI", "HI");
		instituteHash.put("HK", "HK");
		instituteHash.put("HL", "HL");
		instituteHash.put("HM", "HM");
		instituteHash.put("HO", "HO");
		instituteHash.put("HP", "HP");
		instituteHash.put("HR", "HR");
		instituteHash.put("HS", "HS");
		instituteHash.put("HV", "HV");
		instituteHash.put("HX", "HX");
		instituteHash.put("IP", "IP");
		instituteHash.put("IS", "IS");
		instituteHash.put("JT", "JT");
		instituteHash.put("LM", "LM");
		instituteHash.put("MB", "MB");
		instituteHash.put("MD", "MD");
		instituteHash.put("MH", "MH");
		instituteHash.put("MN", "MN");
		instituteHash.put("NC", "NC");
		instituteHash.put("NR", "NR");
		instituteHash.put("NS", "NS");
		instituteHash.put("NU", "NU");
		instituteHash.put("OC", "OC");
		instituteHash.put("OD", "OD");
		instituteHash.put("OH", "OH");
		instituteHash.put("PC", "PC");
		instituteHash.put("PE", "PE");
		instituteHash.put("PH", "PH");
		instituteHash.put("PR", "PR");
		instituteHash.put("PS", "PS");
		instituteHash.put("RG", "RG");
		instituteHash.put("RR", "RR");
		instituteHash.put("RS", "RS");
		instituteHash.put("RX", "RX");
		instituteHash.put("SC", "SC");
		instituteHash.put("SH", "SH");
		instituteHash.put("SM", "SM");
		instituteHash.put("SO", "SO");
		instituteHash.put("SP", "SP");
		instituteHash.put("TI", "TI");
		instituteHash.put("TP", "TP");
		instituteHash.put("TR", "TR");
		instituteHash.put("TS", "TS");
		instituteHash.put("TW", "TW");
		instituteHash.put("VA", "VA");
		instituteHash.put("WC", "WC");
		instituteHash.put("WH", "WH");
		
		System.out.println("\n\t\t*** nih predicates loaded! ***\n");
	}
	
	private static Pattern awardPattern = Pattern.compile("([1-9]?)[\\- ]*([A-Z0-9][A-Z0-9][A-Z0-9])?[\\- ]*([A-Z][A-Z])[\\- ]*([0-9]+)[\\- ]*([0-9]*)[\\- ]*([A][0-9])?[\\- ]*([S][0-9])?");
	
	private static String match(String source, int position) {
		if (source == null)
			return null;
		Matcher theMatcher = awardPattern.matcher(source);
		if (theMatcher.matches()) {
			if ((theMatcher.group(2) != null && !activityHash.containsKey(theMatcher.group(2))) || !instituteHash.containsKey(theMatcher.group(3)) || theMatcher.group(4) == null || theMatcher.group(4).length() > 6)
					return null;
			else
				return theMatcher.group(position);
		} else
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
		return matches(grant1, grant2, 2);
	}
	
	public static boolean matches(String grant1, String grant2, int level) {
		String institute1 = institute(grant1);
		String institute2 = institute(grant2);
		Integer serialNumber1 = serialNumber(grant1);
		Integer serialNumber2 = serialNumber(grant2);
		Integer awardYear1 = year(grant1);
		Integer awardYear2 = year(grant2);

		if ((institute1 == null || !institute1.equals(institute2)) || serialNumber1 == null || serialNumber2 == null || serialNumber1.intValue() != serialNumber2.intValue())
			return false;
		if (level == 1)
			return true;
		if (awardYear1 == null || awardYear2 == null || awardYear1.intValue() != awardYear2.intValue())
			return false;
		return true;
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
