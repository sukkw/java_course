package com.sirma.itt.javacourse.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

import com.sirma.itt.javacourse.common.Capitalizer;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.decorators.CustomMsgDecorator;
import com.sirma.itt.javacourse.decorators.DecoratorFactory;
import com.sirma.itt.javacourse.decorators.ICustomMsgDecorator;
import com.sirma.itt.javacourse.lang.LangBundleHandler;

/**
 * This class creates client GUI.
 * 
 * @version 1.1 26 July 2013
 * @author Stella Djulgerova
 */
public class ClientGUI extends JFrame {

	private static final long serialVersionUID = 4025893542089938760L;

	// GUI components
	private JButton btnCancel;
	private JButton btnConnect;
	private JTextField txtNick;
	private JButton btnSend;
	private JButton btnLogout;
	public DefaultListModel<String> model;
	private JList<String> clientsList;
	private JScrollPane scrollReceiving;
	private JScrollPane scrollClients;
	private JPanel loginPanel;
	private JPanel consolePanel;
	private JTextPane receivedMsgs;
	private JScrollPane scrollInput;
	private JTextField sendMsgArea;
	public String username;
	private SimpleAttributeSet attrSet = new SimpleAttributeSet();
	private JLabel flagLabel;
	private JLabel langLabel;

	// language bundle and logger
	private ResourceBundle bundle;

	/**
	 * Constructor. Initialize all graphic components.
	 */
	public ClientGUI() {

		try {
			// load language bundle and logger
			LangBundleHandler.setLocale(Locale.US);
			bundle = LangBundleHandler.getBundle();
			
			// set the layout details
			loginPanel = new JPanel();
			GridBagLayout loginLayout = new GridBagLayout();
			loginLayout.rowWeights = new double[] { 0, 0, 0 };
			loginLayout.rowHeights = new int[] { 10, 10, 10 };
			loginLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
			loginLayout.columnWidths = new int[] { 300, 40, 40, 40, 40 };
			loginPanel.setLayout(loginLayout);

			// label to choose different language
			BufferedImage myPicture = ImageIO.read(getClass()
					.getResourceAsStream(bundle.getString("flagIcon")));
			flagLabel = new JLabel(new ImageIcon(myPicture));
			langLabel = new JLabel(bundle.getString("changeLang"));
			langLabel.setName(bundle.getString("lang"));
			flagLabel.setName(bundle.getString("lang"));

			loginPanel.add(langLabel, new GridBagConstraints(3, 0, 1, 1, 0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(10, 15, 0, 0), 0, 0));

			loginPanel.add(flagLabel, new GridBagConstraints(4, 0, 1, 1, 0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 10), 0, 0));

			// text field for nickname
			txtNick = new JTextField();
			loginPanel.add(txtNick, new GridBagConstraints(0, 1, 5, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10),
					0, 0));
			txtNick.setBorder(BorderFactory.createTitledBorder(bundle.getString("nick")));

