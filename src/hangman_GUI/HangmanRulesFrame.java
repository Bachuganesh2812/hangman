package hangman_GUI;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class HangmanRulesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HangmanRulesFrame() throws HeadlessException {
		getContentPane().setBackground(Color.WHITE);
		setTitle("INSTRUCTIONS");
		getContentPane().setLayout(null);
		setSize(445, 375);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 439, 346);
		getContentPane().add(panel);
				panel.setLayout(null);
		
				JLabel lblStart = new JLabel("To Start:");
				lblStart.setBounds(10, 7, 419, 19);
				panel.add(lblStart);
				lblStart.setFont(new Font("Calibri", Font.BOLD, 15));
				lblStart.setHorizontalAlignment(SwingConstants.LEFT);
				
						JTextArea txtInstructions = new JTextArea();
						txtInstructions.setBounds(10, 24, 414, 118);
						panel.add(txtInstructions);
						txtInstructions.setEditable(false);
						txtInstructions.setBackground(Color.WHITE);
						txtInstructions.setFont(new Font("Calibri", Font.PLAIN, 15));
						txtInstructions.setText("- First, select your account or create a new account;\r\n"
								+ "- If there is a saved game under your account you will be\r\n"
								+ "\tprompted to play it;\r\n"
								+ "- Either saved game or new game will load depending on the\r\n"
								+ "\tprevious step; \r\n");
						
								JLabel lblPlay = new JLabel("To Play:");
								lblPlay.setBounds(10, 141, 414, 17);
								panel.add(lblPlay);
								lblPlay.setFont(new Font("Calibri", Font.BOLD, 15));
								
										JTextArea txtrSelectWhich = new JTextArea();
										txtrSelectWhich.setBounds(10, 167, 414, 168);
										panel.add(txtrSelectWhich);
										txtrSelectWhich.setBackground(Color.WHITE);
										txtrSelectWhich.setEditable(false);
										txtrSelectWhich.setFont(new Font("Calibri", Font.PLAIN, 15));
										txtrSelectWhich.setText("- A random word will be selected and you may guess a single\r\n"
												+ "\tletter at a time; \r\n"
												+ "- You may also guess the whole word if you know it, but you must\r\n"
												+ "\tenter it with all of the characters, white space\r\n"
												+ "\tand punctuation included;\r\n"
												+ "- If you do not guess a correct letter the hangman will be\r\n"
												+ "\tdrawn to match; \r\n"
												+ "- You can make up to six mistakes before the game ends;\r\n");
	}
}
