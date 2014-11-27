abstract class Adventurer{
    private String name;
    private int HP;
    private int STR;
    private int DEX;
    private int INT;

    //constructors
    public Adventurer(String name,int HP, int STR, int DEX, int INT){
    	setName(name);
	setHP(HP);
	setSTR(STR);	  
	setDEX(DEX);
	setINT(INT);
    }
    //int num = (int) (Math.random()*range)+min
    //where "range=(max-min)+1"
    public Adventurer (String name){
	this(name, (int)(Math.random()*81)+20, 
	     (int)(Math.random()*31)+10,
	     (int)(Math.random()*31)+10,
	     (int)(Math.random()*31)+10);
    }
    public Adventurer(){   
	this("Bob", (int)(Math.random()*81)+20, 
	     (int)(Math.random()*31)+10,
	     (int)(Math.random()*31)+10,
	     (int)(Math.random()*31)+10);
    }

    //setters and getters for variables    
    public String getName(){
	return name;
    }
    public void setName(String name){
	this.name=name;
    }

    public int getHP(){
	return HP;
    }
    public void setHP(int HP){
	this.HP=HP;
    }

    public int getSTR(){
	return STR;
    }
    public void setSTR(int STR){
	this.STR=STR;
    }

    public int getDEX(){
	return DEX;
    }
    public void setDEX(int DEX){
	this.DEX=DEX;
    }

    public int getINT(){
	return INT;
    }
    public void setINT(int INT){
	this.INT=INT;
    }

    //toString method
    public String getStats(){
	return getName()+" ("+getClass().getSimpleName()+")"+"\n"+getHP()+"HP  "+getSTR()+"STR  "+getDEX()+"DEX  "+getINT()+"INT ";
    }

    //hit method-- will you hit the person or not
    //QUESTION: Why is actualhitrate<= hitchance the only way it works?
    public boolean hit(Adventurer other, double hitchance){
	double actualhitrate=this.getDEX()/other.getDEX();
	if (actualhitrate<=hitchance && Math.abs(actualhitrate)<=1){
	    return true;
	}
	else{
	    return false;
	}
    }

    public int getMaxStatDiff(){
	int STRINT= Math.abs(getSTR()-getINT());
	int DEXINT= Math.abs(getDEX()-getINT());
	int STRDEX= Math.abs(getSTR()-getDEX());
	int maxspan=STRINT;
	if (DEXINT>=maxspan){
	    maxspan=DEXINT;
	}
	else if(STRDEX>=maxspan){
	    maxspan=STRDEX;
	}
	return maxspan;
    }

    //hit method
    public boolean hit (Adventurer other){
	int x= (int)(Math.random()*4)+1;
	int hitchance= this.getDEX()/other.getDEX();
	if (x<hitchance){
	    return true;
	}
	else{
	    return false;
	}
    }
    
    //attack method
    public abstract String attack();
    /*{
	String msg=getName()+" the "+getClass().getSimpleName()+" attacks "+other.getName()+" the "+other.getClass().getSimpleName()+"\n";
	if (hit(other) && getHP()>0){
	    int x=(int)(this.getDEX()/other.getDEX());
	//int x=(int)((1.00-(double)(this.getMaxStatDiff()/other.getMaxStatDiff()))*getHP());
	    x=Math.abs(x);
	    if (other.getHP()-x>0 && x>0){	       
		other.setHP(other.getHP()-x);
		msg=msg+"=>Yay! "+getName()+" successfully hit "+
		    other.getName()+" and did "+ x+ " damage";
	    }
	    else if (other.getHP()-x<=0 && x>0){
		other.setHP(0);
		msg=msg+"=>Dayum! "+getName()+" did " +x+
		    " damage and KOed "+other.getName();
	    }
	}
	else if (getHP()<=0){
	    msg+="=>Not enough HP. Sorry,"+getName()+" can't attack when you're dead";
	}	
	else{
	    msg= msg+"=>...and misses :(";
	}
	return msg;
    }
    */
    
    public String specialAttack(Adventurer other){
	double hitchance= (double)(Math.random()*2)+0;
	String msg=getName()+" special attacks "+other.getName()+"\n";
	if (hit (other,hitchance) && getHP()>11){
	    int x=(int)((1.00-(double)(this.getMaxStatDiff()/other.getMaxStatDiff()))*getHP());
	    x=Math.abs(x)+3;
	    setHP(getHP()-10);
	    other.setHP(other.getHP()-x);
	    return msg+="=>"+getName()+" uses <some special attack an Adventurer would have> and strikes "+
		other.getName()+" and does "+x+" damage";
	}
	else if(getHP()<=11){
	    return msg+="=>Not enough HP to use special attack. Try again, "+getName()+".";
	}
	else if(getHP()==0){
	    return msg+="=>Sorry,"+getName()+", can't attack when you're dead";
	}
	//else{
	//   return msg+="Cruel Gods of Java, WHY ISN'T THIS WORKING?!?!?!?!";
	//}
	return msg+="=>Not high enought hit chance \n"+"==>"+getName()+" will attack normally instead: \n"+attack(other);
    }

}
