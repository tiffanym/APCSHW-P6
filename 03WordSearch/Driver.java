import java.util.*;
import java.io.*;

public class Driver{  
    public static void main(String[]args){
	WordGrid w=new WordGrid();
	boolean fillRandomLetters=true;
	if (args.length>0){
	    try{
		int rows=Integer.parseInt(args[0]);
		int cols=Integer.parseInt(args[1]);
		w =new WordGrid(rows,cols);
		if (args.length==3) w.setSeed(Integer.parseInt(args[2]));
		if (args.length==4){ 
		    w.setSeed(Integer.parseInt(args[2])); 
		    fillRandomLetters=!args[3].equals("1");}
	    }catch(NumberFormatException e){
		System.err.println("Arguments "+args[0]+" must be an integer.");
		System.exit(1);
	    }
	}
	System.out.println("\\**Welcome to WORDGRID v1.0**// \n"+"          \\(^ o ^)/ \n");
	System.out.println("NOTE: Based on your terminal size, WordGrid may or not fit (will still run)."
			   +"\nThere is no limit to the number of rows or columns.\n");
	w.loadWordsFromFile("WordGridWords.txt",fillRandomLetters);
	System.out.println("Find these words:\n"+w.wordsInPuzzle());
	System.out.println(w);
    }
}