/* 
 * Kenny Miller
 * CIS 1068
 * Summer 2022
 * 
 * This program reads the script of Jaws from an input file
 * translates the text to a Southie accent and outputs the
 * text to a separate output file 
 */

// Imports
import java.io.*;
import java.util.Scanner;

public class Southie {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Initialize new file in scanner
		
		Scanner input = new Scanner(new File("./jaws_input.txt"));
		PrintStream output = new PrintStream(new File("./jaws_output.txt"));
		
		// Scan all lines
		
		while (input.hasNext()) {
			String line = input.nextLine();
			
			// Check exceptions
			// If 'r' at end of word preceded by "ee" or 'i', replace 'r' with "yah"
			// If 'r' at end of word preceded by "oo", replace 'r' with "wah"
			line = exceptions(line);
			
			// Check for 'r' or 'R' after vowel, replace with 'h' or 'H'
			line = checkForR(line);
			
			// If word ends in 'a', append 'r',
			line = appendR(line);
			
			// Replace "very" with "wicked"
			line = line.replaceAll("very", "wicked");
			line = line.replaceAll("VERY", "WICKED");
			
			// Print line to `jaws_output.txt`
			output.println(line);
		}
		
	/* 
	 * END OF MAIN
	 */
	}
	
	// METHODS
		
	// Check for 'r' preceded by vowel
	public static String checkForR(String line) {
		String newLine = "";
		char placeholder = ' ';
		for (int i = 0; i < line.length(); i++) {
			if (i != 0 && 
				checkForVowels(line.charAt(i - 1)) && 
				line.charAt(i) == 'r') {
				placeholder = 'h';
			} else if (i != 0 && 
					   checkForVowels(line.charAt(i - 1)) && 
					   line.charAt(i) == 'R') {
				placeholder = 'H';  
			} else {
				placeholder = line.charAt(i);
			}
			newLine += placeholder;
		}
		return newLine;
	}
	
	// Check for vowels
	public static boolean checkForVowels(char c) {
		char[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
		for (int i = 0; i < vowels.length; i++) {
			if (c == vowels[i]) {
				return true;
			}
		}
		return false;
	}
	
	// Append 'r' or 'R' to words that end in 'a' or 'A' (not word "a") and do not apply to `checkForR` method
	public static String appendR(String line) {
		String newLine = "";
	
		for (int i = 0; i < line.length(); i++) {
			if ((i != line.length() - 1 &&
				 i != 0) && 
				line.charAt(i) == 'a' && 
			   (line.charAt(i + 1) == ' ' || 
			    checkPunct(line.charAt(i + 1))) && 
			    line.charAt(i - 1) != ' ') {
				newLine += line.charAt(i);
				newLine += 'r';
			} else if ((i != line.length() - 1 &&
					   i != 0) && 
					   line.charAt(i) == 'A' && 
					  (line.charAt(i + 1) == ' ' || 
					   checkPunct(line.charAt(i + 1))) && 
					   line.charAt(i - 1) != ' ') {
				newLine += line.charAt(i);
				newLine += 'R';
			} else if (i == line.length() - 1 && 
					   line.charAt(i) == 'a') {
				newLine += line.charAt(i);
				newLine += 'r';
			} else if (i == line.length() - 1 && 
					   line.charAt(i) == 'A') {
				newLine += line.charAt(i);
				newLine += 'R';
			} else {
				newLine += line.charAt(i);
			}
			
		}
		return newLine;
	}
	
	public static boolean checkPunct(char c) {
		char[] punctuation = {'.', ',', '?', '!', ')', '-', '"'};
		for (int i = 0; i < punctuation.length; i++) {
			if (c == punctuation[i]) {
				return true;
			}
		}
		return false;
	}
	
	
	// Run in main before checkForR, appending "yah" and "wah" will remove all r's that end words
	
	public static String exceptions(String line) {
		String newLine = "";
	
		for (int i = 0; i < line.length(); i++) {

			if (i != line.length() - 1 && 
				 line.charAt(i) == 'r' && 
				(line.charAt(i + 1) == ' ' || 
				 checkPunct(line.charAt(i + 1))) && 
				(line.charAt(i - 1) == 'i' || 
				(line.charAt(i - 1) == 'e' && 
				 line.charAt(i - 2) == 'e'))) {
				
				newLine += "yah";
				
			} else if (i != line.length() - 1 && 
					    line.charAt(i) == 'R' && 
					   (line.charAt(i + 1) == ' ' || 
						checkPunct(line.charAt(i + 1))) && 
					   (line.charAt(i - 1) == 'I' || 
					   (line.charAt(i - 1) == 'E' && 
					    line.charAt(i - 2) == 'E'))) {
					    	
				newLine += "YAH";
				
			} else if (i != line.length() - 1 && 
					    line.charAt(i) == 'r' && 
					   (line.charAt(i + 1) == ' ' || 
					    checkPunct(line.charAt(i + 1))) && 
					    line.charAt(i - 1) == 'o' && 
					    line.charAt(i - 2) == 'o') {
				
				newLine += "wah";
				
			} else if (i != line.length() - 1 && 
				    line.charAt(i) == 'R' && 
				   (line.charAt(i + 1) == ' ' || 
				    checkPunct(line.charAt(i + 1))) && 
				    line.charAt(i - 1) == 'O' && 
				    line.charAt(i - 2) == 'O') {
				
				newLine += "WAH";
				
			} else if (i == line.length() - 1 && 
					   line.charAt(i) == 'r' && 
					  (line.charAt(i - 1) == 'i' || 
					  (line.charAt(i - 1) == 'e' && 
					   line.charAt(i - 2) == 'e'))) {
						   
				newLine += "yah";
				
			} else if (i == line.length() - 1 && 
					   line.charAt(i) == 'R' && 
					  (line.charAt(i - 1) == 'I' || 
					  (line.charAt(i - 1) == 'E' && 
					   line.charAt(i - 2) == 'E'))) {
						   
				newLine += "YAH";
				
			} else if (i == line.length() - 1 && 
					   line.charAt(i) == 'r' &&
					   line.charAt(i - 1) == 'o' && 
					   line.charAt(i - 2) == 'o') {
						   
				newLine += "wah";
				
			} else if (i == line.length() - 1 && 
					   line.charAt(i) == 'r' &&
					   line.charAt(i - 1) == 'o' && 
					   line.charAt(i - 2) == 'o') {
						   
				newLine += "wah";
				
			} else {
				newLine += line.charAt(i);
			}
		}
		return newLine;
	}	
}
