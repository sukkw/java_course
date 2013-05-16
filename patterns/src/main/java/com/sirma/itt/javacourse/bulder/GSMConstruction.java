package com.sirma.itt.javacourse.bulder;

/**
 * Interface with all components need for GSM construction .
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public interface GSMConstruction {

	public void setScreenResolution(String resolution);
	public void setCamera(float megapixels);
	public void setJavaSupport(String javaSupport);
	public void setIOInterfaces(String interfaces);
	public void setRadio(String radio);
}
