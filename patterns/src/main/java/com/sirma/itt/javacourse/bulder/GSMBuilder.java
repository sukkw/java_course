package com.sirma.itt.javacourse.bulder;

/**
 * Defines all methods needed for GSM construction.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public interface GSMBuilder {
	
	public void setScreenResolution();
	public void setCamera();
	public void setJavaSupport();
	public void setIOInterfaces();
	public void setRadio();
	public GSM getGSM();
}
