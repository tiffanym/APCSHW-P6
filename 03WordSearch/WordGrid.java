import java.util.*;

public class WordGrid{
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data= new char[rows][cols];
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int i=0;i<data.length;i++){
	    for (int x=0;x<data[i].length;x++){
		data[i][x]='_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String s="";
	for (int i=0;i<data.length;i++){
	    for (int x=0;x<data[i].length;x++){
		s=s+data[i][x];
	    }
	    s=s+"\n";
	}
	return s;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	int width=data[0].length;
	if (word.length()+col>width){
	    return false;
	}	
	else{
	    for (int i=col;i<word.length()+col;i++){
		//if
		//data[row][i]=word.charAt(i-col);
	    }
	    return true;
	}
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordVertical(String word,int row, int col){
	return false;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word,int row, int col){
	return false;
    }

    /**Finds the maximum number in the array, assuming that the input array is
     *made up of integers.
     *
     *@param ary is the given array you want to find the max number of.
     *@return the maximum number OR 0 if array has length of 0 (array is null)
     */
    public static int max(int[][] ary){	
	if (ary.length>0){
	    int max=ary[0][0];
	    for (int i=0;i<ary.length;i++){
		for (int x=0;x<ary[i].length;x++){
		    if (ary[i][x]>max){
			max=ary[i][x];
		    }
		}
	    }
	    return max;
	}
	return 0;
    }
    
    /**Finds the sum of the elements of a specified row in a given array.
     *Assumes that the inputed row parameter is within the array.
     *
     *@param ary is the array in which you want the sum of one of its rows.
     *@param x is the row whose elements you want the sum of.
     *@return the sum of the row you specify OR 0 if the array has a length of 0 (array is null)
     */
    public static int rowSum(int[][] ary, int x){
	if (ary[x].length>0){
	    int sum=0;
	    for (int i=0;i<ary[x].length;i++){
		sum+=ary[x][i];
	    }
	    return sum;
	}
	return 0;
    }

    /**Checks if the array is square (i.e. every row has the same length as AR itself).
     *
     *@param ary is the array you want to check the squarity of.
     *@return true if the number of rows= number of columns; false otherwise.
     */
    public static boolean isSquare(int[][] ary){
	boolean sq=true;
	for (int i=0;i<ary.length;i++){
	    if (ary[i].length != ary.length){
		sq=false;
		break;
	    }
	}
	return sq;
    }

    public static void main(String[]args){
	WordGrid w=new WordGrid(6,7);
	w.clear();
	String word1="Happy";
	String word2="Duhh";
	//w.addWordHorizontal(word1,3,2);
	//w.addWordHorizontal(word2,1,4);
	
	//System.out.println(w.toString());
	int[][] ary={
	    {1,2,3},
	    {6,5,4},
	    {7,12,0}
	};
	System.out.println(max(ary));
	System.out.println(rowSum(ary,1));
	System.out.println(isSquare(ary));
    }
}