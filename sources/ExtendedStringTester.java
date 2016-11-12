//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// File Name:		ExtendedStringTester.java																											//
// Author: 			Ethan Morisette																														//
// Description:		a program that tests the ExtendedString class 																						//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Map;
import java.util.HashMap;

public class ExtendedStringTester {
	public static void main(String[] args) {
		// countMatches() tests
		System.out.println("Testing countMatches()");
		System.out.println("======================");
		testCountMatches(1);
		testCountMatches(2);
		System.out.println("");

		// indexOf() tests
		System.out.println("Testing indexOf()");
		System.out.println("======================");
		testIndexOf(1);
		testIndexOf(2);
		testIndexOf(3);
		System.out.println("");
		
		// substring() tests
		System.out.println("Testing substring()");
		System.out.println("======================");
		testSubstring(1);
		System.out.println("");
		
		// getCharacterMap() tests
		System.out.println("Testing getCharacterMap()");
		System.out.println("======================");
		testGetCharacterMap(1);
		System.out.println("");
		
		// getTopCharacters() tests
		System.out.println("Testing getTopCharacters()");
		System.out.println("======================");
		testGetTopCharacters(1);
		testGetTopCharacters(2);
		System.out.println("");
	}

	private static void testCountMatches(int testNumber) {
		ExtendedString 		extendedString 		= 	new ExtendedString("Hello my name is Ethan. Ethan is my name. How many times does Ethan occur? Will you play this game?");
		Integer 			numOfMatches 		= 	0;

		switch (testNumber) {
			// CASE 1: user enters a substring that occurs multiple times in the string data
			case 1:
				numOfMatches = extendedString.countMatches("Ethan");
				System.out.println("Actual: numOfMatches = " + numOfMatches + " | " + "Expected: numOfMatches = " + 3);
				break;
			// CASE 2: user enters a single character (as a String)
			case 2:
				numOfMatches = extendedString.countMatches("a");
				System.out.println("Actual: numOfMatches = " + numOfMatches + " | " + "Expected: numOfMatches = " + 8);
				break;
		}
	}

	private static void testIndexOf(int testNumber) {
		ExtendedString 		extendedString 		= 	new ExtendedString("Hello my name is Ethan. Ethan is my name. How many times does Ethan occur? Will you play this game?");
		int 				index 				= 	0;

		switch (testNumber) {
			// CASE 1: user enters a substring that occurs only once in the string data
			case 1:
				index = extendedString.indexOf("How");
				System.out.println("Actual: index = " + index + " | " + "Expected: index = " + 42);
				break;
			// CASE 2: user enters a substring that occurs multiple times in string data (should only return index of first)
			case 2: 
				index = extendedString.indexOf("Ethan");
				System.out.println("Actual: index = " + index + " | " + "Expected: index = " + 17);
				break;
			// CASE 3: user enters a substring that occurs in the string data and a starting index to start searching from
			case 3:
				index = extendedString.indexOf("Ethan", 20);
				System.out.println("Actual: index = " + index + " | " + "Expected: index = " + 24);
				break;

		}
	}

	public static void testSubstring(int testNumber) {
		ExtendedString 		extendedString 		= 	new ExtendedString("Hello my name is Ethan. Ethan is my name. How many times does Ethan occur? Will you play this game?");
		String 				string;

		switch (testNumber) {
			// CASE 1: standard case
			case 1:
				string = extendedString.substring(17, 22);
				System.out.println("Actual: string = \"" + string + "\" | " + "Expected: string = " + "\"Ethan\"");
				break;
		}
	}

	private static void testGetCharacterMap(int testNumber) {
		ExtendedString 				extendedString 		= 	new ExtendedString("Hello my name is Ethan.");
		Integer 					numOfMatches 		= 	0;
		Map<Character, Integer> 	characterMap 		= 	new HashMap<Character, Integer>();

		switch (testNumber) {
			// CASE 1: standard case
			case 1:
				characterMap = extendedString.getCharacterMap();
				System.out.println("Actual: characterMap = " + characterMap + " | Expected: characterMap = " + "{ =4, a=2, e=3, h=2, i=1, l=2, m=2, n=2, .=1, o=1, s=1, t=1, y=1}");
				break;
		}
	}

	private static void testGetTopCharacters(int testNumber) {
		ExtendedString 				extendedString 		= 	new ExtendedString("Hello my name is Ethan.");
		Map<Character, Integer> 	topCharactersMap 	= 	new HashMap<Character, Integer>();

		switch (testNumber) {
			// CASE 1: standard case
			case 1:
				topCharactersMap = extendedString.getTopCharacters(3);
				System.out.println("Actual: characterMap = " + topCharactersMap + " | Expected: characterMap = " + "{a=2, e=3, h=2}");
				break;
			// CASE 2: user asks for more top entries then there are in the characters in the string data	
			case 2:
				topCharactersMap = extendedString.getTopCharacters(15);
				System.out.println("Actual: characterMap = " + topCharactersMap + " | Expected: characterMap = " + "{a=2, e=3, h=2, i=1, l=2, m=2, n=2, o=1, s=1, t=1, y=1}");
				break;
		}

	}
}