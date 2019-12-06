package com.queue.demo.web.rest.header;

import java.nio.charset.Charset;
import java.util.Base64;

public class BasicAuthRequest {

	private BasicAuthRequest() {
	}

	public static String generateBasicAuth(String username, String password) {
		byte[] userCredentials = (username + ":" + password).getBytes(Charset.defaultCharset());
		return "Basic " + base64Encode(userCredentials);
	}

	private static String base64Encode(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}

}
