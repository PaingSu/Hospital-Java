package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;
import java.util.*;
import javax.swing.border.*;

import java.sql.*;
import java.sql.Date;

import Database.DB_Con;

public class PaymentPanel extends JPanel {

	private DB_Con con = new DB_Con();
	private int rid;
	private long rnrc;
	private boolean rgender;
	private int rsex;
	private Date rdate;
	private int total1;
	private JTextField jta1, jta2, jta3, jta4, jta5, jta6, jta7, jta8, jta9,
			jta10, jta11, jta12, jta13, jta14, jta15, jta16, jta17, jta18;
	private JButton jbt_cal = new JButton("Calculate", new ImageIcon(
			"image/calculate1.png"));
	private JButton jbt_clear = new JButton("Clear", new ImageIcon(
			"image/clear.png"));

	private JTextField jtf_name = new JTextField();
	private JTextField jtf_nrc = new JTextField();
	private JTextField jtf_1 = new JTextField(25);
	private JTextField jtf_2 = new JTextField(25);
	private JTextField jtf_3 = new JTextField(25);
	private JTextField jtf_4 = new JTextField(25);
	private JTextField jtf_5 = new JTextField(25);
	private JTextField jtf_6 = new JTextField(25);
	private JTextField jtf_7 = new JTextField(25);
	private JTextField jtf_8 = new JTextField(25);
	private JTextField jtf_9 = new JTextField(25);
	private JTextField jtf_10 = new JTextField(25);

	private JTextField jtf_11 = new JTextField(8);
	private JTextField jtf_22 = new JTextField(8);
	private JTextField jtf_33 = new JTextField(8);
	private JTextField jtf_44 = new JTextField(8);
	private JTextField price1 = new JTextField(8);
	private JTextField price2 = new JTextField(8);
	private JTextField price3 = new JTextField(8);
	private JTextField price4 = new JTextField(8);
	private JTextField price5 = new JTextField(8);
	private JTextField totalprice = new JTextField(8);

	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();
	private JPanel p6 = new JPanel();
	private JPanel p7 = new JPanel();
	private JPanel p8 = new JPanel();
	private JPanel p9 = new JPanel();
	private JPanel p10 = new JPanel();

	private String[] nurse = {  "0","1", "2", "3" };
	private String[] room = { "Hall", "Private" };
	private JComboBox jcb_quantity = new JComboBox(nurse);
	private JComboBox jcb_roomtype = new JComboBox(room);// End Left
	private JLabel name = new JLabel();
	private JLabel nrc = new JLabel();
	private JLabel sex = new JLabel();
	private JLabel start = new JLabel();
	private JLabel end = new JLabel();
	private JLabel total = new JLabel();
	private JTextField disease = new JTextField();

	private String[] nurse_name;
	private String[] doct_name;

	private String[] ward = { "OPD", "Eye Ward", "Bone Ward", "OG Ward",
			"ENT Ward", "Neuro Ward" };
	private ImageIcon rec = new ImageIcon("image/save.png");
	private JButton jbt_record = new JButton("Record", rec);
	private JComboBox jc_doctor;
	private JComboBox jc_nurse;
	// private JComboBox jc_disease=new JComboBox(disease);
	private JComboBox jc_ward = new JComboBox(ward);
	private JPanel t1 = new JPanel();
	private JPanel t2 = new JPanel();

