import java.util.*;
import java.io.*;
public class Driver{  
    public static void main(String[]args){
	/*
	  int[][] ary={
	  {1,2,3},
	    {6,4},
	    {7,12,0}
	    };
	    int[][] AR={};
	    
	    System.out.println(max(ary));
	    System.out.println(rowSum(ary,1));
	    System.out.println(Arrays.toString(allRowSums(ary)));
	    System.out.println(isSquare(ary));
	    System.out.println(columnSum(ary,2));
	    System.out.println(isRowMagic(ary));
	    System.out.println(isColumnMagic(ary));
	    System.out.println(isColumnMagic(AR));	
	
	*/
	WordGrid w=new WordGrid(6,7);
	//w.clear();
	String word1="Happy";
	String word2="Duhh";
	String word3="cat";
	String word4="crab";
	//w.addWordHorizontal(word1,3,2,,1);
	//w.addWordHorizontal(word2,1,4,0,1);	
	//w.addWordVertical(word3,2,3);
	//w.addWordVertical(word3,2,5);
	//w.addWordDiagonal(word4,1,1);
	//w.fillUp();
	System.out.println(w.checkWord(word2,3,3,-1,0));
	System.out.println(w.toString());
	

	//creating File instance to refrence text file in Java
	File text =new File("/home/tiffany/Desktop/AP-CS/APCSHW-P6/03WordSearch/WordGridWords.txt");	
	//Reads words into an ArrayList<String>
	ArrayList<String> dict= new ArrayList<String>();
	try{
	    Scanner scnr=new Scanner(text);
	    while(scnr.hasNextLine()){
		String word=scnr.nextLine();
		dict.add(word);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("Could not read from file");
	}	
	//System.out.println(dict.toString());
	/*
	WordGrid w=new WordGrid(20,20);
	for (int i=0;i<10;i++){
	    int randWordIndex=(int)(Math.random()*100);
	    int randMethod=(int)(Math.random()*3)+1;
	    int row=(int)(Math.random()*20);
	    int col=(int)(Math.random()*20);
	    switch (randMethod){
	    case 1:
		if(!w.addWordHorizontal(dict.get(randWordIndex),row,col)){
		    randWordIndex=(int)(Math.random()*100)+1;
		    w.addWordHorizontal(dict.get(randWordIndex),row,col);
		}
	    case 2:
		if(!w.addWordVertical(dict.get(randWordIndex),row,col)){
		    randWordIndex=(int)(Math.random()*100)+1;
		    w.addWordVertical(dict.get(randWordIndex),row,col);
		}
	    case 3:
		if(!w.addWordDiagonal(dict.get(randWordIndex),row,col)){
		    randWordIndex=(int)(Math.random()*100)+1;
		    w.addWordDiagonal(dict.get(randWordIndex),row,col);
		}		
	    }
	}
	System.out.println(w.toString());
	*/
    }
}