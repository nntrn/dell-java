import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordGuessGame {

	public static ArrayList<String> words = getListOfWords("java8classlist.txt");
	public static Scanner sc = new Scanner(System.in);
	public static String randomWord;
	public static String[] eachWord;
	public static boolean stopGame = false;
	public static String hiddenWord;
	public static List<String> lettersUsed;
	
	public static void main(String[] args) {

		System.out.println("Word Guess Game:".toUpperCase());
		System.out.println("Java 8 Classes\n"+ dashes(50));
		System.out.println("INFO:");
		System.out.println("input needs to be:");
		System.out.println("  - an alphabet (case insensitive)");
		System.out.println("  - a single character");
		System.out.println("  - not already used");
		System.out.println(dashes(50));

		newGame();
	}

	public static void playGuessingGame() {
		
		System.out.println(randomWord);  // guess this word
		System.out.print("\nstart");
		
		int counter = 1;
		while (!stopGame) {
			System.out.print("\n> ");
			String userGuess = sc.next().toLowerCase();
			
			if(userGuess.contains("skip"))
				newGame();
			else if(checkForInputErrors(userGuess)) {
				lettersUsed.add(userGuess);
				hiddenWord = updateHiddenWord(userGuess);
				System.out.print("\t" + counter++ + ".  "+hiddenWord+"\tused: "+ getWordsUsed());
			}
			if (hiddenWord.equals(randomWord))
				gameComplete();
		}
		sc.close();
	}
	// reset global variables for new game
	public static void newGame() {
		lettersUsed = new LinkedList<String>();
		randomWord = getRandomWord(words);
		hiddenWord = dashes(randomWord.length());
		eachWord = randomWord.split("");
		stopGame = false;
		
		System.out.print(hiddenWord.length() + " letters\t");
		playGuessingGame();
	}
	// check and alert invalid user inputs
	public static boolean checkForInputErrors(String letter) {
		if(!letter.matches("[A-Za-z]*")) {
			System.out.print("\terror: invalid character");
			return false;
		}
		if(letter.length() > 1) {
			System.out.print("\terror: too many inputs");
			return false;
		}
		if(Arrays.stream(lettersUsed.toArray()).anyMatch(letter::equals)) {
			System.out.print("\terror: letter already guessed");
			return false;
		}
		return true;	
	}
	// update hidden word string with new guess input
	public static String updateHiddenWord(CharSequence userWord) {
		
		List<String> result = new LinkedList<String>();
		String[] hidden = hiddenWord.split("");
		
		for (int i = 0; i < hidden.length; i++) {
			String str = (eachWord[i].toLowerCase().equals(userWord)) ?
					eachWord[i] : hidden[i];
			result.add(str);
		}
		return String.join("", result);
	}
	public static void gameComplete() {
		stopGame = true;
		System.out.print("\n"+dashes(30)+"\ncompleted\nnew game?\n> ");
		if(sc.next().contains("y"))
			newGame();
	}
	// return list from txt file
	public static ArrayList<String> getListOfWords(String filename) {
		ArrayList<String> listOfWords = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine())
				listOfWords.add(scanner.nextLine());
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listOfWords;
	}
	public static String getWordsUsed() {
		return lettersUsed.toString().replaceAll(" ", "");
	}
	public static String getRandomWord(ArrayList<String> list) {
		int random = (int) (Math.random() * list.size() + 1);
		return list.get(random);
	}
	public static String dashes(int length) {
		return String.format("%" + length + "c", ' ').replace(' ', '-');
	}

}
