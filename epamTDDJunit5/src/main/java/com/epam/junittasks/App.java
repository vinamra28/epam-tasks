package com.epam.junittasks;


public class App {
    
	/**
	 * Program to remove A from first two Characters of String if present
	 * 
	 * @param {String}
	 * @return {String}
	 */
	
	public String removeAChars(String str) {
    	
		if(str.length()<=2) {
    		return str.replaceAll("[aA]+", "");
    	}else {
    		String firstTwoChars = str.substring(0,2).replaceAll("[aA]+", "");
    		return firstTwoChars+str.substring(2);
    	}
    }
}
