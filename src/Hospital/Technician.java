package Hospital;
import java.awt.*;  

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.awt.event.*;

import Database.DB_Con;
import Hospital.Doctor.TimerListener;

public class Technician extends JPanel{

	/**
	 * @param args
	 */
	private DB_Con con=new DB_Con();
	private DefaultListModel techlist;
	private JList list2;
	

	private JPanel listpanel=new JPanel();
	
	private JLabel name=new JLabel();
	private JLabel gender=new JLabel();
	private JLabel rank=new JLabel();
	private JLabel salary=new JLabel();
	private JLabel phno=new JLabel();
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	private JPanel buttonpanel=new JPanel();
	private JLabel jl_name=new JLabel();
	private JLabel jl_type=new JLabel();
	private JLabel jl_bdate=new JLabel();
	private JLabel jl_nrc=new JLabel();
	private JLabel jl_ward=new JLabel();
	private JLabel jl_phno=new JLabel();
	private JLabel jl_rank=new JLabel();
	private JLabel jl_salary=new JLabel();
	private int id;
	private int nrco = 0;
	private int counter=0;
	private int index=0;
	private JButton jbt_remove=new JButton("Remove",new ImageIcon("image/removetech.png"));
	
	public Technician()
	{
		setLayout(new GridLayout(1,2));
		JTabbedPane jtp=new JTabbedPane();
		techlist = new DefaultListModel();
		
		createDatabae();
		Timer time = new Timer(1000, new TimerListener());
		time.start();
		
	
		list2 = new JList(techlist);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listpanel.setLayout(new BorderLayout());
		listpanel.add(new JScrollPane(list2));
		setBorder(new TitledBorder("Technicians List and Informations"));
		//jtp.add("List",listpanel);
		
		buttonpanel.setLayout(new BorderLayout());
		buttonpanel.add(jbt_remove,BorderLayout.SOUTH);
		
		p1.setLayout(new GridLayout(9,1));
		p1.add(new JLabel("	Name   "));
		p1.add(new JLabel("Certificate "));
		p1.add(new JLabel("Birthday  "));
		p1.add(new JLabel("NRC Number    "));
		p1.add(new JLabel("	Ward"));
		p1.add(new JLabel("	Phone Number     "));
		p1.add(new JLabel("Rank"));
		p1.add(new JLabel("Salary"));
		p2.setLayout(new GridLayout(9,1));
		p2.add(jl_name);
		p2.add(jl_type);
		p2.add(jl_bdate);
		p2.add(jl_nrc);
		p2.add(jl_ward);
		p2.add(jl_phno);
		p2.add(jl_rank);
		p2.add(jl_salary);
		p2.add(buttonpanel);
		p3.setLayout(new GridLayout(1,2));
		p3.add(p1);
		p3.add(p2);
		add(listpanel);
		add(p3);
		
		list2.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Click");
				Object name = list2.getSelectedValue();
				String sql = "SELECT * FROM `staff` as s,birthday as b WHERE `sname`='" + name
						+ "' and s.sid=b.bid ";

				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						id=rs.getInt("sid");
						jl_name.setText(" - "+rs.getString("sname"));
						jl_type.setText(" - "+rs.getString("certificate"));
						jl_bdate.setText(" - "+ rs.getInt("day") +" / " +rs.getString("month")+" / " +rs.getInt("year"));
						jl_nrc.setText(" - " + rs.getInt("nrc"));
						nrco = rs.getInt("nrc");
						jl_ward.setText(" - "+rs.getString("ward"));
						jl_phno.setText(" - "+rs.getString("phno"));
						jl_rank.setText(" - "+rs.getString("rank"));
						jl_salary.setText(" - " + rs.getInt("salary"));
						System.out.println(nrco);

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
		jbt_remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object name1 = list2.getSelectedValue();
				int rindex = list2.getSelectedIndex();
				
				int user_id = 0;
				
			
				String sql="select * from staff where sname='"+name1+"' and nrc='"+nrco+"'";
				try {
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(sql);
				

					while(rs.next()){
						user_id=rs.getInt("sid");
					}
					
				

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try{
					String sql2="delete from birthday where bid='"+user_id+"'"	;
					String sql3="delete from staff where sid='"+user_id+"'";
					Connection c = con.getConnection();
					Statement st = c.createStatement();
					int i=st.executeUpdate(sql3);
					int j=st.executeUpdate(sql2);
					if(i==1 && j==1){
						System.out.print("success");
						list2.remove(rindex);
						JOptionPane.showMessageDialog(null,"Success! Your data have been successfully removed.","Message",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}

			}

		}); 	// Remove List
	}
	class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			checkingDatabase();
		}

	}
	
	public void createDatabae(){
		String sql = "SELECT * FROM `staff` where `stype`='Technician'";
		try {
			Connection c = con.getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				techlist.addElement(rs.getString("sname"));
				counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void checkingDatabase(){
		String sql = "SELECT * FROM `staff` where `stype`='Technician'";
		try{
			Connection c=con.getConnection();
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				index++;
				System.out.println("Index "+ index +" : " +counter);
			}
			if(index==counter){
				System.out.println("Checking");
				index=0;
			}
			if(index!=counter){
				counter=0;
				index=0;
				techlist.removeAllElements();
				createDatabae();
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	

}
