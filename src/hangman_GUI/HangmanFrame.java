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
	
	private HangmanEnterUsernamePanel enterUsernamePanel;
	private int initializeDictionaryOutput;
	
	private HangmanDropdownPanel dropDownPanel;

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
		
		btnHint.addActionListener(this);
		
		enterUsernamePanel = new HangmanEnterUsernamePanel();
		enterUsernamePanel.setVisible(false);	
		enterUsernamePanel.setBounds(173, 56, 394, 269);
		enterUsernamePanel.setFrame(this);
		getContentPane().add(enterUsernamePanel);
		
		dropDownPanel = new HangmanDropdownPanel(this);
		dropDownPanel.setVisible(false);
		dropDownPanel.setBounds(184, 56, 384, 269);
		getContentPane().add(dropDownPanel);
		
	}

	public static void main(String[] args) {
		HangmanFrame frame = new HangmanFrame();
		frame.setSize(692, 582);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.toggleGame(false);
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

	public void start() {
		hangmanController = new HangmanController();
		initializeDictionaryOutput = hangmanController.initializeDictionary();

		if (hangmanController.isScoreboard()) {
			int choice = JOptionPane.showConfirmDialog(this, "Have you played Hangman before?", "Start",
					JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				displayUserDropDown();
			} else {
				displayEnterUsername();
			}
		} else
			displayEnterUsername();

		// if (initializeDictionaryOutput == -1) {
		// JOptionPane.showMessageDialog(this, "Sorry the game cannot be played at this
		// time!", "Broken Hangman",
		// JOptionPane.ERROR_MESSAGE);
		// } else {
		// /// no words but saved game in progress?!?!?
		// JOptionPane.showMessageDialog(this, "Sorry there are no more words left!",
		// "Out of Words To Play",
		// JOptionPane.ERROR_MESSAGE);
		// }

	}

	public void displayUserDropDown() {
		String[] usernames = hangmanController.retrieveUserNames();
		dropDownPanel.setUsernames(usernames);
		dropDownPanel.setVisible(true);

//		String choice = (String) JOptionPane.showInputDialog(this, dialog, title, JOptionPane.PLAIN_MESSAGE, null,
//				usernames, "  ");
	}

	public void displayEnterUsername() {
		if (initializeDictionaryOutput == 1) {
			enterUsernamePanel.setVisible(true);
		} else
			JOptionPane.showMessageDialog(this, "Sorry there are no more words left!", "Out of Words To Play",
					JOptionPane.ERROR_MESSAGE);
	}

	public void startGameAs(String username) {
		addWindowListener(this);
		hangmanController.findUser(username);
		if (hangmanController.isSavedGame(username))
			displayContinueSavedGame();
		else
			newGame();
	}

	public void enterUsername(String username) {
		if (!username.isEmpty()) {
			if (hangmanController.getScoreboard().findUser(username) != null) {
				displayWarning(username);
			} else {
				hangmanController.addUser(username);
				addWindowListener(this);
				newGame();
			}
		} else {
			JOptionPane.showMessageDialog(this, "You must enter a username to submit.", "No Username Entered",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void displayWarning(String username) {
		enterUsernamePanel.setVisible(false);
		String dialog = "The username: " + username + " is already taken.\nDo you want to continue as " + username
				+ "?\n";
		String title = "Username Taken";

		int choice = JOptionPane.showConfirmDialog(this, dialog, title, JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			startGameAs(username);
		} else {
			enterUsernamePanel.setVisible(true);
		}

	}

	private void displayContinueSavedGame() {
		String dialog = "You have a saved game on file.\nDo you want to continue where you left off?";
		String title = "Saved Game Available";

		int choice = JOptionPane.showConfirmDialog(this, dialog, title, JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			if (hangmanController.retrieveSavedGame() && !hangmanController.getGame().isGameDone()) {
				game = hangmanController.getGame();
				hangmanController.initializeDictionary();
				System.out.println("Save game has been retrieved");
				toggleGame(true);
				enterUsernamePanel.setVisible(false);
				updateGame();
			} else {
				JOptionPane.showMessageDialog(this,
						"Your saved game is finished! A new game will be started for you.");
				newGame();
			}
		} else {
			newGame();
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
		// modify user
		int choice = JOptionPane.showConfirmDialog(this, "You won the game!\nWould you like to play again?", "You win!",
				JOptionPane.YES_NO_OPTION);
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
			enterUsernamePanel.setVisible(false);
			updateGame();
		} else {
			toggleGameEnabled(false);
			updateGame();
			JOptionPane.showMessageDialog(this, "There are no more words left to play!");
		}
	}

	public void updateGame() {
		txtPaneWordDisplay.setText(game.getInterfaceLettersString());
		txtPaneGuessedLetters.setText(game.getGuessedLettersString());
		fldNumMistakes.setText("" + game.getMistakesLeft());
	}

	public void guessWholeWord() {
		String title = "Guess Whole Word";
		String dialog = "Enter the whole word.\nPlease include any spaces/and or dashes seen on the board.";
		String guess = (String) JOptionPane.showInputDialog(this, dialog, title, JOptionPane.PLAIN_MESSAGE);
		if (guess != null) {
			int output = game.checkWord(guess);
			if (output == 10) {
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
	
	public void displayScoreboard() {
		HangmanScoreboardFrame scoreboardFrame = new HangmanScoreboardFrame();
		scoreboardFrame.setVisible(true);
		scoreboardFrame.setSize(630, 370);
		scoreboardFrame.setLocationRelativeTo(null);
		scoreboardFrame.setVisible(true);
		scoreboardFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scoreboardFrame.printScores(hangmanController.getScoreboard().getScoreboard());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuess) {
			displayCheckLetterOutput();
			txtFldGuess.setText("");
		} else if (e.getSource() == btnHint) {
			if (game.giveHint() == 10)
				gameWon();
			else
				updateGame();
		} else if (e.getSource() == btnGuessWholeWord) {
			guessWholeWord();
		} else if (e.getSource() == mntmSaveGame) {
			hangmanController.saveGame(game);
		} else if (e.getSource() == mntmNewGame) {
			newGame();
		} else if (e.getSource() == mntmScoreboard) {
			displayScoreboard();
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
	public void windowClosing(WindowEvent e) {
		if (hangmanController.saveGame(game))
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
