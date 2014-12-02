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
	    s+=" "+(data[i]);
	}
	return s+"]";
    }

    //add commands----------//
    public void add(String s){
	resize(data.length+1);
	data[data.length-1]=s;
	for (int i=data.length-2;i>0;i--){
	    if (s.compareTo(data[i])>=0){
		data[i+1]=data[i];
		data[i]=s;
		break;
	    }
	    else{
		data[i+1]=data[i];
	    }
	}	
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
    }

    public Object get(int index){
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
	    //return "ERROR: index not within range of array";
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
    
    public static void main(String[]args){
	OrderedSuperArray data=new OrderedSuperArray(10);
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
    }
}
