package hangman_logic;

import java.io.Serializable;

import hangman_files.DictionaryFile;
import linked_data_structures.SinglyLinkedList;

public class Dictionary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SinglyLinkedList<String> dictionary;
	private transient DictionaryFile file;
	
	public Dictionary() {
		dictionary = null;
	}
	
	public SinglyLinkedList<String> getDictionary() {
		return dictionary;
	}
	
	public void setDictionary(SinglyLinkedList<String> dictionary) {
		this.dictionary = dictionary;
	}
	
	public boolean initializeDictionary() {
		boolean dictionaryInitialized = false;	
		file = new DictionaryFile(); 
		if(file.readDictionary()) {
			dictionary = file.getDictionary().getDictionary();
			dictionaryInitialized = true;
		} else {
			System.out.println("Something went wrong with the dictionary file.");
		}
		return dictionaryInitialized;
	}

	public boolean saveDictionary() {
		return file.saveDictionary(this);
	}

	// what happens at last word?
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
	}
	
	public String toString() {
		String dictionaryString = "";
		
		for(int i = 0; i < dictionary.getLength(); i++) {
			dictionaryString += dictionary.getElementAt(i);
			dictionaryString += "\n";
		}
		
		return dictionaryString;
	}
	
}
