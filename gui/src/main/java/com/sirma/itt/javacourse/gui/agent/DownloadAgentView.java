package com.sirma.itt.javacourse.gui.agent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

	/**
	 * Constructor. Initialize all components and show it on screen.
	 */
	public DownloadAgentView() {
		setTitle("Download Agent");

		btnDownload.setName("download");
		btnDownload.setFocusable(true);

		txtPath.setName("path");

		JPanel pnlDownload = new JPanel();
		pnlDownload.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.ipadx = 300;
		c.ipady = 8;
		pnlDownload.add(txtPath, c);
		pnlDownload.add(btnDownload);

		btnDownload.addMouseListener(this);
		txtPath.addMouseListener(this);
		btnCancel.addMouseListener(this);

		JPanel pnlProgress = new JPanel();
		pnlProgress.setLayout(new GridBagLayout());

		Border border = BorderFactory.createTitledBorder("Download progress...");
		progressBar.setBorder(border);
		progressBar.setVisible(false);

		btnCancel.setName("cancel");
		btnCancel.setText("Cancel");
		btnCancel.setVisible(false);
		c.ipady = 2;
		c.ipadx = 285;
		pnlProgress.add(progressBar, c);
		pnlProgress.add(btnCancel);

		Container pane = this.getContentPane();
		pane.add(pnlDownload, BorderLayout.NORTH);
		pane.add(pnlProgress, BorderLayout.SOUTH);

		setResizable(false);
		this.setSize(400, 110);
		setLocation(350, 200);
		setVisible(true);

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
		txtPath.setText("Enter file path...");
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