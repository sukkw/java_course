package com.sirma.itt.javacourse.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import com.sirma.itt.javacourse.common.Capitalizer;
import com.sirma.itt.javacourse.common.LogFileHandler;
import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.config.Config;

public class ChatFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 4025893542089938760L;

	public SocketClient client;
	public String username;
	public Thread clientThread;
	public DefaultListModel model;

	private JButton btnCancel;
	private JButton btnConnect;
	private JTextField txtNick;

	private Logger log = Logger.getLogger("LoginView");

	private JButton btnSend;
	private JButton btnLogout;

	private JList clientsList;

	private JScrollPane scrollReseiving;
	private JScrollPane scrollClients;

	private JTextArea receivedMsgs;
	private JTextField sendMsgArea;

	private JScrollPane scrollInput;

	private JLabel flagLabel;
	private JLabel langLabel;

	private ResourceBundle bundle;

	private JPanel loginPanel;
	private JPanel consolePanel;
	
	public ChatFrame() {
		initComponents();
		
		model.addElement("All");
		clientsList.setSelectedIndex(0);

		this.addWindowListener(new WindowListener() {

			public void windowOpened(WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {
				try {
					client.send(new Message("message", username, ".bye",
							"SERVER"));
					clientThread.stop();
				} catch (Exception ex) {
				}
			}

			public void windowClosed(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowActivated(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent e) {
			}
		});
	}

	private void initComponents() {

		try {
			bundle = ResourceBundle.getBundle(Config.LANG_BUNDLE);
			log.addHandler(LogFileHandler.getHandler());

			// set the layout details
			loginPanel = new JPanel();
			GridBagLayout loginLayout = new GridBagLayout();
			loginLayout.rowWeights = new double[] { 0, 0, 0 };
			loginLayout.rowHeights = new int[] { 10, 10, 10 };
			loginLayout.columnWeights = new double[] { 0.0, 0.0, 0.0 };
			loginLayout.columnWidths = new int[] { 340, 5, 5 };
			loginPanel.setLayout(loginLayout);
			
			// label to choose different language
			BufferedImage myPicture = ImageIO.read(getClass()
					.getResourceAsStream(bundle.getString("flagIcon")));
			flagLabel = new JLabel(new ImageIcon(myPicture));
			langLabel = new JLabel(bundle.getString("changeLang"));
			langLabel.setName(bundle.getString("lang"));
			flagLabel.setName(bundle.getString("lang"));

			loginPanel.add(
					langLabel,
					new GridBagConstraints(1, 0, 1, 1, 0, 0.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
							0, 0));

			loginPanel.add(
					flagLabel,
					new GridBagConstraints(2, 0, 1, 1, 0, 0.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(0, 0,
									0, 0), 0, 0));

			// text field for nickname
			txtNick = new JTextField();
			loginPanel.add(txtNick, new GridBagConstraints(0, 1, 3, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0,
					0));
			txtNick.setBorder(BorderFactory
					.createTitledBorder("Please enter your nickname"));

			// connect button
			btnConnect = new JButton("connect");
			btnConnect.setActionCommand("connect");
			btnConnect.setSelected(true);
			loginPanel.add(btnConnect, new GridBagConstraints(1, 2, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 0), 0,
					0));

			// cancel button
			btnCancel = new JButton("cancel");
			btnCancel.setActionCommand("cancel");
			loginPanel.add(btnCancel, new GridBagConstraints(2, 2, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 10), 0,
					0));

			// //////////////////////////////////////////////////

			consolePanel = new JPanel();
			GridBagLayout consoleLayout = new GridBagLayout();
			consoleLayout.rowWeights = new double[] { 0.0, 0.0, 0.0 };
			consoleLayout.rowHeights = new int[] { 450, 20, 20 };
			consoleLayout.columnWeights = new double[] { 0, 0 };
			consoleLayout.columnWidths = new int[] { 600, 220 };
			consolePanel.setLayout(consoleLayout);

			// text area for receiving messages
			receivedMsgs = new JTextArea();
			scrollReseiving = new JScrollPane();

			receivedMsgs.setColumns(20);
			receivedMsgs.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
			receivedMsgs.setRows(5);
			scrollReseiving.setViewportView(receivedMsgs);

			consolePanel.add(scrollReseiving, new GridBagConstraints(0, 0, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 10, 0, 0), 0, 0));
			receivedMsgs.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			receivedMsgs.setEditable(false);
			/*
			 * receivedMsgs
			 * .append("[<12:22:54>] <Black.Flame>: <Hello my beautiful people>\n"
			 * ); receivedMsgs.append("[<12:22:54>] <Black.Flame>: <Lalala>\n");
			 * receivedMsgs.append("[<12:22:54>] <Black.Flame>: <HYoooo>\n");
			 */
			// text area where the user enters messages
			sendMsgArea = new JTextField();
			scrollInput = new JScrollPane(sendMsgArea);
			consolePanel.add(scrollInput, new GridBagConstraints(0, 1, 1, 2,
					0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 10, 10, 0), 0, 0));
			sendMsgArea.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));

			// sendMsgArea.append("Write your message here...");
			DocumentFilter dfilter = new Capitalizer();

			((AbstractDocument) sendMsgArea.getDocument())
					.setDocumentFilter(dfilter);

			// clients list area
			clientsList = new JList();
			scrollClients = new JScrollPane();
			clientsList.setModel((model = new DefaultListModel()));
			scrollClients.setViewportView(clientsList);
			
			clientsList.setCellRenderer(new DefaultListCellRenderer() {
	        	  
	            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	               
	                ImageIcon pigIcon = createImageIcon("../images/online1.png",
	        				"a cute pig");
	                    label.setIcon(pigIcon);
	                return label;
	            }
	        });

			consolePanel.add(
					scrollClients,
					new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(10, 10, 0, 10), 0, 0));

			clientsList.setBorder(BorderFactory
					.createTitledBorder("Online users"));
			// clientsList.setEditable(false);

			// logout button
			btnLogout = new JButton();
			btnLogout.setActionCommand("logout");
			consolePanel.add(
					btnLogout,
					new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 10,
									10, 10), 0, 0));
			btnLogout.setText("logout");

			btnSend = new JButton();
			btnSend.setActionCommand("send");
			consolePanel.add(
					btnSend,
					new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(10, 10, 0, 10), 0, 0));
			btnSend.setText("send");
			//btnSend.setEnabled(false);

			getContentPane().add(consolePanel, BorderLayout.CENTER);
			getContentPane().add(loginPanel, BorderLayout.NORTH);
			
			btnCancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					btnCancelActionPerformed(evt);
				}
			});

			btnConnect.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					btnConnectActionPerformed(evt);
				}
			});

			btnSend.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					btnSendActionPerformed(evt);
				}
			});
			
			btnLogout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					btnLogOutActionPerformed(evt);
				}
			});
			
			sendMsgArea.getDocument().addDocumentListener( new DocumentListener () {
				String message;
				public void insertUpdate(DocumentEvent arg0) {
					 message = sendMsgArea.getText();
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
					// TODO Auto-generated method stub
					
				}

				public void removeUpdate(DocumentEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});

			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			consolePanel.setVisible(false);
			
			setResizable(false);
			setLocation(300, 220);
			pack();

		} catch (Exception ex) {
			receivedMsgs.append("[Application > Me] : Server not found\n");
		}
	}

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			client.send(new Message("message", username, ".bye", "SERVER"));
			clientThread.stop();
			dispose();
		} catch (Exception ex) {
		}

	}

	private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		String msg = sendMsgArea.getText();
		String target = clientsList.getSelectedValue().toString();

		if (!msg.isEmpty() && !target.isEmpty()) {
			System.out.println("clear??");
			
			client.send(new Message("message", username, msg, target));
			sendMsgArea.setText("");
			sendMsgArea.requestFocus();
		}
	}

	private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {
		
		
		try {
			client = new SocketClient(this);
			client.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clientThread = new Thread(client);
		clientThread.start();

		username = txtNick.getText();
		setTitle(username);
		if (!username.isEmpty()) {
			client.send(new Message("signup", username, "", "SERVER"));
		}
	}
	
	private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		try {
			client.send(new Message("message", username, ".bye",
					"SERVER"));
			clientThread.stop();
			//dispose();
		} catch (Exception ex) {
		}
	}

	/**
	 * Shows different messages.
	 * 
	 * @param message
	 *            - message to be shown.
	 */
	public void showMessage(String message) {
		receivedMsgs.append(message + "\n");
	}

	public JPanel getLoginPanel() {
		return loginPanel;
	}

	public JPanel getConsolePanel() {
		return consolePanel;
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = Capitalizer.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}