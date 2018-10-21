package hangman_files;

import hangman_logic.Scoreboard;
import hangman_logic.User;
import linked_data_structures.DoublyLinkedList;

public class ScoreboardFile {
	
	private static final String FILE_NAME = "scoreboad.ser";

	public ScoreboardFile() {
		// TODO Auto-generated constructor stub
	}

	private boolean open() {
		return false;
	}
	
	private boolean read() {
		return false;
	}
	
	public boolean write (Scoreboard scoreboard) {
		return false;
	}
	
	private boolean close() {
		return false;
	}
	
	public DoublyLinkedList<User> getScoreBoard() {
		return null;
	}
}
