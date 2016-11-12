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
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {
	final static String URL = "https://banno.com/";
	
	public static void main(String[] args) throws Exception {
		ExtendedString entityString;
		int matches;
		String twitterHandle;
		Map<Character, Integer> topCharactersMap = new HashMap<Character, Integer>();

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
		topCharactersMap = entityString.getTopCharacters(3);
		System.out.println("Top 3 occurring alphanumeric characters...");
		for (Map.Entry<Character, Integer> entry : topCharactersMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		// 5. find the number of .png images
		matches = entityString.countMatches(".png");
		System.out.println("Number of PNG images: " + matches);

		// 6. find Twitter handle
		twitterHandle = getTwitterHandle(entityString);
		System.out.println("Twitter handle: " + twitterHandle);

		// 7. find the number of times "fincancial institution" occur
		matches = entityString.countMatches("financial institution");
		System.out.println("Number of times \"financial institution\" occurs: " + matches);
	}

	/** 
	 ** Extracts the twitter handle from the retrieved HTML document.
	 ** @param input The HTML document given as a string.
	 ** @return The twitter handle as a string.
	 */
	private static String getTwitterHandle(ExtendedString input) {
		int 		twitterIndexStart;
		int 		twitterIndexEnd;
		String 		twitterURL;
		String 		twitterHandle;

		// 1. get the starting and ending index of the full twitter URL (the handle is the suffix of this)
		twitterIndexStart = input.indexOf("\"https://twitter.com/");
		twitterIndexEnd = input.indexOf("\"", twitterIndexStart + 1);

		// 2. get the URL substring
		twitterURL = input.substring(twitterIndexStart + 1, twitterIndexEnd);

		// 3. get the twitter handle
		twitterHandle = twitterURL.substring("https://twitter.com/".length());

		return twitterHandle;
	}
}