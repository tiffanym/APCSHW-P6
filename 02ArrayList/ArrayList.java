import java.util.ArrayList;
public class ArrayList{
    public void collapseDuplicates(ArrayList<Integer> L){
	for (int i=0;i<L.length-1;i++){
	    if (L[i]==L[i+1]){
		L[i]=null;
		L[i+1]=null;
		i=i+1;
	    }
	}
    }
    
    //  0,1,2,3,4
    //  5,6,1,5,5
    
    public static void main(String[]args){
	ArrayList<Integer> elements=new ArrayLIst<>();
	elements.add(2);
	elements.add(3);
	elements.add(4);
	elements.add(4);
	elements.add(3523);
	
	collaseDuplicates(elements);
    }
}