import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class duxie {

	public static void main(String args[]) throws IOException {
     File f=new File(".\\src\\result.txt");
	if(!f.exists())
	{	 	 f.createNewFile();}
	
     try{
    	 PrintStream outPrintStream=new PrintStream(f);

     }catch (Exception e) {
		// TODO: handle exception
     							}
		}
    
	}

