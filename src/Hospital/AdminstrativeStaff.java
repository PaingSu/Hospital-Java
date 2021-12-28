package Hospital;
import java.awt.*; 

import javax.swing.*;
import javax.swing.border.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.awt.event.*;

public class AdminstrativeStaff extends JPanel{


	private DefaultListModel userlist;
	private JList list=new JList();
	

	private JPanel listpanel=new JPanel();
	
	private JLabel name=new JLabel();
	private JLabel gender=new JLabel();
	private JLabel rank=new JLabel();
	private JLabel salary=new JLabel();
	private JLabel phno=new JLabel();
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	private JPanel buttonpanel=new JPanel();
	private JLabel jl_name=new JLabel();
	private JLabel jl_type=new JLabel();
	private JLabel jl_bdate=new JLabel();
	private JLabel jl_nrc=new JLabel();
	private JLabel jl_ward=new JLabel();
	private JLabel jl_phno=new JLabel();
	private JLabel jl_rank=new JLabel();
	private JLabel jl_salary=new JLabel();
	
	private JButton jbt_remove=new JButton("Remove",new ImageIcon("image/remove.png"));
	
	public AdminstrativeStaff()
	{
		setLayout(new GridLayout(1,2));
		JTabbedPane jtp=new JTabbedPane();
		listpanel.setLayout(new BorderLayout());
		listpanel.add(new JScrollPane(list));
		setBorder(new TitledBorder("Adminstrators List and Informations"));
		//jtp.add("List",listpanel);
		
		buttonpanel.setLayout(new BorderLayout());
		buttonpanel.add(jbt_remove,BorderLayout.SOUTH);
		
		p1.setLayout(new GridLayout(9,1));
		p1.add(new JLabel("	Name   "));
		p1.add(new JLabel("Certificate "));
		p1.add(new JLabel("Birthday  "));
		p1.add(new JLabel("NRC Number    "));
		p1.add(new JLabel("	Ward"));
		p1.add(new JLabel("	Phone Number     "));
		p1.add(new JLabel("Rank"));
		p1.add(new JLabel("Salary"));
		p2.setLayout(new GridLayout(9,1));
		p2.add(jl_name);
		p2.add(jl_type);
		p2.add(jl_bdate);
		p2.add(jl_nrc);
		p2.add(jl_ward);
		p2.add(jl_phno);
		p2.add(jl_rank);
		p2.add(jl_salary);
		p2.add(buttonpanel);
		p3.setLayout(new GridLayout(1,2));
		p3.add(p1);
		p3.add(p2);
		add(listpanel);
		add(p3);
		
	}
	
	

}
