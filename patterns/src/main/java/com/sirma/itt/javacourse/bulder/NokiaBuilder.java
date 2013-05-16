package com.sirma.itt.javacourse.bulder;

/**
 * Builder class which create parts of NokiaN95 GSM.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class NokiaBuilder implements GSMBuilder {

	private GSM gsm;

	/**
	 * Constructor.
	 */
	public NokiaBuilder() {
		this.gsm = new GSM();
	}

	/**
	 * Set GSM screen resolution
	 */
	public void setScreenResolution() {
		gsm.setScreenResolution("240 x 320 pixels");
	}

	/**
	 * Set GSM camera megapixels.
	 */
	public void setCamera() {
		gsm.setCamera(5);
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
		gsm.setIOInterfaces("Bluetooth, Infrared port, USB");
	}

	/**
	 * Set GSM radio.
	 */
	public void setRadio() {
		gsm.setRadio("Stereo FM radio");
	}

	/**
	 * Get created GSM.
	 */
	public GSM getGSM() {
		return this.gsm;
	}

}
