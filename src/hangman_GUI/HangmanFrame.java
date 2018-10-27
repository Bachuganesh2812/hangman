package hangman_GUI;

import java.awt.GraphicsConfiguration;
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

public class HangmanFrame extends JFrame implements ActionListener, WindowListener{
	
	private HangmanController hangmanController;
	private HangmanGame game;

	public HangmanFrame() throws HeadlessException {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmScoreboard = new JMenuItem("Scoreboard");
		mnMenu.add(mntmScoreboard);
		
		JMenuItem mntmSaveGame = new JMenuItem("Save Game");
		mnMenu.add(mntmSaveGame);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnMenu.add(mntmNewGame);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnMenu.add(mntmQuit);
		getContentPane().setLayout(null);
		// TODO Auto-generated constructor stub
	}

	public HangmanFrame(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HangmanFrame(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HangmanFrame(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		HangmanFrame frame = new HangmanFrame();
		frame.setSize(950, 550);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.start();
		
	}
	
	public void start() {
		hangmanController = new HangmanController();
		if(hangmanController.retrieveScoreboard()) {
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
		
		String choice = (String) JOptionPane.showInputDialog(this, dialog, title, 
				JOptionPane.PLAIN_MESSAGE, null, usernames, "  ");
		
	}
	
	public void displayEnterUser() {
		String dialog = "Enter your username.\nRemember your username?\nClick cancel to select it.";
		String title = "Enter your username";
		
		String username = (String) JOptionPane.showInputDialog(this, dialog, title, 
				JOptionPane.PLAIN_MESSAGE);
	
		if(hangmanController.checkIfUsernameIsTaken(username)) {
			displayWarning(username);
		} else {
			
		}
	}
	
	public void displayWarning(String username) {
		String dialog = "The username: " + username + " is already taken.\nDo you want to continue as " + username + "?";
		String title = "Username Taken";
		
		int choice = JOptionPane.showConfirmDialog(this, dialog, title,
				JOptionPane.YES_NO_OPTION);
		if(choice == 0 && hangmanController.retrieveGame()) {
			displayContinueSavedGame();
		} else if (choice == 0) {
			hangmanController.newGame();
		} else {
			displayEnterUser();
		}
		
	}
	
	private void displayContinueSavedGame() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
