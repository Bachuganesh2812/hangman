package hangman_logic;

import java.io.Serializable;
import hangman_files.DictionaryFile;
import linked_data_structures.SinglyLinkedList;

/*
 *       Title: Dictionary
 * Description: Class that holds the list of available words to play
 *     Teacher: Sandra Stark
 *     Program: 420-B30 Programming III
 *      Author: Marissa Cleroux 
 */

public class Dictionary implements Serializable{

	private static final long serialVersionUID = 1L;
	private SinglyLinkedList<String> dictionary;
	private transient DictionaryFile file;
	
	public Dictionary() {
		dictionary = null;
	}// Dictionary()
	
	public SinglyLinkedList<String> getDictionary() {
		return dictionary;
	}// getDictionary()
	
	public void setDictionary(SinglyLinkedList<String> dictionary) {
		this.dictionary = dictionary;
	}//setDictionary(SinglyLinkedList<String>)
	
	public boolean initializeDictionary() {
		boolean dictionaryInitialized = false;	
		file = new DictionaryFile(); 
		if(file.readDictionary()) {
			dictionary = file.getDictionary().getDictionary();
			dictionaryInitialized = true;
		}
		
		return dictionaryInitialized;
	}//initializeDictionary()

	public boolean saveDictionary() {
		return file.saveDictionary(this);
	}//saveDictionary()

	public String getRandomWord() {
		String word = null;
		if(dictionary.getLength() >= 1) {
			int randNum = (int)(Math.random() * dictionary.getLength() - 1);
			word = dictionary.getElementAt(randNum);
			dictionary.remove(randNum);
		}else {
			System.out.println("There is no more words left");
		}
		
		return word;
	}//getRandomWord()
	
	public String toString() {
		String dictionaryString = "";
		
		for(int i = 0; i < dictionary.getLength(); i++) {
			dictionaryString += dictionary.getElementAt(i);
			dictionaryString += "\n";
		}
		
		return dictionaryString;
	}//toString()
	
}// Dictionary class
