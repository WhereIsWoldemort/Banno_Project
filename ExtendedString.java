//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// File Name:		ExtendedString.java																													//
// Author: 			Ethan Morisette																														//
// Description:		a program that fetches and parses banno.com's web page																				//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ExtendedString {

	String data;

	public ExtendedString() {
		this.data = "";
	}

	/**
	 ** @param data The string data for this String wrapper. 
	 */
	public ExtendedString(String data) {
		this.data = data;
	}

	/**
	 ** Count the number of times the given regex string occurs in ExtendedString instance.
	 ** @param regexString Regex string to be counted.
	 ** @return The number of times the regex string occurs in the ExtendedString instance.
	 */
	public int countMatches(String regexString) {
		Pattern 	regexPattern 	= 		Pattern.compile(regexString);
		Matcher 	regexMatcher 	= 		regexPattern.matcher(this.data);
		int 		matches 		= 		0;

		while (regexMatcher.find()) {
			matches++;
		}

		return matches;
	}

	public int indexOf(String stringToFind) {
		int index = 0;

		index = this.data.indexOf(stringToFind);
		return index;
	}

	public int indexOf(String stringToFind, int startingIndex) {
		int index = 0;

		index = this.data.indexOf(stringToFind, startingIndex);
		return index;
	}

	public String substring(int startingIndex, int endingIndex) {
		String string; 

		string = this.data.substring(startingIndex, endingIndex);
		return string;
	}

	/** Analyzes the string to find the most common characters in this string that belong to the given character set.
	 ** @param characterSet The set of characters to count in the string.
	 ** @return A map that contains the most common character and the number of times it occurs.
	 */
	// public Map<Character, int> getMostCommonCharacterFromSet(Set<Character> characterSet) {
	// 	Character character;
	// 	Iterator iterator = characterSet.iterator();
	// 	int matches = 0;
	// 	Character highestKey;
	// 	int highestValue = 0;
	// 	Map<Character, int> characterMap = new HashMap<Character, int>();

	// 	while (iterator.hasNext()) {
	// 		character = iterator.next();

	// 		matches = this.countMatches(character.toString());

	// 		if (matches > maxMatches) {
	// 			highestKey = character;
	// 			highestValue = matches;
	// 		}
	// 	}

	// 	characterMap.put(highestKey, highestValue);

	// 	return characterMap;
	// }
}