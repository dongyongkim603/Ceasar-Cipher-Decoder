package com.dcryptionPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ResultsWriter {

	/**
	 * takes in an ArrayList of Strings and prints each to a file named 'Results.txt'.
	 * @param results the ArrayList of Strings to be printed.
	 */
	public void writeResults(ArrayList<String> results) {
		try (FileWriter writer = new FileWriter(new File("Resutls.txt"))) {
			for (int i =0; i < results.size(); i++) {
				writer.write("The permutation " + i + " is " + results.get(i) + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
