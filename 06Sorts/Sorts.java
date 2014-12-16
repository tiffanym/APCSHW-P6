public class Sorts{
    int[] data;
    /*
    public static void insertionSort(int[] data){
	if (data.length>1){
	    for (int i=1;i<data.length;i++){
		int element=data[i];
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

    public static void selectionSort(int[] data){
	for (int i=0;i<data.length;i++){
	    int min=findMinIndex(i,data.length-1);
	    int sAtMin=data[min];
	    for (int x=min;x>i;x--){
		data[x]=data[x-1];
	    }
	    data[i]=sAtMin;
	}
    }
    */

    public boolean checkNoSwaps(int[] data,int index){
	boolean swapsLeft=true;
	for (int i=index;i>0;i--){
	    if (data[i+1]<data[i]){
		swapsLeft=false;
		break;
	    }
	}
	return swapsLeft;
    }

    //moves this way <------from end
    public static void bubbleSort(int[] data){
	int end=data.length-1;
	//if false; then stop
	boolean swapsLeft=true;
	for (int i=end;i>-1;i--){
	    if (checkNoSwaps(data,i)){
		for (int x=0;x<end;x++){
		    if (data[x]>data[x+1]){
			int temp=data[x];
			data[x]=data[x+1];
			data[x+1]=temp;
		    }
		}
	    }
	    else{
		break;
	    }
	}
    }

    public static void main(String[]args){
	int[] data = new int[]{5,10,4,12,-5,1,0};
	bubbleSort(data);
	System.out.println(data.toString());
    }

}