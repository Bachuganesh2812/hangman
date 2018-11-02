package hangman_GUI;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HangmanEnterUsernamePanel extends JPanel implements ActionListener{
	
	private JTextField fldUsername;
	private JButton btnEnter;
	private JButton btnCancelEnterUsername;
	private JLabel lblEnterUsername;
	private JLabel lblEnterUsernameCancel;
	private HangmanFrame frame;
	
	public HangmanEnterUsernamePanel() {
		setLayout(null);

		fldUsername = new JTextField();
		fldUsername.setBounds(80, 92, 185, 20);
		add(fldUsername);
		fldUsername.setColumns(10);

		btnEnter = new JButton("Enter");
		btnEnter.setBounds(80, 123, 89, 23);
		add(btnEnter);
		btnEnter.addActionListener(this);

		btnCancelEnterUsername = new JButton("Cancel");
		btnCancelEnterUsername.setBounds(179, 123, 89, 23);
		add(btnCancelEnterUsername);
		btnCancelEnterUsername.addActionListener(this);

		lblEnterUsername = new JLabel("Enter a unique username:");
		lblEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterUsername.setBounds(85, 57, 180, 23);
		add(lblEnterUsername);

		lblEnterUsernameCancel = new JLabel("Press cancel to select a username from a drop down list.");
		lblEnterUsernameCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUsernameCancel.setBounds(0, 166, 370, 23);
		add(lblEnterUsernameCancel);
		

	}
	
	public void setFrame(HangmanFrame frame) {
		this.frame = frame;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnter) {
			frame.enterUsername(fldUsername.getText());
		} else if (e.getSource() == btnCancelEnterUsername) {
			frame.displayUserDropDown();
		}
	}

}
