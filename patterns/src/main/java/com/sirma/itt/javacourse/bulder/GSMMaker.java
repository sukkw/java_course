package com.sirma.itt.javacourse.bulder;

import java.util.logging.Logger;

/**
 * Create different GSMs using GSMBuilder interface.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class GSMMaker {
	private GSMBuilder gsmBuilder;
	private Logger log  = Logger.getLogger("GSMMaker");
	
	/**
	 * Constructor.
	 * @param gsmBuilder - type of GSM
	 */
	public GSMMaker(GSMBuilder gsmBuilder) {
		if(gsmBuilder == null) {
			log.warning("Wrong argumant :: nill pointer exception");
			System.exit(0);
		}
		this.gsmBuilder = gsmBuilder;
	}
	
	/**
	 * Get created GSM.
	 * @return created GSM
	 */
	public GSM getGSM() {
		return this.gsmBuilder.getGSM();
	}
	
	/**
	 * Execute methods specific to GSMBuilder and create GSM.
	 */
	public void makeGSM() {
		this.gsmBuilder.setScreenResolution();
		this.gsmBuilder.setCamera();
		this.gsmBuilder.setJavaSupport();
		this.gsmBuilder.setIOInterfaces();
		this.gsmBuilder.setRadio();
	}
}
