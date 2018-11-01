package hangman_logic;

import java.io.Serializable;

import hangman_files.GameFile;
import linked_data_structures.SinglyLinkedList;

public class HangmanGame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SinglyLinkedList<Character> answerLetters = new SinglyLinkedList<Character>();
	private SinglyLinkedList<Character> guessedLetters = new SinglyLinkedList<Character>();
	private User user;
	private String answer;
	private int mistakesLeft;
	private char[] interfaceLetters;
	private boolean gameDone = false;

	public HangmanGame() {
		this.answer = null;
		this.mistakesLeft = 6;
		this.interfaceLetters = null;
		this.user = new User();
	}
	
	public HangmanGame(User user) {
		this.answer = null;
		this.mistakesLeft = 6;
		this.interfaceLetters = null;
		this.user = user;
	}

	public HangmanGame(String ans, User user) {
		this.answer = ans;
		this.mistakesLeft = 6;
		this.interfaceLetters = null;
		this.user = user;
	}

	public boolean isGameDone() {
		return gameDone;
	}

	public void setGameDone(boolean gameDone) {
		this.gameDone = gameDone;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public SinglyLinkedList<Character> getAnswerLetters() {
		return answerLetters;
	}

	public void setAnswerLetters(SinglyLinkedList<Character> answer) {
		this.answerLetters = answer;
	}

	public char[] getInterfaceLetters() {
		return interfaceLetters;
	}

	public void setInterfaceLetters(char[] interfaceLetters) {
		this.interfaceLetters = interfaceLetters;
	}

	public int getMistakesLeft() {
		return mistakesLeft;
	}

	public void setMistakesLeft(int mistakesLeft) {
		this.mistakesLeft = mistakesLeft;
	}

	public SinglyLinkedList<Character> getGuessedLetters() {
		return guessedLetters;
	}

	public void setGuessedLetters(SinglyLinkedList<Character> guessedLetters) {
		this.guessedLetters = guessedLetters;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getInterfaceLettersString() {
		String interfaceLettersStr = "";
		for(char letter : interfaceLetters) {
			interfaceLettersStr += letter;
			interfaceLettersStr += " ";
		}
		
		return interfaceLettersStr;
	}

	public void initializeAnswer() {
		interfaceLetters = new char[answer.length()];
		for (int i = answer.length() - 1; i >= 0; i--) {
			answerLetters.add(answer.charAt(i));
			if (Character.isLetter(answer.charAt(i))) {
				interfaceLetters[i] = '_';
			} else {
				interfaceLetters[i] = answer.charAt(i);
			}
		}

		for (int i = 0; i < answerLetters.getLength(); i++) {
			System.out.print(answerLetters.getElementAt(i));
		}

		System.out.println();

	}

	public int checkLetter(String letter) {
		if (validateLetter(letter)) {
			char let = letter.charAt(0);
			for (int i = 0; i < guessedLetters.getLength(); i++) {
				if (let == guessedLetters.getElementAt(i))
					return -2;
			}

			if (!checkForMatchingLetter(let)) {
				mistakesLeft -= 1;
			}

			if (checkForLose()) {
				gameDone = true;
				unmaskWholeWord();
				return -10;
			} else if(checkForWin()) {
				gameDone = true;
				user.setTotalWins(user.getTotalWins() + 1);
				return 10;
			}

			guessedLetters.add(let);
			return 1;
		} else {
			return -1;
		}
	}

	private boolean checkForLose() {
		return (mistakesLeft == 0);
	}
	
	private boolean checkForWin() {
		boolean isEqual = true;
		
		for(int i = 0; i < answerLetters.getLength(); i++) {
			if(interfaceLetters[i] != answerLetters.getElementAt(i))
				isEqual = false;
		}
		
		return isEqual;
	}

	private boolean checkForMatchingLetter(char letter) {
		boolean foundMatch = false;
		for (int i = 0; i < answerLetters.getLength(); i++) {
			if (Character.toLowerCase(letter) == Character.toLowerCase(answerLetters.getElementAt(i))) {
				System.out.println(letter);
				interfaceLetters[i] = answerLetters.getElementAt(i);
				foundMatch = true;
			}
		}

		return foundMatch;
	}

	private boolean validateLetter(String letter) {
		if (letter.length() == 0)
			return false;
		else if (letter.length() > 1)
			return false;
		else if (!Character.isLetter(letter.charAt(0)))
			return false;

		return true;
	}

	public int checkWord(String word) {
		if (word.length() == 0) {
			return -2;
		} else if (word.length() != answerLetters.getLength()) {
			mistakesLeft -= 1;
			return -1;
		} else {
			for (int i = 0; i < answerLetters.getLength(); i++) {
				if (word.charAt(i) != answerLetters.getElementAt(i)) {
					mistakesLeft -= 1;
					if (checkForLose()) {
						unmaskWholeWord();
						return -10;
					}
					return -1;
				}
			}
			return 1;
		}
	}

	public boolean validateWord(String word) {
		if (word.length() != 0)
			return false;
		else if (word.length() != answerLetters.getLength())
			return false;

		return true;
	}

	public int checkGameDone() {
		return 0;
	}// checkGameDone()

	public boolean saveGame() {
		GameFile file = new GameFile();
		return (file.saveGame(this));
	}
	
	public HangmanGame retrieveSavedGame() {
		GameFile file = new GameFile();
		if(file.deserializeGame())
			return file.getGame();
		else
			return null;
	}
	
	public boolean isSavedGame(String username) {
		GameFile file = new GameFile();
		User tempUser = new User(username);
		return (file.deserializeGame() && file.getGame().getUser().equals(tempUser));
	}

	public boolean startGame() {
		return false;
	}
	
	

	public int giveHint() {
		for (int i = 0; i < answerLetters.getLength(); i++) {
			if(interfaceLetters[i] != answerLetters.getElementAt(i)) {
				checkForMatchingLetter(answerLetters.getElementAt(i));
				if(checkForWin()) {
					user.setTotalWins(user.getTotalWins() + 1);
					gameDone = true;
					return 10;
				}
				return 1;
			}
		}
		return -1;
	}

	private void unmaskWholeWord() {
		for (int i = 0; i < answerLetters.getLength(); i++) {
			interfaceLetters[i] = answerLetters.getElementAt(i);
		}
	}
	
	public String getGuessedLettersString() {
		String guessedLettersString = "";
		for (int i = 0; i < guessedLetters.getLength(); i++) {
			guessedLettersString += guessedLetters.getElementAt(i);
			guessedLettersString += " ";
		}

		return guessedLettersString;
	}

	@Override
	public String toString() {
		return null;
	}
	

}
