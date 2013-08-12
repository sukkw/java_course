package com.sirma.itt.javacourse.config;

/**
 * This class keeps information about application configurations.
 * Ports, files, look and feel, etc...
 * 
 * @version 1.1 26 July 2013
 * @author Stella Djulgerova
 */
public class Config {
	
	public static final String LANG_BUNDLE = "com.sirma.itt.javacourse.lang.LangResource";
	public static final String LOOK_AND_FEEL = "Nimbus";
	public static final String[] PORTS = { 
			"7000", "7001", "7002", "7003", "7004", "7005", "7006", 
			"7007", "7008", "7009", "7010", "7011", "7012", "7013", 
			"7014", "7015", "7016", "7017", "7018", "7019", "7020", 
			"7021", "7022", "7023", "7024", "7025" };
	public static final String SERVER_FRAME = "ServerGUI";
	public static final String SERVER = "Server";
	public static final String SERVER_MAIN = "ServerMainThread";
	public static final String SERVER_UI_LOADED = "Server UI is loaded.";
	public static final String SERVER_UI_ERROR = "Error in loading UI. ";
	public static final String DATE_FORMAT = "hh:mm:ss";
	public static final String ENGLISH = "Language is changed to english.";
	public static final String BULGARIAN = "Language is changed to bulgarian.";
	public static final String SERVER_UI_CLOSED = "Server console is closed.";
	public static final String CONNECTION_FAILED = "Connection attempt failed.";
	public static final String SERVER_STARTED = "Server is started.";
	public static final String PORT_IN_USE = "Try to connect to unavailable port.";
	public static final String SERVER_STOPPED = "Server stopped";
	public static final String STOP_ERROR = "Error while stopping server.";
	
}