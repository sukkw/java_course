package com.sirma.itt.javacourse.gui.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URLConnection;

import javax.swing.SwingWorker;

class DownloadTask extends SwingWorker<Void, Void> {
	
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
		BigInteger bytes = new BigInteger(Integer.toString(connection
				.getContentLength()));

		setProgress(0);

		try {
			in = new BufferedInputStream(connection.getInputStream());
			out = new BufferedOutputStream(new FileOutputStream(outputDir));

			byte[] buffer = new byte[10240];
			int size = 0;
			BigInteger transferedBytes = new BigInteger("0");

			while ((size = in.read(buffer)) > 0) {
				if (isCancelled()) {
					in.close();
					out.close();
					break;
				}
				
				out.write(buffer, 0, size);
				transferedBytes = transferedBytes.add(new BigInteger(Integer
						.toString(size)));
				int progress = transferedBytes
						.multiply(BigInteger.valueOf(100)).divide(bytes)
						.intValue();
				setProgress(progress);
			}

			if (bytes.equals(transferedBytes)) {
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
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}