public class SuperArray{
    private Object[] data;
    private int numElements;

    public SuperArray(){
	numElements=10;
	data=new SuperArray[numElements];
    }

    public SuperArray(int numElements){
	this.numElements=numElements;
	data=new SuperArray[numElements];
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
    public void add(Object o){
	resize(data.length+1);
	data[size()-1]=o;
    }

    public void add(int index,Object o){
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
	Object[] newdata=new Object[newSize];
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
	for (int i=0;i<data.length;i++){
	    data[i]=null;
	}
    }

    public Object get(int index){
	if (outofrange(index)){
	    //return "ERROR: index not within range of array";
	    throw new ArithmeticException();
	}
	return data[index];
    }
    
    public Object set (int index, Object e){
	if (outofrange(index)){
	    //return "ERROR: index not within range of array";
	    throw new ArithmeticException();
	}
	else{
	    Object objreplaced=data[index];
	    data[index]=e;
	    return objreplaced;
	}
    }
    
    public Object remove(int index){
	if (outofrange(index)){
	    //return "ERROR: index not within range of array";
	    throw new ArithmeticException();
	}
	else{
	    Object objreplaced=data[index];
	    for (int i=index;i<size()-1;i++){
		data[i]=data[i+1];
	    }
	    resize(data.length-1);
	    return objreplaced;
	}
    }
    
    public static void main(String[]args){
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
	//data.resize(8);
	//data.add("happy");
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
    }
}
