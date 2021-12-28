package Hospital;
import java.awt.*;    
import javax.swing.*;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import Database.DB_Con;



public class AddStaff extends JPanel{
	
	private DB_Con con=new DB_Con();
	private JPanel p1=new JPanel();
	private JPanel p3=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p4=new JPanel();
	
	private String []Year={"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014"};
	private String []Day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String []Month={"January","February","March","Apirl","May","June","July","August","September","October","November","December"};
	private String []Staff={"Doctor","Nurse","Technician","GeneralStaff"};
	private String []Ward={"OPD","Eye Ward","Bone Ward","OG Ward","ENT Ward","Neuro Ward","Reception","Main Room","Car Parking"};
	private JComboBox jcb_year=new JComboBox(Year);
	private JComboBox jcb_day=new JComboBox(Day);
	private JComboBox jcb_month=new JComboBox(Month);
	private JComboBox jcb_staff=new JComboBox(Staff);
	private JComboBox jcb_ward=new JComboBox(Ward);
	
	private JTextField jt_name=new JTextField();
	private JTextField jt_nrc=new JTextField();  
	private JTextField jt_age=new JTextField();  
	private JTextField jt_add=new JTextField();  
	private JTextField jt_phno=new JTextField(); 
	private JTextField jt_doc=new JTextField();  
	private JTextField jt_cer=new JTextField();  
	private JTextField jt_rno=new JTextField();  
	private JTextField jt_rank=new JTextField();
	private JTextField jt_salary=new JTextField();
	private JTextArea jt_note=new JTextArea(3,3);    //note
	private JButton jbt_add=new JButton("Add",new ImageIcon("image/add1.png"));  
	private JButton jbt_clear=new JButton("Clear",new ImageIcon("image/clear.png"));   
	private JRadioButton jrb_male=new JRadioButton("Male");
	private JRadioButton jrb_female=new JRadioButton("Female");
	private JScrollPane jscroll=new JScrollPane(jt_note);
	
	public AddStaff(){
		
		ButtonGroup group=new ButtonGroup();
		
		group.add(jrb_female);
		group.add(jrb_male);
		JPanel ps=new JPanel();
		ps.setLayout(new FlowLayout(FlowLayout.LEFT));
		ps.add(jrb_male);
		ps.add(jrb_female);
		p1.setLayout(new GridLayout(11,1));
		p1.add(new JLabel("	Name   "));
		p1.add(new JLabel("Staff Type "));
		p1.add(new JLabel("Certificate"));
		p1.add(new JLabel("Birthday  "));
		p1.add(new JLabel("NRC Number    "));
		p1.add(new JLabel("	Ward"));
		p1.add(new JLabel("Sex"));
		p1.add(new JLabel("	Phone Number     "));
		p1.add(new JLabel("Rank"));
		p1.add(new JLabel("Salary"));
		p1.add(new JLabel("	Address"));
		p4.setLayout(new GridLayout(1,3));
		p4.add(jcb_month);
		p4.add(jcb_day);
		p4.add(jcb_year);
		p3.setLayout(new GridLayout(11,1));
		p3.add(jt_name);
		p3.add(jcb_staff);
		p3.add(jt_cer);
		p3.add(p4);
		p3.add(jt_nrc);
		p3.add(jcb_ward);
		p3.add(ps);
		p3.add(jt_phno);
		p3.add(jt_rank);
		p3.add(jt_salary);
		p3.add(jt_add);
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbt_clear);
		p2.add(jbt_add);
		setLayout(new BorderLayout());
		add(p1,BorderLayout.WEST);
		add(p3,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		setBorder(new TitledBorder("New Staffs"));
		
		jbt_add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int id=0;
				String name=jt_name.getText();
				int t=jcb_staff.getSelectedIndex();
				String stafftype=Staff[t];
				String certi=jt_cer.getText();
				
				int m=jcb_month.getSelectedIndex();
				String month=Month[m];
				int y=jcb_year.getSelectedIndex();
				String year=Year[y];
				int d=jcb_day.getSelectedIndex();
				String day=Day[d];
				
				long nrc=Integer.parseInt(jt_nrc.getText());
				int w=jcb_ward.getSelectedIndex();
				String ward=Ward[w];
				int gender = 1;
				if (jrb_male.isSelected()) {
					gender = 1;
				}
				if (jrb_female.isSelected()) {
					gender = 0;
				}
				//int phno=Integer.parseInt(jt_phno.getText());
				String rank=jt_rank.getText();
				int salary=Integer.parseInt(jt_salary.getText());
				String address=jt_add.getText();
				
				String sql="insert into staff values('"+id+"','"+name+"','"+stafftype+"','"+certi+"'," +
						    "'"+nrc+"','"+ward+"','"+gender+"','"+jt_phno.getText()+"','"+rank+"','"+salary+"','"+address+"')";
				String sql1="insert into birthday values('"+id+"','"+day+"','"+month+"','"+year+"')";
				try{
					Connection c=con.getConnection();
					Statement st=c.createStatement();
					int i=st.executeUpdate(sql);
					int j=st.executeUpdate(sql1);
					if(i==1 && j==1)
					{
						System.out.println("Success");
						JOptionPane.showMessageDialog(null,"Success! Your data have been saved.","Message",JOptionPane.INFORMATION_MESSAGE);
						
					}
					else
					{
						System.out.println("Fail");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		});
		jbt_clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jt_name.setText(null);
				jt_age.setText(null);
				jt_nrc.setText(null);
				jt_phno.setText(null);
				jt_add.setText(null);
				jt_cer.setText(null);
				jt_rank.setText(null);
				jt_salary.setText(null);
			}
			
		});
		
		
	}
	

}
