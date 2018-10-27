package hangman_logic;

import java.io.Serializable;

import hangman_files.DictionaryFile;
import linked_data_structures.SinglyLinkedList;

public class Dictionary implements Serializable{

	private SinglyLinkedList<String> dictionary;
	private DictionaryFile file = new DictionaryFile();
	
	public Dictionary() {
		dictionary = null;
	}
	
	public SinglyLinkedList<String> getDictionary() {
		return dictionary;
	}
	
	public boolean initializeDictionary() {
		boolean dictionaryInitialized = false;
	
		if(file.readDictionary()) {
			dictionary = file.getDictionary();
			dictionaryInitialized = true;
		} else {
			System.out.println("Something went wrong with the dictionary file.");
		}
		return dictionaryInitialized;
	}

	public boolean saveDictionary() {
		if(file.saveDictionary(this))
			return true;
		else 
			return false;
	}

	
	public String getRandomWord() {
		return null;
	}

	public boolean deleteWord() {
		return false;
	}
	
}
