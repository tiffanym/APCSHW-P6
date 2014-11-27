public class Warrior implements Comparable<Warrior>{
    private int rage;
    
    //constuctors
    public Warrior(String s){
	super();
    }
    public Warrior(){
	super();
	//setrage((int)(Math.random()*15)+1);
    }
    
    public String getName(){
	return name;
    }

     public int compareTo (Warrior other){
	int me= getHP();
	int thing= other.getHP();
	return (me-thing);
    }

}   
