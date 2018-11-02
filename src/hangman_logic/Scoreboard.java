package hangman_logic;

import java.io.Serializable;

import hangman_files.ScoreboardFile;
import linked_data_structures.DoublyLinkedList;

/*
 *       Title: Scoreboard
 * Description: Holds the users of the application, handles the addition of users 
 * 				to the application as well as sorting
 *     Teacher: Sandra Stark
 *     Program: 420-B30 Programming III
 *      Author: Marissa Cleroux 
 */

public class Scoreboard implements Serializable {

	private static final long serialVersionUID = 1L;
	private DoublyLinkedList<User> scoreboard;
	private int currPlayer;

	public Scoreboard() {
		scoreboard = new DoublyLinkedList<User>();
		currPlayer = 0;
	}//Scoreboard()
	
	public DoublyLinkedList<User> getScoreboard() {
		return scoreboard;
	}//getScoreboard()

	
	public void setCurrPlayer(int currPlayer) {
		this.currPlayer = currPlayer;
	}

	public boolean retrieveScoreboard() {
		ScoreboardFile scoreboardFile = new ScoreboardFile();

		if (scoreboardFile.deserializeScoreboard()) {
			scoreboard = scoreboardFile.getScoreboard().getScoreboard();
			return true;
		} else {
			return false;
		}
	}//retrieveScoreboard()

	public String[] retrieveUserNames() {
		String[] usernames;

		if (scoreboard.getLength() > 0) {
			usernames = new String[scoreboard.getLength()];

			for (int i = 0; i < scoreboard.getLength(); i++) {
				usernames[i] = scoreboard.getElementAt(i).getUsername();
			}

		} else
			usernames = null;

		return usernames;
	}//retrieveUserNames()

	public void addUser(User user) {
		if (scoreboard.getLength() == 0) {
			scoreboard.add(user);

			for (int i = 0; i < scoreboard.getLength(); i++) {
				scoreboard.getElementAt(i).toString();
			}
		} else {
			findSpot(user);
		}
	}// addUser();
	
	public User nextUser() {
		User user;
		if(scoreboard.getLength() == 0) {
			user = null;
		} else if(currPlayer == scoreboard.getLength()) {
			user = null;
		} else {
			user = scoreboard.getElementAt(currPlayer++);	
		}	
		return user;
	}// nextUser()
	
	private void findSpot(User user) {
		int index = 0;
		boolean foundSpot = false;
		String userAfter = scoreboard.getElementAt(index).getUsername();

		while (!foundSpot && index < scoreboard.getLength()) {
			if (userAfter.compareToIgnoreCase(user.getUsername()) > 0 && index != 0) {
				scoreboard.add(user, index);
				foundSpot = true;
			} else if (userAfter.compareToIgnoreCase(user.getUsername()) > 0) {
				scoreboard.add(user);
				foundSpot = true;
			} else if (scoreboard.getLength() == 1) {
				scoreboard.add(user, 1);
				foundSpot = true;
			} else if (index + 1 != scoreboard.getLength()) {
				userAfter = scoreboard.getElementAt(++index).getUsername();
			} else {
				scoreboard.add(user, ++index);
				foundSpot = true;
			}
		}
	}//findSpot(User)

	public boolean saveScoreboard() {
		ScoreboardFile file = new ScoreboardFile();
		return file.saveScoreboard(this);
	}//saveScoreboard()

	public boolean checkForUser(User user) {
		boolean userExists = false;

		for (int i = 0; i < scoreboard.getLength(); i++) {
			if(scoreboard.getElementAt(i).equals(user))
				userExists = true;
		}

		return userExists;
	}// checkForUser(User)

	public User findUser(String username) {
		User tempUser = new User(username);

		for (int i = 0; i < scoreboard.getLength(); i++) {
			User currUser = scoreboard.getElementAt(i);
			if (currUser.equals(tempUser)) {
				return currUser;
			}
		}

		return null;
	}//findUser()

	@Override
	public String toString() {
		String users = "";
		for (int i = 0; i < scoreboard.getLength(); i++) {
			users += scoreboard.getElementAt(i).getUsername();
			users += "\n";
		}
		return users;
	}// toString()

}// Scoreboard class
