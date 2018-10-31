package hangman_logic;

public class HangmanController {

	private HangmanGame game;
	private Dictionary dictionary;
	private Scoreboard scoreboard;
	private User currPlayer;

	public HangmanController() {
		this.game = new HangmanGame();
		this.dictionary = new Dictionary();
		this.scoreboard = new Scoreboard();
		this.currPlayer = new User();
	}

	public boolean initializeHangman() {
		if (!dictionary.initializeDictionary()) {
				System.out.println("Dictionary not initialized");
				return false;
			} else {
				System.out.println("Dictionary initialized");
				return true;
			}
	}

	public User getCurrPlayer() {
		return currPlayer;
	}

	public void setCurrPlayer(User currPlayer) {
		this.currPlayer = currPlayer;
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

	public void addUser(String username) {
		this.currPlayer = new User(username);
		scoreboard.addUser(currPlayer);
	}

	public void findUser(String username) {
		this.currPlayer = scoreboard.findUser(username);
	}

	public boolean isSavedGame(String username) {

		return game.isSavedGame(username);
	}

	public String[] retrieveUserNames() {
		return this.scoreboard.retrieveUserNames();
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
		if (initializeHangman()) {
			String word = dictionary.getRandomWord();
			if (word == null) {
				return false;
			} else {
				this.game = new HangmanGame(word, currPlayer);
				game.initializeAnswer();
				return true;
			}
		}

		return false;
	}

	public void lose() {
		// TODO Auto-generated method stub

	}

	public boolean saveGame(HangmanGame game) {
		return (dictionary.saveDictionary() && game.saveGame() && scoreboard.saveScoreboard());
	}

}
