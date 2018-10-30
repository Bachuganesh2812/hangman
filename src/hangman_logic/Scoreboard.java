package hangman_logic;

import java.io.Serializable;
import java.util.ArrayList;

import hangman_files.ScoreboardFile;
import linked_data_structures.DoublyLinkedList;

public class Scoreboard implements Serializable{

	private DoublyLinkedList<User> scoreboard = new DoublyLinkedList<User>();
	
	public Scoreboard() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean retrieveScoreboard() {
		ScoreboardFile scoreboardFile = new ScoreboardFile();
		scoreboard = scoreboardFile.getScoreboard().getScoreboard();
		
		return (scoreboard.getLength() > 0);
	}
	
	public DoublyLinkedList<User> getScoreboard() {
		return scoreboard;
	}

	public void setScoreboard(DoublyLinkedList<User> scoreboard) {
		this.scoreboard = scoreboard;
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
	
	public void addUser(User user) {
		this.scoreboard.add(user);
	}
	
	public boolean saveState() {
		return false;
	}
	
	public boolean checkForUser(User user) {
		boolean userExists = false;
		
		for(int i = 0; i < scoreboard.getLength(); i++) {
			scoreboard.getElementAt(i).equals(user);
		}
		
		return userExists;
	}

}
