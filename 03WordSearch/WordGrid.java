import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordGrid{
    protected char[][]data;
    protected Random r= new Random();
    protected ArrayList<String> dict=new ArrayList<String>(); //all words
    protected ArrayList<String> wordList=new ArrayList<String>(); //words used in WordGrid

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param rows is the starting height of the WordGrid
     *@param cols is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	if (rows>4 && cols>4){
	    data= new char[rows][cols];	    
	}
	else{
	    data= new char[10][10];
	}
	r.setSeed(1234);
	clear();
    }

    public WordGrid(){
	data=new char[10][10];
	clear();
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
	    s+="[";
	    for (int x=0;x<data[i].length;x++){
		s=s+data[i][x];
	    }
	    s=s+"]\n";
	}
	return s;
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

    /**Calculates the row sum for every row and returns each of the values in an array. 
     *Index i of the return array contains the sum of elements in row i.
     *@param AR is the array in which you want the sum of one of its rows.
     *@return memory of new array with sums (use Arrays.toString(allRowSums(some array)) to return 
     *the row sum for every row with index i of the return array = the sum of elements in row i.)
     */
    public static int[] allRowSums(int[][] AR){
	int[] ary=new int[AR.length];
	for (int i=0; i<AR.length;i++){
	    ary[i]=rowSum(AR, i);	   
	}
	return ary;
    }

    /**Finds the sum of the elements of a specified column in a given array.
     *Assumes that the inputed column parameter is within the array.
     *
     *@param AR is the array in which you want the sum of one of its columns.
     *@param x is the column whose elements you want the sum of.
     *@return the sum of the elements in Column x of AR OR 0 if the array has a length of 0 (array is null)
     */
    public static int columnSum(int[][] AR, int x){
	if (AR.length>0){
	    int sum=0;
	    for (int i=0;i<AR.length;i++){
		if (AR[i].length>x){
		    sum+=AR[i][x];
		}
	    }
	    return sum;
	}
	return 0;
    }

    /**Checks if the array is row-magic (if every row has the same row sum);
     *
     *@param AR is the array which you're checking for row-magic.
     *@return true if the array is row-magic or has length 0 and false otherwise.
     */
    public static boolean isRowMagic(int[][] AR){
	if (AR.length>0){
	    int defrm=rowSum(AR,0);
	    for (int i=1;i<AR.length;i++){
		if (rowSum(AR,i)!=defrm){
		    return false;
		}
	    }
	}
	return true;
    }

    /**Checks if the array is column-magic (this means that every column has the same column sum)
     *Note: Rows can have different lengths
     *
     *@param AR is the array which you're checking for column-magic.
     *@return true if the array is column-magic or has length 0 and false otherwise.
     */
    public static boolean isColumnMagic(int[][] AR){
	if(AR.length>0){
	    //checks for maximum width
	    int width=AR[0].length;
	    for (int i=1;i<AR.length;i++){
		if (AR[i].length>width){
		    width=AR[i].length;
		}
	    }
	    //checks for column magic
	    int defcm=columnSum(AR,0);
	    for (int i=0;i<width;i++){
		if (columnSum(AR,i)!=defcm){
		    return false;
		}
	    }
	}
	return true;	
    }
    
    /**Checks if the word fits in the given row, column, and direction AND does not overlap
     *
     *@param word is any text to be added to the word grid
     *@param row is the row you want the word to start in
     *@param col is the column you want the word to start in
     *@param dx +1 (or just 1) is to the right, -1 is to the left, 0 means no x coordinate
     *@param dy +1 (or just 1) is down, -1 is up, 0 means no y coordinate
     *@return true when the word fits, the direction exists, and there is no overlap
     *when the word is added; false otherwise
     */
    public boolean checkWord(String word, int row, int col, int dx, int dy){
	if ((dx==0 && dy==0)||
	    Math.abs(dx)>1 || Math.abs(dy)>1 ||
	    dx*word.length()+col+1<0 || dx*word.length()+col>data[0].length||
	    dy*word.length()+row+1<0 || dy*word.length()+row>data.length
	    ){
	    return false;
	}
	else{
	    word=word.toUpperCase();
	    for (int i=0;i<word.length();i++){
		String letter=word.substring(i,i+1);		
		if (checkOverlap(letter,row,col) ||
		    col<0 || col>data[0].length||
		    row<0 || row>data.length
		    ){
		    return false;
		}
		else{
		    row+=dy;
		    col+=dx;
		}
	    }
	    return true;
	}
    }

    /**Checks if there is overlap, that is, if the letter at a given spot 
     *is different from the letter wordgrid is about to put in
     *
     *@param letter is what you're going to put in and are checking to see if it's different
     *from what's there
     *@param row is the row the letter is in
     *@param col is the column the letter is in
     *@return true when there is an overlap, false otherwise
     */
    public boolean checkOverlap(String letter, int row, int col){
	String letterAt=String.valueOf(data[row][col]);
	if (letter.equals(letterAt) || letterAt.equals(""+'_')){
	    return false;
	}
	else{
	    return true;
	}     
    }

    /**Adds a word to the WordGrid
     *<br>dx dy Direction
     *<br>0 -1 N
     *<br>-1 -1 NW    
     *<br>-1 0 W
     *<br>-1 1 SW
     *<br>0 1 S
     *<br>1 1 SE
     *<br>1 0 E
     *<br>1 -1 NE
     *@param word is any text to be added to the word grid
     *@param row is the row you want the word to start in
     *@param col is the column you want the word to start in
     *@param dx +1 (or just 1) is to the right, -1 is to the left, 0 means no x coordinate
     *@param dy +1 (or just 1) is down, -1 is up, 0 means no y coordinate
     *@return true when the word fits, the direction exists, and there is no overlap
     *when the word is added; false otherwise
     */
    public boolean addWord(String word,int row, int col, int dx, int dy){
	word=word.toUpperCase();
	if (checkWord(word,row,col,dx,dy)){
	    for (int i=0;i<word.length();i++){
		data[row][col]=Character.toUpperCase(word.charAt(i));
		row+=dy;
		col+=dx;		
	    }
	    
	    return true;
	}
	return false;
    }

    /**Fills any empty spots in array with random letters
     */
    public void fillUp(){
	if (data.length>0){
	    for (int row=0;row<data.length;row++){
		for (int col=0;col<data[row].length;col++){
		    if (data[row][col]=='_'){
			char c=(char)(r.nextInt(26)+'a');
			data[row][col]=Character.toUpperCase(c);
		    }
		}
	    }
	}
    }

    /**Mutator that changes the random seed of your Random object. 
     *
     *@param seed the initial seed
     */
    public void setSeed(long seed){
	r.setSeed(seed);
    }

    /**Adds words randomly from a given list of words
     *Number of words added is based on size of array
     *
     *@param allWords the dictionary/word list the words are from
     */
    public void addManyWordsToList (ArrayList<String> allWords){
	int maxWords=(int)(data.length * data[0].length/4);
	ArrayList<String> temp= new ArrayList<String>();
	for (int i=0;i<maxWords;i++){
	    int index=r.nextInt(dict.size());
	    int row=r.nextInt(data.length);
	    int col=r.nextInt(data[0].length);
	    int dx=r.nextInt(3)-1;
	    int dy=r.nextInt(3)-1;
	    if (!addWord(allWords.get(index),row,col,dx,dy) && !temp.contains(allWords.get(index))){
		temp.add(allWords.get(index));
		addWord(allWords.get(index),row,col,dx,dy);
		wordList.add(allWords.get(index));
	    }
	    else if (index+10<allWords.size()){
		index+=5;
	    }
	}
    }

    /**Tells you the words used in the WordGrid
     *
     *@return a formatted string of text that has several words per line
     */
    public String wordsInPuzzle(){
	String s="";
	for (int i=0;i<wordList.size();i++){
	    if (i%4==0){
		s+="\n";		
	    }
	    s+=wordList.get(i).toUpperCase()+"          ";
	}
	return s;
    }

    /**Loads word from a file and fills in empty spaces in wordGrid if asked to
     *
     *@param fileName tells WordGrid from which file to read all of the words
     *@param fillRandomLetters determines if you need to fill it up or not
     */
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters){
	File text=new File(fileName);	
	try{
	    Scanner scnr = new Scanner (text);
	    int lineNumber=1;
	    ArrayList<String> temp=new ArrayList<String>();
	    while (scnr.hasNextLine()){
		String line=scnr.nextLine();
		temp.add(line);
		lineNumber++;
	    }
	    
	    for (int i=0;i<temp.size();i++){		
		int row=r.nextInt(data.length);
		int col=r.nextInt(data[0].length);
		int dx=r.nextInt(3)-1;
		int dy=r.nextInt(3)-1;
		if (addWord(temp.get(i),row,col,dx,dy)){
		    dict.add(temp.get(i));
		}
	    }
	    
	}catch(Exception e){
	    e.printStackTrace();
	}
	
	if (fillRandomLetters){
	    fillUp();
	}

	addManyWordsToList(dict);
    }

}