			// connect button
			btnConnect = new JButton("connect");
			btnConnect.setActionCommand("connect");
			btnConnect.setSelected(true);
			loginPanel.add(btnConnect,
					new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5,
									0), 0, 0));

			// cancel button
			btnCancel = new JButton("cancel");
			btnCancel.setActionCommand("cancel");
			loginPanel.add(btnCancel, new GridBagConstraints(3, 2, 2, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 10), 0,
					0));

			consolePanel = new JPanel();
			GridBagLayout consoleLayout = new GridBagLayout();
			consoleLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
			consoleLayout.rowHeights = new int[] { 450, 20, 20 };
			consoleLayout.columnWeights = new double[] { 0, 0 };
			consoleLayout.columnWidths = new int[] { 600, 220 };
			consolePanel.setLayout(consoleLayout);

			// text area for receiving messages
			receivedMsgs = new JTextPane();
			scrollReceiving = new JScrollPane();
			receivedMsgs.setFont(new Font("Consolas", 0, 12)); 
			scrollReceiving.setViewportView(receivedMsgs);

			consolePanel.add(scrollReceiving, new GridBagConstraints(0, 0, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 10, 0, 0), 0, 0));
			receivedMsgs.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			receivedMsgs.setEditable(false);
			
			// make scroll to stay always at last line
			DefaultCaret caret = (DefaultCaret)receivedMsgs.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

			// text area where the user enters messages
			sendMsgArea = new JTextField();
			scrollInput = new JScrollPane(sendMsgArea);
			consolePanel.add(scrollInput, new GridBagConstraints(0, 1, 1, 2,
					0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 10, 10, 0), 0, 0));
			sendMsgArea.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));

			//sendMsgArea.setText((bundle.getString("write_here")));
			DocumentFilter dfilter = new Capitalizer();
			((AbstractDocument) sendMsgArea.getDocument()).setDocumentFilter(dfilter);

			// clients list area
			clientsList = new JList<String>();
			scrollClients = new JScrollPane();
			clientsList.setModel((model = new DefaultListModel<String>()));
			scrollClients.setViewportView(clientsList);
			model.addElement(bundle.getString("no_users"));
			clientsList.setSelectedIndex(0);
			// TODO
			updateOnlineUsers();

			consolePanel.add(scrollClients, new GridBagConstraints(1, 0, 1, 1,
					0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

			clientsList.setBorder(BorderFactory.createTitledBorder(bundle.getString("online")));

			// logout button
			btnLogout = new JButton(bundle.getString("logout"));
			btnLogout.setActionCommand("logout");
			consolePanel.add(btnLogout, new GridBagConstraints(1, 2, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 10),
					0, 0));

			btnSend = new JButton(bundle.getString("send"));
			btnSend.setActionCommand("send");
			btnSend.setEnabled(false);
			consolePanel.add(btnSend, new GridBagConstraints(1, 1, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(10, 10, 0, 10), 0, 0));

			getContentPane().add(consolePanel, BorderLayout.CENTER);
			getContentPane().add(loginPanel, BorderLayout.NORTH);

			sendMsgArea.getDocument().addDocumentListener(
					new DocumentListener() {
						String message;

						public void insertUpdate(DocumentEvent arg0) {
					
							message = sendMsgArea.getText();
		       				
							if (message.length() == 0 || "".equals(message.trim())) {
								SwingUtilities.invokeLater(new Runnable() {
									public void run() {
										sendMsgArea.setText("");
									}
								});
							} else {
								btnSend.setEnabled(true);
							}
							
							if (message.length() > 200) {
								message = message.substring(0, 200);
								SwingUtilities.invokeLater(new Runnable() {
									public void run() {
										sendMsgArea.setText(message);
									}
								});
							}

						}

						public void changedUpdate(DocumentEvent arg0) {
						}

						public void removeUpdate(DocumentEvent arg0) {
							if (sendMsgArea.getText().length() < 1) {
								btnSend.setEnabled(false);
							}
						}
					});

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			consolePanel.setVisible(false);

			setVisible(true);
			setResizable(false);
			setLocation(450, 400);
			pack();
			
		} catch (Exception ex) {
		}
	}

	/**
	 * Get Login panel
	 * @return - login panel
	 */
	public JPanel getLoginPanel() {
		return loginPanel;
	}

	/**
	 * Customize JList look and feel
	 * @param bundle - language bundle
	 */
	public void updateOnlineUsers() {
		clientsList.setCellRenderer(new DefaultListCellRenderer() {

			public Component getListCellRendererComponent(JList list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(
						list, value, index, isSelected, cellHasFocus);

				if(index > 0) {
					ImageIcon ii = new ImageIcon(this.getClass().getResource(
							"/images/online1.png"));
		
					label.setIcon(ii);
				} 
				
				return label;
			}
		});
	}

	/**
	 * Change JList items depend on how much users are online.
	 */
	public void updateUsersList() {
		if(model.getSize() == 1) {
			model.setElementAt(bundle.getString("no_users"), 0);
		} else {
			model.setElementAt(bundle.getString("all"), 0);
		}
	}

	/**
	 * Add action listeners
	 * 
	 * @param listener - mouse listener
	 */
	public void addClientActionListener(ActionListener listener) {
		btnCancel.addActionListener(listener);
		btnConnect.addActionListener(listener);
		btnSend.addActionListener(listener);
		btnLogout.addActionListener(listener);
	}

	/**
	 * Add mouse listeners
	 * 
	 * @param listener - mouse listener
	 */
	public void addClientMouseListener(MouseListener listener) {
		flagLabel.addMouseListener(listener);
		langLabel.addMouseListener(listener);
	}

	/**
	 * Get nickname text field
	 * @return - text field
	 */
	public JTextField getTxtNick() {
		return txtNick;
	}

	/**
	 * Get clients list
	 * @return - clients list
	 */
	public JList<String> getClientsList() {
		return clientsList;
	}

	/**
	 * Get messages area
	 * @return - message area
	 */
	public JTextField getSendMsgArea() {
		return sendMsgArea;
	}
	
	/**
	 * Show main form
	 */
	public void showChat() {
		setTitle(username);
		getLoginPanel().setVisible(false);
		sendMsgArea.requestFocus();
		consolePanel.setVisible(true);
		setLocation(250, 200);
		pack();
	}

	/**
	 * Show new message in text area.
	 * 
	 * @param msg - message
	 */
	public void showMessge(Message msg) {
	
		CustomMsgDecorator area = new CustomMsgDecorator(attrSet);
		DecoratorFactory factory = new DecoratorFactory();
		ICustomMsgDecorator decorator = factory.getDecorator(msg, area);

		StyledDocument doc = receivedMsgs.getStyledDocument();
		
		try {
			doc.insertString(doc.getLength(), 
					"<" + msg.date + ">" +
					"<" + msg.sender + ">: " 
					+ msg.content+"\n\n", decorator.getComponent());
		} catch (BadLocationException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * Updates GUI corresponding to the chosen language
	 * 
	 * @param bundle - language bundle
	 */
	public void updateComponents(ResourceBundle bundle) {
		this.bundle = bundle;
		// try to change language.
		try {
			btnCancel.setText(bundle.getString("cancel"));
			btnConnect.setText(bundle.getString("connect"));
			langLabel.setText(bundle.getString("changeLang"));
			txtNick.setBorder(BorderFactory.createTitledBorder(bundle.getString("nick")));
			btnLogout.setText(bundle.getString("logout"));
			btnSend.setText(bundle.getString("send"));
			clientsList.setBorder(BorderFactory.createTitledBorder(
					bundle.getString("online")));	
			model.setElementAt(bundle.getString("no_users"), 0);
			
			BufferedImage myPicture = ImageIO.read(getClass()
					.getResourceAsStream(bundle.getString("flagIcon")));
			flagLabel.setIcon(new ImageIcon(myPicture));
			langLabel.setName(bundle.getString("lang"));
			flagLabel.setName(bundle.getString("lang"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}