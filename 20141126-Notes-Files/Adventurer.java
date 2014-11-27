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
}
