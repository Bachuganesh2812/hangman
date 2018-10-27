package hangman_logic;

import java.io.Serializable;

import linked_data_structures.SinglyLinkedList;

public class HangmanGame implements Serializable{
	
	private SinglyLinkedList<Character> answerLetters = new SinglyLinkedList<Character>();
	private SinglyLinkedList<Character> guessedLetters = new SinglyLinkedList<Character>();
	private SinglyLinkedList<Character> interfaceLetters = new SinglyLinkedList<Character>();
	private String answer;
	private int mistakesLeft;
	private boolean usedHint = false;
	
	public HangmanGame() {
		this.answer = null;
		this.mistakesLeft = 0;
	}
	
	public HangmanGame(String ans) {
		this.answer = ans;
		this.mistakesLeft = 6;
	}

	public SinglyLinkedList<Character> getAnswerLetters() {
		return answerLetters;
	}

	public void setAnswerLetters(SinglyLinkedList<Character> answer) {
		this.answerLetters = answer;
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
	
	public void initializeAnswer( ) {
		for(int i = answer.length() - 1; i >= 0; i--) {
			answerLetters.add(answer.charAt(i));
			if(Character.isLetter(answer.charAt(i))) {
				interfaceLetters.add('_');
			} else {
				interfaceLetters.add(answer.charAt(i));
			}
		}
	}

	public int checkLetter(char letter) {
		return 0;
	}
	
	public int checkWord(String word) {
		return 0;
	}
	
	public int checkGameDone() {
		return 0;
	}// checkGameDone()
	
	public boolean equals(Object o) {
		return true;
	}
	
	public boolean saveGame() {
		return true;
	}
	
	public boolean startGame() {
		return false;
	}
	
	private char giveHint() {
		return 'a';
	}
	
	public String toString() {
		String word = "";
		for(int i = 0; i < interfaceLetters.getLength(); i++) {
			word += interfaceLetters.getElementAt(i);
			word += " ";
		}
		return word;
	}

}
