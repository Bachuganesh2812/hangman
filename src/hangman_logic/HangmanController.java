package hangman_logic;

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
			System.out.println("Dictionary not initialized");
			return false;
		} else {
			System.out.println("Dictionary initialized");
			System.out.println(dictionary.toString());
			return true;
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

	public boolean isSavedGame() {
		return game.isSavedGame();
	}
	
	public String[] retrieveUserNames() {
		return null;
	}
	
	public HangmanGame playSavedGame() {
		
		
		return null;
	}
	
	public boolean isScoreboard() {
		return this.scoreboard.retrieveScoreboard();
	}
	
	public boolean checkIfUsernameIsTaken(String userName) {
		return false;
	}
	
	public boolean getNewGame() {
		String word = dictionary.getRandomWord();
		if(word == null) {
			return false;
		} else {
			this.game = new HangmanGame(word);
			game.initializeAnswer();
			return true;
		}
	}

	public void lose() {
		// TODO Auto-generated method stub
		
	}
	
	public void saveGame(HangmanGame game) {
		dictionary.saveDictionary();
		game.saveGame();
	}
	

	
}

