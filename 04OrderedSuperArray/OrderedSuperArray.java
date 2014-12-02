public class OrderedSuperArray extends SuperArray{
    String[] data;

    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int numElements){
	super(numElements);
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
	if (data[data.length-1] ==null){
	    resize(data.length+1);
	    data[data.length-1]=s;
	}
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

    public void add (int index, String o){
	
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
	//for (int i=0;i<data.length;i++){
	//data[i]=null;
	//}
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
	OrderedSuperArray data=new OrderedSuperArray();
	OrderedSuperArray sup=new OrderedSuperArray(6);
	//data.resize(8);
	data.add("happy");
	System.out.println(data.toString());
       
	//data.clear();
	//System.out.println(data.get(3));
	//System.out.println(data.get(15));
	//data.add(5,"woot");
	//System.out.println(data.toString());
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
	//System.out.println(data.toString());
    }
}
