package hangman_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import hangman_logic.HangmanGame;

public class GameFile{
	
	private static final String FILE_NAME = "game.ser";
	private HangmanGame game = new HangmanGame();

	public GameFile() {
		
	}
	
	public boolean deserializeGame() {
		
		boolean gameDeserialized = false;
		try {
			FileInputStream inStream = new FileInputStream(FILE_NAME);
			ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
			game = (HangmanGame) objectInputFile.readObject();
			gameDeserialized = true;
			
			objectInputFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}
		
		
		return gameDeserialized;
	}

	public boolean saveGame(HangmanGame game) {

		boolean gameSerialized = false;

		try {
			FileOutputStream outStream = new FileOutputStream(FILE_NAME);
			ObjectOutputStream outputFile = new ObjectOutputStream(outStream);
			outputFile.writeObject(game);
			gameSerialized = true;
			
			System.out.println("Game saved");
			outputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return gameSerialized;
	}
	
	public HangmanGame getGame() {
		return this.game;
	}

}
