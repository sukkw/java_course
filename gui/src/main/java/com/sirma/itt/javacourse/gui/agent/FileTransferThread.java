package com.sirma.itt.javacourse.gui.agent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;

import com.sirma.itt.javacourse.gui.config.Config;

/**
 * FileTransferThread class. Transfer file and show result continuously on
 * progress bar.
 * 
 * @version 1.1 16 June 2013
 * @author Stella Djulgerova
 */
public class FileTransferThread extends Thread {

	// detect if file download is canceled by user
	public static boolean canceled = false;

	// class private members
	private BufferedInputStream in;
	private BufferedOutputStream out;
	private URLConnection connection;
	private File outputDir;
	private DownloadAgentView view;

	/**
	 * Constructor. Initialize variables.
	 * 
	 * @param connection - connection to the file.
	 * @param outputPath - destination directory.
	 */
	public FileTransferThread(URLConnection connection, File outputDir,
			DownloadAgentView view) {
		this.view = view;
		this.connection = connection;
		this.outputDir = outputDir;
	}

	/**
	 * Creates the input and the output streams. Performs the downloading and
	 * save the file. Update progress bar.
	 */
	public void run() {
		int bytes = connection.getContentLength();
		int transferedBytes = 0;
		int ch;
		int count = 0;
		view.showProgressBar(0, bytes);

		try {
			in = new BufferedInputStream(connection.getInputStream());
			out = new BufferedOutputStream(new FileOutputStream(outputDir));

			int stopWrite = bytes - 1;

			while ((ch = in.read()) != -1) {
				if (canceled) {
					in.close();
					out.close();
					canceled = false;
					break;
				}

				if (count <= stopWrite) {
					out.write(ch);
					transferedBytes++;
					view.updateBar(transferedBytes);
				}
				count++;
			}

			if (bytes == transferedBytes) {
				view.showMessage("Download is completed!", Config.INFO);
				view.hideProgressBar();
			} else {
				view.showMessage("Download isn't completed!", Config.WARNING);
				view.hideProgressBar();
			}
		} catch (IOException e) {
			e.printStackTrace();
			view.showMessage("Download failed!", Config.INFO);
			view.hideProgressBar();
		} finally {
			try {
				if(in != null) 
				in.close();
				if(out != null)
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}