package com.sirma.itt.javacourse.server;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.config.Config;
import com.sirma.itt.javacourse.lang.LangBundleHandler;

/**
 * This class creates server GUI.
 * 
 * @version 1.1 26 July 2013
 * @author Stella Djulgerova
 */
public class ServerGUI extends JFrame implements Observer {

	private static final long serialVersionUID = 7372785543380113979L;

	// GUI components
	private JButton btnStart;
	private JButton btnStop;
	private JTextArea console;
	private JScrollPane consoleScroll;
	private JPanel consolePanel;

	private JComboBox<String> portsList;
	private JLabel flagLabel;
	private JLabel langLabel;
	private JPanel configPanel;
	
	// language bundle and logger
	private ResourceBundle bundle;
	private Logger log = Logger.getLogger(ServerGUI.class.getName());

	/**
	 * Constructor. Initialize all graphic components.
	 */
	public ServerGUI() {

		try {
			// load language bundle and logger
			LangBundleHandler.setLocale(Locale.US);
			bundle = LangBundleHandler.getBundle();

			// Create layout for console panel
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

			// console text area
			console = new JTextArea();
			consoleScroll = new JScrollPane(console);
			consolePanel.add(consoleScroll, new GridBagConstraints(0, 0, 5, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(5, 10, 0, 10), 0, 0));
			console.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			console.setEditable(false);
			console.setFont(new java.awt.Font("Arial", 0, 13));
			console.setEditable(false);
			consoleScroll.setViewportView(console);

			// create layout for configuration panel
			configPanel = new JPanel();
			GridBagLayout configLayout = new GridBagLayout();
			configLayout.rowWeights = new double[] { 0 };
			configLayout.rowHeights = new int[] { 40 };
			configLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
			configLayout.columnWidths = new int[] { 330, 20, 20, 20, 20 };
			configPanel.setLayout(configLayout);

			// combo box to choose a port number. 
			// Port number is loaded from configuration file.
			ComboBoxModel<String> portsListModel = new DefaultComboBoxModel<String>(
					Config.PORTS);
			portsList = new JComboBox<String>();

			configPanel.add(portsList,
					new GridBagConstraints(0, 0, 2, 1, 0, 0.0,
							GridBagConstraints.SOUTHEAST,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 3,
									0), 0, 0));
			portsList.setModel(portsListModel);

			// label and small icon to choose different language
			BufferedImage flag = ImageIO.read(getClass()
					.getResourceAsStream(bundle.getString("flagIcon")));
			flagLabel = new JLabel(new ImageIcon(flag));
			
			//getResource("/images/icon.jpg") 
			
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

			// add configuration and console panels to frame
			getContentPane().add(consolePanel, BorderLayout.CENTER);
			getContentPane().add(configPanel, BorderLayout.NORTH);

			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			setTitle(bundle.getString("chatServer"));

			setResizable(false);
			setLocation(400, 200);
			setVisible(true);
			pack();

			log.info(Config.SERVER_UI_LOADED);

		} catch (Exception e) {
			log.warn(Config.SERVER_UI_ERROR + e.getMessage());
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
	 * @param message - message to be shown.
	 */
	public void showMessage(String message) {
		if (message != null) {
			Date date = new Date();
			String formatedDate = new SimpleDateFormat(Config.DATE_FORMAT).format(date);

			console.append("[<" + formatedDate + ">] " + message + "\n");
		} else {
			console.setText("");
		}
	}

	/**
	 * Updates GUI corresponding to the chosen language
	 * 
	 * @param bundle - language bundle
	 */
	public void updateComponents(ResourceBundle bundle) {

		// try to change language.
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
	 * @param listener - mouse listener
	 */
	public void addServerMouseListener(MouseListener listener) {
		flagLabel.addMouseListener(listener);
		langLabel.addMouseListener(listener);
	}

	/**
	 * Add action listener
	 * 
	 * @param listener - action listener
	 */
	public void addServerActionListener(ActionListener listener) {
		btnStart.addActionListener(listener);
		btnStop.addActionListener(listener);
	}

	/**
	 * get ports combo box
	 * 
	 * @return ports list combo box
	 */
	public JComboBox<String> getPortsList() {
		return portsList;
	}

	/**
	 * Get configuration panel
	 * 
	 * @return
	 */
	public JPanel getConfigPanel() {
		return configPanel;
	}

	/**
	 * Shows different messages in server console. 
	 * 
	 * @param obs - the observable object.
	 * @param arg - an argument passed to the notifyObservers method
	 */
	public void update(Observable obs, Object arg) {
		showMessage(arg.toString());
	}
}