/**
 * 
 */
package dawg;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.ConfigurationParameters;

/**
 * @author jammavi
 *
 */
public class Register extends JPanel {
	private static final long serialVersionUID = 1L;
	private ControllingFrame controller;
	private final int WIDTH = ConfigurationParameters.width, HEIGHT = ConfigurationParameters.height;

	private JTextField nameField, idField, ownerField;
	private JCheckBox grooming, obedience, socialization, fetch;
	String[] genders = new String[] { "Gender", "Male", "Female" };
	private JComboBox<String> genderDropDown;

	public Register() {
		this.controller = ControllingFrame.getInstance();
		// setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		addComponents();
	}

	private void addComponents() {
		// JPanel dndPanel = new DnDImagePanel(controller, "GhoseImageTemplate.png");

		GroupLayout layout = new GroupLayout(this);

		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		JLabel label1 = new JLabel("Name: ", JLabel.CENTER);
		label1.setLabelFor(nameField);

		JLabel label2 = new JLabel("ID: ", JLabel.CENTER);
		label2.setLabelFor(idField);

		JLabel label3 = new JLabel("Gender: ", JLabel.CENTER);
		label3.setLabelFor(genderDropDown);

		JLabel label4 = new JLabel("Owner: ", JLabel.CENTER);
		label4.setLabelFor(ownerField);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(controller);
		saveButton.setActionCommand("Save");

		nameField = new JTextField("Enter name", 10);
		nameField.addActionListener(controller);
		nameField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent event) {
				if (nameField.getText().equals("Enter name")) {
					nameField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (nameField.getText().equals("")) {
					nameField.setText("Enter name");
				}

			}
		});

		idField = new JTextField("Enter ID", 10);
		idField.addActionListener(controller);
		idField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent event) {
				if (idField.getText().equals("Enter ID")) {
					idField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idField.getText().equals("")) {
					idField.setText("Enter ID");
				}

			}
		});

//		genderField = new JTextField("Enter Gender", 10);
//		genderField.addActionListener(controller);
//		genderField.addFocusListener(new FocusListener() {
//        	@Override
//        	public void focusGained(FocusEvent event) {
//        		if (genderField.getText().equals("Enter Gender")) {
//        			genderField.setText("");
//        		}
//        	}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				if (genderField.getText().equals("")) {
//					genderField.setText("Enter Gender");
//        		}
//				
//			}
//        });
		genderDropDown = new JComboBox<>(genders);

		ownerField = new JTextField("Enter Owner's Name", 10);
		ownerField.addActionListener(controller);
		ownerField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent event) {
				if (ownerField.getText().equals("Enter Owner's Name")) {
					ownerField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (ownerField.getText().equals("")) {
					ownerField.setText("Enter Owner's Name");
				}

			}
		});

		layout.setHorizontalGroup(layout.createSequentialGroup()
				// .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				// .addComponent(dndPanel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(label1)
						.addComponent(label2).addComponent(label3).addComponent(label4))

				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(nameField)
						.addComponent(idField).addComponent(genderDropDown).addComponent(ownerField))

		);
		layout.setVerticalGroup(layout.createSequentialGroup().addGap(30)
				// .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				// .addComponent(dndPanel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label1)
						.addComponent(nameField))
				.addGap(15)
				.addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label2).addComponent(idField))
				.addGap(15)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label3)
						.addComponent(genderDropDown))
				.addGap(15).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label4)
						.addComponent(ownerField))
				.addGap(15)

		);

	}
}
