//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// File Name:		ExtendedStringTester.java																											//
// Author: 			Ethan Morisette																														//
// Description:		a program that tests the ExtendedString class 																						//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ExtendedStringTester {
	public static void main(String[] args) {
		testCountMatches(1);
		testCountMatches(2);
		testIndexOf(1);
		testIndexOf(2);
		testIndexOf(3);
		testSubstring(1);
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

	// private static void testGetMostCommonCharacterFromSet(int testNumber) {
	// 	ExtendedString extendedString = new ExtendedString("Hello my name is Ethan. Ethan is my name. How many times does Ethan occur? Will you play this game?");
	// 	Integer numOfMatches = 0;
	// 	Map<Character, int> characterMap = new HashMap<Character, int>();

	// 	switch (testNumber) {
	// 		case 1:
	// 			Set<char> characterSet = new HashSet<char>();
	// 			characterSet.add('a');
	// 			characterSet.add('b');
	// 			characterMap = extendedString.getMostCommonCharacterFromSet(characterSet);

	// 			for ()
	// 			System.out.println("Actual: Character = " + characterEntry.getKey() + ", Count = " + characterEntry.getValue() + " | Expected: Character = a, Count = 8");
	// 			break;
	// 		case 2:
	// 			break; 
	// 	}
	// }
}