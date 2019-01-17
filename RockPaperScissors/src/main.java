import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class main {
	
	public static void main(String[] args) {

		String user = getMoveForUser();
		String comp = getMoveForComp();
		System.out.println(user);


	}
	
	public static String getMoveForUser() {
		String[] handMoves = {"rock", "paper", "scissors"};

		Scanner sc = new Scanner(System.in);
		
		String userMove = sc.next().toLowerCase();
		
		// input check to prompt user for valid hand moves
		while(!Arrays.stream(handMoves).anyMatch(userMove::equals))  {
			System.out.println("need to be: rock, paper, or scissors");
			userMove = sc.next().toLowerCase();
		}
		return userMove;
		
	}
	
	public static String getMoveForComp() {
		String[] handMoves = {"rock", "paper", "scissors"};

		Scanner sc = new Scanner(System.in);
		
		String userMove = sc.next().toLowerCase();
		
		// input check to prompt user for valid hand moves
		while(!Arrays.stream(handMoves).anyMatch(userMove::equals))  {
			System.out.println("need to be: rock, paper, or scissors");
			userMove = sc.next().toLowerCase();
		}
		return userMove;
		
	}
	
}
