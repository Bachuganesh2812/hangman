package hangman_logic;

import java.io.Serializable;
import java.util.ArrayList;

import hangman_files.ScoreboardFile;
import linked_data_structures.DoublyLinkedList;

public class Scoreboard implements Serializable{

	private DoublyLinkedList<User> scoreboard = new DoublyLinkedList<User>();
	private ScoreboardFile scoreboardFile;
	
	public Scoreboard() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean retrieveScoreboard() {
		scoreboardFile = new ScoreboardFile();
		scoreboard = scoreboardFile.getScoreBoard();
		
		if(scoreboard != null)
			return (scoreboard.getLength() > 0);
		else
			return false;
	}
	
	public String[] retrieveUserNames() {
		String[] usernames;
		
		if(scoreboard.getLength() > 0) {
			usernames = new String[scoreboard.getLength()];
			
			for(int i = 0; i < scoreboard.getLength(); i++) {
				usernames[i] = scoreboard.getElementAt(i).getUsername();
			}
			
		} else 
			usernames = null;
		
		
		return usernames;
	}
	
	public boolean addUser(User user) {
		return false;
	}
	
	public boolean saveState() {
		return false;
	}
	
	public boolean equals(Object o) {
		return false;
	}

}