	public PaymentPanel() {
		t1.setLayout(new BorderLayout());

		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		p4.setLayout(new BorderLayout());
		p5.setLayout(new BorderLayout());
		p6.setLayout(new BorderLayout());
		p7.setLayout(new BorderLayout());
		p8.setLayout(new BorderLayout());
		p9.setLayout(new BorderLayout());
		p10.setLayout(new BorderLayout());

		JPanel p = new JPanel();
		JPanel up = new JPanel();
		JPanel uptotal = new JPanel();

		p.setLayout(new GridLayout(2, 1));
		p.add(new JLabel("Name           "));
		// p.add(jta1=new JTextField());
		p.add(new JLabel("NRC Number             "));
		// p.add(jta2=new JTextField());

		up.setLayout(new GridLayout(2, 1));
		up.add(jtf_name);
		up.add(jtf_nrc);

		uptotal.setLayout(new BorderLayout());
		uptotal.add(p, BorderLayout.WEST);
		uptotal.add(up, BorderLayout.CENTER);
		// uptotal.setBorder(new TitledBorder("Paitent"));//For name and nrc
		// number
		JPanel plabel = new JPanel();
		plabel.setLayout(new BorderLayout());
		plabel.add(new JLabel("                                    Names"),
				BorderLayout.WEST);
		plabel.add(new JLabel("Prices             "), BorderLayout.EAST);

		p1.add(new JLabel("Examination Fees"), BorderLayout.WEST);
		p1.add(jtf_11, BorderLayout.EAST);
		// int pr1=Integer.parseInt(jtf_11.getText());

		p2.add(new JLabel("Investigation Charges"), BorderLayout.WEST);
		p2.add(jtf_22, BorderLayout.EAST);
		// int pr2=Integer.parseInt(jtf_22.getText());

		p3.add(new JLabel(
				"Nurse                                                                    Quantity    "),
				BorderLayout.WEST);
		p3.add(jcb_quantity, BorderLayout.CENTER);
		p3.add(jtf_33, BorderLayout.EAST);
		// int choice=jcb_quantity.getSelectedIndex();
		// int cc=Integer.parseInt(nurse[choice]); // nurse Quantity

		p5.add(new JLabel(
				"Room charge                                                            Type     "),
				BorderLayout.WEST);
		p5.add(jcb_roomtype, BorderLayout.CENTER);
		p5.add(jtf_44, BorderLayout.EAST);

		p4.add(new JLabel("                                 Medicinal Fees"),
				BorderLayout.WEST);
		p4.add(new JLabel("Prices              "), BorderLayout.EAST);

		p6.add(jtf_6, BorderLayout.WEST);
		p6.add(price1, BorderLayout.EAST);

		p7.add(jtf_7, BorderLayout.WEST);
		p7.add(price2, BorderLayout.EAST);

		p8.add(jtf_8, BorderLayout.WEST);
		p8.add(price3, BorderLayout.EAST);

		p9.add(jtf_9, BorderLayout.WEST);
		p9.add(price4, BorderLayout.EAST);

		p10.add(new JLabel(
				"Total Cost   ..................................................................................................."),
				BorderLayout.WEST);
		p10.add(totalprice, BorderLayout.EAST);

		jbt_record.setEnabled(false);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(11, 1));
		center.add(plabel);
		center.add(p1);
		center.add(p2);
		center.add(p3);
		center.add(p5);
		center.add(p4);
		center.add(p6);
		center.add(p7);
		center.add(p8);
		center.add(p9);
		center.add(p10);
		// center.setBorder(new TitledBorder("Enter Name & Price"));

		JPanel pbutton = new JPanel();
		pbutton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// pbutton.add(jbt_clear);
		pbutton.add(jbt_cal);

		JPanel pbutton1 = new JPanel();
		pbutton1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pbutton1.add(jbt_clear);

		JPanel buttontotal = new JPanel();
		buttontotal.setLayout(new BorderLayout());
		buttontotal.add(pbutton1, BorderLayout.WEST);
		buttontotal.add(pbutton, BorderLayout.EAST);

		t1.setLayout(new BorderLayout());
		t1.add(uptotal, BorderLayout.NORTH);
		t1.add(center, BorderLayout.CENTER);
		t1.add(buttontotal, BorderLayout.SOUTH);

		// setBorder(new TitledBorder("CASH PAYMENT"));

		jbt_cal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int nur_name=jcb_quantity.getSelectedIndex();
				int rindex=jcb_roomtype.getSelectedIndex();
			//	String roomtype=room[rindex];
				String name1 = jtf_name.getText();
				String nrc1 = jtf_nrc.getText();
				int pr1=Integer.parseInt(jtf_11.getText());
				int pr2=Integer.parseInt(jtf_22.getText());
				int p1111;
				int p2222;
				int p3333;
				int p4444;
				int n=nur_name* Integer.parseInt(jtf_33.getText());
				int r=rindex*Integer.parseInt(jtf_44.getText());
				
				if(jtf_6.getText().equals(""))
					p1111=0;
				else
					p1111=Integer.parseInt(price1.getText());
				if(jtf_7.getText().equals(""))
				{
					p2222=0;
				}
				else{
					p2222=Integer.parseInt(price2.getText());
				}
				if(jtf_8.getText().equals(""))
				{
					p3333=0;
				}
				else{
					p3333=Integer.parseInt(price3.getText());
				}
				if(jtf_9.getText().equals(""))
				{
					p4444=0;
				}
				else{
					p4444=Integer.parseInt(price4.getText());
				}
				
				
				int sum=pr1+pr2+n+r+p1111+p2222+p3333+p4444;
				totalprice.setText(""+sum);
				
