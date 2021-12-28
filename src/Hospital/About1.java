package Hospital;
import java.awt.*;  
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import javax.swing.border.*;

public class About1 extends JFrame{
	private JTabbedPane jtb=new JTabbedPane();
	private JLabel icon=new JLabel(new ImageIcon("image/about1.png"));
	private JLabel title=new JLabel("General Hospital Management System");
	private Font font=new Font("Times New Roman",Font.BOLD,30);
	private Font font1=new Font("Brush Script MT Italic",Font.ITALIC,100);
	private JLabel thank=new JLabel("Thank You");
	private JLabel cre=new JLabel("Created by students from 3IS-D (2013-2014)");
//	private JButton jbt_ok=new JButton("OK",new ImageIcon("image/ok.png"));
	public About1(){
		title.setFont(font);
		title.setForeground(new Color(0,46,230));
		thank.setFont(font1);
		cre.setFont(new Font("Times New Roman",Font.BOLD,20));
		JPanel titlePanel=new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.add(title);
		//icon.setBorder(new LineBorder(Color.black,1));
		
		JPanel iconPanel=new JPanel();
		iconPanel.setLayout(new BorderLayout());
		iconPanel.add(icon,BorderLayout.NORTH);
		
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("if you use this application,"));
		p1.add(new JLabel(" you can register and remove patient easily."));
		p1.add(new JLabel("you can add and remove staff easily."));
		p1.add(new JLabel("you can get appointment from online."));
		p1.add(new JLabel("you can search record of your hospital easily. "));
		
		/*JPanel pi=new JPanel();
		pi.setLayout(new BorderLayout());
		pi.add(p1,BorderLayout.CENTER);*/
		
		JPanel p2=new JPanel();
		p2.setLayout(new BorderLayout(10,1));
		p2.add(p1,BorderLayout.CENTER);
		p2.add(iconPanel,BorderLayout.WEST);
		
		/*JPanel pp=new JPanel();
		pp.setLayout(new BorderLayout());
		pp.add(p2,BorderLayout.CENTER);*/
		
		//JPanel okPanel=new JPanel();
		//okPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//okPanel.add(jbt_ok);
		
		JPanel application=new JPanel();
		application.setLayout(new BorderLayout());
		application.add(titlePanel,BorderLayout.NORTH);
		application.add(p2,BorderLayout.CENTER);
		//application.add(okPanel,BorderLayout.SOUTH);
		
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(thank);
		
		JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.add(cre);
		
		JPanel p5=new JPanel();
		p5.setLayout(new GridLayout(5,2));
		p5.add(new JLabel("1.Mg Nyi Nyi Htun Lwin"));
		p5.add(new JLabel(" 6.Mg Yan Naung Nyein"));
		p5.add(new JLabel("2.Mg Htet Aung Ye"));
		p5.add(new JLabel(" 7.Ma Khin Mon Kyaw"));
		p5.add(new JLabel("3.Mg Zay Linn Htike"));
		p5.add(new JLabel(" 8.Ma"));
		p5.add(new JLabel("4.Mg Kyaw Soe Win"));
		p5.add(new JLabel(" 9.Ma "));
		p5.add(new JLabel("5.Mg Thein Htike Zaw"));
		p5.add(new JLabel("10.Ma"));
		
		JPanel create=new JPanel();
		create.setLayout(new BorderLayout());
		create.add(p4,BorderLayout.NORTH);
		create.add(p5,BorderLayout.CENTER);
		create.add(p3,BorderLayout.SOUTH);
		
		jtb.addTab("application",application);
		jtb.addTab("creater",create);
		add(jtb);
		setTitle("About");
		setLocationRelativeTo(null);
		setSize(600,350);
		setResizable(false);
		setIconImage(new ImageIcon("image/about.png").getImage());
		
		create.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				setVisible(false);
			}
		});
		
		application.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				setVisible(false);
			}
		});
	}

}
