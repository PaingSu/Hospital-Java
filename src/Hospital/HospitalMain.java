package Hospital;

import java.awt.*;

 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Timer;

import java.io.*;
import java.util.*;
import javax.swing.border.*;
import java.sql.*;
import Database.DB_Con;

public class HospitalMain extends JFrame {
	private DB_Con con = new DB_Con();
	private PaymentPanel p1 = new PaymentPanel();
	private BottomPanel bp = new BottomPanel();
	private SearchRecord sr = new SearchRecord();
	private TopPanel tp = new TopPanel();
	private Appointment appointment = new Appointment();
	private PatientPanel pp = new PatientPanel();
	private StaffPanel sp = new StaffPanel();
	private JTabbedPane jtp_mid = new JTabbedPane();

	public static void main(String[] args) {
		HospitalMain h = new HospitalMain();
		h.setTitle("General Hospital System");
		h.setIconImage(new ImageIcon("image/icon.jpg").getImage());
		h.setSize(935, 700);
		h.setLocationRelativeTo(null);
		h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		h.setVisible(true);
		h.setResizable(false);
	}

	public HospitalMain() {
		Timer time = new Timer(1000, new TimerListener());
		time.start();
		setLayout(new BorderLayout());
		jtp_mid.addTab("Patient Registration", new ImageIcon(
				"image/register2.png"), pp);
		jtp_mid.addTab("Appointment", new ImageIcon("image/appointment.png"),
				appointment);
		jtp_mid.addTab("Payment and Records", new ImageIcon(
				"image/payment1.png"), p1);
		jtp_mid.addTab("Search Record",
				new ImageIcon("image/searchrecord.png"), sr);
		jtp_mid.addTab("Staff Management", new ImageIcon("image/doctor.png"),
				sp);
		// jtp_mid.setEnabledAt(3, false);

		add(tp, BorderLayout.NORTH);
		add(jtp_mid, BorderLayout.CENTER);
		add(bp, BorderLayout.SOUTH);

	}

	class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Checking();
		}

	}

	public void Checking() {
		boolean login = false;
		try {
			String sql = "select * from admin";
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				login = rs.getBoolean("islogin");

			}
			if (login) {
				jtp_mid.setEnabledAt(4, true);
			} else {
				jtp_mid.setEnabledAt(4, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
