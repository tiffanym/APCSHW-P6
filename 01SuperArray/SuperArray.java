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
	    	s+=" "+(String)(data[i]);
		}
		return s+"]";
    }

    public void add(Object e){
		resize(data.length+1);
		data[data.length-1]=e;
    }
    
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

    public static void main(String[]args){
		SuperArray data=new SuperArray();
		//SuperArray nextd=new SuperArray(5);
		data.resize(8);
		//nextd.resize(6);
		data.add("happy");
		//nextd.add("happy");

		Integer x = new Integer(5);
		SuperArray L = new SuperArray();
		L.add(x);
		L.add(new Integer(99));
		System.out.println(data.toString());
		//System.out.println(nextd.toString());
    }
}
