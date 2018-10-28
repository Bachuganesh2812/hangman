package hangman_GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import hangman_logic.HangmanController;
import hangman_logic.HangmanGame;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class HangmanFrame extends JFrame implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HangmanController hangmanController;
	private HangmanGame game;
	private HangmanPanel hangmanPanel;
	private JTextField txtFldGuess;
	private JButton btnGuess;
	private JButton btnClear;
	private JButton btnGuessWholeWord;
	private JTextPane txtPaneWordDisplay;
	private JLabel lblGuessedLetter;
	private JTextPane txtPaneGuessedLetters;
	private JTextField txtFldNumMistakes;
	private JButton btnHint;

	private JMenuItem mntmScoreboard;
	private JMenuItem mntmSaveGame;
	private JMenuItem mntmNewGame;
	private JMenuItem mntmQuit;

	public HangmanFrame() throws HeadlessException {
		setTitle("Hangman");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		mntmScoreboard = new JMenuItem("Scoreboard");
		mntmScoreboard.addActionListener(this);
		mnMenu.add(mntmScoreboard);

		mntmSaveGame = new JMenuItem("Save Game");
		mntmSaveGame.addActionListener(this);
		mnMenu.add(mntmSaveGame);

		mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(this);
		mnMenu.add(mntmNewGame);

		mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(this);
		mnMenu.add(mntmQuit);
		getContentPane().setLayout(null);

		hangmanPanel = new HangmanPanel();
		hangmanPanel.setBounds(0, 56, 178, 269);
		getContentPane().add(hangmanPanel);

		btnGuess = new JButton("Guess");
		btnGuess.addActionListener(this);
		btnGuess.setToolTipText("Enter your single letter guess");
		btnGuess.setForeground(SystemColor.textText);
		btnGuess.setBounds(420, 224, 75, 23);
		getContentPane().add(btnGuess);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		btnClear.setBounds(505, 224, 75, 23);
		getContentPane().add(btnClear);

		txtFldGuess = new JTextField();
		txtFldGuess.setBounds(324, 225, 86, 20);
		getContentPane().add(txtFldGuess);
		txtFldGuess.setColumns(10);

		JLabel lblYourGuess = new JLabel("Your Guess:");
		lblYourGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYourGuess.setBounds(204, 226, 110, 19);
		getContentPane().add(lblYourGuess);

		btnGuessWholeWord = new JButton("Guess Whole Word");
		btnGuessWholeWord.setBounds(420, 294, 162, 23);
		btnGuessWholeWord.addActionListener(this);
		getContentPane().add(btnGuessWholeWord);

		txtPaneWordDisplay = new JTextPane();
		txtPaneWordDisplay.setEditable(false);
		txtPaneWordDisplay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPaneWordDisplay.setBounds(204, 56, 461, 157);
		getContentPane().add(txtPaneWordDisplay);

		JLabel lblMistakesLeft = new JLabel("Mistakes Left:");
		lblMistakesLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMistakesLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMistakesLeft.setBounds(430, 22, 150, 23);
		getContentPane().add(lblMistakesLeft);

		lblGuessedLetter = new JLabel("Guessed Letters:");
		lblGuessedLetter.setHorizontalAlignment(SwingConstants.LEFT);
		lblGuessedLetter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGuessedLetter.setBounds(10, 349, 156, 23);
		getContentPane().add(lblGuessedLetter);

		txtPaneGuessedLetters = new JTextPane();
		txtPaneGuessedLetters.setEditable(false);
		txtPaneGuessedLetters.setBounds(10, 381, 655, 129);
		getContentPane().add(txtPaneGuessedLetters);

		txtFldNumMistakes = new JTextField();
		txtFldNumMistakes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtFldNumMistakes.setEditable(false);
		txtFldNumMistakes.setBounds(590, 22, 75, 23);
		getContentPane().add(txtFldNumMistakes);
		txtFldNumMistakes.setColumns(10);

		btnHint = new JButton("Give Hint");
		btnHint.setBounds(420, 258, 160, 23);
		getContentPane().add(btnHint);
		btnHint.addActionListener(this);

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		HangmanFrame frame = new HangmanFrame();
		frame.setSize(950, 550);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.start();

	}

	public void start() {
		hangmanController = new HangmanController();
		if (hangmanController.retrieveScoreboard()) {
			int choice = JOptionPane.showConfirmDialog(this, "Have you played Hangman before?", "Start",
					JOptionPane.YES_NO_OPTION);
			this.setEnabled(true);
			if (choice == 0) {
				displayUserDropDown();
			} else {
				displayEnterUser();
			}
		} else
			displayEnterUser();

	}

	public void displayUserDropDown() {
		String[] usernames = hangmanController.retrieveUserNames();
		String dialog = "Select your username.\nDon't see your username?\nClick cancel to enter it.";
		String title = "Select your username";

		String choice = (String) JOptionPane.showInputDialog(this, dialog, title, JOptionPane.PLAIN_MESSAGE, null,
				usernames, "  ");
	}

	public void displayEnterUser() {
		String dialog = "Enter your username.\nRemember your username?\nClick cancel to select it.";
		String title = "Enter your username";

		String username = (String) JOptionPane.showInputDialog(this, dialog, title, JOptionPane.PLAIN_MESSAGE);

		if (hangmanController.checkIfUsernameIsTaken(username)) {
			displayWarning(username);
		} else {
			displayContinueSavedGame();
		}
	}

	public void displayWarning(String username) {
		String dialog = "The username: " + username + " is already taken.\nDo you want to continue as " + username
				+ "?";
		String title = "Username Taken";

		int choice = JOptionPane.showConfirmDialog(this, dialog, title, JOptionPane.YES_NO_OPTION);
		if (choice == 0 && hangmanController.retrieveGame()) {
			displayContinueSavedGame();
		} else if (choice == 0) {
			hangmanController.initializeHangman();
			game = hangmanController.getGame();
			displayGame();
		} else {
			displayEnterUser();
		}

	}

	private void displayContinueSavedGame() {
		String dialog = "There is a saved game on file.\nDo you want to continue where the last player left off?";
		String title = "Saved Game Available";

		int choice = JOptionPane.showConfirmDialog(this, dialog, title, JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			game = new HangmanGame();
			game = game.retrieveSavedGame();
			if (game != null) {
				System.out.println("Save game has been retrieved");
				displayGame();
			} else {
				System.out.println("Saved game could not be retrieved.");
			}
		} else {
			game = hangmanController.getGame();
			displayGame();
		}

	}

	public void displayGame() {
		this.setVisible(true);
		txtPaneWordDisplay.setText(game.toString());
		txtFldNumMistakes.setText("" + game.getMistakesLeft());
		displayWord();
	}

	public void displayCheckLetterOutput() {
		int checkLetterOutput = game.checkLetter(txtFldGuess.getText());

		if (checkLetterOutput == -1) {
			JOptionPane.showMessageDialog(this,
					"Your input was invalid.\nYour input must be a single letter guess.\nTo guess the whole phrase press the\n"
							+ "Guess whole word button.");
		} else if (checkLetterOutput == -2) {
			JOptionPane.showMessageDialog(this,
					"This letter was already guessed.\nTo see the guessed letter please refer to the bottom of the frame.");
		} else if (checkLetterOutput == -10) {
			gameOver();
		} else {
			displayWord();
			txtPaneGuessedLetters.setText(game.toString());
			txtFldNumMistakes.setText("" + game.getMistakesLeft());
		}
	}

	public void gameOver() {
		int choice = JOptionPane.showConfirmDialog(this, "You made too many mistakes!\nWould you like to play again?",
				"Game Over", JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			newGame();
		} else {
			txtPaneGuessedLetters.setText(game.toString());
			txtFldNumMistakes.setText("" + game.getMistakesLeft());
			displayWord();
			hangmanPanel.setEnabled(false);
			txtFldGuess.setEnabled(false);
			btnGuess.setEnabled(false);
			btnClear.setEnabled(false);
			btnGuessWholeWord.setEnabled(false);
			txtPaneWordDisplay.setEnabled(false);
			btnHint.setEnabled(false);
		}
	}

	public void newGame() {
		if (hangmanController.getNewGame()) {
			game = hangmanController.getGame();
		} else {
			JOptionPane.showMessageDialog(this, "Something went wrong please try again later.");
		}
	}

	public void displayWord() {
		String displayInterfaceLetters = "";
		for (int i = 0; i < game.getInterfaceLetters().length(); i++) {
			displayInterfaceLetters += game.getInterfaceLetters().charAt(i);
			displayInterfaceLetters += " ";
		}

		txtPaneWordDisplay.setText(displayInterfaceLetters);
	}

	public void gameWon() {

	}

	public void guessWholeWord() {
		String title = "Guess Whole Word";
		String dialog = "Enter the whole word.\nPlease include any spaces/and or dashes seen on the board.";
		String guess = (String) JOptionPane.showInputDialog(this, dialog, title, JOptionPane.PLAIN_MESSAGE);
		if (guess != null) {
			int output = game.checkWord(guess);
			if (output == 1) {
				gameWon();
			} else if (output == -1) {
				JOptionPane.showMessageDialog(this, "Your entered word did not match!");
			} else if (output == -2) {
				JOptionPane.showMessageDialog(this, "That was an invalid entry.");
			} else {
				gameOver();
			}
		}
	}

	public void giveHint() {
		if (!game.giveHint()) {
			JOptionPane.showMessageDialog(this, "You have already used your hint - you are limited to one hint.");
		} else {
			displayWord();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuess) {
			displayCheckLetterOutput();
			txtFldGuess.setText("");
		} else if (e.getSource() == btnHint) {
			giveHint();
		} else if (e.getSource() == btnGuessWholeWord) {
			guessWholeWord();
		} else if (e.getSource() == mntmSaveGame) {
			hangmanController.saveGame(game);
		}

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
}
