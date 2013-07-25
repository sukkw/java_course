package com.sirma.itt.javacourse.gui.download;

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

	// class private members
	private DownloadTask task;
	private DownloadAgentView view;

	/**
	 * Constructor. Get reference to the view.
	 * 
	 * @param view
	 *            - GUI object.
	 */
	public DownloadAgent(DownloadAgentView view) {
		this.view = view;
	}

	/**
	 * Creates an URLConnection to the source.
	 * 
	 * @param sourcePath
	 *            - path to the file.
	 */
	public void downloadFile(String sourcePath) {

		File path = new File(sourcePath);
		File out = null;
		URL url = null;
		File sourceFileName = null;
		URLConnection connection = null;

		try {
			if (path.isFile()) {
				sourcePath = sourcePath.replaceAll("\\\\", "/");
				sourcePath = "file:/" + sourcePath;
			}
			url = new URL(sourcePath);
			connection = url.openConnection();

			String urlToString = url.toString();
			String file = urlToString
					.substring(urlToString.lastIndexOf("/") + 1);
			sourceFileName = new File(file);

			out = view.chooseDirectoryToSave(sourceFileName, sourcePath);

			task = new DownloadTask(connection, out, view);
			task.addPropertyChangeListener(view);
			

		} catch (MalformedURLException e1) {
			view.showMessage("Invalid URL or filepath!", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		task.execute();
	}
	
	public void cancel() {
		if (task != null) {
			task.cancel(true);
		}
	}
}