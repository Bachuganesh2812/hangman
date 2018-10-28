package hangman_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import hangman_logic.Dictionary;
import linked_data_structures.SinglyLinkedList;

public class DictionaryFile {
	
	private static final String FILE_NAME_STATIC = "dictionary.txt";
	private static final String FILE_NAME_SERIALIZED = "dictionary.ser";
	private SinglyLinkedList<String> dictionaryList;
	private Dictionary dictionary = new Dictionary();

	public DictionaryFile() {
	}
	
	public boolean readDictionary() {
		boolean dictionaryCreated = false;
		
		if(deserializeDictionary()) {
			System.out.println("Dictionary deserialized");
			dictionaryCreated = true;
		} else if(readDictionaryFile()) {

			System.out.println("Dictionary read from text file");
			dictionary = new Dictionary();
			dictionaryCreated = true;
		} 
		
		return dictionaryCreated;
	}
	
	private boolean deserializeDictionary() {
		
		boolean dictionaryDeserialized = false;
		try {
			FileInputStream inStream = new FileInputStream(FILE_NAME_SERIALIZED);
			ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
			dictionary = (Dictionary) objectInputFile.readObject();
			dictionaryDeserialized = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}
		
		
		return dictionaryDeserialized;
	}
	
	private boolean readDictionaryFile() {
		File dictionaryFile = new File(FILE_NAME_STATIC);
		Scanner in = null;
		try {
			in = new Scanner(dictionaryFile);
			in.useDelimiter("\r\n");
			dictionaryList = new SinglyLinkedList<String>();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		while(in.hasNext()) {
			dictionaryList.add(in.nextLine());
		}
		
		in.close();
		
		if(dictionaryList.getLength() == 0) {
			return false;
		}
		
		dictionary.setDictionary(dictionaryList);
		return true;
	}
	
	public boolean saveDictionary(Dictionary dictionary) {
		
		boolean dictionarySerialized = false;
		
		try {
			FileOutputStream outStream = new FileOutputStream(FILE_NAME_SERIALIZED);
			ObjectOutputStream outputFile = new ObjectOutputStream(outStream);
			outputFile.writeObject(dictionary);
			dictionarySerialized = true;
			outputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return dictionarySerialized;
	}
	
	public Dictionary getDictionary() {
		return dictionary;
	}
}
