import java.util.Arrays;

public class Main {
	
	public static void main(String[] args)  {

		String[] colors = {"blue","dark blue","royal blue","midnight blue", "navy"};
		
		for (int i = 0; i < colors.length; i++)
			System.out.println(colors[i]);
		
		String[][] board = new String [3][3];
		
		for (int i = 0; i < board.length; i++)
			board[i][i] = "x";
		
		System.out.println(board);
		
		System.out.println(Arrays.toString(board[1])); 
		
		
	}


}
