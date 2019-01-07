import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		String word = getWordInput();

		if (isEnglishWord(word)) {
			String pl = translate(word);
			System.out.println(pl);
		} else {
			System.out.println("input is not a english word");
		}

	}

	public static String getWordInput() {
		@SuppressWarnings("resource")

		Scanner sc = new Scanner(System.in);
		System.out.println("word to translate:");

		while (!sc.hasNext("[A-Za-z]*")) {
			System.out.println("a-z character values only");
			sc.next();
		}

		return sc.next();

	}

	public static String translate(String word) {

		String firstLetter = Character.toString(word.charAt(0));
		boolean firstLetterIsVowel = Pattern.matches("[aeiou]", firstLetter);
		boolean wordContainsVowel = Pattern.matches(".*[a|e|i|o|u].*", word);

		// System.out.println("firstLetterIsVowel: " + firstLetterIsVowel);
		// System.out.println("wordContainsVowel: " + wordContainsVowel);

		if (wordContainsVowel) {
			if (!firstLetterIsVowel) {
				// starts with consonant and has a vowel
				Pattern pattern = Pattern.compile("[a|e|i|o|u]");
				Matcher matcher = pattern.matcher(word);
				if (matcher.find()) {
					int vowelPosition = matcher.start();
					return word.substring(vowelPosition) + word.substring(0, vowelPosition) + "ay";
				}
				return word;

			} else
				return word + "yay"; // first letter is a vowel

		} else
			return word + "ay"; // does not have any vowels

	}

	public static boolean isEnglishWord(String word) throws FileNotFoundException {

		Set<String> dictionaryWords = readWords("words");

		if (!dictionaryWords.contains(word)) {
			System.out.println("word does not exist in english dictionary");
			return false;
		}

		return true;

	}

	public static Set<String> readWords(String filename) throws FileNotFoundException {
		Set<String> words = new HashSet<>();
		Scanner in = new Scanner(new File(filename));
		// Use any characters other than a-z or A-Z as delimiters
		in.useDelimiter("[^a-zA-Z]+");
		while (in.hasNext()) {
			words.add(in.next().toLowerCase());
		}
		return words;
	}
}
