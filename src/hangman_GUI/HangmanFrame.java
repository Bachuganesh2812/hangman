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
	 * WORDS WITH SPACES DON'T WORK
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
	private JTextField fldNumMistakes;
	private JButton btnHint;
	private JLabel lblYourGuess;
	private JLabel lblMistakesLeft;

	private JMenuItem mntmScoreboard;
	private JMenuItem mntmSaveGame;
	private JMenuItem mntmNewGame;
	private JMenuItem mntmQuit;
	
	private JTextField fldUsername;
	private JButton btnEnter;
	private JButton btnCancelEnterUsername;
	private JLabel lblEnterUsername;
	private JLabel lblEnterUsernameCancel;

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

		lblYourGuess = new JLabel("Your Guess:");
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

		lblMistakesLeft = new JLabel("Mistakes Left:");
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

		fldNumMistakes = new JTextField();
		fldNumMistakes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fldNumMistakes.setEditable(false);
		fldNumMistakes.setBounds(590, 22, 75, 23);
		getContentPane().add(fldNumMistakes);
		fldNumMistakes.setColumns(10);

		btnHint = new JButton("Give Hint");
		btnHint.setBounds(420, 258, 160, 23);
		getContentPane().add(btnHint);
		
		fldUsername = new JTextField();
		fldUsername.setBounds(225, 179, 185, 20);
		getContentPane().add(fldUsername);
		fldUsername.setColumns(10);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(225, 210, 89, 23);
		getContentPane().add(btnEnter);
		btnEnter.addActionListener(this);
		
		btnCancelEnterUsername = new JButton("Cancel");
		btnCancelEnterUsername.setBounds(324, 210, 89, 23);
		getContentPane().add(btnCancelEnterUsername);
		btnCancelEnterUsername.addActionListener(this);
		
		lblEnterUsername = new JLabel("Enter a unique Username:");
		lblEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterUsername.setBounds(225, 145, 180, 23);
		getContentPane().add(lblEnterUsername);
		
		lblEnterUsernameCancel = new JLabel("Press cancel to select a username from a drop down list.");
		lblEnterUsernameCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUsernameCancel.setBounds(132, 244, 370, 23);
		getContentPane().add(lblEnterUsernameCancel);
		btnHint.addActionListener(this);
	}

	public static void main(String[] args) {
		HangmanFrame frame = new HangmanFrame();
		frame.setSize(692, 582);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.toggleGame(false);
		frame.toggleEnterUsername(false);
		frame.start();
	}
	
	public void toggleGame(boolean show) {
		hangmanPanel.setVisible(show);
		txtFldGuess.setVisible(show);
		btnGuess.setVisible(show);
		btnClear.setVisible(show);
		btnGuessWholeWord.setVisible(show);
		txtPaneWordDisplay.setVisible(show);
		lblGuessedLetter.setVisible(show);
		txtPaneGuessedLetters.setVisible(show);
		fldNumMistakes.setVisible(show);
		btnHint.setVisible(show);
		lblYourGuess.setVisible(show);
		lblMistakesLeft.setVisible(show);
		mntmSaveGame.setEnabled(show);
		mntmNewGame.setEnabled(show);
	}
	
	public void toggleEnterUsername(boolean show) {
		fldUsername.setVisible(show);
		btnEnter.setVisible(show);
		btnCancelEnterUsername.setVisible(show);
		lblEnterUsername.setVisible(show);
		lblEnterUsernameCancel.setVisible(show);
	}

	public void start() {
		hangmanController = new HangmanController();
		if (hangmanController.isScoreboard()) {
			int choice = JOptionPane.showConfirmDialog(this, "Have you played Hangman before?", "Start",
					JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				displayUserDropDown();
			} else {
				toggleEnterUsername(true);
			}
		} else
			toggleEnterUsername(true);

	}

	public void displayUserDropDown() {
		String[] usernames = hangmanController.retrieveUserNames();
		String dialog = "Select your username.\nDon't see your username?\nClick cancel to enter it.";
		String title = "Select your username";

		String choice = (String) JOptionPane.showInputDialog(this, dialog, title, JOptionPane.PLAIN_MESSAGE, null,
				usernames, "  ");
		startGameAs(choice);
		
		
	}

	public void enterUsername() {
		if(!fldUsername.getText().isEmpty()) {
			if(hangmanController.checkIfUsernameIsTaken(fldUsername.getText())) {
				displayWarning(fldUsername.getText());
			} else {
				hangmanController.addUser(fldUsername.getText());
				newGame();
			}
		} else {
			JOptionPane.showMessageDialog(this, "You must enter a username to submit.", "No Username Entered",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void startGameAs(String username) {
		hangmanController.findUser(username);
		if(hangmanController.isSavedGame(username)) 
			displayContinueSavedGame();
		else
			newGame();
	}

	public void displayWarning(String username) {
		toggleEnterUsername(false);
		String dialog = "The username: " + username + " is already taken.\nDo you want to continue as " + username
				+ "?\n";
		String title = "Username Taken";

		int choice = JOptionPane.showConfirmDialog(this, dialog, title, JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			startGameAs(username);
		} else {
			toggleEnterUsername(true);
		}

	}

	private void displayContinueSavedGame() {
		String dialog = "You have a saved game on file.\nDo you want to continue where you left off?";
		String title = "Saved Game Available";

		int choice = JOptionPane.showConfirmDialog(this, dialog, title, JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			game = new HangmanGame();
			game = game.retrieveSavedGame();
			hangmanController.initializeHangman();
			if (game != null) {
				System.out.println("Save game has been retrieved");
				toggleGame(true);
				toggleEnterUsername(false);
				updateGame();
			} else {
				System.out.println("Saved game could not be retrieved.");
			}
		} else {
			game = hangmanController.getGame();
			hangmanController.initializeHangman();
			toggleGame(true);
			toggleEnterUsername(false);
			updateGame();
		}

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
		} else if (checkLetterOutput == 10) {
			gameWon();
		} else {
			updateGame();
		}
	}
	
	public void toggleGameEnabled(boolean enable) {
		hangmanPanel.setEnabled(enable);
		txtFldGuess.setEnabled(enable);
		btnGuess.setEnabled(enable);
		btnClear.setEnabled(enable);
		btnGuessWholeWord.setEnabled(enable);
		txtPaneWordDisplay.setEnabled(enable);
		btnHint.setEnabled(enable);
	}
	

	public void gameOver() {
		int choice = JOptionPane.showConfirmDialog(this, "You made too many mistakes!\nWould you like to play again?",
				"Game Over", JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			newGame();
		} else {
			updateGame();
			toggleGameEnabled(false);
		}
	}
	
	public void gameWon() {	
		//modify user
		int choice = JOptionPane.showConfirmDialog(this, "You won the game!\nWould you like to play again?",
				"You win!", JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			newGame();
		} else {
			updateGame();
			toggleGameEnabled(false);
		}
		
		
	}

	public void newGame() {
		if (hangmanController.getNewGame()) {
			game = hangmanController.getGame();
			toggleGame(true);
			toggleGameEnabled(true);
			toggleEnterUsername(false);
			updateGame();
		} else {
			JOptionPane.showMessageDialog(this, "Something went wrong please try again later.");
		}
	}

	public void updateGame() {
		String displayInterfaceLetters = "";
		for (int i = 0; i < game.getInterfaceLetters().length(); i++) {
			displayInterfaceLetters += game.getInterfaceLetters().charAt(i);
			displayInterfaceLetters += " ";
		}

		txtPaneWordDisplay.setText(displayInterfaceLetters);
		txtPaneGuessedLetters.setText(game.getGuessedLettersString());
		fldNumMistakes.setText("" + game.getMistakesLeft());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuess) {
			displayCheckLetterOutput();
			txtFldGuess.setText("");
		} else if (e.getSource() == btnHint) {
			game.giveHint();
			updateGame();
		} else if (e.getSource() == btnGuessWholeWord) {
			guessWholeWord();
		} else if (e.getSource() == mntmSaveGame) {
			hangmanController.saveGame(game);
		} else if (e.getSource() == mntmNewGame) {
			newGame();
		} else if (e.getSource() == btnEnter) {
			enterUsername();
		} else if (e.getSource() == btnCancelEnterUsername) {
			displayUserDropDown();
		}

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		if(hangmanController.saveGame(game))
			System.out.println("Everything was saved");
		else
			System.out.println("Something could not be saved");

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
