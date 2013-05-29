package com.sirma.itt.javacourse.bulder;

/**
 * GSM construction class based on GSMConstruction interface.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class GSM implements GSMImpl {

	// class private members
	private String screenResolution;
	private float camMegapixels;
	private String javaSupport;
	private String interfaces;
	private String radio;

	/**
	 * Get screen resolution.
	 * 
	 * @return screen resolution
	 */
	public String getScreenResolution() {
		return screenResolution;
	}

	/**
	 * Set Screen resolution
	 * 
	 * @param resolution - screen resolution
	 */
	public void setScreenResolution(String resolution) {
		screenResolution = resolution;
	}

	/**
	 * Get camera megapixels.
	 * 
	 * @return camera megapixels
	 */
	public float getCamMegapixels() {
		return camMegapixels;
	}

	/**
	 * Set camera megapixels.
	 * 
	 * @param megapixels - camera megapixels
	 */
	public void setCamera(float megapixels) {
		camMegapixels = megapixels;
	}

	/**
	 * Detect is GSM using java.
	 * 
	 * @return true if java is supported or false if not
	 */
	public String getJavaSupport() {
		return javaSupport;
	}

	/**
	 * Set is GSM using java.
	 * 
	 * @param javaSupport - support or not
	 */
	public void setJavaSupport(String javaSupport) {
		this.javaSupport = javaSupport;
	}

	/**
	 * Get GSM I/O interfaces.
	 * 
	 * @return GSM I/O interfaces
	 */
	public String getIOInterfaces() {
		return interfaces;
	}

	/**
	 * Set GSM I/O interfaces.
	 * 
	 * @param interfaces - GSM I/O interfaces.
	 */
	public void setIOInterfaces(String interfaces) {
		this.interfaces = interfaces;
	}

	/**
	 * Detect is GSM using radio.
	 * 
	 * @return type of radio
	 */
	public String getRadio() {
		return radio;
	}

	/**
	 * Set GSM radio.
	 * 
	 * @param radio - GSM radio
	 */
	public void setRadio(String radio) {
		this.radio = radio;
	}
}
