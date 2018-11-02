package hangman_GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 *       Title: HangmanDropdownPanel
 * Description: Custom JPanel to allow for selecting from the users that are saved
 *     Teacher: Sandra Stark
 *     Program: 420-B30 Programming III
 *      Author: Marissa Cleroux 
 */

public class HangmanDropdownPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> cmBxUsernames;
	private JButton btnSubmit;
	private JButton btnCancel;
	private HangmanFrame frame;

	public HangmanDropdownPanel() {
		setLayout(null);

		cmBxUsernames = new JComboBox<String>();
		cmBxUsernames.setBounds(51, 107, 192, 20);
		add(cmBxUsernames);

		JLabel lblSelectYourUsername = new JLabel("Select your username:");
		lblSelectYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectYourUsername.setBounds(77, 69, 166, 27);
		add(lblSelectYourUsername);

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(51, 138, 90, 23);
		add(btnSubmit);
		btnSubmit.addActionListener(this);

		btnCancel = new JButton("Cancel");
		btnCancel.setToolTipText("Don't see your username? Select here to enter.");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(153, 138, 90, 23);
		add(btnCancel);

		JLabel lblNoUsername = new JLabel("Don't see your username? Press cancel.");
		lblNoUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNoUsername.setBounds(36, 171, 240, 27);
		add(lblNoUsername);

	}// HangmanUserNameDropDownPanel()

	public void setFrame(HangmanFrame frame) {
		this.frame = frame;
	}

	public String getUserName() {
		return null;
	}// getUserName()

	public void setUsernames(String[] usernames) {
		for (String username : usernames) {
			cmBxUsernames.addItem(username);
		}
	}// retrieveUserNames()

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmit) {
			submit();
		} else if (e.getSource() == btnCancel) {
			this.setVisible(false);
			frame.displayEnterUsername();
		}
	}// actionPerformed(ActionEvent)

	public void submit() {
		frame.startGameAs(cmBxUsernames.getSelectedItem().toString());
		this.setVisible(false);
		frame.toggleGame(true);
	}// submit()
}// HangmanUserNameDropDownPanel class
