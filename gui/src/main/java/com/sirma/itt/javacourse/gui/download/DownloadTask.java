package com.sirma.itt.javacourse.gui.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;

import javax.swing.SwingWorker;

class DownloadTask extends SwingWorker<Void, Void> {


	// detect if file download is canceled by user
	public static boolean canceled = false;

	// class private members
	private BufferedInputStream in;
	private BufferedOutputStream out;
	private URLConnection connection;
	private File outputDir;
	private DownloadAgentView view;

	public DownloadTask(URLConnection connection, File outputDir,
			DownloadAgentView view) {
		this.view = view;
		this.connection = connection;
		this.outputDir = outputDir;
	}
	
	public Void doInBackground() {
		int bytes = connection.getContentLength();
		int transferedBytes = 0;
		int ch;
		int count = 0;
		setProgress(0);

		try {
			in = new BufferedInputStream(connection.getInputStream());
			out = new BufferedOutputStream(new FileOutputStream(outputDir));

			int stopWrite = bytes - 1;
			
			while ((ch = in.read()) != -1) {
				if (canceled) {
					in.close();
					out.close();
					canceled = false;
					this.cancel(true);
					break;
				}

				if (count <= stopWrite) {
					out.write(ch);
					transferedBytes++;
					System.out.println("transfered " + transferedBytes + " all "+ bytes + " % : " + (float)transferedBytes*100/bytes);
					setProgress((transferedBytes*100/bytes));
				}
				count++;
			}

			if (bytes == transferedBytes) {
				view.showMessage("Download is completed!", 1);
				view.hideProgressBar();
			} else {
				view.showMessage("Download isn't completed!", 1);
				view.hideProgressBar();
			}
		} catch (IOException e) {
			e.printStackTrace();
			view.showMessage("Download failed!", 1);
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
		return null;
	}
}