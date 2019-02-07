
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.File;

//https://www.tutorialspoint.com/java/java_files_io.htm


public class JavaFiles {
	
public static void main(String[] args) throws IOException {

/* LIST REPOSITIORY *************************************************/
/* */
	
      File file = null;
      String[] paths;
  
      try {      
         // create new file object
     file = new File("/Users/annie/spagon");

     // array of files and directory
     paths = file.list();

     // for each name in the path array
     for(String path:paths) {
        // prints filename and directory name
        System.out.println(path);
     }
  } catch (Exception e) {
     // if any error occurs
     e.printStackTrace();
  }
  
/* COPY FILE *************************************************/
/* main must throw IOException  */      
      
  InputStream in = null;
  OutputStream out = null;

  try {
     in = new FileInputStream("/Users/annie/Pictures/logo.png");
     out = new FileOutputStream("/Users/annie/Downloads/test.png");
     
     int c;
     while ((c = in.read()) != -1) {
        out.write(c);
     }
  } finally {
     if (in != null) {
        in.close();
     }
     if (out != null) {
        out.close();
     }
  }

/* READ & WRITE *************************************************/
/* read more: https://stackabuse.com/reading-and-writing-files-in-java/
 */	      
	    	    	
    String directory = System.getProperty("user.home");  
    String fileName = "downloads/test.txt";  
    String absolutePath = directory + File.separator + fileName;
    
    System.out.print(absolutePath);

    // write the content in file 
    try(FileWriter fileWriter = new FileWriter(absolutePath)) {  
        String fileContent = "This is a sample text.";
        fileWriter.write(fileContent);
    } catch (IOException e) {
        // exception handling
    }

    // read the content from file
    try(FileReader fileReader = new FileReader(absolutePath)) {  
        int ch = fileReader.read();
        while(ch != -1) {
            System.out.print((char)ch);
            ch = fileReader.read();
        }
    } catch (FileNotFoundException e) {
        // exception handling
    } catch (IOException e) {
        // exception handling
    }
	      
	      
	}	 
}