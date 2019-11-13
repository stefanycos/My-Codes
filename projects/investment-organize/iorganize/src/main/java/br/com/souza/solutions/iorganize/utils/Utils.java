package br.com.souza.solutions.iorganize.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

	public static LocalDateTime getDateFromString(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
		return LocalDateTime.parse(date, formatter);
	}
	
	public static String encodePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}

}