				total1 = Integer.parseInt(totalprice.getText());
				String sql = "SELECT * FROM `patient` WHERE `name`='" + name1
						+ "' and `nrc`='" + nrc1 + "'";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {

						name.setText(rs.getString("name"));
						nrc.setText(rs.getString("nrc"));
						rgender = rs.getBoolean("sex");
						rnrc = rs.getLong("nrc");
						if (rs.getBoolean("sex")) {
							sex.setText("Male");
						} else
							sex.setText("Female");

						start.setText("" + rs.getDate("date"));
						rdate = rs.getDate("date");
						end.setText("" + new java.util.Date());
						total.setText("" + total1);

						jbt_record.setEnabled(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});// End left

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
		jc_doctor = new JComboBox(doct_name);
		// Nurse
		int counter1 = 0;

		try {

			String getDocsql = "select * from staff where stype='Nurse'";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				counter1++;

			}
			System.out.println("C" + counter1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		nurse_name = new String[counter1];
		System.out.println("-------" + nurse_name.length);
		int index1 = 0;

		try {

			String getDocsql = "select * from staff where stype='Nurse'";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(getDocsql);
			while (rs.next()) {
				nurse_name[index1++] = rs.getString("sname");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jc_nurse = new JComboBox(nurse_name);

		JPanel p11 = new JPanel();
		p11.setLayout(new GridLayout(10, 1, 5, 5));
		p11.add(new JLabel("Name"));
		p11.add(new JLabel("NRC Number"));
		p11.add(new JLabel("Sex"));
		p11.add(new JLabel("Disease"));
		p11.add(new JLabel("Doctor Name"));
		p11.add(new JLabel("Nurse Name"));
		p11.add(new JLabel("Ward"));
		p11.add(new JLabel("Start Date"));
		p11.add(new JLabel("End Date"));
		p11.add(new JLabel("Total Cost"));

		JPanel p22 = new JPanel();
		p22.setLayout(new GridLayout(10, 1, 5, 5));
		p22.add(name);
		p22.add(nrc);
		p22.add(sex);
		p22.add(disease);
		p22.add(jc_doctor);
		p22.add(jc_nurse);
		p22.add(jc_ward);
		;
		p22.add(start);
		p22.add(end);
		p22.add(total);

		JPanel p33 = new JPanel();
		p33.setLayout(new BorderLayout(20, 5));
		p33.add(p11, BorderLayout.WEST);
		p33.add(p22, BorderLayout.CENTER);

		JPanel p44 = new JPanel();
		p44.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p44.add(jbt_record);

		t2.setLayout(new BorderLayout());
		t2.add(p33, BorderLayout.CENTER);
		t2.add(p44, BorderLayout.SOUTH);
		t2.setBorder(new TitledBorder("Save Record"));

		setLayout(new GridLayout(1, 2));
		add(t1);
		add(t2);

		jbt_record.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				int docindex = jc_doctor.getSelectedIndex();
				
				String docname = doct_name[docindex];
				int nursindex = jc_nurse.getSelectedIndex();
				String nurname = nurse_name[nursindex];
				int windex = jc_ward.getSelectedIndex();
				String wname = ward[windex];
				System.out.println("Doctoer index " + docindex);
				if (rgender)
					rsex = 1;
				else
					rsex = 0;

				String sql2 = "insert into record values('" + rid + "','"
						+ name.getText() + "','" + rnrc + "','" + rsex + "','"
						+ disease.getText() + "','" + docname + "','" + nurname
						+ "','" + wname + "','" + rdate + "',now(),'" + total1
						+ "')";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					int i = st.executeUpdate(sql2);
					if (i == 1) {
						System.out.println("Success");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
		jbt_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				jtf_name.setText(null);
				jtf_nrc.setText(null);
				jtf_11.setText(null);
				jtf_22.setText(null);
				jtf_33.setText(null);
				jtf_44.setText(null);
				jtf_6.setText(null);
				jtf_7.setText(null);
				jtf_8.setText(null);
				jtf_9.setText(null);
				price1.setText(null);
				price2.setText(null);
				price3.setText(null);
				price4.setText(null);
				totalprice.setText(null);
			}

		});

	}
}
