/**
 * 
 */
package dawg;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * @author jammavi
 *
 */
public class RegisterContainer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControllingFrame controller;

	public RegisterContainer(ControllingFrame controller) {
		this.controller = controller;

		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new DnDImagePanel(controller, "GhoseImageTemplate.png"));
		add(new Register());
		add(new CheckBoxPanel());
		add(new DnDImagePanel(controller, "dawgfoodad.png"));
	}

}
