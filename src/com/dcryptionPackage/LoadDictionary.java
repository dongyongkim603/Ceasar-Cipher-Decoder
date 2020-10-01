package com.dcryptionPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public abstract class LoadDictionary {

	// class variables
	public static TreeMap<String, String> dictionary = new TreeMap<>();

	// constructor that will automatically load the dictionary
	public LoadDictionary() {
		initiateDicationary();
	}

//-----------load file method-------------------------------------

	/**
	 * Loads an English dictionary in the root directory into a TreeMap with key of
	 * String and a value of the String.
	 */
	public void initiateDicationary() {
		int wordCount = 0;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"))) {
			System.out.println("Loading dictionary to memory...");
			String word = "";
			while ((word = bufferedReader.readLine()) != null) {
				System.out.println(word);
				dictionary.put(word, word);
				wordCount++;
			}
			System.out.println("\nDictionary loaded, number of words loaded is " + wordCount + "\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File was not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error with the IO");
		}
	}
}
