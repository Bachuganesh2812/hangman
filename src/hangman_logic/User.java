package hangman_logic;

import java.io.Serializable;

public class User implements Serializable{

	private String username;
	private int totalWins;
	private int totalGames;
//	private Dictionary dictionary;
	private HangmanGame gameState;
	private boolean gameInProgress;
	
	public User() {
		this.username = null;
		this.totalWins = 0;
		this.totalGames = 0;
		this.gameState = null;
		this.gameInProgress = false;
	}
	
	public User(String uName, int wins, int games, HangmanGame state, boolean inProg) {
		this.username = uName;
		this.totalWins = wins;
		this.totalGames = games;
		this.gameState = state;
		this.gameInProgress = inProg;
	};
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTotalWins() {
		return totalWins;
	}

	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}

	public int getTotalGames() {
		return totalGames;
	}

	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}

	public HangmanGame getGameState() {
		return gameState;
	}

	public void setGameState(HangmanGame gameState) {
		this.gameState = gameState;
	}

	public boolean isGameInProgress() {
		return gameInProgress;
	}

	public void setGameInProgress(boolean gameInProgress) {
		this.gameInProgress = gameInProgress;
	}
	
	public void newGame() {
		
	}
	
	public String toString() {
		return null;	
	}

}
