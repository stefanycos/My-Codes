package br.com.souza.solutions.iorganize.utils;

import br.com.souza.solutions.iorganize.commons.Constants;

public class Utils {
	
	private Utils() {
	}
	
	public static String getStatusDescription(boolean status) {
		return status ? Constants.ACTIVE : Constants.INACTIVE;
	}
	
	public static boolean getStatusValue(String status) {
		return status.equalsIgnoreCase(Constants.ACTIVE);
	}

}
