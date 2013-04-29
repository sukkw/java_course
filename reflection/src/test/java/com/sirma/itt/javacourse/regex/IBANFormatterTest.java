package com.sirma.itt.javacourse.regex;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for IBAN formatter methods.
 * 
 * @version 1.1 29 April 2013
 * @author Stella Djulgerova
 */
public class IBANFormatterTest {

	// class private members
	private String regExPattern = "<iban>(BG[0-9]{2}\\s*[A-Z]{4}\\s*[0-9]{4}\\s*[0-9]{4}\\s*[0-9]{4}\\s*[0-9]{2})</iban>";
	private IBANFormatter formatter = new IBANFormatter(regExPattern);

	/**
	 * Data used for tests.
	 * 
	 * @return object with data used for tests
	 */
	@DataProvider
	public Object[][] validData() {
		return new Object[][] {
				{
						"<bankAccounts>\n" + "<iban>GR16 0110 1050 0000 1054 7023 795</iban>\n"
								+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>\n"
								+ "<iban>SA80 8000 0375 6080 1019 0160</iban>\n"
								+ "<iban>CH51 0868 6001 2565 1500 1</iban>\n"
								+ "<iban>BG80 BNBG 9661 1020 3456 78</iban>\n"
								+ "<iban>IL30 01BG 0300 0009 6339 234</iban>\n"
								+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\n"
								+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n"
								+ "<iban>BG80 BNBG 9661 1020 3456 76</iban>\n"
								+ "<iban>BG80 BNBG 9661 1020 3456 7878</iban>\n"
								+ "</bankAccounts>",
						"<bankAccounts>\n" + "<iban>GR16 0110 1050 0000 1054 7023 795</iban>\n"
								+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>\n"
								+ "<iban>SA80 8000 0375 6080 1019 0160</iban>\n"
								+ "<iban>CH51 0868 6001 2565 1500 1</iban>\n"
								+ "<iban>**** 1020 3456 78</iban>\n"
								+ "<iban>IL30 01BG 0300 0009 6339 234</iban>\n"
								+ "<iban>AL47 2121 1009 0000 0002 3569 8741</iban>\n"
								+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n"
								+ "<iban>**** 1020 3456 76</iban>\n"
								+ "<iban>BG80 BNBG 9661 1020 3456 7878</iban>\n"
								+ "</bankAccounts>" },
				{
						"<bankAccounts>\n" + "<iban>GR16 0110 1050 0000 1054 7023 795</iban>\n"
								+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>\n"
								+ "<iban>SA80 8000 0375 6080 1019 0160</iban>\n"
								+ "<iban>CH51 0868 6001 2565 1500 1</iban>\n"
								+ "<iban>BG80 BNBG 9661 1020 3456 78</iban>\n"
								+ "<iban>IL30 01BG 0300 0009 6339 234</iban>\n"
								+ "<iban>BG13UBBS80023300186210</iban>\n"
								+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n"
								+ "<iban>BG80 BNBG 9661 1020 3456 76</iban>\n"
								+ "<iban>BG80 BNBG 9661 1020 3456 7878</iban>\n"
								+ "</bankAccounts>",
						"<bankAccounts>\n" + "<iban>GR16 0110 1050 0000 1054 7023 795</iban>\n"
								+ "<iban>GB35 MIBG 4025 3432 1446 70</iban>\n"
								+ "<iban>SA80 8000 0375 6080 1019 0160</iban>\n"
								+ "<iban>CH51 0868 6001 2565 1500 1</iban>\n"
								+ "<iban>**** 1020 3456 78</iban>\n"
								+ "<iban>IL30 01BG 0300 0009 6339 234</iban>\n"
								+ "<iban>****3300186210</iban>\n"
								+ "<iban>AZ21 NABZ 0000 0000 1370 1000 1944</iban>\n"
								+ "<iban>**** 1020 3456 76</iban>\n"
								+ "<iban>BG80 BNBG 9661 1020 3456 7878</iban>\n"
								+ "</bankAccounts>" } };
	}

	/**
	 * Test format method.
	 * 
	 * @param stringToFormat - string to be formated
	 * @param valid - correct formatted string
	 */
	@Test(dataProvider = "validData")
	public void format(String stringToFormat, String valid) {
		String result = formatter.format(stringToFormat);
		Assert.assertEquals(result, valid);
	}
}
