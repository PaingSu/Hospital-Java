package Hospital;
import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class About extends JFrame{
	
	private ImageIcon ico=new ImageIcon("image/icon.png");
	private ImageIcon ok_icon=new ImageIcon("image/ok.png");
	private JButton jbt_ok=new JButton("OK",ok_icon);
	private JLabel icon=new JLabel(ico);
	private JLabel title =new JLabel("General Hospital System");
	private JLabel thank=new JLabel("     Developed");
	private JLabel thank1=new JLabel("           By");
	private JLabel thank2=new JLabel(" 3IS-D @ Group-I");
//	private JLabel develop=new JLabel("Created by Students from 3IS-D(2013-2014)");
	private Font font=new Font("Baskerville Old Face",Font.BOLD,15);
	private Font font1=new Font("Baskerville Old Face",Font.BOLD,20);

	public About(){
		title.setFont(font1);
	//	develop.setFont(font);
		thank.setFont(new Font("Baskerville Old Face",Font.BOLD,20));
		thank1.setFont(new Font("Baskerville Old Face",Font.BOLD,20));
		thank2.setFont(new Font("Baskerville Old Face",Font.BOLD,20));
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(title);
		
	//	JPanel p2=new JPanel();
	//	p2.setLayout(new FlowLayout(FlowLayout.LEFT));
	//	p2.add(develop);
		
		JPanel p3=new JPanel();
		p3.setLayout(new GridLayout(5,2));
		p3.add(new JLabel(" 1.	Mg Nyi Nyi Htun Lwin"));
		p3.add(new JLabel(" 6.	Mg Yan Naung Nyein"));
		p3.add(new JLabel(" 2.	Mg Zay Linn Htike"));
		p3.add(new JLabel(" 7.	Ma Khin Mon Kyaw"));
		p3.add(new JLabel(" 3.	Mg Htet Aung Ye"));
		p3.add(new JLabel(" 8.	Ma Eaint Thiri Myo"));
		p3.add(new JLabel(" 4.  Mg Kyaw Soe Win"));
		p3.add(new JLabel(" 9.	Ma Thin Thin Swe"));
		p3.add(new JLabel(" 5.	Mg Thein Htike Zaw"));
		p3.add(new JLabel("10.	Ma Su Wai Htet"));
		
		JPanel p4=new JPanel();
		p4.setLayout(new BorderLayout());
		p4.add(p1,BorderLayout.CENTER);
	//	p4.add(p2,BorderLayout.SOUTH);
		
		JPanel p5=new JPanel();
		p5.setLayout(new BorderLayout());
		p5.add(p3,BorderLayout.CENTER);
		p5.add(p4,BorderLayout.NORTH);
		
		JPanel thankp=new JPanel();
		thankp.setLayout(new GridLayout(3,1));
		thankp.add(thank);
		thankp.add(thank1);
		thankp.add(thank2);
		
		JPanel pi=new JPanel();
	//	icon.setBorder(new LineBorder(Color.black,));
		pi.setLayout(new BorderLayout());
		pi.add(icon,BorderLayout.NORTH);
		pi.add(thankp,BorderLayout.CENTER);
		
		JPanel p6=new JPanel();
		p6.setLayout(new BorderLayout());
		p6.add(p5,BorderLayout.CENTER);
		p6.add(pi,BorderLayout.WEST);
		
		JPanel p7=new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p7.add(jbt_ok);
		
		
		JPanel p8=new JPanel();
		p8.setLayout(new BorderLayout());
	//	p8.add(thank,BorderLayout.CENTER);
		p8.add(p7,BorderLayout.EAST);
		
		JPanel p9=new JPanel();
		p9.setLayout(new BorderLayout());
		p9.add(p8,BorderLayout.SOUTH);
		
		setLayout(new BorderLayout());
		add(p6,BorderLayout.CENTER);
		add(p9,BorderLayout.SOUTH);
		setTitle("About Us");
		setIconImage(new ImageIcon("image/about.png").getImage());
		setSize(500,300);
		setResizable(false);
		setLocationRelativeTo(null);
		jbt_ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		
	}

}
