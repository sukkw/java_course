package com.sirma.itt.javacourse.regex;

import java.util.regex.PatternSyntaxException;

/**
 * IBAN validator run class.
 * 
 * @version 1.1 28 April 2013
 * @author Stella Djulgerova
 */
public class IBANFormatterRun {

	/**
	 * Class main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// string for format
			String stringToFormat = "<bankAccounts>\n"
					+ "<iban>GR16 0110 1050 0000 1054 7023 795</iban>\n"
					+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>\n"
					+ "<iban>SA80 8000 0375 6080 1019 0160</iban>\n"
					+ "<iban>CH51 0868 6001 2565 1500 1</iban>\n"
					+ "<iban>BG80 BNBG 9661 1020 3456 78</iban>\n"
					+ "<iban>IL30 01BG 0300 0009 6339 234</iban>\n"
					+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\n"
					+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n"
					+ "<iban>BG80 BNBG 9661 1020 3456 76</iban>\n"
					+ "<iban>BG80 BNBG 9661 1020 3456 7878</iban>\n" 
					+ "</bankAccounts>";

			// regular expression pattern
			String regExPattern = "<iban>(BG[0-9]{2}\\s*[A-Z]{4}\\s*[0-9]{4}\\s*[0-9]{4}\\s*[0-9]{4}\\s*[0-9]{2})</iban>";

			IBANFormatter validator = new IBANFormatter(regExPattern);
			stringToFormat = validator.format(stringToFormat);

			System.out.println(stringToFormat);

		} catch (PatternSyntaxException e) {
			System.out.println("Error in reg ex pattern");
		}
	}
}
