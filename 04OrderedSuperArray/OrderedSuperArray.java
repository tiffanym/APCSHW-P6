import java.util.*;
public class OrderedSuperArray extends SuperArray{
    String[] data;

    public OrderedSuperArray(){
	this(10);
    }

    public OrderedSuperArray(int numElements){
	this.numElements=numElements;
	data=new String[numElements];
    }

    public String toString(){
	String s="[";
	for (int i=0;i<data.length;i++){
	    s+=" "+(data[i])+",";
	}
	s=s.substring(0,s.length()-1);
	return s+"]";
    }

    //add commands----------//
    public void add(String s){
	resize(data.length+1);
	data[data.length-1]=s;
	for (int i=data.length-2;i>-1;i--){
	    if (s.compareTo(data[i])>=0){
		data[i+1]=s;
		break;
	    }
	    else{
		data[i+1]=data[i];
		data[i]=s;
	    }
	}		
    }

    public void add(int index, String s){
	if (index<0 || index>data.length){
	    throw new IndexOutOfBoundsException();
	}
	add(s);
    }
    //--------------------//
    
    public int size(){
	return data.length;
    }
    
    public void resize(int newSize){
	String[] newdata=new String[newSize];
	int max=numElements;
	if (newSize<=numElements){
	    max=newSize;
	}
	for (int i=0;i<max;i++){
	    if (data[i]==null){
		data[i]="";	
	    }
	    newdata[i]=data[i];
	}
	numElements=newSize;
	data=newdata;
    }

    //extra methods
    public void clear(){
	numElements=0;
	data=new String[numElements];
    }

    public String get(int index){
	if (outofrange(index)){
	    throw new ArithmeticException();
	}
	return data[index];
    }
    
    public String set (int index, String element){
	if (index<0 || index>data.length){
	    throw new IndexOutOfBoundsException();
	}
	element=data[index].charAt(0)+element.substring(1);
	String sreplaced=remove(index);
	add(element);	
	return sreplaced;
    }
    
    public String remove(int index){
	if (outofrange(index)){
	    throw new ArithmeticException();
	}
	else{
	    String sreplaced=data[index];
	    for (int i=index;i<size()-1;i++){
		data[i]=data[i+1];
	    }
	    resize(data.length-1);
	    return sreplaced;
	}
    }
    
    //binary search
    public int find (String target){
	int index=0;
	for (int pos=1;pos<data.length;pos=pos*2){
	    if (data[pos-1].equals(target)){
		if (pos>1 && data[pos-2].equals(target)){
		    for (int x=pos-2;x>0;x--){
			if (!data[x-1].equals(target)){
			    index=x-1;
			}
		    }
		}
		index=pos-1;
		break;
	    }
	}
	return index;
    }

    public static void main(String[]args){
	OrderedSuperArray data=new OrderedSuperArray(10);	
	data.clear();
	data.add("if");
	System.out.println(data.toString());
	data.add("you");
	System.out.println(data.toString());
	data.add("happy");
	System.out.println(data.toString());
	data.add("and");
	System.out.println(data.toString());
	data.add("know");
	System.out.println(data.toString());
	data.add("it");
	System.out.println(data.toString());
	data.add("clap");
	System.out.println(data.toString());
	data.add("feet");
	System.out.println(data.toString());
	data.add("dance");
	System.out.println(data.toString());
	data.add("party");
	System.out.println(data.toString());
	data.add("supperarray");
	System.out.println(data.toString());
	System.out.println(data.set(5,"dancing"));
	System.out.println(data.toString());
	System.out.println(data.find("feet"));
	System.out.println(data.find("bird"));
    }
}
