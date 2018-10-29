package hangman_GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangmanDropdownPanel extends JPanel {

	public HangmanDropdownPanel() {
		setLayout(null);

		JComboBox<String> cmBxUsernames = new JComboBox<String>();
		cmBxUsernames.setBounds(77, 107, 153, 20);
		add(cmBxUsernames);

		JLabel lblSelectYourUsername = new JLabel("Select your username:");
		lblSelectYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectYourUsername.setBounds(77, 69, 166, 27);
		add(lblSelectYourUsername);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(76, 137, 71, 23);
		add(btnSubmit);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setToolTipText("Don't see your username? Select here to enter.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(157, 138, 73, 23);
		add(btnNewButton);
		// TODO Auto-generated constructor stub
	}// HangmanUserNameDropDownPanel()

	public String getUserName() {
		return null;
	}// getUserName()

	public void retrieveUserNames() {

	}// retrieveUserNames()

}// HangmanUserNameDropDownPanel class
