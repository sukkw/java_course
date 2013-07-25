package com.sirma.itt.javacourse.gui.agent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * DownloadAgent view. Creates GUI.
 * 
 * @version 1.1 16 June 2013
 * @author Stella Djulgerova
 */
public class DownloadAgentView extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;

	// all gui components
	private JProgressBar progressBar = new JProgressBar();
	private JFileChooser fileChooser = new JFileChooser();
	private JButton btnCancel = new JButton();
	private JTextField txtPath = new JTextField("Enter file path...");
	private JButton btnDownload = new JButton("Download");
	private DownloadAgent downloadAgent;
	private JPanel pnlProgress;

	/**
	 * Constructor. Initialize all components and show it on screen.
	 */
	public DownloadAgentView() {
		setTitle("Download Agent");

		btnDownload.setName("download");
		btnDownload.setFocusable(true);

		txtPath.setName("path");

		JPanel pnlDownload = new JPanel();
		
		// Layout for download panel
		GridBagLayout consoleLayout = new GridBagLayout();
		consoleLayout.rowWeights = new double[] { 0 };
		consoleLayout.rowHeights = new int[] { 20 };
		consoleLayout.columnWeights = new double[] { 0.1, 0.1 };
		consoleLayout.columnWidths = new int[] { 300, 50 };
		pnlDownload.setLayout(consoleLayout);
		
		pnlDownload.add(txtPath, new GridBagConstraints(0, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0,
				7));

		pnlDownload.add(btnDownload, new GridBagConstraints(1, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 0, 10, 10), 0,
				0));


		btnDownload.addMouseListener(this);
		txtPath.addMouseListener(this);
		btnCancel.addMouseListener(this);

		pnlProgress = new JPanel();
		
		// Layout for progress panel
		GridBagLayout progressLayout = new GridBagLayout();
		progressLayout.rowWeights = new double[] { 0 };
		progressLayout.rowHeights = new int[] { 20 };
		progressLayout.columnWeights = new double[] { 0.1, 0.1 };
		progressLayout.columnWidths = new int[] { 300, 50 };
		pnlProgress.setLayout(progressLayout);
		
		pnlProgress.add(progressBar, new GridBagConstraints(0, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 8, 10, 11), 0,
				0));

		pnlProgress.add(btnCancel, new GridBagConstraints(1, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 12, 10), 0,
				0));

		Border border = BorderFactory
				.createTitledBorder("Download progress...");
		progressBar.setBorder(border);
		progressBar.setVisible(false);

		btnCancel.setName("cancel");
		btnCancel.setText("Cancel");
		btnCancel.setVisible(false);

		Container pane = this.getContentPane();
		pane.add(pnlDownload, BorderLayout.NORTH);
		pane.add(pnlProgress, BorderLayout.SOUTH);
		pnlProgress.setVisible(false);
		
		setResizable(false);
		setLocation(350, 200);
		setVisible(true);
		
		pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Detect if mouse is pressed.
	 */
	public void mousePressed(MouseEvent event) {
		downloadAgent = new DownloadAgent(this);

		switch (event.getComponent().getName()) {
		case "download":
			String sourcePath = txtPath.getText();
			downloadAgent.downloadFile(sourcePath);
			break;
		case "cancel":
			FileTransferThread.canceled = true;
			break;
		case "path":
			txtPath.selectAll();
			break;
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

	/**
	 * Show the fileChooser and let user to choose directory.
	 * 
	 * @param file - file name
	 * @param path - path to the file
	 */
	public File chooseDirectoryToSave(File file, String path) {
		fileChooser.setSelectedFile(file); 
		File outputPath = null;
		int returnVal = fileChooser.showSaveDialog(DownloadAgentView.this);
		if ((returnVal == JFileChooser.APPROVE_OPTION)) {
			String destination = fileChooser.getCurrentDirectory() + "\\" + fileChooser.getSelectedFile().getName();
			outputPath = new File(destination);
		}
		return outputPath;
	}

	/**
	 * Show warning and info messages.
	 * 
	 * @param msg -  message that should be displayed.
	 * @param type - type of the window to be shown.
	 */
	public void showMessage(String msg, int type) {
		switch (type) {
		case 1:
			JOptionPane.showMessageDialog(this, msg, "Warning", JOptionPane.WARNING_MESSAGE);
			break;
		case 2:
			JOptionPane.showMessageDialog(this, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	/**
	 * Show Progress bar on screen.
	 * 
	 * @param min - start value for the progress bar.
	 * @param max - end value for the progress bar.
	 */
	public void showProgressBar(int min, int max) {
		btnDownload.removeMouseListener(this);
		btnDownload.setEnabled(false);
		txtPath.setEnabled(false);
		progressBar.setMinimum(min);
		progressBar.setMaximum(max);
		progressBar.setValue(min);
		progressBar.setVisible(true);
		btnCancel.setVisible(true);
		pnlProgress.setVisible(true);
		pack();
	}

	/**
	 * Hide progress bar.
	 */
	public void hideProgressBar() {
		btnDownload.addMouseListener(this);
		btnDownload.setEnabled(true);
		txtPath.setEnabled(true);
		progressBar.setVisible(false);
		btnCancel.setVisible(false);
		pnlProgress.setVisible(false);
		txtPath.setText("Enter file path...");
		pack();
	}

	/**
	 * Update progress bar.
	 * 
	 * @param value - new value of progress bar
	 */
	public void updateBar(int value) {
		progressBar.setValue(value);
		progressBar.setStringPainted(true);
	}
}