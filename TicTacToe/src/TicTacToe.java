import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {

	public static String[] board = new String[9];
	public static String num[] = "0,1,2,3,4,5,6,7,8".split(",");
	
	
	public static int move = 1;

	public static void main(String[] args) {
		Arrays.fill(board, "   ");
		
		while(move < 10) {
			getMoveForUser(move);
		}
		
		printBoard();
		System.out.println("\n----END----");

	}

	public static String getMoveForUser(int m) {
		
		printBoard();

		String playerTurn = " X ";
		if(m % 2 == 0)
			playerTurn = " O ";
			
		move++;
		
		System.out.println("\nmove for: " + playerTurn);
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		while(!Arrays.stream(num).anyMatch(input::equals))  {
			System.out.println("invalid input, try again for " + playerTurn );
			input = sc.nextLine();
		}
		
		int i = Integer.parseInt(input);
		num[i] = playerTurn;
		board[i] = playerTurn;

		return input;

	}

	static void printBoard() {

		System.out.println(board[0] + "|" + board[1] + "|" + board[2] );
		System.out.println("-----------");
		System.out.println(board[3] + "|" + board[4] + "|" + board[5] );
		System.out.println("-----------");
		System.out.println(board[6] + "|" + board[7] + "|" + board[8] );

	}

}
