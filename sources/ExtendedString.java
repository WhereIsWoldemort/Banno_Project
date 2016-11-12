//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// File Name:		ExtendedString.java																													//
// Author: 			Ethan Morisette																														//
// Description:		a program that fetches and parses banno.com's web page																				//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ExtendedString {

	String data; // holds the main string data to be

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
		Pattern 	regexPattern 	= 	Pattern.compile(regexString);
		Matcher 	regexMatcher 	= 	regexPattern.matcher(this.data);
		int 		matches 		= 	0;

		while (regexMatcher.find()) {
			matches++;
		}

		return matches;
	}

	/**
	 ** A method wrapper for the indexOf(String) method of the String class.
	 ** @param stringToFind The substring to find the index of. 
	 ** @return The index of the first occurrence of the given substring.
	 */
	public int indexOf(String stringToFind) {
		int index = 0;

		index = this.data.indexOf(stringToFind);
		return index;
	}

	/**
	 ** A method wrapper for the indexOf(String, int) method of the String class.
	 ** @param stringToFind The substring to find the index of. 
	 ** @param startingIndex The starting index of where the indexOf search should start.
	 ** @return The index of the first occurrence of the given substring.
	 */
	public int indexOf(String stringToFind, int startingIndex) {
		int index = 0;

		index = this.data.indexOf(stringToFind, startingIndex);
		return index;
	}

	/**
	 ** A method wrapper for the substring(int, int) method of the String class.
	 ** @param startingIndex The starting index of the substring to be extracted. 
	 ** @param endingIndex The ending index of the substring to be extracted.
	 ** @return The substring indicated by the starting and ending index.
	 */
	public String substring(int startingIndex, int endingIndex) {
		String string; 

		string = this.data.substring(startingIndex, endingIndex);
		return string;
	}

	/** Generates a map of all characters contained in the string data and how many times they occur.
	 ** @return A map of all characters in the string data.
	 */
	public Map<Character, Integer> getCharacterMap() {
		Character 					character;
		String 						lowerCaseData;
		Map<Character, Integer> 	characterMap 	= 	new HashMap<Character, Integer>();
		Integer 					numOfMatches 	= 	0;


		// 1. make the character map
		for (int i = 0; i < this.data.length(); i++) {
			lowerCaseData = data.toLowerCase();

			// A. get the character at index i
			character = lowerCaseData.charAt(i);

			// B. if the character isn't a key in the character map, add it with a count of 1; otherwise, increment the current value
			if ((characterMap.putIfAbsent(character, 1)) != null) {
				numOfMatches = characterMap.get(character) + 1;
				characterMap.replace(character, numOfMatches);
			}

		}

		return characterMap;
	}

	/** 
	 ** Extracts the twitter handle from the retrieved HTML document.
	 ** @param numberOfEntries The number of entries to get the top values of.
	 ** @return A map containing the top numberOfEntries characters and their values in the string data.
	 */
	public Map<Character, Integer> getTopCharacters(int numberOfEntries) {
		Integer 					bestValue;
		Character 					bestKey; 	
		Integer 					value;
		Character 					key;
		Map<Character, Integer> 	topCharactersMap 	= 	new HashMap<Character, Integer>();
		Map<Character, Integer> 	characterMap 		= 	new HashMap<Character, Integer>();
		ArrayList<Character> 		keysToRemove 		= 	new ArrayList<Character>();

		characterMap = this.getCharacterMap();

		// 1. remove all non-alphanumeric characters from the map
		for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
			key = entry.getKey();

			if (!Character.isLetterOrDigit(key)) {
				keysToRemove.add(key);
			}
		}

		for (int i = 0; i < keysToRemove.size(); i++) {
			characterMap.remove(keysToRemove.get(i));
		}

		// 2. put an upper bound on the number of entries that can be picked
		if (numberOfEntries > characterMap.size()) {
			numberOfEntries = characterMap.size();
		}

		// 3. get the top numberOfEntries characters and their values and put them into a map to be returned
		for (int i = 0; i < numberOfEntries; i++) {
			bestValue = 0;
			bestKey = null;
			for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
				key = entry.getKey();
				value = entry.getValue();

				if ((value > bestValue)){
					bestValue = value;
					bestKey = key;
				}
			}

			// we remove the largest key chosen from the map, so we don't pick it again
			characterMap.remove(bestKey);
			topCharactersMap.put(bestKey, bestValue);
		}

		return topCharactersMap;
	}
}