package Hospital;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class TopPanel extends JPanel {
	
	//private ClockAnimation clock=new ClockAnimation();
	
	private ImageIcon icon=new ImageIcon("image/icon.png");
	private JLabel lb_icon=new JLabel(icon);
	
	private ImageIcon icon1=new ImageIcon("image/flag1.gif");
	private JLabel lb_icon1=new JLabel(icon1);
	
	private JLabel lb_title=new JLabel("       General Hospital Management System");
	private Font font=new Font("Baskerville Old Face",Font.BOLD,15);
	private Font font1=new Font("Baskerville Old Face",Font.BOLD,28);
	
	private JLabel jbt1=new JLabel("    MYANMAR");
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
	
	
	private JPanel panel=new JPanel();
	public TopPanel()
	{
		lb_title.setFont(font1);
		lb_title.setForeground(new Color(0,46,230));
		
		jbt1.setFont(font);
		jbt1.setForeground(new Color(255,0,0));
		
		lb_icon.setBorder(new LineBorder(Color.white));
		
	//	lb_icon1.setBorder(new LineBorder(Color.red));
		setLayout(new BorderLayout());
		p1.setBackground(Color.white);
		p1.setBorder(new LineBorder(Color.white));
		p1.setLayout(new BorderLayout());
		p1.add(lb_icon1,BorderLayout.CENTER);
		p1.add(jbt1,BorderLayout.SOUTH);
		
		p2.setLayout(new GridLayout(1,1));
		p2.add(lb_icon);
		p2.setBackground(Color.white);
		p2.setBorder(new LineBorder(Color.white));
		
		add(p2,BorderLayout.WEST);
		add(lb_title,BorderLayout.CENTER);
		add(p1,BorderLayout.EAST);
		//add(clock,BorderLayout.EAST);
	    setBackground(Color.white);
		setBorder(new LineBorder(Color.BLACK,1));
	}

}
