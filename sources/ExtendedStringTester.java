//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// File Name:		ExtendedStringTester.java																											//
// Author: 			Ethan Morisette																														//
// Description:		a program that tests the ExtendedString class 																						//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Map;
import java.util.HashMap;

public class ExtendedStringTester {
	public static void main(String[] args) {
		testCountMatches(1);
		testCountMatches(2);
		testIndexOf(1);
		testIndexOf(2);
		testIndexOf(3);
		testSubstring(1);
		testGetCharacterMap(1);
		testGetTopCharacters(1);
		testGetTopCharacters(2);
	}

	private static void testCountMatches(int testNumber) {
		ExtendedString extendedString = new ExtendedString("Hello my name is Ethan. Ethan is my name. How many times does Ethan occur? Will you play this game?");
		Integer numOfMatches = 0;

		System.out.println("Testing countMatches()");
		System.out.println("======================");

		switch (testNumber) {
			case 1:
				numOfMatches = extendedString.countMatches("Ethan");
				System.out.println("Actual: " + numOfMatches + " | " + "Expected: " + 3);
				break;
			case 2:
				numOfMatches = extendedString.countMatches("a");
				System.out.println("Actual: " + numOfMatches + " | " + "Expected: " + 8);
				break;
		}

		System.out.println("");
	}

	private static void testIndexOf(int testNumber) {
		ExtendedString extendedString = new ExtendedString("Hello my name is Ethan. Ethan is my name. How many times does Ethan occur? Will you play this game?");
		int index = 0;

		System.out.println("Testing indexOf()");
		System.out.println("======================");

		switch (testNumber) {
			case 1:
				index = extendedString.indexOf("How");
				System.out.println("Actual: " + index + " | " + "Expected: " + 42);
				break;
			case 2: 
				index = extendedString.indexOf("Ethan");
				System.out.println("Actual: " + index + " | " + "Expected: " + 17);
				break;
			case 3:
				index = extendedString.indexOf("Ethan", 20);
				System.out.println("Actual: " + index + " | " + "Expected: " + 24);
				break;

		}

		System.out.println("");
	}

	public static void testSubstring(int testNumber) {
		ExtendedString extendedString = new ExtendedString("Hello my name is Ethan. Ethan is my name. How many times does Ethan occur? Will you play this game?");
		String string;

		System.out.println("Testing substring()");
		System.out.println("======================");


		switch (testNumber) {
			case 1:
				string = extendedString.substring(17, 22);
				System.out.println("Actual: \"" + string + "\" | " + "Expected: " + "\"Ethan\"");
				break;
		}

		System.out.println("");
	}

	private static void testGetCharacterMap(int testNumber) {
		ExtendedString extendedString = new ExtendedString("Hello my name is Ethan.");
		Integer numOfMatches = 0;
		Map<Character, Integer> characterMap = new HashMap<Character, Integer>();

		switch (testNumber) {
			case 1:
				characterMap = extendedString.getCharacterMap();
				System.out.println("Actual: characterMap = " + characterMap + " | Expected: characterMap = " + "{ =4, a=2, e=3, h=2, i=1, l=2, m=2, n=2, .=1, o=1, s=1, t=1, y=1}");
				break;
		}
	}

	private static void testGetTopCharacters(int testNumber) {
		ExtendedString extendedString = new ExtendedString("Hello my name is Ethan.");
		Map<Character, Integer> topCharactersMap = new HashMap<Character, Integer>();

		switch (testNumber) {
			case 1:
				topCharactersMap = extendedString.getTopCharacters(3);
				System.out.println("Actual: characterMap = " + topCharactersMap + " | Expected: characterMap = " + "{a=2, e=3, h=2}");
				break;
			case 2:
				topCharactersMap = extendedString.getTopCharacters(15);
				System.out.println("Actual: characterMap = " + topCharactersMap + " | Expected: characterMap = " + "{a=2, e=3, h=2, i=1, l=2, m=2, n=2, o=1, s=1, t=1, y=1}");
				break;
		}

	}
}