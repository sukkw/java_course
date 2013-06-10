package com.sirma.itt.javacourse.fluent;

/**
 * Mail run class.
 * 
 * @version 1.1 29 May 2013
 * @author Stella Djulgerova
 */
public class MailRun {

	/**
	 * Class main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create e-mail using fluent interface concept
		Mail mail = new Mail("sdjulgerova@gmail.com")
			.addReciver("sdjulgerova@abv.bg")
			.addSubject("JustATest")
			.addCC("eli-mar22@abv.bg")
			.addAttachment("1")
			.addAttachment("2")
			.addAttachment("3");
	
		mail.print();
	}
}
