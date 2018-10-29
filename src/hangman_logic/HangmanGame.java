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
	private String interfaceLetters;
	private String answer;
	private int mistakesLeft;
	private boolean usedHint;

	public HangmanGame() {
		this.answer = null;
		this.mistakesLeft = 6;
		this.interfaceLetters = "";
		usedHint = false;
	}

	public HangmanGame(String ans) {
		this.answer = ans;
		this.mistakesLeft = 6;
		this.interfaceLetters = "";
		usedHint = false;
	}

	public SinglyLinkedList<Character> getAnswerLetters() {
		return answerLetters;
	}

	public void setAnswerLetters(SinglyLinkedList<Character> answer) {
		this.answerLetters = answer;
	}

	public String getInterfaceLetters() {
		return interfaceLetters;
	}

	public void setInterfaceLetters(String interfaceLetters) {
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

	public void initializeAnswer() {
		for (int i = answer.length() - 1; i >= 0; i--) {
			answerLetters.add(answer.charAt(i));
			System.out.print(answer.charAt(i));
			if (Character.isLetter(answer.charAt(i))) {
				interfaceLetters += "_";
			} else {
				interfaceLetters += answer.charAt(i);
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
				unmaskWholeWord();
				return -10;
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

	private boolean checkForMatchingLetter(char letter) {
		boolean foundMatch = false;
		for (int i = 0; i < answerLetters.getLength(); i++) {
			if (letter == answerLetters.getElementAt(i)) {
				String temp = interfaceLetters.substring(0, i);
				temp += letter;
				interfaceLetters = temp + interfaceLetters.substring(i + 1);
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

	public boolean equals(Object o) {
		return true;
	}

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
	
	public boolean isSavedGame() {
		GameFile file = new GameFile();
		return file.deserializeGame();
	}

	public boolean startGame() {
		return false;
	}

	public boolean giveHint() {
		if (!usedHint) {
			addHinted();
			usedHint = true;
			return true;
		}

		return false;
	}

	private boolean addHinted() {
		for (int i = 0; i < answerLetters.getLength(); i++) {
			if (!interfaceLetters.contains(answerLetters.getElementAt(i).toString())) {
				checkForMatchingLetter(answerLetters.getElementAt(i));
				return true;
			}
		}
		return false;
	}

	private void unmaskWholeWord() {
		for (int i = 0; i < answerLetters.getLength(); i++) {
			if (!interfaceLetters.contains(answerLetters.getElementAt(i).toString())) {
				checkForMatchingLetter(answerLetters.getElementAt(i));
			}
		}
	}

	public String toString() {
		String guessedLettersString = "";
		for (int i = 0; i < guessedLetters.getLength(); i++) {
			guessedLettersString += guessedLetters.getElementAt(i);
		}

		return guessedLettersString;
	}

}
