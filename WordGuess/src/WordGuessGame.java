import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordGuessGame {

	public static Scanner sc = new Scanner(System.in);
	public static String randomWord = "";
	public static String[] eachWord;
	public static boolean stopGame = false;
	public static String hiddenWord;
	
	
	public static void main(String[] args) {
		
		// TODO: add rules
		newGame();
	}

	public static void playGuessingGame() {
		
		List<String> lettersUsed = new LinkedList<String>();
		System.out.print("start");

		while (!stopGame) {

			System.out.print("\n> ");
			String userGuess = sc.next().toLowerCase();
			
			// TODO: catch invalid inputs
			
			lettersUsed.add(userGuess);
			hiddenWord = updateHiddenWord(userGuess);

			System.out.println("\t" + hiddenWord);
			System.out.print("\n\tused: " + lettersUsed.toString());
			
			if (hiddenWord.indexOf("-") == -1)
				stopGame = true;
		}
		sc.close();
		System.out.println("end game");

	}
	
	public static void newGame() {
		
		ArrayList<String> words = getListOfWords("java8classlist.txt");

		randomWord = getRandomWord(words);
		hiddenWord = dashes(randomWord.length());
		eachWord = randomWord.split("");
		
		System.out.println(randomWord + "\n\n"); // TODO: remove this later
		
		System.out.println("Word Guess Game\n"+dashes(35));
		System.out.println("hint: its a class in Java 8 with " );
		System.out.println(hiddenWord.length() + " letters\n");
		
		playGuessingGame();
	}

	public static String updateHiddenWord(CharSequence userWord) {
		
		List<String> result = new LinkedList<String>();
		String[] cs = hiddenWord.split("");
		
		for (int i = 0; i < cs.length; i++) {
			if (eachWord[i].toLowerCase().equals(userWord)) {
				result.add((String) eachWord[i]);	
			}
			else
				result.add(cs[i]);
		}
		return String.join("", result);
	}

	public static ArrayList<String> getListOfWords(String filename) {
		ArrayList<String> listOfWords = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				listOfWords.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listOfWords;
	}

	public static String getRandomWord(ArrayList<String> list) {
		int fileSize = list.size();
		int random = (int) (Math.random() * fileSize + 1);
		return list.get(random);
	}

	public static String dashes(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}

}
