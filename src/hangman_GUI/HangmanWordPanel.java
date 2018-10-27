package hangman_GUI;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class HangmanWordPanel extends JPanel {
	private JTextField textField;

	public HangmanWordPanel() {
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.control);
		textArea.setBounds(60, 62, 315, 107);
		add(textArea);
		
		textField = new JTextField();
		textField.setBounds(130, 195, 75, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Guess");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(215, 195, 75, 21);
		add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(300, 195, 75, 21);
		add(btnClear);
		
		JButton btnGuessWholeWord = new JButton("Guess Whole Word");
		btnGuessWholeWord.setBounds(215, 227, 160, 23);
		add(btnGuessWholeWord);
		
		JLabel lblNewLabel = new JLabel("Your Guess:");
		lblNewLabel.setBounds(60, 198, 60, 18);
		add(lblNewLabel);
		// TODO Auto-generated constructor stub
	}

	public HangmanWordPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HangmanWordPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HangmanWordPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
}
