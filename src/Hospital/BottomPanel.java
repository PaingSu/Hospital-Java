package Hospital;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.border.*;

import Database.DB_Con;

public class BottomPanel extends JPanel {
	private Help help=new Help();
	
	private JButton jbt_login = new JButton("Log in", new ImageIcon("image/login.png"));

	private JButton jbt_about = new JButton("About ", new ImageIcon(
			"image/about.png"));
	private JButton jbt_help = new JButton("Help", new ImageIcon(
			"image/help.png"));
	
	private JButton jbt_logout = new JButton("Log out", new ImageIcon(
			"image/logout.png"));
	private JLabel thank = new JLabel(
			"Please Login to Manage Staffs.Only Adminstrators can control it. ");
	private Font font = new Font("Baskerville Old Face", Font.PLAIN, 20);
	private About about = new About();
//	private Help help = new Help();
	private JTextField admin = new JTextField(20);
	private JPasswordField pass = new JPasswordField(15);

	private JPanel p12 = new JPanel();
	private JPanel p22 = new JPanel();
	private JPanel p32 = new JPanel();
	private JPanel ptotal1 = new JPanel();
	private JPanel ptotal2 = new JPanel();

	private DB_Con con = new DB_Con();

	private JLabel jlb_li = new JLabel("Username :            ");
	private JLabel jlb_pw = new JLabel("Password :            ");
	private JTextField jtf_li = new JTextField(10);
	private JTextField jtf_pw = new JPasswordField(10);
	private JButton jbt_k = new JButton("Login", new ImageIcon(
			"image/login.png"));
	private JButton jbt_c = new JButton("Cancel", new ImageIcon(
			"image/remove.png"));

	public BottomPanel() {

		jbt_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (jbt_login.getText().endsWith("in")) {
					final JFrame box = new JFrame();

					p12.setLayout(new GridLayout(2, 1));
					p22.setLayout(new FlowLayout(FlowLayout.RIGHT));
					p32.setLayout(new GridLayout(2, 1));
					ptotal1.setLayout(new BorderLayout());
					ptotal2.setLayout(new BorderLayout());
					p12.add(jlb_li);
					p12.add(jlb_pw);
					p22.add(jbt_c);
					p22.add(jbt_k);
					p32.add(jtf_li);
					p32.add(jtf_pw);
					ptotal1.add(p12, BorderLayout.WEST);
					ptotal1.add(p32, BorderLayout.CENTER);
					box.add(ptotal1, BorderLayout.CENTER);
					box.add(p22, BorderLayout.SOUTH);
					box.setSize(320, 160);
					box.setLocationRelativeTo(null);
					box.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					box.setVisible(true);
					box.setIconImage(new ImageIcon("image/login.png")
							.getImage());
					box.setLayout(new BorderLayout());

					jbt_k.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							Login();
							box.setVisible(false);
						}

					});

					jbt_c.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {

							box.setVisible(false);
						}

					});

				}

				if (jbt_login.getText().endsWith("Out")) {
					Logout();
				}

			}

		});

		thank.setFont(font);
		thank.setForeground(new Color(0, 46, 230));
		jbt_logout.setEnabled(false);
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p1.add(jbt_about);
		p1.add(jbt_help);
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));

		p2.add(jbt_login);
		p2.add(thank);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.EAST);
		add(p2, BorderLayout.WEST);

		jbt_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about.setVisible(true);
			}
		});

		jbt_help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help.setVisible(true);
			}
		});

	}

	public void Login() {

		String sql = "SELECT * FROM admin WHERE mail='" + jtf_li.getText()
				+ "' AND password='" + jtf_pw.getText() + "'";
		int id = 0;
		String name = null;
		try {
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("name");
			}
			if (id != 0) {
				if (!name.equals(null)) {
					updateAdmin(id);

					System.out.println("Success");
					jbt_login.setText("Log Out");
					jtf_li.setText(null);
					jtf_pw.setText(null);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateAdmin(int id) {
		String sql = "update admin set islogin='1' where id='" + id + "'";
		try {
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			int i = st.executeUpdate(sql);
			if (i == 1) {
				System.out.println("success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Logout() {

		String sql = "update admin set islogin='0' where id='1'";
		try {
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			int i = st.executeUpdate(sql);
			if (i == 1) {
				System.out.println("success");
				jbt_login.setText("Log in");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		pass.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
	
}
