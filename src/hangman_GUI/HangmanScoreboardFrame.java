package hangman_GUI;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import hangman_logic.Scoreboard;
import hangman_logic.User;
import linked_data_structures.DoublyLinkedList;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

public class HangmanScoreboardFrame extends JFrame {

	private JTextArea txtAreaScoreboard;
	
	public HangmanScoreboardFrame() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 595, 309);
		getContentPane().add(scrollPane);
		
		txtAreaScoreboard = new JTextArea();
		scrollPane.setViewportView(txtAreaScoreboard);
		txtAreaScoreboard.setFont(new Font("Monospaced", Font.PLAIN, 12));
	}//HangmanScoreboardPanel()

	public void printScores(DoublyLinkedList<User> scoreboard) {
		displayColumnHeadings();
		displayScoreboard(scoreboard);
	}//retrieveScores()
	
	private void displayColumnHeadings() {
		txtAreaScoreboard.append(String.format("%-40s%-15s%-15s\n", "User", "Total Games", "Total Wins"));
		String underline = "";
		for (int i = 0; i < 80; ++i)
			underline += "-";
		txtAreaScoreboard.append(String.format("%s\n", underline.toString()));
	}// displayColumnHeading()
	
	private void displayScoreboard(DoublyLinkedList<User> scoreboard) {
		for(int i = 0; i < scoreboard.getLength(); i++) {
			txtAreaScoreboard.append(String.format("%-40s%-15d%-15d\n", scoreboard.getElementAt(i).getUsername(), scoreboard.getElementAt(i).getTotalGames(),
					scoreboard.getElementAt(i).getTotalWins()));
			txtAreaScoreboard.append("\n");
		}
	}
}// HangmanScoreboardPanel class
