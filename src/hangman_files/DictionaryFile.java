package hangman_files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import hangman_logic.Dictionary;
import linked_data_structures.SinglyLinkedList;

public class DictionaryFile {
	
	private static final String FILE_NAME_STATIC = "dictionary.txt";
	private static final String FILE_NAME_SERIALIZED = "dictionary.ser";
	private SinglyLinkedList<String> dictionary;

	public DictionaryFile() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean readDictionary() {
		boolean dictionaryCreated = false;
		
		if(deserializeDictionary()) {
			dictionaryCreated = true;
		} else if(readDictionaryFile()) {
			dictionaryCreated = true;
		} 
		
		return dictionaryCreated;
	}
	
	private boolean deserializeDictionary() {
		
		return false;
	}
	
	private boolean readDictionaryFile() {
		File dictionaryFile = new File(FILE_NAME_STATIC);
		Scanner in = null;
		try {
			in = new Scanner(dictionaryFile);
			in.useDelimiter("\r\n");
			dictionary = new SinglyLinkedList<String>();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		while(in.hasNext()) {
			dictionary.add(in.nextLine());
		}
		
		in.close();
		
		if(dictionary.getLength() == 0) {
			return false;
		}
		
		return true;
	}
	
	public boolean saveDictionary(Dictionary dictionary) {
		
		boolean dictionarySerialized = false;
		
		try {
			FileOutputStream outStream = new FileOutputStream(FILE_NAME_SERIALIZED);
			ObjectOutputStream outputFile = new ObjectOutputStream(outStream);
			outputFile.writeObject(dictionary);
			dictionarySerialized = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dictionarySerialized;
	}
	
	public SinglyLinkedList<String> getDictionary() {
		return dictionary;
	}

}
