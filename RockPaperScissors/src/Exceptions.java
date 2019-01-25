import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Exceptions {
	
	public static String[] handMoves = {"rock", "paper", "scissors"};
	public static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
		boolean continueGame = false;
		
		while(!continueGame) {
			playGame();
			
			System.out.println("continue playing? (y/n)");
			
			String continuePlaying = sc.next();
			
			if(continuePlaying.equals("n")){
				continueGame = true;
			}
			
			if(continuePlaying.equals("y")) {
				playGame();
			}
			
			
		}
		
		
	}
	
	public static void playGame() {
		
		String user = getMoveForUser();
		String comp = getMoveForComp();
		System.out.println("your move: " + user);
		System.out.println("comp move: " + comp);
		
		getGameResults(user, comp);
		
	}
	
	public static String getMoveForUser() {

		System.out.println("rock, paper, or scissors?");

		String userMove = sc.next().toLowerCase();
		
		// input check to prompt user for valid hand moves
		while(!Arrays.stream(handMoves).anyMatch(userMove::equals))  {
			System.out.println("need to be: rock, paper, or scissors");
			userMove = sc.next().toLowerCase();
		}
		return userMove;
		
	}
	
	public static String getMoveForComp() {

		int random = (int)(Math.random() * 3 + 0);
		// 2 is the maximum and the 0 is our minimum

		String compMove = handMoves[random];
		
		return compMove;
		
	}
	public static void getGameResults(String u, String c) {

        int resultMatrix[][] = {  // R  P  S
        					/*R*/ { 0, -1,  1 }, 
        					/*P*/ { 1,  0, -1 }, 
        					/*S*/ {-1,  1,  0 } 
        					}; 
        
        int userIndex = Arrays.asList(handMoves).indexOf(u);
        int compIndex = Arrays.asList(handMoves).indexOf(c);
        
        int result = resultMatrix[userIndex][compIndex];
       
        		
        if (result == 0)
        	System.out.println("TIE");
        
        if (result == -1)
        	System.out.println("COMP WINS");
        
        if (result == 1)
        	System.out.println("USER WINS");

	}	
	

}
