//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// File Name:		Main.java																															//
// Author: 			Ethan Morisette																														//
// Description:		a program that fetches and parses banno.com's web page																				//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class Main {
	final static String URL = "https://banno.com/";
	
	public static void main(String[] args) throws Exception {
		ExtendedString entityString;
		int matches = 0;
		int twitterIndexStart = 0;
		int twitterIndexEnd = 0;
		String twitterHandle = "";
		Map<Character, Integer> finalMap = new HashMap<Character, Integer>();

		// 1. create the client
		CloseableHttpClient httpclient = HttpClients.createDefault();

		
		// 2. request web page for banno.com 
		try {
			HttpGet request = new HttpGet(URL);
			CloseableHttpResponse response = httpclient.execute(request);	

			// A. get the entity from the response	
			try {
				HttpEntity entity = response.getEntity();
				entityString = new ExtendedString(EntityUtils.toString(entity));
			} finally {
				response.close();
			}

		} finally {
			httpclient.close();
		}

		// 3. find the number of platform features offered
		matches = entityString.countMatches("platform-feature");
		System.out.println("Number of platform features: " + matches);

		// 4. find the top three occurring alphanumeric characters
		// finalMap = getCharacterMap(entityString);
		// System.out.println("Most common alphanumeric characters:");
		// for (Map.Entry<Character, Integer> entry : finalMap.entrySet()) {
		// 	System.out.print(entry.getKey());
		// 	System.out.print(": ");
		// 	System.out.println(entry.getValue());	
		// }

		// 5. find the number of .png images
		matches = entityString.countMatches(".png");
		System.out.println("Number of PNG images: " + matches);

		// 6. find Twitter handle
		twitterIndexStart = entityString.indexOf("\"https://twitter.com/");
		twitterIndexEnd = entityString.indexOf("\"", twitterIndexStart + 1);

		String twitterURL = entityString.substring(twitterIndexStart + 1, twitterIndexEnd);

		twitterHandle = twitterURL.substring("https://twitter.com/".length());
		System.out.println("Twitter Handle: " + twitterHandle);

		// 7. find the number of times "fincancial institution" occur

		matches = entityString.countMatches("financial institution");
		System.out.println("Number of times \"financial institution\" occurs: " + matches);

		// getCharacterMap(entityString);

	}

	// private static int countMatches(String regexString, String input) {
	// 	Pattern regexPattern = Pattern.compile(regexString);
	// 	Matcher regexMatcher = regexPattern.matcher(input);
	// 	int matches = 0;

	// 	while (regexMatcher.find()) {
	// 		matches++;
	// 	}

	// 	return matches;
	// }

	private static String getTwitterHandle(String input) {
		return null;
	}

	private static Map<Character, Integer> getCharacterMap(String input) {
		Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
		Map<Character, Integer> finalMap = new HashMap<Character, Integer>();
		Integer currentIndex = 0;

		// 1. make a Map of all characters and number of times they occur 
		for (int i = 0; i < input.length(); i++) {
			Character character = input.charAt(i);
			
			currentIndex = characterMap.putIfAbsent(character, 1);

			if (currentIndex != null) {
				characterMap.put(character, currentIndex + 1);
			}
		}

		// 2. find the top three occurring entries in the above character map
		for (int i = 0; i < 3; i++) {	
			Character largestKey = null;
			Integer largestValue = 0;

			for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
				Character key = entry.getKey();
				Integer value = entry.getValue();

				if ((value > largestValue) && (Character.isLetterOrDigit(key))) {
					largestValue = value;
					largestKey = key;
				}
			}
			characterMap.remove(largestKey);
			finalMap.put(largestKey, largestValue);
		}	

		return finalMap;
	}
}