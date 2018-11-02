package hangman_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import hangman_logic.HangmanGame;

/*
 *       Title: GameFile
 * Description: File Handler for the HangmanGame class
 *     Teacher: Sandra Stark
 *     Program: 420-B30 Programming III
 *      Author: Marissa Cleroux 
 */

public class GameFile {

	private static final String FILE_NAME = "game.ser";
	private HangmanGame game;

	public GameFile() {
		game = new HangmanGame();
	}// GameFile()

	public boolean deserializeGame() {

		boolean gameDeserialized = false;
		try {
			FileInputStream inStream = new FileInputStream(FILE_NAME);
			ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
			game = (HangmanGame) objectInputFile.readObject();
			gameDeserialized = true;

			objectInputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}

		return gameDeserialized;
	}// deserializeGame()

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
	}// saveGame(HangmanGame)

	public HangmanGame getGame() {
		return this.game;
	}// getGame()

}// GameFile class
