package hangman_logic;

/*
 *       Title: HangmanController
 * Description: Facilitates the creation and saving of games
 *     Teacher: Sandra Stark
 *     Program: 420-B30 Programming III
 *      Author: Marissa Cleroux 
 */

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
	} // HangmanController()

	public int initializeDictionary() {
		if (gameInProgress) {
			return 1;
		} else if (!dictionary.initializeDictionary()) {
			return -1;
		} else if (dictionary.getDictionary().getLength() == 0) {
			return -2;
		} else {
			gameInProgress = true;
			return 1;
		}
	} // initializeDictionary()

	public User getCurrPlayer() {
		return currPlayer;
	}// getCurrPlayer()

	public void setCurrPlayer(User currPlayer) {
		this.currPlayer = currPlayer;
	}// setCurrPlayer(User)

	public boolean isGameInProgress() {
		return gameInProgress;
	}//isGameInProgress()
	
	public HangmanGame getGame() {
		return game;
	}//getGame()

	public void setGame(HangmanGame game) {
		this.game = game;
	}//setGame(HangmanGame)

	public Dictionary getDictionary() {
		return dictionary;
	}//getDictionary()

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}//setDictionary(Dictionary)

	public Scoreboard getScoreboard() {
		return scoreboard;
	}// getScoreboard()

	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}// setScoreboard(Scoreboard)

	public void addUser(String username) {
		this.currPlayer = new User(username);
		scoreboard.addUser(currPlayer);
	}// addUser(String)

	public void findUser(String username) {
		this.currPlayer = scoreboard.findUser(username);
	}//findUser(String)

	public boolean retrieveSavedGame() {
		game = new HangmanGame();
		game = game.retrieveSavedGame();
		return (game != null);
	}// retrieveSavedGame()

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
	}// getNewGame();

	public boolean saveGame(HangmanGame game) {
		return (dictionary.saveDictionary() && game.saveGame() && scoreboard.saveScoreboard());
	}// saveGame(HangmanGame)

}// HangmanController class
