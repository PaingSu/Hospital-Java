package Hospital;

import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;

import java.io.*;
import java.util.*;
import java.util.Date;

import javax.swing.border.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.net.*;

import Database.DB_Con;

public class AppointmentLeftPanel extends JPanel {
	private JTextField jt_name = new JTextField();
	private JTextField jt_nrc = new JTextField();
	private String[] doct_name;
	private String[] doct_sche = new String[4];
	
	private DB_Con con = new DB_Con();
	private DefaultListModel patinerL;
	private JList list = new JList();
	private int pa_counter = 0;
	private int pa_index = 0;
	private JLabel name = new JLabel();
	private JLabel nrc = new JLabel();
	private JLabel sche = new JLabel();
	private JLabel doctor = new JLabel();
	private JTextArea jta = new JTextArea();
	private JComboBox jcb_doct;
	private JComboBox jcb_sche;
	private int rtime;

	private JRadioButton jr_check = new JRadioButton("Check");

	private JButton save = new JButton("Save Appointment", new ImageIcon(
			"image/save.png"));
	private JButton clear = new JButton("Clear", new ImageIcon(
			"image/clear.png"));

	private JButton accept = new JButton("Accept", new ImageIcon(
			"image/appointment.png"));
	private JButton decline = new JButton(" Decline", new ImageIcon(
			"image/remove.png"));
	private JButton refresh = new JButton("",
			new ImageIcon("image/refresh.png"));

	private int tempid;
	private String temppname;
	private int temppnrc;
	private int tempptime;
	private String temppdoc;

	public AppointmentLeftPanel() {
		// Timer time = new Timer(1000, new TimerListener());

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

		doct_name = new String[counter];
		System.out.println("-------" + doct_name.length);
		int index = 0;

		try {

			String getDocsql = "select * from staff where stype='Doctor'";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				doct_name[index++] = rs.getString("sname");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// time/
		int index2 = 0;
		try {

			String getDocsql = "select * from time ";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				doct_sche[index2++] = rs.getString("name");
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patinerL = new DefaultListModel();

		list = new JList(patinerL);
	//	createDatabase();
		// time.start();
		jcb_doct = new JComboBox(doct_name);
		jcb_sche = new JComboBox(doct_sche);

		jcb_doct.setBackground(Color.WHITE);
		jcb_doct.setForeground(Color.GRAY);

		setLayout(new GridLayout(2, 1));
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 1));
		p1.add(new JLabel("Name          "));
		// p1.add(jt_name);
		p1.add(new JLabel("NRC Number            "));
		// p1.add(jt_nrc);
		p1.add(new JLabel("Schedule                  "));
		// p1.add(jcb_sche);
		p1.add(new JLabel("Doctor                "));
		// p1.add(jcb_doct);
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p2.add(clear);
		p2.add(save);

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(4, 1));
		p3.add(jt_name);
		p3.add(jt_nrc);
		p3.add(jcb_sche);
		p3.add(jcb_doct);
		// p3.add(jr_check);

		JPanel p4 = new JPanel();
		p4.setLayout(new BorderLayout());
		p4.add(p1, BorderLayout.WEST);
		p4.add(p3, BorderLayout.CENTER);

		JPanel p5 = new JPanel();
		p5.setLayout(new BorderLayout());
		p5.setBorder(new TitledBorder("Making Appointment"));

		p5.add(p4, BorderLayout.CENTER);
		p5.add(p2, BorderLayout.SOUTH);// End of Upper Offline Appointment

