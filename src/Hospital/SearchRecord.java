package Hospital;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import java.io.*;
import java.util.*;
import javax.swing.border.*;

import java.sql.*;

import Database.DB_Con;

public class SearchRecord extends JPanel {
	private JLabel name = new JLabel();
	private JLabel nrc = new JLabel();
	private JLabel sex = new JLabel();
	private JLabel start = new JLabel();
	private JLabel end = new JLabel();
	private JLabel total = new JLabel();
	private JLabel doctor = new JLabel();
	private JLabel nurse = new JLabel();
	private JLabel disease = new JLabel();
	private JLabel ward = new JLabel();
	private JLabel search = new JLabel("Search");

	private String[] byname = { "PatientName", "DoctorName" };
	private ImageIcon h1 = new ImageIcon("image/hospital1.png");
	private ImageIcon h2 = new ImageIcon("image/hospital2.png");
	private ImageIcon h3 = new ImageIcon("image/hospital3.png");
	private ImageIcon ico = new ImageIcon("image/search.png");
	private JTextField jt_name = new JTextField();
	private JButton jbt_go = new JButton("GO", ico);
	private JComboBox jcb_byname = new JComboBox(byname);
	private DB_Con con = new DB_Con();
	private DefaultTableModel pdatap;
	private JTable plist;
	private boolean rgender;
	private JButton jbt_clear=new JButton("Clear");

	public SearchRecord() {
		jt_name.setToolTipText("Enter Name to Search");
		jbt_go.setToolTipText("Search");
		search.setFont(new Font("Brush Script MT", Font.ITALIC, 20));

		JPanel jlb = new JPanel();
		jlb.setLayout(new FlowLayout(FlowLayout.CENTER));
		jlb.add(search);

		JPanel jbt = new JPanel();
		jbt.setLayout(new BorderLayout());
		jbt.add(jcb_byname, BorderLayout.WEST);
		jbt.add(jbt_go, BorderLayout.EAST);

		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout(0, 2));
		p1.add(jlb, BorderLayout.WEST);
		p1.add(jt_name, BorderLayout.CENTER);
		p1.add(jbt, BorderLayout.EAST);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(10, 1, 5, 5));
		p2.add(new JLabel("Name"));
		p2.add(new JLabel("NRC Number"));
		p2.add(new JLabel("Sex"));
		p2.add(new JLabel("Disease"));
		p2.add(new JLabel("Doctor Name"));
		p2.add(new JLabel("Nurse Name"));
		p2.add(new JLabel("Ward"));
		p2.add(new JLabel("Start Date"));
		p2.add(new JLabel("End Date"));
		p2.add(new JLabel("Total Cost"));

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(10, 1, 5, 5));
		p3.add(name);
		p3.add(nrc);
		p3.add(sex);
		p3.add(disease);
		p3.add(doctor);
		p3.add(nurse);
		p3.add(ward);
		;
		p3.add(start);
		p3.add(end);
		p3.add(total);

		JPanel p4 = new JPanel();
		p4.setLayout(new BorderLayout(20, 5));
		p4.add(p2, BorderLayout.WEST);
		p4.add(p3, BorderLayout.CENTER);
		p4.setBorder(new TitledBorder("Information"));

		pdatap = new DefaultTableModel();
		pdatap.addColumn("Name");
		pdatap.addColumn("ID");
		jbt_go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = jcb_byname.getSelectedIndex();
				String key = byname[index];
				String sql = "";

				if (key.equals("PatientName")) {
					sql = "select * from record where pname='"
							+ jt_name.getText() + "'";

					try {
						Connection c = con.getConnection();
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery(sql);
						while (rs.next()) {
							String[] data = { rs.getString("pname"),
									"" + rs.getInt("recordid") };
							System.out.println("Success");
							pdatap.addRow(data);

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (key.equals("DoctorName")) {
					sql = "select * from record where dname='"
							+ jt_name.getText() + "'";

					try {
						Connection c = con.getConnection();
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery(sql);
						while (rs.next()) {
							String[] data = { rs.getString("pname"),
									"" + rs.getInt("recordid") };
							System.out.println("Success");
							pdatap.addRow(data);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		});
		plist = new JTable(pdatap);
		plist.setBorder(new LineBorder(Color.black));


		JPanel p5 = new JPanel();
		p5.setLayout(new BorderLayout());
		p5.add(new JScrollPane(plist), BorderLayout.CENTER);
		p5.add(jbt_clear,BorderLayout.SOUTH);
		p5.setBorder(new TitledBorder("Patient List"));

		JPanel p6 = new JPanel();
		p6.setLayout(new GridLayout(1,2));
		p6.add(p5);
		p6.add(p4);

		JPanel p7 = new JPanel();
		p7.setLayout(new BorderLayout());
		p7.add(p1, BorderLayout.NORTH);
		p7.add(p6, BorderLayout.CENTER);

		JPanel p8 = new JPanel();
		p8.setLayout(new GridLayout(2, 1, 5, 5));
		p8.add(new JLabel(h3));
		p8.add(new JLabel(h1));
		p8.setBorder(new LineBorder(Color.black, 1));

		setLayout(new BorderLayout());
		add(p7, BorderLayout.CENTER);
		add(p8, BorderLayout.EAST);
		
		plist.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
			
				System.out.println("Click");
				int id = Integer.parseInt((String) pdatap.getValueAt(
						plist.getSelectedRow(), 1));
				String sql = "SELECT * FROM `record` WHERE `recordid`='" +id+"'";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						
						name.setText(" - " + rs.getString("pname"));
						nrc.setText(" - " + rs.getString("pnrc"));
						rgender  = rs.getBoolean("pgender");
						 sex.setText(" - "+rs.getString("pgender"));
						 if (rs.getBoolean("pgender")) {
							 sex.setText(" - "+"Male");
							} else
							sex.setText(" - "+"Female");

						disease.setText(" - " + rs.getString("disease"));
					
						doctor.setText(" - " + rs.getString("dname"));
						nurse.setText(" - " + rs.getString("nurse"));
						ward.setText(" - " + rs.getString("ward"));
						start.setText(" - " + rs.getString("sdate"));
						end.setText(" - " + rs.getString("edate"));
					    total.setText(" - "+rs.getString("amount"));

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
		jbt_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				// pdatap.removeRow(plist.getSelectedRow());
				int row = pdatap.getRowCount();
				for (int i = 1; i<=row; i++) {
					pdatap.removeRow(row-i);
				}

				jt_name.setText(null);
				name.setText(null);
				nrc.setText(null);
				sex.setText(null);
				disease.setText(null);
				doctor.setText(null);
				nurse.setText(null);
				ward.setText(null);
				start.setText(null);
				end.setText(null);
				total.setText(null);
			}

		});
		

	}

}
