import java.util.*;
import java.io.*;

public class Sorts{

    public static String name(){
	return "Ming, Tiffany";
    }

    public static int period(){
	return 6;
    }

    public static void insertionSort(int[] data){
	if (data.length>1){
	    for (int i=1;i<data.length;i++){
		int element=data[i];
		if (element-data[i-1]<0){
		    int x;
		    if (i>1){
			x=i-2;
			data[i]=data[i-1];
			while(x>-1 && data[x]-element>0){
			    data[x+1]=data[x];
			    x--;
			}
			
			if (x>=0){
			    data[x+1]=element;
			}
			else if (x<0){
			    data[0]=element;
			}
			
		    }
		    else{
			data[i]=data[i-1];
			data[i-1]=element;			
		    }		    
		}
	    }
	}
    }
    
    public static void selectionSort(int[] data){
	for (int i=0;i<data.length;i++){
	    int minIndex=i;
	    for (int a=i;a<data.length;a++){
		if (data[a]-data[minIndex]<0){
		    minIndex=a;
		}
	    }	   
	    int sAtMin=data[minIndex];
	    for (int x=minIndex;x>i;x--){
		data[x]=data[x-1];
	    }
	    data[i]=sAtMin;
	}
    }

    public static void bubbleSort(int[] data){	
	for (int end=data.length-1;end>0;end--){
	    boolean swapsLeft=false;
	    for (int x=end-1;x>0;x--){
		if (data[x+1]<data[x]){
		    swapsLeft=true;
		    break;
		}
	    }
	    if (swapsLeft){
		for (int i=0;i<end;i++){
		    if (data[i]>data[i+1]){
			int temp=data[i];
			data[i]=data[i+1];
			data[i+1]=temp;
		    }
		}
	    }
	    else{
		break;
	    }
	}
    }

    public static void radix(int[] data){
	int mod=10;
	int n=1;

	//orders array
	for (int rounds=maxDigits(data);rounds>0;rounds--){
	    boolean inOrder=inOrder(data);
	    ArrayList<ArrayList<Integer>> tempAL= new ArrayList<ArrayList<Integer>>();
	    for (int i=0;i<10;i++){
		tempAL.add(new ArrayList<Integer>());
	    }
	    //checks that array is not in order
	    if (!inOrder){
		for (int i=0;i<data.length;i++){
		    int digit=(data[i]%mod)/n;
		    int size=tempAL.get(digit).size(); //gets size of the arraylist at index digit of superarraylist temp
		    tempAL.get(digit).add(size,data[i]); //NOTE:[Arraylist name].add(index,element)
		}
		//reads everything into new temporary array
		int[] tempAR=new int[data.length];
		int psn=0;
		for (int i=0;i<tempAL.size();i++){
		    if (tempAL.get(i).size()>0){
			for (int x=0;x<tempAL.get(i).size();x++){
			    tempAR[psn]=tempAL.get(i).get(x);
			    psn+=1;
			}
		    }
		}
		data=tempAR;
		mod=mod*10;
		n=n*10;
	    }
	    else{
		break;
	    }
	}
    }

    public static boolean inOrder(int[] data){
	boolean inOrder=true;
	for (int i=0;i<data.length-1;i++){
	    if (data[i]>data[i+1]){
		inOrder=false;
		break;
	    }
	}
	return inOrder;
    }

    public static int maxDigits(int[] data){
	int dmax=0;
	for (int i=0;i<data.length;i++){
	    String s=""+data[i];
	    int intlen=s.length();
	    if (intlen>dmax){
		dmax=intlen;
	    }
	}
	return dmax;
    }

    public static void main(String[]args){
	System.out.println(name());
	System.out.println(period());
	System.out.println();
	int[] data = new int[]{5,10,4,12,1,0};
	System.out.println("Original data set:\n"+Arrays.toString(data));
	//bubbleSort(data);
	//selectionSort(data);
	//insertionSort(data);
	radix(data);
	System.out.println("Ordered data set:\n"+Arrays.toString(data));
    }

}