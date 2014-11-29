import java.util.*;
import java.io.*;

public class Driver{  
    public static void main(String[]args){
	WordGrid w=new WordGrid();
	boolean fillRandomLetters=true;
	if (args.length==2){
	    try{
		int rows=Integer.parseInt(args[0]);
		int cols=Integer.parseInt(args[1]);
		w=new WordGrid(rows,cols);
	    }catch(NumberFormatException e){
		System.err.println("Argument"+args[0]+" must be an integer.");
		System.exit(1);
	    }
	}
	if(args.length==3){
	    w.setSeed(args[2]);
	}
	if(args.length==4){
	    fillRandomLetters =!args[3].equals("1");
	}
	
	w.loadWordsFromFile("WordGridWords.txt",fillRandomLetters);
	System.out.println("\nFind these words:\n"+w.wordsInPuzzle());
	System.out.println(w);
    }
}