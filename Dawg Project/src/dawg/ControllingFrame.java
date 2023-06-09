/**
 * 
 */
package dawg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import auth.Authenticator;
import config.ConfigurationParameters;

//import image_dnd.ImagePanel;
/**
 * @author jammavi
 *
 */
public class ControllingFrame extends JFrame implements ActionListener, FocusListener, ConfigurationParameters {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WIDTH = ConfigurationParameters.width, HEIGHT = ConfigurationParameters.height;

	// Container panel has two components, 1. The info panel, and 2. the
	// corresponding button panel.
	private JPanel containerPanel;
	private JPanel informationPanel;
	private JPanel buttonPanel;

	private String regLogin, regPasswd;

	private StartUpScreen authScreen;
	private ButtonPanelForAuthentication authButtons;
	private FourButtons fourButtons;
	private ContestView contest;
	private RegisterContainer register;
	private Authenticator auth;

	private static ControllingFrame instance = null;

	private ControllingFrame(String title) {
		// initial setup
		auth = new Authenticator();

		instance = this;
		setBackground(Color.BLACK);
		setTitle(title);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLocationRelativeTo(null); //sets the pop up screen to the bottom right
		// corner
		Dimension screenDimension = getToolkit().getScreenSize();
		setLocation(screenDimension.width / 2 - WIDTH / 2, screenDimension.height / 2 - HEIGHT / 2);
		addComponents();
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println("Errors setting UI look and feel!");
			System.exit(0);
		}
		pack();
		setVisible(true);
	}

	public static ControllingFrame getInstance() {
		return getInstance("Demo");
	}

	public static ControllingFrame getInstance(String title) {
		if (instance == null) {
			new ControllingFrame(title);
		} else {
			if (!instance.getTitle().equals(title))
				instance.setTitle(title);
		}
		return instance;
	}

	private void addComponents() {

		setLayout(new BorderLayout());

		containerPanel = new JPanel();
		containerPanel.setLayout(new BorderLayout());

		informationPanel = new JPanel();
		informationPanel.setLayout(new CardLayout(10, 10));

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new CardLayout(10, 10));

		// add the various information panels to be switched to the info container
		// add the corresponding buttons to the buttons panel

		authScreen = new StartUpScreen(this, "dog_logo.png");
		contest = new ContestView();
		register = new RegisterContainer(this);

		informationPanel.add(authScreen, "TITLE");
		informationPanel.add(contest, "Contest View");
		informationPanel.add(register, "Register");

		containerPanel.add(informationPanel, BorderLayout.CENTER);

		authButtons = new ButtonPanelForAuthentication();
		fourButtons = new FourButtons();
		buttonPanel.add(authButtons, "AUTH");
		buttonPanel.add(fourButtons, "4Buttons");
		containerPanel.add(buttonPanel, BorderLayout.LINE_END);

		add(containerPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		Object o = null;
		o = e.getSource();
		switch (actionCommand) {
		case "LOGIN":

			if (o instanceof JTextField) {
				JTextField tf = (JTextField) o;
				System.out.println("Login field:  " + tf.getText());
			} else if (o instanceof JButton) {
				System.out.println("Login button pressed!");
				if(auth.hasAccount(regLogin)) {
				CardLayout layout = (CardLayout) buttonPanel.getLayout();
				layout.show(buttonPanel, "4Buttons");
				}
			}
			break;

		case "Create":
			if (o instanceof JButton) {
				if (!auth.hasAccount(regLogin)) {
					auth.putPassword(regLogin, regPasswd);
					auth.commit();
				} else {
					System.out.println("Password exists!");
				}
			}
			break;
	//	case "PASSWORD":

		//	if (o instanceof JPasswordField) {
		//		JPasswordField tf = (JPasswordField) o;
	//			char[] password = tf.getPassword();
		//		System.out.println("Password field:  " + new String(password));
	//		}
		//	break;
		case "Records":

			break;

		case "Register":
			if (o instanceof JButton) {

				CardLayout layout = (CardLayout) informationPanel.getLayout();
				layout.show(informationPanel, "Register");
			}
			break;

		case "Contest View":

			if (o instanceof JButton) {

				CardLayout layout = (CardLayout) informationPanel.getLayout();
				layout.show(informationPanel, "Contest View");
			}
			break;

		case "Exit":

			if (o instanceof JButton) {
				System.out.println("Main Button clicked");
				CardLayout layout = (CardLayout) informationPanel.getLayout();

				layout.show(informationPanel, "TITLE");

				CardLayout layout1 = (CardLayout) buttonPanel.getLayout();
				layout1.show(buttonPanel, "AUTH");

			}
			break;

		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		Object o = e.getSource();
		if (o instanceof JPasswordField) {
			JPasswordField pf = (JPasswordField) o;
			regPasswd = new String(pf.getPassword());
			System.out.println(regPasswd);
		} else if (o instanceof JTextField) {
			JTextField tf = (JTextField) o;
			regLogin = tf.getText();
			System.out.println(regLogin);
		}
	}

}
