package com.dcryptionPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CeasarDecryption extends LoadDictionary {

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
	 * takes in an int array and shifts letters according to key or will try a brute
	 * force of all 26 possible permutations
	 * 
	 * @param asciiArray an array of integers that are a characters converted to
	 *                   ascii.
	 */
	public void shiftLetters(int[] asciiArray) {
		for (int i = 0; i < 26; i++) {
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
			if (this.key != -1) {
				break;
			}
		}
	}// end of method

//----------------find spaces methods-----------------------------
	
//	public HashMap<Integer, ArrayList<String>> findWords(ArrayList<String> plaintext) {
//		HashMap<Integer, ArrayList<String>> listWithSpaces = new HashMap<Integer, ArrayList<String>>();
//		StringBuilder builder = new StringBuilder();
//		for (int k = 0; k < plaintext.size(); k++) {// incoming list
//			String s = plaintext.get(k);
//			System.out.println("the key is "+ k + " and the word is " + s);
//			for (int j = 0; j < s.length(); j++) {// goes through all the possible permutations
//				int combindLength = 0;// initializes and clears length counter
//				System.out.println("middle loop" + s.length() + " index is at " + j);
//				ArrayList<String> innerList = new ArrayList<>();// initializes and clears innerlist
//				for(int l = 0;  < s.length(); l++)
//				for (int i = l; i < s.length(); i++) {// goes through the string looking for known English words
//					builder.append(s.charAt(i));
//					if (LoadDictionary.dictionary.containsKey(builder.toString())) {// if word is found in dictionary
//						innerList.add(builder.toString());// add it to the innerList
//						combindLength += builder.length();
//						System.out.println(builder);
//						builder = new StringBuilder();// clear StringBuilder
//					} // conditional
//				} // inner-most loop
//				if (combindLength == s.length()) {
//					for(String f: innerList) {
//						System.out.println(f);
//					}
//					
//					listWithSpaces.put(k, innerList);//
//				}
//			} // middle loop
//		} // outer loop
//		return listWithSpaces;
//	}//end of method
//	
//	
//	public void findAllWhiteSpaces(String s) {
//		LinkedList<String> wordList = new LinkedList<>();
//		int length = s.length();
//		boolean found = false;
//		for(int i = 0; i< length; i++) {
//			StringBuilder builder = new StringBuilder();
//			LinkedList<String> tempWordList = new LinkedList<>();
//			int c = 0;
//			int foundLength = 0;
//			int whichWord = 0;
//			if(i != 0 && found == false) {
//				break;
//			}
//			while(c < length) {
//				builder.append(s.charAt(c));
//				String temp = builder.toString().toLowerCase();
//				if()
//				System.out.println(temp);
//				if(LoadDictionary.dictionary.containsKey(temp) && wordList.isEmpty()) {
//					found = true;
//					foundLength += builder.length();
//					String word = builder.toString();
//					System.out.println(word);
//					builder = new StringBuilder();
//					whichWord++;
//					tempWordList.add(temp);
//				}else if(LoadDictionary.dictionary.containsKey(temp) && !wordList.isEmpty()) {
//					if(wordList.size()-1 >= whichWord && wordList.get(whichWord).equals(temp)) {
//						c++;
//						continue;
//					}else {
//						found = true;
//						foundLength += builder.length();
//						String word = builder.toString();
//						System.out.println(word);
//						builder = new StringBuilder();
//						tempWordList.add(temp);
//						whichWord++;
//					}
//				}
//				c++;
//			}//while loop
//			if(foundLength == length) {
//				System.out.println("we have a match");
//			}else if(foundLength != length && found == true) {
//				System.out.println("we did not find one but will try again"); 
//				if(wordList.size() < tempWordList.size()) {
//					wordList = tempWordList;
//				}
//			}else {
//				System.out.println("no match and no chance of one");
//			}
//		}//for loop
//		System.out.println("broke early since there are no matches");
//	}
}// end of class
