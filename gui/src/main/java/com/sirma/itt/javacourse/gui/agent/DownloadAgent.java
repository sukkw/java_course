package com.sirma.itt.javacourse.gui.agent;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * DownloadAgent class. Creates URL connection.
 * 
 * @version 1.1 16 June 2013
 * @author Stella Djulgerova
 */
public class DownloadAgent {

	private FileTransferThread thread;
	private DownloadAgentView view;
	
	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view -  GUI object.
	 */
	public DownloadAgent(DownloadAgentView view) {
		this.view = view;
	}

	/**
	 * Creates an URLConnection to the source.
	 * 
	 * @param sourcePath - path to the file.
	 */
	public void downloadFile(String sourcePath) {
		
		File sPath = new File(sourcePath);
		File out = null;
		URL url = null;
		File sourceFileName = null;
		URLConnection sourceConn = null;
		
		try {
			if (sPath.isFile()) { 
				sourcePath = sourcePath.replaceAll("\\\\", "/");
				sourcePath = "file:/" + sourcePath;
			}
			url = new URL(sourcePath);
			sourceConn = url.openConnection();
			
			String theUrl = url.toString();
			String file = theUrl.substring(theUrl.lastIndexOf("/") + 1);
			sourceFileName = new File(file);
			
			out = view.chooseDirectoryToSave(sourceFileName, sourcePath);
			
			thread = new FileTransferThread(sourceConn, out, view);
			thread.start();
			
		} catch (MalformedURLException e1) {
			view.showWarning("Invalid URL or filepath!", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}