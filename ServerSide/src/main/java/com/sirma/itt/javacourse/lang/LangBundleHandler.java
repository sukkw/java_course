package com.sirma.itt.javacourse.lang;

import java.util.Locale;
import java.util.ResourceBundle;

import com.sirma.itt.javacourse.config.Config;

/**
 * This class change language bundle locale.
 * 
 * @version 1.1 26 July 2013
 * @author Stella Djulgerova
 */
public class LangBundleHandler {

	// language bundle
	private static ResourceBundle bundle;

	/**
	 * Get language bundle
	 * @return - language bundle
	 */
	public static ResourceBundle getBundle() {
		return bundle;
	}

	/**
	 * Change language bundle locale
	 * @param locale - locale
	 */
	public static void setLocale(Locale locale) {
		try {
			bundle = ResourceBundle.getBundle(Config.LANG_BUNDLE, locale);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
