package hangman_GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HangmanWordPanel extends JPanel implements ActionListener{
	private JTextField guessTextField;
	private JTextArea wordTextArea;
	private JButton btnGuess;
	private JButton btnClear;
	private JButton btnGuessWholeWord;

	public HangmanWordPanel() {
		setLayout(null);
		
		//36
		wordTextArea = new JTextArea();
		wordTextArea.setFont(new Font("Calibri", Font.PLAIN, 35));
		wordTextArea.setEditable(false);
		wordTextArea.setBackground(SystemColor.control);
		wordTextArea.setBounds(47, 11, 374, 188);
		add(wordTextArea);
		
		guessTextField = new JTextField();
		guessTextField.setBounds(141, 210, 75, 21);
		add(guessTextField);
		guessTextField.setColumns(10);
		
		btnGuess = new JButton("Guess");
		btnGuess.setBounds(238, 210, 75, 21);
		add(btnGuess);
		btnGuess.addActionListener(this);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(323, 210, 75, 21);
		add(btnClear);
		btnClear.addActionListener(this);
		
		btnGuessWholeWord = new JButton("Guess Whole Word");
		btnGuessWholeWord.setBounds(238, 242, 160, 23);
		add(btnGuessWholeWord);
		btnGuessWholeWord.addActionListener(this);
		
		JLabel lblYourGuess = new JLabel("Your Guess:");
		lblYourGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYourGuess.setBounds(38, 210, 93, 18);
		add(lblYourGuess);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGuess) {
			
		}
	}
	
	public String getGuessValue() {
		return guessTextField.getText();
	}
	
	public void drawWord(String word) {
		wordTextArea.append(word);	
	}
}
