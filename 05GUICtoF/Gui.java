import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener{
    private Container pane;    
    private JLabel l;
    private JTextField text;
    private Container buttons;
    private Container textyStuff;
    private JRadioButton cf;
    private JRadioButton fc;
    private JButton convert;
    private JCheckBox box;

    public Gui() {
	this.setTitle("The LEGIT Temperature Converter");
	this.setSize(600,200);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(2,1));
	
	l = new JLabel("Enter temperature:",null,JLabel.CENTER);
	text = new JTextField(12);
	cf = new JRadioButton("Celsius to Fahrenheit");   
	fc = new JRadioButton("Fahrenheit to Celsius");
	convert = new JButton("Convert!");
	box = new JCheckBox("Do some cool random mathy stuff!");

	cf.addActionListener(this);
	cf.setActionCommand("cToF");
	fc.addActionListener(this);
	fc.setActionCommand("fToC");
	convert.addActionListener(this);
	convert.setActionCommand("converter");

	textyStuff = new Container();
	textyStuff.setLayout(new FlowLayout());
	textyStuff.add(l);
	textyStuff.add(text);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());
	buttons.add(cf);
	buttons.add(fc);
	buttons.add(convert);
	buttons.add(box);

	pane.add(textyStuff);
	pane.add(buttons);
    }
    
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("converter")){			    
	    String s=text.getText(); 
	    int currTemp = Integer.parseInt(s);
	    if (cf.isSelected()){
		int newTemp = (int)((9*currTemp)/5)+32;
		if (box.isSelected()){
		    s=""+(newTemp + (int)(Math.random()*10));
		}
		else{
		    s=""+newTemp;
		}
	    }	    
	    else if (fc.isSelected()){
		int newTemp = (int)(5*(currTemp-32)/9);
		if (box.isSelected()){
		    s=""+(newTemp + (int)(Math.random()*10));
		}
		else{
		    s=""+newTemp;
		}
	    }
	    text.setText(s);
	}
    }

    public static void main(String[] args) {
        Gui g = new Gui();
        g.setVisible(true);
    }
}