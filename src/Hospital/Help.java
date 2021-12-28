package Hospital;
import java.awt.*;   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class Help extends JFrame{
	private JLabel icon1=new JLabel(new ImageIcon("image/help1.png"));
	private JLabel icon2=new JLabel(new ImageIcon("image/help2.png"));
	private JLabel icon3=new JLabel(new ImageIcon("image/help3.png"));
	private JLabel icon4=new JLabel(new ImageIcon("image/help4.png"));
	private JLabel icon5=new JLabel(new ImageIcon("image/help5.png"));
	private JLabel icon6=new JLabel(new ImageIcon("image/help6.png"));
	private JLabel icon7=new JLabel(new ImageIcon("image/help7.png"));
	private JLabel icon12=new JLabel(new ImageIcon("image/help12.png"));
	private JLabel icon8=new JLabel(new ImageIcon("image/help8.png"));
	private JLabel icon9=new JLabel(new ImageIcon("image/help9.png"));
	private JLabel icon=new JLabel(new ImageIcon("image/help11.png"));
	private JLabel icon10=new JLabel(new ImageIcon("image/help10.png"));
	private JLabel icon13=new JLabel(new ImageIcon("image/help13.png"));
	private JTabbedPane jtb=new JTabbedPane();

	public Help(){
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(new JLabel("1.Enter Information."));
		p1.add(new JLabel("2.Click 'Save' button to register patient."));
		p1.add(new JLabel("3.Click 'Clear' button to clear information."));
		
		//JPanel pi=new JPanel();
		//pi.setLayout(new BorderLayout());
		//pi.add(p1,BorderLayout.SOUTH);
		
		JPanel pp=new JPanel();
		pp.setLayout(new FlowLayout(FlowLayout.LEFT));
		pp.add(icon1);
		
		JPanel p2=new JPanel();
		p2.setLayout(new BorderLayout(5,1));
		p2.add(pp,BorderLayout.CENTER);
		p2.add(p1,BorderLayout.SOUTH);
		
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(new JLabel("4.The messsage box will appear after registeration."));
		
		JPanel pa=new JPanel();
		pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		pa.add(icon2);
		
		JPanel p4=new JPanel();
		p4.setLayout(new BorderLayout(5,1));
		p4.add(pa,BorderLayout.CENTER);
		p4.add(p3,BorderLayout.SOUTH);
		
		JPanel p5=new JPanel();
		p5.setLayout(new GridLayout(4,1));
		p5.add(new JLabel("5.Enter patient name in the search box.\n"));
		p5.add(new JLabel("6.Click 'Search' button.\n"));
		p5.add(new JLabel("7.Patient name will appear on the list"));
		p5.add(new JLabel("8.Select name in the list and then patient's information will appear"));
		
		//JPanel p6=new JPanel();
		//p6.setLayout(new BorderLayout());
		//p6.add(p5,BorderLayout.SOUTH);
		
		JPanel pe=new JPanel();
		pe.setLayout(new FlowLayout(FlowLayout.LEFT));
		pe.add(icon3);
		
		JPanel p7=new JPanel();
		p7.setLayout(new BorderLayout(5,1));
		p7.add(pe,BorderLayout.CENTER);
		p7.add(p5,BorderLayout.SOUTH);
		
		JPanel pat=new JPanel();
		pat.setLayout(new GridLayout(3,1));
		pat.add(p2);
		pat.add(p4);
		pat.add(p7);
		
		JScrollPane js1=new JScrollPane(pat);
		
		JPanel p8=new JPanel();
		p8.setLayout(new GridLayout(3,1));
		p8.add(new JLabel("1.Enter Information."));
		p8.add(new JLabel("2.Click 'Save Appointment' button to save appointment."));
		p8.add(new JLabel("3.Click 'Clear' button to clear information."));
		
		//JPanel pw=new JPanel();
	//	pw.setLayout(new BorderLayout());
	//	pw.add(p8,BorderLayout.SOUTH);
		
		JPanel p9=new JPanel();
		p9.setLayout(new FlowLayout(FlowLayout.LEFT));
		p9.add(icon4);
		
		JPanel p10=new JPanel();
		p10.setLayout(new BorderLayout());
		p10.add(p8,BorderLayout.SOUTH);
		p10.add(p9,BorderLayout.CENTER);
		
		JPanel p11=new JPanel();
		p11.setLayout(new BorderLayout());
		p11.add(new JLabel("4.The dialog box will appear after you get appointment."),BorderLayout.SOUTH);
		
		JPanel p12=new JPanel();
		p12.setLayout(new FlowLayout(FlowLayout.LEFT));
		p12.add(icon5);
		
		
		JPanel p13=new JPanel();
		p13.setLayout(new BorderLayout(5,1));
		p13.add(p11,BorderLayout.SOUTH);
		p13.add(p12,BorderLayout.CENTER);
		
		JPanel p14=new JPanel();
		p14.setLayout(new GridLayout(5,1));
		p14.add(new JLabel("5.Select doctor name and time."));
		p14.add(new JLabel("6.Click 'Search' button."));
		p14.add(new JLabel("7.Appointed patient list will appear"));
		p14.add(new JLabel("8.Select name in the list to show information."));
		p14.add(new JLabel("9.Click 'Remove' button to remove appointment"));
		
		//JPanel pt=new JPanel();
		//pt.setLayout(new BorderLayout());
		//pt.add(p14,BorderLayout.SOUTH);
		
		JPanel p15=new JPanel();
		p15.setLayout(new FlowLayout(FlowLayout.LEFT));
		p15.add(icon);
		
		JPanel p16=new JPanel();
		p16.setLayout(new BorderLayout(5,1));
		p16.add(p14,BorderLayout.SOUTH);
		p16.add(p15,BorderLayout.CENTER);
		
		JPanel p17=new JPanel();
		p17.setLayout(new GridLayout(3,1));
		p17.add(p10);
		p17.add(p13);
		p17.add(p16);
		
		JScrollPane js2=new JScrollPane(p17);
		
		JPanel p18=new JPanel();
		p18.setLayout(new GridLayout(3,1));
		p18.add(new JLabel("1.Enter information in text field."));
		p18.add(new JLabel("2.Click 'Calculate' button to calculate payment"));
		p18.add(new JLabel("3.Click 'Clear' button to clear information."));
		
		
		JPanel p19=new JPanel();
		p19.setLayout(new FlowLayout(FlowLayout.LEFT));
		p19.add(icon6);
		
		//JPanel p20=new JPanel();
		//p20.setLayout(new BorderLayout());
		//p20.add(p18,BorderLayout.SOUTH);
		
		JPanel p21=new JPanel();
		p21.setLayout(new BorderLayout(5,1));
		p21.add(p18,BorderLayout.SOUTH);
		p21.add(p19,BorderLayout.CENTER);
		
		JPanel p22=new JPanel();
		p22.setLayout(new GridLayout(2,1));
		p22.add(new JLabel("4.Enter disease ,choose doctor and nurse."));
		p22.add(new JLabel("5.Then click 'Save Record' button to save the record."));
		
		//JPanel p23=new JPanel();
		//p23.setLayout(new BorderLayout());
		//p23.add(p22,BorderLayout.SOUTH);
		
		JPanel p24=new JPanel();
		p24.setLayout(new FlowLayout(FlowLayout.LEFT));
		p24.add(icon7);
		
		JPanel p25=new JPanel();
		p25.setLayout(new BorderLayout());
		p25.add(p22,BorderLayout.SOUTH);
		p25.add(p24,BorderLayout.CENTER);
		
		JScrollPane js3=new JScrollPane(p25);
		
		JPanel p26=new JPanel();
		p26.setLayout(new GridLayout(5,1));
		p26.add(new JLabel("1.Choose which type do you want to search with patient or with doctor."));
		p26.add(new JLabel("2.Enter name in the text field."));
		p26.add(new JLabel("3.Click 'Search' button to search patient."));
		p26.add(new JLabel("4.Then patient list will appear."));
		p26.add(new JLabel("5.Choose patient name,which you want to see his/her infromation."));
		
		//JPanel p27=new JPanel();
		//p27.setLayout(new BorderLayout());
		//p27.add(p26,BorderLayout.SOUTH);
		
		JPanel p28=new JPanel();
		p28.setLayout(new FlowLayout(FlowLayout.LEFT));
		p28.add(icon12);
		
		JPanel p29=new JPanel();
		p29.setLayout(new BorderLayout(5,1));
		p29.add(p26,BorderLayout.SOUTH);
		p29.add(p28,BorderLayout.CENTER);
		
		JScrollPane js4=new JScrollPane(p29);
		
		JPanel p30=new JPanel();
		p30.setLayout(new GridLayout(4,1));
		p30.add(new JLabel("1.Click 'Log in' button."));
		p30.add(new JLabel("2.'Log in' dialog box will appear."));
		p30.add(new JLabel("3.Enter gmail and password."));
		p30.add(new JLabel("4.Staff management tab will enable."));
		
		//JPanel p31=new JPanel();
		//p31.setLayout(new BorderLayout());
		//p31.add(p30,BorderLayout.SOUTH);
		
		JPanel p32=new JPanel();
		p32.setLayout(new FlowLayout(FlowLayout.LEFT));
		p32.add(icon8);
		
		JPanel p33=new JPanel();
		p33.setLayout(new BorderLayout(5,1));
		p33.add(p30,BorderLayout.SOUTH);
		p33.add(p32,BorderLayout.CENTER);
		
		JPanel p34=new JPanel();
		p34.setLayout(new GridLayout(2,1));
		p34.add(new JLabel("5.Enter information about staff."));
		p34.add(new JLabel("6.Click 'Add' button to add staff."));
		
		//JPanel p35=new JPanel();
		//p35.setLayout(new BorderLayout());
		//p35.add(p34,BorderLayout.SOUTH);
		
		JPanel p36=new JPanel();
		p36.setLayout(new FlowLayout(FlowLayout.LEFT));
		p36.add(icon9);
		
		JPanel p37=new JPanel();
		p37.setLayout(new BorderLayout(5,1));
		p37.add(p34,BorderLayout.SOUTH);
		p37.add(p36,BorderLayout.CENTER);
		
		JPanel p38=new JPanel();
		p38.setLayout(new FlowLayout(FlowLayout.LEFT));
		p38.add(new JLabel("7.The dialog box will appear after adding staff."));
		
		JPanel p39=new JPanel();
		p39.setLayout(new FlowLayout(FlowLayout.LEFT));
		p39.add(icon10);
		
		JPanel p40=new JPanel();
		p40.setLayout(new BorderLayout(5,1));
		p40.add(p38,BorderLayout.SOUTH);
		p40.add(p39,BorderLayout.CENTER);

		JPanel p41=new JPanel();
		p41.setLayout(new GridLayout(4,1));
		p41.add(new JLabel("8.Select type of staff."));
		p41.add(new JLabel("9.Select name in the list."));
		p41.add(new JLabel("10.His/Her informations will appear."));
		p41.add(new JLabel("11.Click 'remove' button to remove selected staff"));
		
		//JPanel p42=new JPanel();
		//p42.setLayout(new BorderLayout());
		//p42.add(p41,BorderLayout.SOUTH);
		
		JPanel p43=new JPanel();
		p43.setLayout(new FlowLayout(FlowLayout.LEFT));
		p43.add(icon13);
		
		JPanel p44=new JPanel();
		p44.setLayout(new BorderLayout(5,1));
		p44.add(p41,BorderLayout.SOUTH);
		p44.add(p43,BorderLayout.CENTER);
		
		JPanel p45=new JPanel();
		p45.setLayout(new GridLayout(4,1));
		p45.add(p33);
		p45.add(p37);
		p45.add(p40);
		p45.add(p44);
		
		JScrollPane js5=new JScrollPane(p45);
		jtb.addTab("Patient",new ImageIcon("image/register2.png"),js1);
		jtb.addTab("Appointment",new ImageIcon("image/appointment.png"),js2);
		jtb.addTab("Payment",new ImageIcon("image/payment1.png"),js3);
		jtb.addTab("Search record",new ImageIcon("image/searchrecord.png"),js4);
		jtb.addTab("Staff management",new ImageIcon("image/doctor.png"),js5);
			JPanel p46=new JPanel();
		p46.setLayout(new GridLayout(2,1));
		p46.add(new JLabel(new ImageIcon("image/h1.png")));
		p46.add(new JLabel(new ImageIcon("image/h2.png")));
		
		setLayout(new BorderLayout(5,1));
		add(jtb,BorderLayout.CENTER);
		add(p46,BorderLayout.WEST);
		
		setIconImage(new ImageIcon("image/help.png").getImage());
		setTitle("Help");
		setSize(800,600);
		setLocationRelativeTo(null);
	
	}
}
