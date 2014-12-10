import java.util.*;
public class SuperArray{
    String[] data;
    int numElements;

    public SuperArray(){
	this(10);
    }

    public SuperArray(int numElements){
	this.numElements=numElements;
	data=new String[numElements];
    }

    public String toString(){
	String s="[";
	for (int i=0;i<data.length;i++){
	    s+=" "+(data[i]);
	}
	return s+"]";
    }

    //checks if index is out of range
    public boolean outofrange(int index){
	return (index<0 || index >=size());
    }

    //add commands----------//-
    public void add(String o){
	resize(data.length+1);
	data[size()-1]=o;
    }

    public void add(int index,String o){
	if (index>=size()){
	    resize(data.length+1);
	    data[data.length-1]=o;
	}
	else if(index>=0 && index<size()){
	    resize(data.length+1);
	    for (int i=size()-1;i>index;i--){
		data[i]=data[i-1];
	    }
	    set(index,o);
	}
    }
    //--------------------//
    
    public int size(){
	return data.length;
    }
    
    public void resize(int newSize){
	String[] newdata=new String[newSize];
	int smaller=size();
	if (newSize<=size()){
	    smaller=newSize;
	}
	for (int i=0;i<smaller;i++){
	    newdata[i]=data[i];
	}
	data=newdata;
    }

    //extra methods
    public void clear(){
	numElements=0;
	data=new String[numElements];
    }

    public String get(int index){
	if (outofrange(index)){
	    //return "ERROR: index not within range of array";
	    throw new ArithmeticException();
	}
	return data[index];
    }
    
    public String set (int index, String e){
	if (outofrange(index)){
	    //return "ERROR: index not within range of array";
	    throw new ArithmeticException();
	}
	else{
	    String objreplaced=data[index];
	    data[index]=e;
	    return objreplaced;
	}
    }
    
    public String remove(int index){
	if (outofrange(index)){
	    throw new ArithmeticException();
	}
	else{
	    String objreplaced=data[index];
	    for (int i=index;i<size()-1;i++){
		data[i]=data[i+1];
	    }
	    resize(data.length-1);
	    return objreplaced;
	}
    }

    public void insertionSort(){
	if (data.length>1){
	    for (int i=1;i<data.length;i++){
		String element=data[i];
		if (element.compareTo(data[i-1])<0){
		    int x;
		    if (i>1){
			x=i-2;
			while(data[x].compareTo(element)>0 && x>0){
			    data[x+1]=data[x];
			    x--;
			}
			if (x>0){
			    x+=1;
			}
			for (int a=i;a>x;a--){
			    data[a]=data[a-1];
			}
			data[x]=element;

		    }
		    else{
			data[i]=data[i-1];
			data[i-1]=element;			
		    }		    
		}
	    }
	}
    }

    public int find(String target){
	int index=0;
	if(data.length>0){
	    for (int i=0;i<data.length;i++){
		if (target.equals(data[i])){
		    index=i;
		    break;
		}
	    }
	}
	return index;
    }
    
    //for testing purposes only
    public void badInsertionSort(){	
        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }

    //from 12/5/2014 class
    //from index start, inclusive, to end, exclusive
    public int findMinIndex(int start, int end){
	int minIndex=start;
	for (int i=start;i<end+1;i++){
	    if (data[i].compareTo(data[minIndex])<0){
		minIndex=i;
	    }
	}
	return minIndex;
    }

    public void selectionSort(){
	for (int i=0;i<data.length;i++){
	    int min=findMinIndex(i,data.length-1);
	    String sAtMin=data[min];
	    for (int x=min;x>i;x--){
		data[x]=data[x-1];
	    }
	    data[i]=sAtMin;
	}
    }

    public static void main(String[]args){
	SuperArray data=new SuperArray();
	data.clear();
	//call this test1
	data.add("ice");
	data.add("happy");
	data.add("baby");
	data.add("sad");
	data.add("lalala");
	data.add("shimmy");
	System.out.println(data.toString());
	//data.insertionSort();
	
	/*compile:
	  real 0m0.646 s
	  user 0m0.944 s
	  sys 0m0.040 s
	  
	  run:
	  real 0m0.066 s
	  user 0m0.036 s
	  sys 0m0.024 s
	 */

	//the badInsertion is a few seconds or so slower than my own code
	//data.badInsertionSort();
	/*compile:
	  real 0m0.665 s
	  user 0m0.920 s
	  sys 0m0.056 s
	  
	  run:
	  real 0m0.068 s
	  user 0m0.048 s
	  sys 0m0.012 s
	 */

	//TESTING SELECTION SORT-- call it test2
	//for (int i=0;i<5;i++){
	//    data.add((int)Math.random()*6,""+i);
	//}

	//System.out.println(data.toString());
	//data.selectionSort();
	/*test2

	  compile:
	  real 0m0.874 s
	  user 0m1.602 s
	  sys 0m0.040 s
	  
	  run:
	  real 0m0.085 s
	  user 0m0.075 s
	  sys 0m0.012 s
	 */

	//data.insertionSort();
	/*test2

	  compile:
	  real 0m0.962 s
	  user 0m1.684 s
	  sys 0m0.044 s
	  
	  run:
	  real 0m0.095 s
	  user 0m0.084 s
	  sys 0m0.012 s
	 */

	//longer to compile, but quicker to run... interesting...
	Arrays.sort(data);
	/*test2

	  compile:
	  real 0m0.932 s
	  user 0m1.621 s
	  sys 0m0.048 s
	  
	  run:
	  real 0m0.069 s
	  user 0m0.062 s
	  sys 0m0.008 s
	 */

	System.out.println(data.toString());
	//System.out.println(data.find("lalala"));







	//to compare built in sort() method time with my code's time
	//RESULT: longer to compile, but quicker to run
	//Still prefer my method; can't really tell the diff anyway :P
	//String[] data={"if","you","happy","and","know","it","clap","feet","dance","party","supperarray"};
	  //Arrays.sort(data);
	








  

	/*
	//APCS class test	
	//Integer x = new Integer(5);
	//SuperArray L = new SuperArray();
	//L.add(x);
	//L.add(new Integer(99));
	//System.out.println(L.toString());
	//System.out.println();	
	
	//my tests	
	SuperArray data=new SuperArray();
	SuperArray sup=new SuperArray(6);
	data.resize(8);
	data.add("happy");
	System.out.println(data.toString());
       
	//data.clear();
	//System.out.println(data.get(3));
	//System.out.println(data.get(15));
	data.add(5,"woot");
	System.out.println(data.toString());
	//data.set(5,"wayusdfsdfdso");
	
	try{
	    System.out.println(data.set(17,"wayusdfsdfdso"));
	}
	catch(ArithmeticException e){
	    System.out.println("Please tell me you can count.");
	}
	
	try{
	    System.out.println(data.remove(17));
	}
	catch(ArithmeticException e){
	    System.out.println("Math isn't for you!");
	}
	//System.out.println(data.remove(5));
	System.out.println(data.toString());
	*/
    }
}
