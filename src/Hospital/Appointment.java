package Hospital;
import java.awt.*;     
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.Event.*;
import java.sql.*;

public class Appointment extends JPanel{
	private AppointmentLeftPanel al=new AppointmentLeftPanel();
	private AppointmentRightPanel ar=new AppointmentRightPanel();
	public Appointment(){
		setLayout(new GridLayout(1,2));
		add(al);
		add(ar);
	}

}
