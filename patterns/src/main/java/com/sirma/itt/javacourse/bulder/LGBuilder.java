package com.sirma.itt.javacourse.bulder;

/**
 * Builder class which create parts of LG KG800 GSM.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class LGBuilder implements GSMBuilder {

	private GSM gsm;

	/**
	 * Constructor.
	 */
	public LGBuilder() {
		this.gsm = new GSM();
	}

	/**
	 * Set GSM screen resolution
	 */
	public void setScreenResolution() {
		gsm.setScreenResolution("176 x 220 pixels");
	}

	/**
	 * Set GSM camera megapixels.
	 */
	public void setCamera() {
		gsm.setCamera(1.3f);
	}

	/**
	 * Set is GSM support java or not.
	 */
	public void setJavaSupport() {
		gsm.setJavaSupport("Yes");
	}

	/**
	 * Set GSM I/O interfaces.
	 */
	public void setIOInterfaces() {
		gsm.setIOInterfaces("Bluetooth, USB");
	}

	/**
	 * Set GSM radio.
	 */
	public void setRadio() {
		gsm.setRadio("No");
	}

	/**
	 * Get created GSM.
	 */
	public GSM getGSM() {
		return this.gsm;
	}

}
