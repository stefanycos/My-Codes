package br.com.souza.solutions.mongodb.demo.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateFormatterUtils {

	private DateFormatterUtils() {
	}

	public static LocalDateTime getDateWithMaxTime(LocalDateTime date) {
		return date.toLocalDate().atTime(LocalTime.MAX);
	}

	public static LocalDateTime getDateWithMinTime(LocalDateTime date) {
		return date.toLocalDate().atTime(LocalTime.MIN);
	}

}
