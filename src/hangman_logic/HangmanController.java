package hangman_logic;

public class HangmanController {

	private HangmanGame game;
	private Dictionary dictionary;
	private Scoreboard scoreboard;
	private User currPlayer;
	private boolean gameInProgress = false;

	public HangmanController() {
		this.game = new HangmanGame();
		this.dictionary = new Dictionary();
		this.scoreboard = new Scoreboard();
		this.currPlayer = new User();
	}

	public int initializeDictionary() {
		if (gameInProgress) {
			return 1;
		} else if (!dictionary.initializeDictionary()) {
			System.out.println("Dictionary not initialized");
			return -1;
		} else if (dictionary.getDictionary().getLength() == 0) {
			return -2;
		} else {
			gameInProgress = true;
			System.out.println("Dictionary initialized");
			return 1;
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
		System.out.println(currPlayer.toString());
	}

	public boolean isSavedGame(String username) {
		return game.isSavedGame(username);
	}

	public String[] retrieveUserNames() {
		return this.scoreboard.retrieveUserNames();
	}

	public boolean retrieveSavedGame() {
		game = new HangmanGame();
		game = game.retrieveSavedGame();
		System.out.println(game.getUser().toString());
		return (game != null);
	}

	public boolean isScoreboard() {
		return this.scoreboard.retrieveScoreboard();
	}

	public boolean getNewGame() {
		if (initializeDictionary() == 1) {
			String word = dictionary.getRandomWord();
			if (word == null) {
				return false;
			} else {
				this.game = new HangmanGame(word, currPlayer);
				currPlayer.setTotalGames(currPlayer.getTotalGames() + 1);
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
