package com.sirma.itt.javacourse.server;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;


public class ServerMainThread extends JFrame implements ActionListener {

	private static final long serialVersionUID = 6498641106033575585L;

	private JComboBox<String> portsList;
	private JTextArea console;
	private JScrollPane scroll;
	private JPanel consolePanel;
	private JPanel configPanel;
	private JButton btnStart;
	private JButton btnStop;
	

	private static final String NEW_LINE = "\n";
	//private ChatServer server;
	
	/** A flag to say that the server is started. */
	private boolean isStarted;
	
	/** The logger. */
	private Logger log = Logger.getLogger("ServerMainThread");
	
	
	/**
	 * Displays this frame.
	 */
	public ServerMainThread() {
		super("Chat server");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initUI();
				log.info("Server's console is displayed correctly.");
			}
		});
	}

	/**
	 * Initializes this frame.
	 */
	private void initUI() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				log.info("Server console is closed.");
				if (isStarted) {
					//server.stopServer();
					dispose();
				} else {
					dispose();
				}
			}
		});
		
		try {

			
			//the tab with the console and start/stop buttons
			consolePanel = new JPanel();
			GridBagLayout consoleTabLayout = new GridBagLayout();
			consoleTabLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
			consoleTabLayout.rowHeights = new int[] {138, 135, 139, 7};
			consoleTabLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			consoleTabLayout.columnWidths = new int[] {7, 7, 7, 7};
			consolePanel.setLayout(consoleTabLayout);
			
			
			//the tab containing options for configuration
			configPanel = new JPanel();
			GridBagLayout configTabLayout = new GridBagLayout();
			configTabLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			
			configTabLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1};
			configTabLayout.columnWidths = new int[] {105, 78, 118, 7};
			configPanel.setLayout(configTabLayout);

			
			//start button
			btnStart = new JButton("start server");
			btnStart.setActionCommand("start");
			consolePanel.add(btnStart, new GridBagConstraints(
					2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, 
					GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0,5),0,0));
			btnStart.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			btnStart.addActionListener(this);
		
			
			//stop button
			btnStop = new JButton("stop server");
			btnStop.setActionCommand("stop");
			consolePanel.add(btnStop, new GridBagConstraints(
					3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, 
					GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0,10),0,0));
			btnStop.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			btnStop.addActionListener(this);
			btnStop.setEnabled(false);
		
			
			//text area that is used as a console
			console = new JTextArea();
			scroll = new JScrollPane(console);
			consolePanel.add(scroll, new GridBagConstraints(
					0, 0, 4, 3, 0.0, 0.0, GridBagConstraints.CENTER, 
					GridBagConstraints.BOTH, new Insets(5, 10, 0, 10), 0, 0));
			console.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			console.setEditable(false);
			console.setFont(new java.awt.Font("Arial",0,10));

			getContentPane().add(consolePanel, BorderLayout.CENTER);
			getContentPane().add(configPanel, BorderLayout.NORTH);
			
			//combo box to choose a port number
			ComboBoxModel portsListModel = new DefaultComboBoxModel(
					new String[] { "7000", "7001", "7002", "7003", "7004" });
			portsList = new JComboBox();
			configPanel.add(portsList, new GridBagConstraints(0, 0, 2, 1, 0.0,0.0, 
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
					new Insets(0, 10, 0, 0), 0, 0));
			portsList.setModel(portsListModel);
			portsList.setBorder(BorderFactory.createTitledBorder("Ports list"));
			
			
			pack();
			setResizable(false);
			setLocation(550, 50);
			setSize(400, 550);
			setVisible(true);
		} catch (Exception e) {
			log.warning("Error in displaying the console.");
		}
	}

	/**
	 * Realizes the actions fired when stop or start buttons are pressed.
	 */
	public void actionPerformed(ActionEvent ae) {
		
		//start button is pressed
		if("start".equals(ae.getActionCommand())) {
			enableStartButton();
			switchCursor(1);	//busy
			Integer portNumber = new Integer((String)portsList.getSelectedItem());
			//server = new ChatServer(this, portNumber.intValue());
			isStarted = true;
			log.info("Server is started.");
			
		//stop button is pressed
		} else if("stop".equals(ae.getActionCommand())) {
			switchCursor(1);	//busy
			//server.stopServer();
			isStarted = false;
			enableStartButton();
			switchCursor(2);
			log.info("Server is stopped.");
		}
	}
	
	/**
	 * Shows warning windows with messages according the parameters.
	 * @param warningMessage The message that should be displayed.
	 * @param msgType		 The type of the window to be shown.
	 */
	public void setWarnings(String warningMessage, int msgType) {
		switch (msgType) {
			case 1:JOptionPane.showMessageDialog(
					this, warningMessage, "Error",
					JOptionPane.ERROR_MESSAGE);
					log.warning(warningMessage);
					break;
			case 2:JOptionPane.showMessageDialog(
					this, warningMessage, "Information",
					JOptionPane.INFORMATION_MESSAGE);
					log.info(warningMessage);
					break;
		}
	}
	
	/**
	 * Enables the start button.
	 */
	public void enableStartButton() {
		btnStop.setEnabled(false);
		btnStart.setEnabled(true);
		
	}
	
	/**
	 * Disables the start button.
	 */
	public void disableStartButton() {
		btnStop.setEnabled(true);
		btnStart.setEnabled(false);
		
	}
	
	/**
	 * Switches cursor mode.
	 * @param mode The mode to be set.
	 */
	public void switchCursor(int mode) {
		switch(mode) {
			case 1: setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					break;	
			case 2: setCursor(Cursor.getDefaultCursor());
					break;
			default : 
					break;
		}	
	}
	
	/**
	 * Prints messages in the text field.
	 * @param msg The message that should be printed.
	 */
	public void prtMessage(String msg) {
		console.append(msg + NEW_LINE);
	}
}
