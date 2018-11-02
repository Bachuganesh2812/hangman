package hangman_logic;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private int totalWins;
	private int totalGames;


	public User() {
		this.username = null;
		this.totalWins = 0;
		this.totalGames = 0;
	}//User()
	
	public User(String uName) {
		this.username = uName;
		this.totalWins = 0;
		this.totalGames = 0;
	}//User(String)
	
	public User(String uName, int wins, int games, boolean inProg) {
		this.username = uName;
		this.totalWins = wins;
		this.totalGames = games;
	}//User(String, int, int, boolean)
	
	public String getUsername() {
		return username;
	}// String getUsername()

	public void setUsername(String username) {
		this.username = username;
	}//setUsername(String)

	public int getTotalWins() {
		return totalWins;
	}//getTotalWins()

	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}//setTotalWins(int)

	public int getTotalGames() {
		return totalGames;
	}//getTotalGames()

	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}//setTotalGames(int)

	@Override 
	public boolean equals(Object o) {
		if(o instanceof User) {
			if(((User) o).getUsername().equals(this.username)) {
				return true;
			}
		}
		return false;
	}// equals(Object)
	
	@Override
	public String toString() {
		return this.getUsername() + " has played a total of "+ this.totalGames + " games and has won " + this.totalWins;	
	}// toString()

}
