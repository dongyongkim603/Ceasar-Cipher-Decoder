package com.MainDriverPackage;

import java.util.Scanner;
import com.dcryptionPackage.*;

public class MainDriver {

	// main driver static class variables
	private static boolean exit = false;
	private static Scanner scanner;
	private static String input;
	private static int key;
	private static int options;
	private static int[] ascii;
	private static ResultsWriter writer = new ResultsWriter();
	private static CeasarDecryption cipher = new CeasarDecryption();

	// main
	public static void main(String[] args) {
		menu();
	}// end of main method

//-----------------menu and options methods-------------------------------

	/**
	 * The menu while loop that will run until exit boolean is true and will allow
	 * user to choose between using a brute force and with key decryption. Will take
	 * in user input from standard keyboard input.
	 */
	public static void menu() {
		while (exit == false) {
			scanner = new Scanner(System.in);
			System.out.println(
					"MAIN MENU: \n1) to enter ciphertext with no key \n2) to enter ciphertext with a key \nany other key) to exit");
			try {
				options = scanner.nextInt();

				switch (options) {
				case 1:
					bruteForce();
					break;
				case 2:
					withKey();
					break;
				default:
					exit = true;
					System.out.println("goodbye...");
					scanner.close();
				}
			} catch (Exception e) {
				System.out.println("goodbye");
				exit = true;
				scanner.close();
			}
			
		}
	}

	/**
	 * Asks the user for the ciphertext and will process and then write plaintext
	 * results to a file 'Results.txt'.
	 */
	public static void bruteForce() {
		System.out.println("please enter a ciphertext you wish to try to decode: ");
		input = scanner.next();
		cipher.setCiphertext(input);
		ascii = cipher.asciiLetters();
		cipher.shiftLetters(ascii);
		System.out.println("printing results to 'Results.txt'...");
		writer.writeResults(cipher.getPlaintext());		
		System.out.println("finished\n");
	}

	/**
	 * Asks the user for the ciphertext and key and will then process and then write
	 * plaintext results to a file 'Results.txt'.
	 */
	public static void withKey() {
		System.out.println("please enter a ciphertext you wish to try to decode: ");
		input = scanner.next();
		System.out.println("enter value of key: ");
		key = scanner.nextInt();
		cipher.setCiphertext(input);
		cipher.setKey(key);
		ascii = cipher.asciiLetters();
		cipher.shiftLetters(ascii);
		System.out.println("printing results to 'Results.txt'...");
		writer.writeResults(cipher.getPlaintext());
		System.out.println("finished\n");
	}

}// end of driver class
