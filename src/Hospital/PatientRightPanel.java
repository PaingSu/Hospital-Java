package Hospital;

import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import Database.DB_Con;

public class PatientRightPanel extends JPanel {

	private JLabel lbname = new JLabel();
	private JLabel lbtype = new JLabel();
	private JLabel lbage = new JLabel();
	private JLabel lbnrc = new JLabel();
	private JLabel lbgender = new JLabel();
	private JLabel lbphno = new JLabel();
	private JLabel lbdate = new JLabel();
	private boolean rgender;
	private JTextField jt_search = new JTextField();// search
	private JTextArea jt_ab = new JTextArea(); // about
	private ImageIcon search = new ImageIcon("image/search.png");
	private JButton jbt_search = new JButton("Search", search); // search button
	private JScrollPane js = new JScrollPane(jt_ab);
	private JButton jbt_clear = new JButton("Clear", new ImageIcon(
			"image/clear.png"));
	private DB_Con con = new DB_Con();
	private DefaultTableModel pdatap;
	private JTable plist;

	public PatientRightPanel() {
		jbt_search.setToolTipText("Search for patient");
		jt_search.setToolTipText("Enter Name for search");
		// jbt_search.setBackground(Color.BLUE);
		// jbt_search.setForeground(Color.WHITE);

		pdatap = new DefaultTableModel();
		pdatap.addColumn("Name");
		pdatap.addColumn("ID");
		jbt_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String sql = "select * from patient where name='"
						+ jt_search.getText() + "'";

				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						String[] data = { rs.getString("name"),
								"" + rs.getInt("pid") };
						System.out.println("Success");
						pdatap.addRow(data);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
		plist = new JTable(pdatap);
		plist.setBorder(new LineBorder(Color.black));

		JPanel plabel = new JPanel();
		plabel.setLayout(new GridLayout(7, 1));
		plabel.add(new JLabel("Name"));
		plabel.add(new JLabel("Patient Type"));
		plabel.add(new JLabel("Age"));
		plabel.add(new JLabel("NRC"));
		plabel.add(new JLabel("Gender"));
		plabel.add(new JLabel("Phone No"));
		plabel.add(new JLabel("Date&Time"));

		JPanel plabel2 = new JPanel();
		plabel2.setLayout(new GridLayout(7, 1));
		plabel2.add(lbname);
		plabel2.add(lbtype);
		plabel2.add(lbage);
		plabel2.add(lbnrc);
		plabel2.add(lbgender);
		plabel2.add(lbphno);
		plabel2.add(lbdate);

		JPanel ptotal = new JPanel();
		ptotal.setLayout(new BorderLayout());
		ptotal.add(plabel, BorderLayout.WEST);
		ptotal.add(plabel2, BorderLayout.CENTER);

		JPanel list = new JPanel();
		list.setLayout(new GridLayout(1, 2));
		list.add(plist);
		list.add(ptotal);

		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout(5, 5));
		p1.add(jt_search, BorderLayout.CENTER);
		p1.add(jbt_search, BorderLayout.EAST);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p3.add(jbt_clear);
		setLayout(new BorderLayout(0, 15));

		list.setBorder(new TitledBorder("Results"));

		add(p1, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		setBorder(new TitledBorder("Search"));

		jbt_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				// pdatap.removeRow(plist.getSelectedRow());
				int row = pdatap.getRowCount();
				for (int i = 1; i<=row; i++) {
					pdatap.removeRow(row-i);
				}

				jt_search.setText(null);
				lbname.setText(null);
				lbtype.setText(null);
				lbage.setText(null);
				lbnrc.setText(null);
				lbgender.setText(null);
				lbphno.setText(null);
				lbdate.setText(null);
			}

		});
		plist.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Click");
				int id = Integer.parseInt((String) pdatap.getValueAt(
						plist.getSelectedRow(), 1));
				String sql = "SELECT * FROM `patient` WHERE `pid`='" + id + "'";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {

						lbname.setText(" - " + rs.getString("name"));
						lbtype.setText(" - " + rs.getString("type"));
						lbage.setText(" - " + rs.getString("age"));
						lbnrc.setText(" - " + rs.getString("nrc"));
						rgender = rs.getBoolean("sex");
						lbgender.setText(" - " + rs.getString("sex"));
						if (rs.getBoolean("sex")) {
							lbgender.setText(" - " + "Male");
						} else
							lbgender.setText(" - " + "Female");

						lbphno.setText(" - " + rs.getString("phno"));
						lbdate.setText(" - " + rs.getString("date"));

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
