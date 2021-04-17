package frontend;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class StartView extends JPanel {

	public StartView() {
		setLayout(null);
		JLabel lblStartView = new JLabel("Das wird das Startmen\u00FC sein");
		lblStartView.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStartView.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartView.setBounds(10, 182, 580, 22);
		add(lblStartView);

	}
}
