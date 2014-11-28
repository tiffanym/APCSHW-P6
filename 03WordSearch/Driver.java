import java.util.*;
import java.io.*;

public class Driver{  
    public static void main(String[]args){
	WordGrid w=new WordGrid();
	if (args.length>0){
	    try{
		int rows=Integer.parseInt(args[0]);
		int cols=Integer.parseInt(args[1]);
		w=new WordGrid(rows,cols);
	    }catch(NumberFormatException e){
		System.err.println("Argument"+args[0]+" must be an integer.");
		System.exit(1);
	    }
	}
	
	boolean fillRandomLetters=true;
	if (args.length==4){
	    fillRandomLetters =!args[3].equals("1");
	}
	
	//if (){
	    //some random seed stuff going on here
	//}
	w.loadWordsFromFile("WordGridWords.txt",false);
			    //fillRandomLetters);
	System.out.println("Find these words:\n"+w.wordsInPuzzle());
	System.out.println(w);
    }
}