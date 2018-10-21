package hangman_logic;

import java.io.Serializable;

import linked_data_structures.SinglyLinkedList;

public class HangmanGame implements Serializable{
	
	private SinglyLinkedList<Character> answerLetters = new SinglyLinkedList<Character>();
	private SinglyLinkedList<Character> guessedLetters = new SinglyLinkedList<Character>();
	private String answer;

	public SinglyLinkedList<Character> getAnswerLetters() {
		return answerLetters;
	}

	public void setAnswer(SinglyLinkedList<Character> answer) {
		this.answerLetters = answer;
	}

	public SinglyLinkedList<Character> getGuessedLetters() {
		return guessedLetters;
	}

	public void setGuessedLetters(SinglyLinkedList<Character> guessedLetters) {
		this.guessedLetters = guessedLetters;
	}

	public HangmanGame() {
		this.answer = null;
	}
	
	public HangmanGame(String ans) {
		this.answer = ans;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
	
	

}
