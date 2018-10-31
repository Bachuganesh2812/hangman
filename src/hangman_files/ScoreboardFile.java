package hangman_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import hangman_logic.Scoreboard;

public class ScoreboardFile {
	
	private static final String FILE_NAME = "scoreboard.ser";
	private Scoreboard scoreboard = new Scoreboard();
	
	
	public boolean deserializeScoreboard() {
		
		boolean scoreboardDeserialized = false;
		try {
			FileInputStream inStream = new FileInputStream(FILE_NAME);
			ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
			scoreboard = (Scoreboard) objectInputFile.readObject();
			scoreboardDeserialized = true;
			
			objectInputFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		
		
		return scoreboardDeserialized;
	}

	public boolean saveScoreboard(Scoreboard scoreboard) {

		boolean scoreboardSerialized = false;

		try {
			FileOutputStream outStream = new FileOutputStream(FILE_NAME);
			ObjectOutputStream outputFile = new ObjectOutputStream(outStream);
			outputFile.writeObject(scoreboard);
			scoreboardSerialized = true;
			
			System.out.println("Scoreboard serialized");
			outputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return scoreboardSerialized;
	}
	
	public Scoreboard getScoreboard() {
		return this.scoreboard;
	}
}
