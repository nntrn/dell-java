import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {

	// GLOBAL VARIABLES
	public static String[] board = new String[9];
	public static String num[] = "1,2,3,4,5,6,7,8,9".split(",");

	public static int move = 1;

	public static void main(String[] args) {

		System.out.println("TIC TAC TOE");
		System.out.println("instructions: specify where on the board you want to move using 1-9");

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

		System.out.println("\n----END----");

	}

	static void getMoveForUser(String playerTurn) {

		move++;

		System.out.println("player " + playerTurn + ":");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		while (!Arrays.stream(num).anyMatch(input::equals)) {
			System.out.println("***invalid position, try again***");
			input = sc.nextLine();
		}

		int i = Integer.parseInt(input) - 1;
		num[i] = playerTurn;
		board[i] = playerTurn;

	}

	public static boolean checkForWin(String player) {

		String[] winMoves = { "0;1;2", "3;4;5", "6;7;8", "0;3;6", "1;4;7", "2;5;8", "0;4;8", "2;4;6" };

		for (int i = 0; i < winMoves.length; i++) {

			int[] move = Arrays.stream(winMoves[i].split(";")).mapToInt(Integer::parseInt).toArray();

			if (board[move[0]] == player && board[move[1]] == player && board[move[2]] == player)
				return true;
		}

		return false;

	}

	static void gameResult(boolean win, String player) {

		if (win) {
			System.out.println("\n-----------------");
			System.out.println("PLAYER" + player + "WINS!");
			System.out.println("-----------------");
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
