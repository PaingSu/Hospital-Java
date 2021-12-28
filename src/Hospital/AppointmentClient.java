package Hospital;

import java.awt.*; 

import javax.swing.*;
import javax.swing.Timer;

import java.io.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.net.*;
import Database.DB_Con;
import Hospital.HospitalMain.TimerListener;

public class AppointmentClient extends JFrame {
	private DB_Con con = new DB_Con();
	private JTextField jt_name = new JTextField();
	private JTextField jt_nrc = new JTextField();
	private String[] doct_name = { "Dr.Htet Aung Ye", "Dr.Nyi Nyi Htun Lwin",
			"Dr.Zay Linn Htike", "Dr.Yan Naung Nyeuin" };
	private String[] doct_sche = new String[4];

	private ImageIcon icon = new ImageIcon("image/icon1.png");
	private JLabel lb_icon = new JLabel(icon);
	private ImageIcon icon1 = new ImageIcon("image/wifiicon.png");
	private JLabel lb_icon1 = new JLabel(icon1);

	private JLabel lb_title = new JLabel(" Online Appointment Making System");
	private JLabel lb_title1 = new JLabel("                      Of");
	private JLabel lb_title2 = new JLabel("              General Hospital");
	private Font font = new Font("Baskerville Old Face", Font.BOLD, 20);

	private JComboBox jcb_doct;
	private JComboBox jcb_sche;
	private int id;
	// private JCheckBox jr_check=new JCheckBox("Check");
	private String tempName;
	private int temptime;
	private int tempnrc;

	private JButton request = new JButton("Request Appointment", new ImageIcon(
			"image/request.png"));

	public static void main(String[] args) {
		AppointmentClient ap = new AppointmentClient();
		ap.setIconImage(new ImageIcon("image/icon.jpg").getImage());
	}

	public AppointmentClient() {
		Timer time = new Timer(1000, new TimerListener());
		time.start();
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

		jcb_doct = new JComboBox(doct_name);
		jcb_sche = new JComboBox(doct_sche);
		//

		jcb_doct.setBackground(Color.WHITE);
		jcb_doct.setForeground(Color.BLACK);
		jcb_sche.setBackground(Color.WHITE);
		jcb_sche.setForeground(Color.BLACK);

		lb_title.setFont(font);
		lb_title.setForeground(new Color(0, 46, 230));
		lb_title1.setFont(font);
		lb_title1.setForeground(new Color(0, 46, 230));
		lb_title2.setFont(font);
		lb_title2.setForeground(new Color(0, 46, 230));

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
		p2.add(request);

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(4, 1));
		p3.add(jt_name);
		p3.add(jt_nrc);
		p3.add(jcb_sche);
		p3.add(jcb_doct);
		// p3.add(jr_check);
		p3.setBackground(Color.white);

		JPanel p4 = new JPanel();
		p4.setLayout(new BorderLayout());
		p4.add(p1, BorderLayout.WEST);
		p4.add(p3, BorderLayout.CENTER);
		p4.setBackground(Color.white);

		JPanel titlepanel = new JPanel();
		titlepanel.setLayout(new GridLayout(3, 1));
		titlepanel.add(lb_title);
		titlepanel.add(lb_title1);
		titlepanel.add(lb_title2);
		titlepanel.setBackground(Color.white);

		JPanel p5 = new JPanel();
		p5.setLayout(new BorderLayout());
		p5.add(lb_icon, BorderLayout.WEST);
		p5.add(titlepanel, BorderLayout.CENTER);
		p5.add(lb_icon1, BorderLayout.EAST);
		p5.setBackground(Color.white);

		setLayout(new BorderLayout());
		add(p5, BorderLayout.NORTH);
		add(p4, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		setTitle("General Hospital's Appointment System");
		setSize(500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(Color.white);

		request.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// to save database
				try {
					int timeindex = jcb_sche.getSelectedIndex() + 1;

					int docindex = jcb_doct.getSelectedIndex();
					String doc = doct_name[docindex];
					String sql = "insert into tempappoint values('" + id
							+ "','" + jt_name.getText() + "','"
							+ jt_nrc.getText() + "','" + timeindex + "','"
							+ doc + "')";

					tempName = jt_name.getText();
					tempnrc = Integer.parseInt(jt_nrc.getText());
					temptime = timeindex;

					Connection c = getConnection();
					Statement st = c.createStatement();
					int i = st.executeUpdate(sql);
					if (i == 1) {
						System.out.println("Success");
						JOptionPane
								.showMessageDialog(
										null,
										"Success! Your request has been sent.Please wait for the response",
										"Message",
										JOptionPane.INFORMATION_MESSAGE);

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				// get id

			}
		});

	}

	class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Checking();
		}

	}

	public void Checking() {
		int id = 0;
		String sql = "select * from tempappoint where pname='" + tempName
				+ "' and pnrc='" + tempnrc + "' and " + "ptime='" + temptime
				+ "'";
		try {
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("id");
			}
			if (id != 0) {
				System.out.println("He is here");
			} else {
				System.out.println("he is missing");
				checkRealDatabase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection con = null;
		String user = "root";
		String pass = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/hospitalmanage", user, pass);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return con;
	}

	public void checkRealDatabase() {
		int id2 = 0;
		String sql = "select * from premanentappoint where pname='" + tempName
				+ "' and pnrc='" + tempnrc + "' and " + "ptime='" + temptime
				+ "'";
		try {
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id2 = rs.getInt("id");
			}
			if (id2 != 0) {
				System.out.println("Your are accept ");
				JOptionPane
				.showMessageDialog(
						null,
						"Success! Your request has been Accepted",
						"Message",
						JOptionPane.INFORMATION_MESSAGE);
			} else if(id2==0){
				System.out.println("Your are declaine...");
					}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
