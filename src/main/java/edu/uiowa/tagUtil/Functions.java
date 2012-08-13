package edu.uiowa.tagUtil;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;

/**
 * @author rrlorent
 * @since July 11, 2012
 * $Date$: Date of last commit
 */
public class Functions {

	public static void main(String[] args){
		System.out.println(capitalize("hello world."));
	}
	
	/**
	 * @param string - string to capitalize first letter of each word and make others lower case
	 * @return
	 */
	public static String capitalize(String string){
		String newString = "";
		if(string != null){
			string = string.trim();
			char[] arr = string.toCharArray();
			for(int i=0;i<arr.length;i++){
				if(i == 0 || (i > 0  && ' ' == arr[i-1])){
					newString += String.valueOf(arr[i]).toUpperCase(); 
				}else{
					newString += String.valueOf(arr[i]).toLowerCase(); 	
				}
				
			}
		}else{
			return null;
		}
		return newString;
	}
	
	public static String replaceIgnoreCase(String string, String replace, String with){
		return string.replaceAll("(?i)"+replace, with);
	}
	
	/**
	 * @param html - string containing html 
	 * @return
	 */
	public static String removeHTML(String html){
		return Jsoup.parse(html).text();
	}
	
	/**
	 * @param html - string containing html 
	 * @param limit - max length of string to return 
	 * @return
	 */
	public static String removeHTMLandTrim(String html, Integer limit){
		if(html != null){
			html = Jsoup.parse(html).text();
			if(html.length()>limit && limit > 0){
				html = html.substring(0, limit-1);
			}
		}
		return html;
	}

	/**
	 * @param string_to_split
	 * @param splitter
	 * @return
	 */
	public static String[] split(String string_to_split, String splitter){
		return StringUtils.split(string_to_split, splitter);
	}
	
	/**
	 * @param string_one
	 * @param string_two
	 * @return
	 */
	public static Boolean equals(String string_one, String string_two){
		return StringUtils.equalsIgnoreCase(string_one, string_one);
	}
	
}