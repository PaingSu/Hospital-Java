package Hospital;

import java.awt.*; 

import javax.swing.*;

import java.io.*;
import java.util.*;
import javax.swing.border.*;
import java.util.Date;
import Database.DB_Con;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.net.*;

public class PatientLeftPanel extends JPanel {

	private DB_Con con = new DB_Con();

	private JPanel p1 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();

	private ImageIcon icon = new ImageIcon("image/register5.png");
	private JLabel jlb_icon = new JLabel(    icon);

	private JLabel jlb_title = new JLabel("      Patient Registration Form ");
	private JLabel jlb_title2 = new JLabel();
	private JLabel jlb_title3 = new JLabel();
	private Font font = new Font("Baskerville Old Face", Font.PLAIN, 25);
	private Font font2 = new Font("", Font.BOLD, 12);

	private String[] Year = { "1990", "1991", "1992", "1993", "1994", "1995",
			"1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003",
			"2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011",
			"2012", "2013", "2014" };
	private String[] Day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
			"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	private String[] Month = { "January", "February", "March", "Apirl", "May",
			"June", "July", "August", "September", "October", "November",
			"December" };
	private String[] type = { "InPatient", "OutPatient", "Emergency" };
	private String[] Ward = { "Eye Ward", "OG Ward", "ENT Ward", "Neuro Ward",
			"null" };
	private String[] Disease = { "Ebola", "AIDS", "Cancer", "Psycho", "Coma",
			"null" };
	private JComboBox jcb_year = new JComboBox(Year);
	private JComboBox jcb_day = new JComboBox(Day);
	private JComboBox jcb_month = new JComboBox(Month);
	private JComboBox jcb_type = new JComboBox(type);
	private JComboBox jcb_ward = new JComboBox(Ward);
	private JComboBox jcb_disease = new JComboBox(Disease);

	private JTextField jt_name = new JTextField(); // name
	private JTextField jt_nrc = new JTextField(); // nrc
	private JTextField jt_age = new JTextField(); // age
	private JTextArea jt_add = new JTextArea(); // address
	private JTextField jt_phno = new JTextField(); // phone number
	private JTextField jt_doc = new JTextField(); // doctor
	private JTextField jt_dis = new JTextField(); // disease
	private JTextField jt_rno = new JTextField(); // room number
	private JTextField jt_rank = new JTextField();
	private JTextField jt_salary = new JTextField();
	private JTextField jt_date = new JTextField();
	private JTextArea jt_note = new JTextArea(3, 3); // note
	private JButton jbt_save = new JButton("Save", new ImageIcon(
			"image/save.png")); // save button
	private JButton jbt_clear = new JButton("Clear", new ImageIcon(
			"image/clear.png"));
	private JRadioButton jrb_male = new JRadioButton("Male");
	private JRadioButton jrb_female = new JRadioButton("Female");
	private JScrollPane jscroll = new JScrollPane(jt_note);

	public PatientLeftPanel() {
		
		jt_date.setEditable(false);
		jt_date.setText(new Date().toString());
		// jbt_save.setBackground(Color.BLUE);
		// jbt_save.setForeground(Color.WHITE);
		// jbt_clear.setBackground(Color.BLUE);
		// jbt_clear.setForeground(Color.WHITE);
		ButtonGroup group = new ButtonGroup();
		group.add(jrb_female);
		group.add(jrb_male);
		// jrb_female.setBackground(Color.YELLOW);
		// jrb_male.setBackground(Color.YELLOW);

		jlb_title.setFont(font);
		jlb_title2.setFont(font2);
		p5.setLayout(new BorderLayout());
		p5.add(jlb_icon, BorderLayout.WEST);
		p5.add(jlb_title, BorderLayout.CENTER);
		// p5.setBackground(Color.blue);
		// p5.add(jlb_title2);
		// p5.add(jlb_title3);

		JPanel ps = new JPanel();
		ps.setLayout(new FlowLayout(FlowLayout.LEFT));
		ps.add(jrb_male);
		ps.add(jrb_female);
		// ps.setBackground(Color.yellow);
		p1.setLayout(new GridLayout(9, 1));
		p1.add(new JLabel("	Name   "));
		p1.add(new JLabel("Type"));
		// p1.add(new JLabel("Birthday  "));
		p1.add(new JLabel("Age"));
		p1.add(new JLabel("NRC Number    "));
		// p1.add(new JLabel("Disease Type"));
		// p1.add(new JLabel("	Ward"));
		p1.add(new JLabel("Sex"));
		p1.add(new JLabel("	Phone Number     "));
		p1.add(new JLabel("Date&Time"));
		p1.add(new JLabel("	Address"));
		// p1.setBackground(Color.WHITE);
		// p4.setLayout(new GridLayout(1,3));
		// p4.add(jcb_month);
		// p4.add(jcb_day);
		// p4.add(jcb_year);
		// p4.setBackground(Color.WHITE);
		p3.setLayout(new GridLayout(7, 1));
		p3.add(jt_name);
		p3.add(jcb_type);
		// p3.add(p4);
		p3.add(jt_age);
		p3.add(jt_nrc);
		// p3.add(jcb_disease);
		// p3.add(jcb_ward);
		p3.add(ps);
		p3.add(jt_phno);
		p3.add(jt_date);
		// p3.add(new JScrollPane(jt_add));
		// p3.setBackground(Color.WHITE);
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbt_clear);
		p2.add(jbt_save);
		// p2.setBackground(Color.WHITE);

		JPanel address = new JPanel();
		address.setLayout(new BorderLayout());
		address.add(new JScrollPane(jt_add), BorderLayout.CENTER);
		jt_add.setRows(4);

		JPanel totalright = new JPanel();
		totalright.setLayout(new BorderLayout());
		totalright.add(p3, BorderLayout.CENTER);
		totalright.add(address, BorderLayout.SOUTH);

		JPanel p6 = new JPanel();
		p6.setLayout(new BorderLayout());
		p6.add(p1, BorderLayout.WEST);
		p6.add(totalright, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		add(p5, BorderLayout.NORTH);
		// add(p1,BorderLayout.WEST);
		add(p6, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		setBorder(new TitledBorder("New Patients"));
		// setBackground(Color.WHITE);

		jbt_save.setMnemonic('a');
		jbt_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DB_Con con = new DB_Con();

				int id = 0;
				String name = jt_name.getText();
				int t = jcb_type.getSelectedIndex();

				String type1 = type[t];
				int age = Integer.parseInt(jt_age.getText());
				String nrc = jt_nrc.getText();

				int gender = 1;
				if (jrb_male.isSelected()) {
					gender = 1;
				}
				if (jrb_female.isSelected()) {
					gender = 0;
				}
				
				String address=jt_add.getText();
				String sql="insert into patient values('"+id+"','"+name+"','"+nrc+"','"+type1+"','"+age+"','"+gender+"',now(),'"+address+"','"+jt_phno.getText()+"')";
				
				try{
					Connection c=con.getConnection();
					Statement st=c.createStatement();
					int i=st.executeUpdate(sql);
					if(i==1)
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
			}
			
		});
		
	}

}
