package hangman_logic;

import java.io.Serializable;

import hangman_files.ScoreboardFile;
import linked_data_structures.DoublyLinkedList;

public class Scoreboard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DoublyLinkedList<User> scoreboard = new DoublyLinkedList<User>();
	
	public Scoreboard() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean retrieveScoreboard() {
		ScoreboardFile scoreboardFile = new ScoreboardFile();
		
		if(scoreboardFile.deserializeScoreboard()) {
			scoreboard = scoreboardFile.getScoreboard().getScoreboard();
			System.out.println("Scoreboard retrieved: " + scoreboard.getLength());
			return true;
		} else {
			return false;
		}
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
		if(scoreboard.getLength() == 0) {
			scoreboard.add(user);
			System.out.println("User added: " + scoreboard.getLength());
			
			for(int i = 0; i < scoreboard.getLength(); i++) {
				scoreboard.getElementAt(i).toString();
			}
		} else {
			int index = 0;
			boolean foundSpot = false;
			String userAfter = scoreboard.getElementAt(index).getUsername();
			System.out.println(this.toString());
			System.out.println("Adding: " + user.toString());
			System.out.println("First user: " + userAfter);
			
			
			while(!foundSpot && index < scoreboard.getLength()) {
				System.out.println("Comparison: " + userAfter.compareToIgnoreCase(user.getUsername()));
				if(userAfter.compareToIgnoreCase(user.getUsername()) > 0 && index != 0) {
					scoreboard.add(user, index - 1);
					foundSpot = true;
				} else if(userAfter.compareToIgnoreCase(user.getUsername()) > 0) {
					scoreboard.add(user);
					foundSpot = true;
				} else if(scoreboard.getLength() == 1) {
					scoreboard.add(user, 1);
					foundSpot = true;
				} else if(index + 1 != scoreboard.getLength()){
					userAfter = scoreboard.getElementAt(++index).getUsername();
				} else {
					scoreboard.add(user, ++index);
					foundSpot = true;
				}
				
				
			}
		}
		
		System.out.println(this.toString());
	}
	
	public boolean saveScoreboard() {
		ScoreboardFile file = new ScoreboardFile();
		return file.saveScoreboard(this);
	}
	
	public void setCurrentPlayer(String username) {
		User tempUser = new User(username);
		
		for(int i = 0; i < scoreboard.getLength(); i++) {
			User currUser = scoreboard.getElementAt(i);
			if(currUser.isGameInProgress() && !currUser.equals(tempUser)) {
				currUser.setGameInProgress(false);
			}else if(currUser.equals(tempUser)) {
				currUser.setGameInProgress(true);
			}
		}
	}
	
	public boolean checkForUser(User user) {
		boolean userExists = false;
		
		for(int i = 0; i < scoreboard.getLength(); i++) {
			scoreboard.getElementAt(i).equals(user);
		}
		
		return userExists;
	}
	
	public String toString() {
		String users = "";
		for(int i = 0; i < scoreboard.getLength(); i++) {
			users += scoreboard.getElementAt(i).toString();
			users += "\n";
		}
		
		return users;
	}

}
