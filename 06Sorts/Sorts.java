import java.util.*;

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
	//ArrayList() creates array list with initial capacity of 10
	//ArrayList<Integer> tempOld=new ArrayList<Integer>(10);
	int[][] tempOld=new int[10][];
	int place=1;
	for (int i : data){  //means "for each element i in data"
	    int digit= i%(int)Math.pow(10,place);
	    //arraylist add function: add (index, element)
	    //tempOld.add(digit,data[i]);
	    
	    //hm... how to add to temporary array thing
	    tempOld[digit][tempOld[digit].length]=data[i];
	    //not sure why above doesn't work....
	    place+=1;
	}
    }

    public static void main(String[]args){
	System.out.println(name());
	System.out.println(period());
	System.out.println();
	int[] data = new int[]{5,10,4,12,1,0};
	System.out.println(Arrays.toString(data));
	//bubbleSort(data);
	//selectionSort(data);
	//insertionSort(data);
	radix(data);
	System.out.println(Arrays.toString(data));
    }

}