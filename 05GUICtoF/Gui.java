import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener{
    private Container pane;    
    private JLabel l;
    private JTextField text;
    private JButton cf;
    private JButton fc;
    private JCheckBox c;

    public Gui() {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	l = new JLabel("Enter temperature:",null,JLabel.CENTER);
	text = new JTextField(12);
	cf = new JButton("Celsius to Fahrenheit");   
	fc = new JButton("Fahrenheit to Celsius");
	c = new JCheckBox("With dem awesome messages");
	pane.add(l);
	pane.add(text);
	pane.add(cf);
	pane.add(fc);
	pane.add(c);

	cf.addActionListener(this);
	cf.setActionCommand("cToF");
	fc.addActionListener(this);
	fc.setActionCommand("fToC");
    }
    
    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	if (s.equals("cToF")){
	    String t=text.getText();
	    //from here convert c to f
	}
	if (s.equals("fToC")){
	    String t=text.getText();
	    //from here convert c to f
	}
    }

    public static void main(String[] args) {
        Gui g = new Gui();
        g.setVisible(true);
    }
}