package hangman_logic;

public class HangmanController {
	
	HangmanGame game;
	Dictionary dictionary;
	Scoreboard scoreboard;

	public HangmanController() {
		game = new HangmanGame();
		dictionary = new Dictionary();
		scoreboard = new Scoreboard();
	}
	
	public boolean initializeHangman() {
		if(!dictionary.initializeDictionary()) {
			return false;
		} 
		
		return false;
	}

	public boolean retrieveGame() {
		//de-serialize the game here?
		// game = 
		return true;
	}
	
	public String[] retrieveUserNames() {
		return null;
	}
	
	public HangmanGame playSavedGame() {
		return null;
	}
	
	public boolean retrieveScoreboard() {
		return true;
	}
	
	public boolean checkIfUsernameIsTaken(String userName) {
		return true;
	}
	
	private boolean getRandomWord() {
		return false;
	}
	

	
}

