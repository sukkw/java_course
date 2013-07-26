package com.sirma.itt.javacourse.server;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import com.sirma.itt.javacourse.common.LogFileHandler;
import com.sirma.itt.javacourse.config.Config;

public class ServerFrame extends JFrame {

	private static final long serialVersionUID = 7372785543380113979L;

	private JButton btnStart;
	private JButton btnStop;
	private JTextArea console;
	private JScrollPane scroll;
	private JPanel consolePanel;

	public SocketServer server;
	public Thread serverThread;

	private JComboBox<String> portsList;
	private JPanel configPanel;
	private JLabel flagLabel;
	private JLabel langLabel;

	private ResourceBundle bundle;
	private Logger log = Logger.getLogger("ServerView");

	public ServerFrame() {
		initComponents();
		console.setEditable(false);
	}

	private void initComponents() {

		try {
			// load language bundle and logger
			bundle = ResourceBundle.getBundle(Config.LANG_BUNDLE);
			log.addHandler(LogFileHandler.getHandler());

			// Layout for console panel
			consolePanel = new JPanel();
			GridBagLayout consoleLayout = new GridBagLayout();
			consoleLayout.rowWeights = new double[] { 0, 0 };
			consoleLayout.rowHeights = new int[] { 400, 50 };
			consoleLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
					0.0 };
			consoleLayout.columnWidths = new int[] { 250, 50, 50, 50, 50 };
			consolePanel.setLayout(consoleLayout);

			// start button
			btnStart = new JButton(bundle.getString("start"));
			btnStart.setActionCommand("start");
			consolePanel.add(btnStart, new GridBagConstraints(1, 1, 2, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 0), 0,
					0));

			// stop button
			btnStop = new JButton(bundle.getString("stop"));
			btnStop.setActionCommand("stop");
			consolePanel.add(btnStop, new GridBagConstraints(3, 1, 2, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0,
					0));
			btnStop.setEnabled(false);

			// text area
			console = new JTextArea();
			scroll = new JScrollPane(console);
			consolePanel.add(scroll, new GridBagConstraints(0, 0, 5, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(5, 10, 0, 10), 0, 0));
			console.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			console.setEditable(false);
			console.setFont(new java.awt.Font("Arial", 0, 10));

			// Layout for config panel
			configPanel = new JPanel();
			GridBagLayout configLayout = new GridBagLayout();
			configLayout.rowWeights = new double[] { 0 };
			configLayout.rowHeights = new int[] { 40 };
			configLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
			configLayout.columnWidths = new int[] { 330, 20, 20, 20, 20 };
			configPanel.setLayout(configLayout);

			// combo box to choose a port number
			DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>(
					new String[] { "7000", "7001", "7002", "7003", "7004" });
			ComboBoxModel<String> portsListModel = defaultComboBoxModel;
			portsList = new JComboBox<String>();

			configPanel.add(portsList,
					new GridBagConstraints(0, 0, 2, 1, 0, 0.0,
							GridBagConstraints.SOUTHEAST,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 3,
									0), 0, 0));
			portsList.setModel(portsListModel);

			// label to choose different language
			BufferedImage myPicture = ImageIO.read(getClass()
					.getResourceAsStream(bundle.getString("flagIcon")));
			flagLabel = new JLabel(new ImageIcon(myPicture));
			langLabel = new JLabel(bundle.getString("changeLang"));
			langLabel.setName(bundle.getString("lang"));
			flagLabel.setName(bundle.getString("lang"));

			configPanel.add(langLabel,
					new GridBagConstraints(3, 0, 1, 1, 0, 0.0,
							GridBagConstraints.SOUTHEAST,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 2,
									0), 0, 0));

			configPanel.add(flagLabel,
					new GridBagConstraints(4, 0, 1, 1, 0, 0.0,
							GridBagConstraints.SOUTHEAST,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));

			getContentPane().add(consolePanel, BorderLayout.CENTER);
			getContentPane().add(configPanel, BorderLayout.NORTH);

			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			setTitle("ChatServer");

			console.setColumns(20);
			console.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
			console.setRows(5);
			scroll.setViewportView(console);

			setResizable(false);
			setLocation(400, 200);
			pack();

			log.info("Server's UI is loaded.");

		} catch (Exception e) {
			log.warning("Error in loading UI.");
			e.printStackTrace();
		}
	}

	/**
	 * Shows warning or error messages according the parameters.
	 * 
	 * @param message
	 *            - The message that should be displayed.
	 * @param type
	 *            - type of the window to be shown.
	 */
	public void showWarning(String message, int type) {
		switch (type) {
		case 1:
			JOptionPane.showMessageDialog(this, message, "Error",
					JOptionPane.ERROR_MESSAGE);
			log.warning(message);
			break;
		case 2:
			JOptionPane.showMessageDialog(this, message, "Information",
					JOptionPane.INFORMATION_MESSAGE);
			log.info(message);
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
	 * Shows different messages.
	 * 
	 * @param message
	 *            - message to be shown.
	 */
	public void showMessage(String message) {
		if (message != null) {
			Date date = new Date();
			String formatedDate = new SimpleDateFormat("hh:mm:ss").format(date);

			console.append("[<" + formatedDate + ">] " + message + "\n");
		} else {
			console.setText("");
		}
	}

	/**
	 * Updates form view corresponding to the chosen language
	 * 
	 * @param bundle
	 *            - lang bundle
	 */
	public void updateComponents(ResourceBundle bundle) {

		try {
			btnStop.setText(bundle.getString("stop"));
			btnStart.setText(bundle.getString("start"));
			langLabel.setText(bundle.getString("changeLang"));

			BufferedImage myPicture = ImageIO.read(getClass()
					.getResourceAsStream(bundle.getString("flagIcon")));
			flagLabel.setIcon(new ImageIcon(myPicture));
			langLabel.setName(bundle.getString("lang"));
			flagLabel.setName(bundle.getString("lang"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add mouse listeners
	 * 
	 * @param listener
	 *            - mouse listener
	 */
	public void addServerMouseListener(MouseListener listener) {
		flagLabel.addMouseListener(listener);
		langLabel.addMouseListener(listener);
	}

	/**
	 * Add action listener
	 * 
	 * @param listener
	 *            - action listener
	 */
	public void addServerActionListener(ActionListener listener) {
		btnStart.addActionListener(listener);
		btnStop.addActionListener(listener);
	}

	/**
	 * Get language label
	 * 
	 * @return - language label
	 */
	public JLabel getLangLabel() {
		return langLabel;
	}

	/**
	 * get ports combo box
	 * 
	 * @return
	 */
	public JComboBox<String> getPortsList() {
		return portsList;
	}

	public JPanel getConfigPanel() {
		return configPanel;
	}
}
