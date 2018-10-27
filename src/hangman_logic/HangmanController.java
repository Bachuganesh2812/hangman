package hangman_logic;

import linked_data_structures.SinglyLinkedList;

public class HangmanController {
	
	HangmanGame game;
	Dictionary dictionary;
	Scoreboard scoreboard;

	public HangmanController() {
		this.game = new HangmanGame();
		this.dictionary = new Dictionary();
		this.scoreboard = new Scoreboard();
	}
	
	public boolean initializeHangman() {
		if(!dictionary.initializeDictionary()) {
			return false;
		} else {
			String word = dictionary.getRandomWord();
			if(word == null) {
				return false;
			} else {
				this.game = new HangmanGame(word);
				game.initializeAnswer();
				return true;
			}
		}
	}

	public HangmanGame getGame() {
		return game;
	}

	public void setGame(HangmanGame game) {
		this.game = game;
	}

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
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
		return false;
	}
	
	public boolean getNewGame() {
		
		
		return false;
		
	}
	

	
}

