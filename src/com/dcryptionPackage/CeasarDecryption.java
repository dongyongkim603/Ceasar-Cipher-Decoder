package com.dcryptionPackage;

import java.util.ArrayList;

public class CeasarDecryption {

	// instance variables
	private String ciphertext;
	private ArrayList<String> plaintext = new ArrayList<>();
	private int key = -1;

	// public constructors
	public CeasarDecryption() {
		this(null);
	}

	public CeasarDecryption(String cipher) {
		this(cipher, -1);
	}

	public CeasarDecryption(String cipher, int key) {
		this.ciphertext = cipher;
		this.key = key;
	}

//-----------------getters and setters--------------------

	public String getCiphertext() {
		return ciphertext;
	}

	public void setCiphertext(String ciphertext) {
		this.ciphertext = ciphertext;
	}

	public ArrayList<String> getPlaintext() {
		return plaintext;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return this.key;
	}

//--------------------------------------------------------

	/**
	 * takes in the ciphertext string and casts the chars of the string into a int
	 * array.
	 * 
	 * @return an int array of the ascii values of the char that make up the
	 *         ciphertext string.
	 */
	public int[] asciiLetters() {
		int[] letterNumbers = new int[ciphertext.length()];
		for (int i = 0; i < ciphertext.length(); i++) {
			char letterAt = ciphertext.charAt(i);
			letterNumbers[i] = (int) letterAt;
		}
		return letterNumbers;
	}

	/**
	 * takes in an int array and shifts letters according to key or will try a brute force of all 26 possible permutations
	 * @param asciiArray an array of integers that are a characters converted to ascii.
	 */
	public void shiftLetters(int[] asciiArray) {
		for (int i = 26; i > 0; i--) {
			StringBuilder text = new StringBuilder();
			for (int j = 0; j < asciiArray.length; j++) {
				if (this.key != -1) {
					char offset = (char) ((asciiArray[j] + this.key - 65) % 26 + 65);
					text.append(offset);
				} else {
					if (Character.isUpperCase(ciphertext.charAt(j))) {
						char offset = (char) ((asciiArray[j] + i - 65) % 26 + 65);
						text.append(offset);
					} else {
						char offset = (char) ((asciiArray[j] + i - 97) % 26 + 97);
						text.append(offset);
					}
				}
			}
			String pText = text.toString();
			System.out.println("With a key of " + i + " the plaintext is: " + pText);
			this.plaintext.add(pText);
		}
	}
}