		JPanel p6 = new JPanel();
		p6.setLayout(new GridLayout(4, 1));
		p6.add(new JLabel("Name"));
		p6.add(new JLabel("NRC Number"));
		p6.add(new JLabel("Time"));
		p6.add(new JLabel("Doctor Name"));

		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(4, 1));
		p7.add(name);
		p7.add(nrc);
		p7.add(sche);
		p7.add(doctor);

		JPanel pbutton = new JPanel();
		pbutton.setLayout(new GridLayout(2, 1));
		pbutton.add(accept);
		pbutton.add(decline);

		JPanel pbutton1 = new JPanel();
		pbutton1.setLayout(new BorderLayout());
		pbutton1.add(refresh, BorderLayout.CENTER);

		JPanel pbutton2 = new JPanel();
		pbutton2.setLayout(new BorderLayout());
		pbutton2.add(pbutton1, BorderLayout.WEST);
		pbutton2.add(pbutton, BorderLayout.CENTER);

		JPanel prtotal = new JPanel();
		prtotal.setLayout(new BorderLayout());
		prtotal.add(p6, BorderLayout.WEST);
		prtotal.add(p7, BorderLayout.CENTER);
		prtotal.add(pbutton2, BorderLayout.SOUTH);
		prtotal.setBorder(new TitledBorder("information"));

		JScrollPane jsp = new JScrollPane(list);// Scroll pane
		jsp.setBorder(new TitledBorder("Patient List"));
		JPanel pall = new JPanel();
		pall.setLayout(new GridLayout(1, 2));
		pall.add(jsp);
		pall.add(prtotal);
		pall.setBorder(new TitledBorder("Online Requested Appointments"));

		add(p5);
		add(pall);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = 0;
				int boxi = jcb_sche.getSelectedIndex() + 1;

				int doci = jcb_doct.getSelectedIndex();
				String doc = doct_name[doci];
				String tmpsql = "insert into premanentappoint values('" + id
						+ "','" + jt_name.getText() + "','" + jt_nrc.getText()
						+ "','" + boxi + "','" + doc + "')";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					int i = st.executeUpdate(tmpsql);
					if (i == 1)
						System.out.print("success");
					JOptionPane.showMessageDialog(null,
							"Success! Your data have been saved.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jt_name.setText(null);
				jt_nrc.setText(null);
			}

		});
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dataCecking();
			}
		});
		list.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Click");
				Object name1 = list.getSelectedValue();
				String sql = "SELECT * FROM `tempappoint` WHERE `pname`='"
						+ name1 + "'";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {

						tempid = rs.getInt("id");
						temppname = rs.getString("pname");
						temppnrc = rs.getInt("pnrc");
						tempptime = rs.getInt("ptime");
						temppdoc = rs.getString("pdoc");

						name.setText(" - " + rs.getString("pname"));
						nrc.setText(" - " + rs.getString("pnrc"));
						rtime = Integer.parseInt(rs.getString("ptime"));
						sche.setText(" - " + rs.getString("ptime"));
						if (rtime == 0) {
							sche.setText(" - " + "7:00 AM To 8:30 AM");
						} else if (rtime == 1)
							sche.setText(" - " + "9:30 AM To 11:30 AM");
						else if (rtime == 2)
							sche.setText(" - " + "1:00 PM To 2:30 PM");
						else
							sche.setText(" - " + "3:30 PM To 5:00 PM");
						doctor.setText(" - " + rs.getString("pdoc"));

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

		accept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				insertRealData();
			}

		});

		decline.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteTempData();
			}

		});
	}

	public void insertRealData() {

		String sql = "delete from tempappoint where pname='"
				+ list.getSelectedValue() + "'";
		String sql2 = "insert into premanentappoint values('" + tempid + "','"
				+ temppname + "','" + temppnrc + "','" + tempptime + "','"
				+ temppdoc + "')";
		try {
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			int i = st.executeUpdate(sql2);
			int j = st.executeUpdate(sql);
			if (i == 1 && j == 1) {
				System.out.println("Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTempData() {
		String sql = "delete from tempappoint where pname='"
				+ list.getSelectedValue() + "'";
		try {
			Connection c = con.getConnection();
			Statement st = c.createStatement();

			int j = st.executeUpdate(sql);
			if (j == 1) {
				System.out.println("Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dataCecking() {
		try {
			String getDocsql = "select * from tempappoint ";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				pa_index++;
			}
			if (pa_index == pa_counter) {
				System.out.print("Checking...");
				pa_index = 0;
			}

			if (pa_index > pa_counter) {
				System.out.print("new Update Occurs");
				updateData();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateData() {
		patinerL.removeAllElements();
		pa_counter = 0;
		pa_index = 0;
		try {
			String getDocsql = "select * from tempappoint ";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				patinerL.addElement(rs.getString("pname"));
				pa_counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createDatabase() {
		try {
			String getDocsql = "select * from tempappoint ";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				patinerL.addElement(rs.getString("pname"));
				pa_counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}