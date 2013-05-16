package com.sirma.itt.javacourse.bulder;

/**
 * Builder design pattern run class.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class BuilderRun {

	public static void main(String[] args) {

		// Build NokiaN95 GSM
		GSMBuilder gsmBuilder = new NokiaBuilder();
		GSMMaker gsmMaker = new GSMMaker(gsmBuilder);
		gsmMaker.makeGSM();
		GSM gsm = gsmMaker.getGSM();

		System.out.println();
		System.out.println("NokiaN95");
		System.out.println("Screen resolution: " + gsm.getScreenResolution());
		System.out.println("Camera: " + gsm.getCamMegapixels() + "MP");
		System.out.println("I/O Interfaces: " + gsm.getIOInterfaces());
		System.out.println("Radio: " + gsm.getRadio());

		// Build SamsungD500 GSM
		gsmBuilder = new SamsungBuilder();
		gsmMaker = new GSMMaker(gsmBuilder);
		gsmMaker.makeGSM();
		gsm = gsmMaker.getGSM();
		
		System.out.println();
		System.out.println("SamsungD500");
		System.out.println("Screen resolution: " + gsm.getScreenResolution());
		System.out.println("Camera: " + gsm.getCamMegapixels() + "MP");
		System.out.println("I/O Interfaces: " + gsm.getIOInterfaces());
		System.out.println("Radio: " + gsm.getRadio());

		// Build LG KG800 GSM
		gsmBuilder = new SamsungBuilder();
		gsmMaker = new GSMMaker(gsmBuilder);
		gsmMaker.makeGSM();
		gsm = gsmMaker.getGSM();

		System.out.println();
		System.out.println("LG KG800");
		System.out.println("Screen resolution: " + gsm.getScreenResolution());
		System.out.println("Camera: " + gsm.getCamMegapixels() + "MP");
		System.out.println("I/O Interfaces: " + gsm.getIOInterfaces());
		System.out.println("Radio: " + gsm.getRadio());
	}
}
