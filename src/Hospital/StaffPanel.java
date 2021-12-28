package Hospital;

import java.awt.*;     
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.io.*;
import java.util.*;
import java.net.*;
import java.awt.event.*;

public class StaffPanel extends JPanel{
	

	private AddStaff staff=new AddStaff();
	private Nurse n=new Nurse();
	private Doctor d=new Doctor();
	private Technician t=new Technician();
	private GeneralStaff ad=new GeneralStaff();
	//private ImageIcon admin=new ImageIcon("image/admin.png");
	//private ImageIcon add=new ImageIcon("image/add.png");
	
	public StaffPanel()
	{
		setLayout(new BorderLayout());
		JTabbedPane jtp1=new JTabbedPane();
		JTabbedPane jtp2=new JTabbedPane();
		jtp1.addTab("Doctors",new ImageIcon("image/doctor.png"), d);
		jtp1.addTab("Nurses",new ImageIcon("image/nurse.png"),n);
		jtp1.addTab("Technicians",new ImageIcon("image/tech.png"),t);
		jtp1.addTab("GeneralStaffs",new ImageIcon("image/admin.png"),ad);
		jtp2.addTab("Add New Staffs",new ImageIcon("image/add.png"),staff);
		add(jtp1,BorderLayout.CENTER);
		add(jtp2,BorderLayout.EAST);
	}

}
