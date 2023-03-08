/**
 * 
 */
package dawg;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author jammavi
 *
 */
public class CheckBoxPanel extends JPanel {

	private JCheckBox grooming, obedience, socialization, fetch;
	private ControllingFrame controller;

	public CheckBoxPanel() {
		addComponents();
	}

	private void addComponents() {
		controller = ControllingFrame.getInstance();
		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		grooming = new JCheckBox("Grooming", false);
		grooming.addActionListener(controller);

		obedience = new JCheckBox("Obedience", false);
		obedience.addActionListener(controller);

		socialization = new JCheckBox("Socialization", false);
		socialization.addActionListener(controller);

		fetch = new JCheckBox("Fetch", false);
		fetch.addActionListener(controller);

		JLabel contest = new JLabel("Contest(s): ", JLabel.LEFT);
		contest.setLabelFor(this);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(controller);
		saveButton.setActionCommand("Save");

		add(contest);
		add(grooming);
		add(Box.createHorizontalStrut(25));
		add(obedience);
		add(Box.createHorizontalStrut(25));
		add(socialization);
		add(Box.createHorizontalStrut(25));
		add(fetch);
		add(Box.createHorizontalStrut(250));
		add(saveButton);
	}
}
