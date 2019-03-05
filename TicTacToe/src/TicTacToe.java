import java.util.Scanner;
import java.util.Arrays;

/**
 * The TicTacToe class implements an application for a two player tic tac toe
 * game. User specify position using values 1 through 9
 */
class TicTacToe {

	// GLOBAL VARIABLES
	public static String[] board = new String[9];
	public static String validBoardPositions[] = "1,2,3,4,5,6,7,8,9".split(",");
	public static int move = 1;

	public static void main(String[] args) {

		System.out.println("TIC TAC TOE");
		System.out.println("instructions: specify position on board 1-9\n");

		Arrays.fill(board, "   ");

		printBoard();

		boolean detectWin = false;
		while (!detectWin && move < 10) {

			String user = " X ";
			if (move % 2 == 0)
				user = " O ";

			getMoveForUser(user);

			if (checkForWin(user))
				detectWin = true;

			gameResult(detectWin, user);
		}
		System.out.println("----END----");

	}

	/**
	 * Accepts position inputs that exist in validBoardPositions[]
	 * 
	 * @param playerTurn (X or O)
	 */
	public static void getMoveForUser(String playerTurn) {

		move++;

		System.out.println("player " + playerTurn + ":");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		while (!Arrays.stream(validBoardPositions).anyMatch(input::equals)) {
			System.out.println("***invalid position, try again***");
			input = sc.nextLine();
		}

		int i = Integer.parseInt(input) - 1;

		validBoardPositions[i] = playerTurn; // remove position so it cant be used again
		board[i] = playerTurn;

	}

	/**
	 * @param player (X or O)
	 * @return boolean if win is detected
	 */
	public static boolean checkForWin(String player) {

		String[] winMoves = { 
			"0;1;2", "3;4;5", "6;7;8", // horizontal wins
			"0;3;6", "1;4;7", "2;5;8", // vertical wins
			"0;4;8", "2;4;6" // diagonal win
		};

		for (int i = 0; i < winMoves.length; i++) {

			int[] move = Arrays.stream(winMoves[i].split(";")).mapToInt(Integer::parseInt).toArray();

			if (board[move[0]] == player && board[move[1]] == player && board[move[2]] == player)
				return true;
		}

		return false;

	}

	/**
	 * @param win    boolean condition from checkForWin
	 * @param player (X or O)
	 */
	static void gameResult(boolean win, String player) {

		if (win) {
			System.out.println("\n-----------------");
			System.out.println("PLAYER" + player + "WINS!");
			System.out.println("-----------------\n");
		}

		if (move == 9)
			System.out.println("TIE GAME");

		printBoard();

	}

	static void printBoard() {
		System.out.println(board[0] + "|" + board[1] + "|" + board[2]);
		System.out.println("-----------");
		System.out.println(board[3] + "|" + board[4] + "|" + board[5]);
		System.out.println("-----------");
		System.out.println(board[6] + "|" + board[7] + "|" + board[8]);
		System.out.println("\n");
	}

}
