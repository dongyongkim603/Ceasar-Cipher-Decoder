package com.dcryptionPackage;

public class CeasarDecryption {

	// instance variables
	private String ciphertext;
	private String[] plaintext;
	private String key;
	private static final char[] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	// public constructors
	public CeasarDecryption() {
		this(null);
		this.plaintext = new String[26];
	}

	public CeasarDecryption(String cipher) {
		this.ciphertext = cipher;
		this.plaintext = new String[26];
	}

	public CeasarDecryption(String cipher, String key) {
		this(null);
		this.ciphertext = cipher;
		this.plaintext = new String[26];
	}

//-----------------getters and setters--------------------

	public String getCiphertext() {
		return ciphertext;
	}

	public void setCiphertext(String ciphertext) {
		this.ciphertext = ciphertext;
	}

	public String[] getPlaintext() {
		return plaintext;
	}

//--------------------------------------------------------

	public int[] permutateLetters() {
		StringBuilder text = new StringBuilder();
		int[] letterNumbers = new int[ciphertext.length()];
		for(int i = 0; i < ciphertext.length(); i++) {
			char letterAt = ciphertext.charAt(i);
			letterNumbers[i] = (int)letterAt;
			System.out.println((int)letterAt);
		}
		
		
//		for(int i = 0; i < charArray.length; i++) {
//			char letter = charArray[i];
//			for(int j = 0; j < 25; j++) {
//				if(ALPHABET[j] == letter) {
//					letterNumbers[i] = j;
//				}
//			}
//		}
		return letterNumbers;
	}
}
