package Hospital;

import java.awt.*; 

import javax.swing.*;

import java.io.*;
import java.util.*;
import javax.swing.border.*;

import Database.DB_Con;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class AppointmentRightPanel extends JPanel {

	private ImageIcon search = new ImageIcon("image/search.png");
	private JButton jbt_search = new JButton("Search", search); // search button
	private JButton jbt_clear = new JButton("Clear");
	private JButton jbt_print = new JButton("Print");
	private ImageIcon app=new ImageIcon("image/appointment1.png");
	private JLabel jlb_app=new JLabel(app);

	private JLabel name = new JLabel();
	private JLabel nrc = new JLabel();
	private JLabel token = new JLabel();
	private JLabel phno = new JLabel();
	private DB_Con con = new DB_Con();
	private JButton jbt_remove = new JButton("Remove", new ImageIcon(
			"image/remove.png"));

	private JList list ;
	private DefaultListModel plist;
	
	private JScrollPane js ;

	private String[] doctor;
	private JComboBox cb_doctor;

	private String[] time = new String[4];
	private JComboBox cb_time;

	public AppointmentRightPanel() {

		//list
		
		plist = new DefaultListModel();
		
		jbt_search.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent arg0) {
				plist.removeAllElements();
				int id = 0;
				int doci = cb_doctor.getSelectedIndex();
				int timei = cb_time.getSelectedIndex();
				
				String docname = doctor[doci];
				String shetime = time[timei];
				System.out.println("docname " + docname + " : " + shetime);

				String checksql = "select * from premanentappoint where pdoc='"
						+ docname + "' and  ptime in(select timeid "
						+ " from time where name='"+ shetime+"');";
						
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs=st.executeQuery(checksql);
					while(rs.next()){
						System.out.println(rs.getString("pname"));
						plist.addElement(rs.getString("pname"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		
		jbt_remove.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object name1 = list.getSelectedValue();
				int rindex=list.getSelectedIndex();
				String sql = "DELETE  FROM `premanentappoint` WHERE `pname`='" + name1+"'";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
				//	ResultSet rs = st.executeQuery(sql);
					int i=st.executeUpdate(sql);
					
					if(i==1)
					{
						System.out.print("success");
					
						JOptionPane.showMessageDialog(null,"Success!One person is removed.","Message",JOptionPane.INFORMATION_MESSAGE);
						list.removeAll();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
		});		// Remove List
		
		
		list = new JList(plist);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		// doctor
		int counter = 0;
		
		
		try {

			String getDocsql = "select * from staff where stype='Doctor'";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				counter++;

			}
			System.out.println("C" + counter);
		} catch (Exception e) {
			e.printStackTrace();
		}

		doctor = new String[counter];
		System.out.println("-------" + doctor.length);
		int index = 0;

		try {

			String getDocsql = "select * from staff where stype='Doctor'";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				doctor[index++] = rs.getString("sname");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// time
		int index2 = 0;
		try {

			String getDocsql = "select * from time ";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				time[index2++] = rs.getString("name");
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		cb_doctor = new JComboBox(doctor);
		cb_time = new JComboBox(time);

		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Search"));
		js= new JScrollPane(list);
		js.setBorder(new TitledBorder("Patient Lists"));

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 2));
		p1.add(cb_doctor);
		p1.add(cb_time);
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(p1, BorderLayout.CENTER);
		p2.add(jbt_search, BorderLayout.EAST);

		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(2, 1));
		p4.add(new JLabel("Name:"));
		p4.add(new JLabel("NRC Number:"));
	//	p4.add(new JLabel("Token Number:"));
	
	//	p4.add(new JLabel("Phone Number:"));

		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(2, 1));
		p5.add(name);
		p5.add(nrc);
	//	p5.add(token);
	//	p5.add(phno);
		// p5.add(jbt_remove);

		JPanel small=new JPanel();
		small.setLayout(new BorderLayout());
		small.add(p4,BorderLayout.WEST);
		small.add(p5,BorderLayout.CENTER);
		
		JPanel button = new JPanel();
		button.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button.add(jbt_remove);
		
		JPanel total = new JPanel();
		total.setLayout(new GridLayout(2,1));
		total.add(small);
		total.add(jlb_app);
	//	total.add(button, BorderLayout.SOUTH);
		
		JPanel totalall=new JPanel();
		totalall.setLayout(new BorderLayout());
		totalall.add(total,BorderLayout.CENTER);
		totalall.add(button,BorderLayout.SOUTH);
		totalall.setBorder(new TitledBorder("Info"));

		JPanel all = new JPanel();
		all.setLayout(new GridLayout(1, 2));
		all.add(js);
		all.add(totalall);

		add(p2, BorderLayout.NORTH);
		add(all, BorderLayout.CENTER);
		
		list.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Click");
				Object name1 = list.getSelectedValue();
				String sql = "SELECT * FROM `premanentappoint` WHERE `pname`='" + name1+"'";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						
						 name.setText(" - "+rs.getString("pname"));
						 nrc.setText(" - "+rs.getString("pnrc"));
						

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			public void mouseEntered(MouseEvent arg0) {

			}

			public void mouseExited(MouseEvent arg0) {

			}

			public void mousePressed(MouseEvent arg0) {

			}

			public void mouseReleased(MouseEvent arg0) {

			}

		});
		
	}

}
