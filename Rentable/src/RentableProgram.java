import java.io.*;
import java.util.*;


public class RentableProgram {
	

    
    public static void main(String[] args) {
    	

        Stack<String> STACK = new Stack<String>(); 
        Scanner scanner = new Scanner(System.in);
    	
    	STACK.push("ajasl");
    	STACK.push("asd");
    	STACK.push("asd");
    	
    	System.out.println(STACK);

    }

    public Stack<String> getCodeString(){
      
      String s = scanner.next();
      STACK.push(s);

      System.out.println(s);

      return STACK;

    }
    
    

}
