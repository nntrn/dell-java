## Word Guessing Game

For this assignment we will be building a guessing game similar to Hangman.

### Requirements

1.  Create a new Java project and class file.
    *   Create a new Java project called "WordGuess".
    *   Inside the WordGuess project, create a new `WordGuessGame.java` class with a standard `main()` method.
    *   Similar to Tic Tac Toe, all your code for gameplay and game logic will go into the `WordGuessGame.java` file. You'll need to add your own helper methods to manage game functionality, just like in Tic Tac Toe.
2.  The program will pick a random word from a .txt file that contains an extensive list of words.
    *   Use the `words_alpha.txt` file in this [english-words Github repository](https://github.com/dwyl/english-words) or create your own word list file. Words should contain alphabetic characters only.
    *   To ensure your program can access your text file, save it in the WordGuess directory in your dell-java folder.
3.  The program should show the player the word with all the letters "hidden". You can use the underscore character "-" for hiding the letters.
    *   If the selected word is elephant, the output should show `--------`.
4.  The program then prompts the user to choose a letter. If the letter is part of the word, it will get filled in.
    *   In our example, if the player guesses "l", they should see `-l------`
    *   If the player guesses a letter that appears multiple times in the word, all occurrences of that character should get filled in. In our example with the word "elephant", if the player guesses "e", the should see `e-e-----`.
    *   If the player inputs a non-alphabetic character or inputs more than one character at a time, the program should notify the player that their input is invalid and prompt them to try again.
5.  Each time the player is prompted to guess a letter, the program should show the player which letters have been guessed so far. In this version of the game, we will give the player an unlimited number of guesses.
6.  When the player has correctly guessed all the characters, the program should inform the player that they have successfully "completed" the word.

### Guidelines

*   Include comments in your code. At the minimum, include a comment for each method to explain what it does. If you submit code without any comments, 5 points will be subtracted from your assignment score.
*   Your implementation should be broken down into different helper methods. Each method should have a well-defined "job".
*   Inform the player about any input rules. For example, if they are allowed to enter lower-case input, upper-case input, or both.

### Bonus Features

*   Restrict the player to a limited number of guesses. Keep track of the number of letters guessed by the player. If they go over the limit, inform the player that they have lost the game.
*   After implementing the bonus above: Each time the player guesses a letter, draw the Hangman stick figure (or similar figure) in the console to help the player keep track of the number of guesses they have remaining.