package hangman_logic;

import java.io.Serializable;

import linked_data_structures.SinglyLinkedList;

public class Dictionary implements Serializable{

	private SinglyLinkedList<String> dictionary = new SinglyLinkedList<String>();
	
	public Dictionary() {
		// TODO Auto-generated constructor stub
	}

	public SinglyLinkedList<String> getDictionary() {
		return dictionary;
		
	}

	public boolean retrieveDictionary(){
		return false;
		
	}
	
	public String getRandomWord() {
		return null;
	}

	
	
}
