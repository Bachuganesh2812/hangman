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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/*
 *       Title: HangmanFrame
 * Description: Custom JFrame - the main frame of the application
 *     Teacher: Sandra Stark
 *     Program: 420-B30 Programming III
 *      Author: Marissa Cleroux 
 *   Reference: https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe (How To Close a JFrame)
 */

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
	private JTextPane txtPaneGuessedLetters;
	private JTextField fldNumMistakes;
	private JButton btnHint;
	private JLabel lblYourGuess;
	private JLabel lblMistakesLeft;

	private JMenuItem mntmScoreboard;
	private JMenuItem mntmSaveGame;
	private JMenuItem mntmNewGame;
	private JMenuItem mntmQuit;
	private JMenuItem mntmHint;

	private HangmanEnterUsernamePanel enterUsernamePanel;
	private int initializeDictionaryOutput;
	private boolean gameInProgress = false;
	private HangmanDropdownPanel dropDownPanel;
	private JPanel panelGame;
	private JPanel guessedLettersPanel;

	public HangmanFrame() throws HeadlessException {
		setBackground(new Color(0, 0, 128));
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Hangman");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 128));
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("MENU");
		mnMenu.setForeground(new Color(248, 248, 255));
		mnMenu.setFont(new Font("Calibri Light", Font.PLAIN, 13));
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

		mntmHint = new JMenuItem("Give Hint");
		mntmHint.addActionListener(this);
		mnMenu.add(mntmHint);

		mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(this);
		mnMenu.add(mntmQuit);
		getContentPane().setLayout(null);

		hangmanPanel = new HangmanPanel();
		hangmanPanel.setBounds(31, 56, 178, 269);
		getContentPane().add(hangmanPanel);

		lblMistakesLeft = new JLabel("Mistakes Left:");
		lblMistakesLeft.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMistakesLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMistakesLeft.setBounds(430, 22, 150, 23);
		getContentPane().add(lblMistakesLeft);

		fldNumMistakes = new JTextField();
		fldNumMistakes.setBackground(Color.WHITE);
		fldNumMistakes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fldNumMistakes.setEditable(false);
		fldNumMistakes.setBounds(590, 22, 75, 23);
		getContentPane().add(fldNumMistakes);
		fldNumMistakes.setColumns(10);

		panelGame = new JPanel();
		panelGame.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panelGame.setBackground(new Color(255, 255, 255));
		panelGame.setBounds(222, 56, 444, 269);
		getContentPane().add(panelGame);
		panelGame.setLayout(null);

		txtPaneWordDisplay = new JTextPane();
		txtPaneWordDisplay.setBounds(10, 11, 424, 153);
		panelGame.add(txtPaneWordDisplay);
		txtPaneWordDisplay.setEditable(false);
		txtPaneWordDisplay.setFont(new Font("Calibri", Font.PLAIN, 30));

		lblYourGuess = new JLabel("Your Guess:");
		lblYourGuess.setBounds(31, 170, 110, 19);
		panelGame.add(lblYourGuess);
		lblYourGuess.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblYourGuess.setHorizontalAlignment(SwingConstants.RIGHT);

		txtFldGuess = new JTextField();
		txtFldGuess.setBounds(147, 169, 86, 20);
		panelGame.add(txtFldGuess);
		txtFldGuess.setForeground(new Color(0, 0, 0));
		txtFldGuess.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtFldGuess.setColumns(10);

		btnGuess = new JButton("Guess");
		btnGuess.setBounds(243, 168, 75, 23);
		panelGame.add(btnGuess);
		btnGuess.setBackground(new Color(0, 0, 128));
		btnGuess.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnGuess.addActionListener(this);
		btnGuess.setToolTipText("Enter your single letter guess");
		btnGuess.setForeground(new Color(245, 255, 250));

		btnClear = new JButton("Clear");
		btnClear.setBounds(328, 168, 75, 23);
		panelGame.add(btnClear);
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 13));

		btnHint = new JButton("Give Hint");
		btnHint.setBounds(243, 202, 160, 23);
		panelGame.add(btnHint);
		btnHint.setFont(new Font("Calibri", Font.PLAIN, 13));

		btnGuessWholeWord = new JButton("Guess Whole Word");
		btnGuessWholeWord.setBounds(243, 235, 162, 23);
		panelGame.add(btnGuessWholeWord);
		btnGuessWholeWord.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnGuessWholeWord.addActionListener(this);

		enterUsernamePanel = new HangmanEnterUsernamePanel();
		enterUsernamePanel.setVisible(false);
		enterUsernamePanel.setBounds(173, 56, 394, 269);
		enterUsernamePanel.setFrame(this);
		getContentPane().add(enterUsernamePanel);

		dropDownPanel = new HangmanDropdownPanel();
		dropDownPanel.setFrame(this);
		dropDownPanel.setVisible(false);
		dropDownPanel.setBounds(184, 56, 384, 269);
		getContentPane().add(dropDownPanel);

		guessedLettersPanel = new JPanel();
		guessedLettersPanel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		guessedLettersPanel.setBackground(new Color(255, 255, 255));
		guessedLettersPanel.setBounds(31, 356, 634, 144);
		getContentPane().add(guessedLettersPanel);
		guessedLettersPanel.setLayout(null);

		txtPaneGuessedLetters = new JTextPane();
		txtPaneGuessedLetters.setBounds(10, 34, 614, 99);
		guessedLettersPanel.add(txtPaneGuessedLetters);
		txtPaneGuessedLetters.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtPaneGuessedLetters.setEditable(false);

		JLabel lblGuessedLetters = new JLabel("Guessed Letters");
		lblGuessedLetters.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblGuessedLetters.setBounds(10, 11, 136, 23);
		guessedLettersPanel.add(lblGuessedLetters);

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { menuBar, mnMenu, mntmScoreboard,
				mntmSaveGame, mntmNewGame, mntmQuit, txtFldGuess, btnGuess, btnClear, btnHint, btnGuessWholeWord }));

		btnHint.addActionListener(this);
		btnClear.addActionListener(this);

		addWindowListener(this);
	}// HangmanFrame()

	public static void main(String[] args) {
		HangmanFrame frame = new HangmanFrame();
		frame.setSize(725, 582);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.toggleGame(false);
	}// main(String[])

	public void initializeWindowActions() {
		gameInProgress = true;
		getRootPane().setDefaultButton(btnGuess);
	}// initializeWindowActions()

	public void toggleGame(boolean show) {
		hangmanPanel.setVisible(show);
		panelGame.setVisible(show);
		guessedLettersPanel.setVisible(show);
		fldNumMistakes.setVisible(show);
		lblMistakesLeft.setVisible(show);
		mntmSaveGame.setEnabled(show);
		mntmNewGame.setEnabled(show);
		mntmHint.setEnabled(show);
	}// toggleGame(boolean)

	public void displayUserDropDown() {
		String[] usernames = hangmanController.getScoreboard().retrieveUserNames();
		dropDownPanel.setUsernames(usernames);
		dropDownPanel.setVisible(true);
	}// displayUserDropDown()

	public void displayEnterUsername() {
		if (initializeDictionaryOutput == 1) {
			enterUsernamePanel.setVisible(true);
		} else
			JOptionPane.showMessageDialog(this, "Sorry there are no more words left!", "Out of Words To Play",
					JOptionPane.ERROR_MESSAGE);
	}// displayEnterUsername()

	public void startGameAs(String username) {
		initializeWindowActions();
		hangmanController.findUser(username);
		if (hangmanController.getGame().isSavedGame(username))
			displayContinueSavedGame();
		else
			newGame();
	}// startGameAs()

	public boolean enterUsername(String username) {
		if (!username.isEmpty()) {
			if (hangmanController.getScoreboard().findUser(username) != null) {
				return (displayWarning(username));

			} else {
				hangmanController.addUser(username);
				initializeWindowActions();
				newGame();
				return true;
			}
		} else {
			JOptionPane.showMessageDialog(this, "You must enter a username to submit.", "No Username Entered",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}// enterUsername()

	public boolean displayWarning(String username) {
		String dialog = "The username: " + username + " is already taken.\nDo you want to continue as " + username
				+ "?\n";
		String title = "Username Taken";

		int choice = JOptionPane.showConfirmDialog(this, dialog, title, JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			startGameAs(username);
			return true;
		} else {
			return false;
		}

	}// displayWarning(String)

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
				updateGame();
			} else {
				JOptionPane.showMessageDialog(this, "Your saved game is finished! A new game will be started for you.");
				newGame();
			}
		} else {
			newGame();
		}

	}// displayContinueSavedGame()

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
	}// displayCheckLetterOutput()

	public void toggleGameEnabled(boolean enable) {
		hangmanPanel.setEnabled(enable);
		txtFldGuess.setEnabled(enable);
		btnGuess.setEnabled(enable);
		btnClear.setEnabled(enable);
		btnGuessWholeWord.setEnabled(enable);
		txtPaneWordDisplay.setEnabled(enable);
		btnHint.setEnabled(enable);
	}// toggleGameEnabled()

	public void gameOver() {
		int choice = JOptionPane.showConfirmDialog(this, "You made too many mistakes!\nWould you like to play again?",
				"Game Over", JOptionPane.YES_NO_OPTION);
		if (choice == 0) {
			newGame();
		} else {
			updateGame();
			toggleGameEnabled(false);
		}
	} // gameOver()

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

	}// gameWon()

	public void newGame() {
		if (hangmanController.getNewGame()) {
			game = hangmanController.getGame();
			toggleGame(true);
			toggleGameEnabled(true);
			enterUsernamePanel.setVisible(false);
			updateGame();
		} else {
			gameInProgress = false;
			toggleGame(false);
			JOptionPane.showMessageDialog(this, "There are no more words left to play!", "Out of Words", JOptionPane.ERROR_MESSAGE);
		}
	}// newGame()

	public void updateGame() {
		txtPaneWordDisplay.setText(game.getInterfaceLettersString());
		txtPaneGuessedLetters.setText(game.getGuessedLettersString());
		fldNumMistakes.setText("" + game.getMistakesLeft());
		hangmanPanel.setMistakes(game.getMistakesLeft());
		hangmanPanel.repaint();
	}// updateGame()

	public void guessWholeWord() {
		String title = "Guess Whole Word";
		String dialog = "Enter the whole word.\nPlease include any spaces/and or dashes seen on the board.";
		String guess = (String) JOptionPane.showInputDialog(this, dialog, title, JOptionPane.PLAIN_MESSAGE);
		if (guess != null) {
			int output = game.checkWord(guess);
			if (output == 10) {
				gameWon();
			} else if (output == -1) {
				updateGame();
				JOptionPane.showMessageDialog(this, "Your entered word did not match!");
			} else if (output == -2) {
				updateGame();
				JOptionPane.showMessageDialog(this, "That was an invalid entry.");
			} else {
				gameOver();
			}
		}
	}// guessWholeWord()

	public void displayScoreboard() {

		HangmanScoreboardFrame scoreboardFrame = new HangmanScoreboardFrame();
		scoreboardFrame.setVisible(true);
		scoreboardFrame.setSize(630, 370);
		scoreboardFrame.setLocationRelativeTo(null);
		scoreboardFrame.setVisible(true);
		scoreboardFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scoreboardFrame.printScores(hangmanController.getScoreboard());
	}// displayScoreboard()

	public void getHint() {
		if (game.giveHint() == 10)
			gameWon();
		else
			updateGame();
	}// getHint()

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuess) {
			displayCheckLetterOutput();
			txtFldGuess.setText("");
		} else if (e.getSource() == btnHint) {
			getHint();
		} else if (e.getSource() == btnGuessWholeWord) {
			guessWholeWord();
		} else if (e.getSource() == mntmSaveGame) {
			hangmanController.saveGame(game);
		} else if (e.getSource() == mntmNewGame) {
			newGame();
		} else if (e.getSource() == mntmScoreboard) {
			displayScoreboard();
		} else if (e.getSource() == btnClear) {
			txtFldGuess.setText("");
		} else if (e.getSource() == mntmHint) {
			getHint();
		} else if (e.getSource() == mntmQuit) {
			// (How to close a JFrame)
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}// actionPerformed()

	@Override
	public void windowActivated(WindowEvent e) {

	}// windowActivated(WindowEvent)

	@Override
	public void windowClosed(WindowEvent e) {

	}// windowClosed(WindowEvent)

	@Override
	public void windowClosing(WindowEvent e) {
		if (gameInProgress) {
			hangmanController.saveGame(game);
			System.out.println("Game saved");
		}

	}// windowClosing(WindowEvent)

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}// windowDeactivated(WindowEvent)

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}// windowDeiconified(WindowEvent)

	@Override
	public void windowIconified(WindowEvent arg0) {

	}// windowIconified(WindowEvent)

	@Override
	public void windowOpened(WindowEvent e) {
		hangmanController = new HangmanController();
		initializeDictionaryOutput = hangmanController.initializeDictionary();

		if (hangmanController.getScoreboard().retrieveScoreboard()) {
			int choice = JOptionPane.showConfirmDialog(this, "Do you have an account already?", "Welcome to Hangman",
					JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				displayUserDropDown();
			} else {
				displayEnterUsername();
			}
		} else
			displayEnterUsername();

	}// windowOpened(WindowEvent)

	public boolean isGameInProgress() {
		return gameInProgress;
	}
}// HangmanFrame class
