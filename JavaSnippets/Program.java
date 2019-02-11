
import java.io.FileOutput;
import java.io.*;
import java.io.IOExceptions;

public class Program {

   public static void main(String args[]) throws FileNotFoundException {  
      FileInputStream in = null;
      FileOutputStream out = null;

      try {
         in = new FiFileOutputStreamleInputStream("/Users/annie/almost-a-programmer/siteicon.png");
         out = new ("/Users/annie/Downloads/siteicon-nntrn.png");
         
         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      }finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}