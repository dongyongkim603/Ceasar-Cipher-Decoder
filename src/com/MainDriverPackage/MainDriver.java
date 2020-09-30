package com.MainDriverPackage;

import java.util.Scanner;
import com.dcryptionPackage.*;

public class MainDriver {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter a ciphertext you wish to try to decode: ");
		String input = scanner.next();
		
		CeasarDecryption cipher = new CeasarDecryption(input);
		cipher.permutateLetters();
	}
	
}
