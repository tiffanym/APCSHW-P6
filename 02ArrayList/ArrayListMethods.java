import java.util.*;

public class ArrayListMethods{
    
    public static void collapseDuplicates( ArrayList<Integer> L ){
	for (int i=0;i<L.size()-1;i++){
	    if (L.get(i)==L.get(i+1)){
		//L.set(i,null);
		//L.set(i+1,null);
		L.remove(i);
		L.remove(i);
		i=i+1;
	    }
	}	
    }
    
    public static void randomize(ArrayList<Integer> L){
	for (int i=L.size();i>0;i--){
	    int x=(int)(Math.random()*i);
	    L.add(L.size(),L.get(x));
	    L.remove(x);
	}
    }
    
    public static void main(String[]args){
	ArrayList<Integer> elements=new ArrayList<>();
	elements.add(2);
	elements.add(3);
	elements.add(22);
	elements.add(4);
	elements.add(3523);
	
	System.out.println(elements);
	//collapseDuplicates(elements);
	//movetoend(elements,2);
	randomize(elements);
	System.out.println(elements);
    }
}