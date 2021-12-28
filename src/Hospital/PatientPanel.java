package Hospital;
import java.awt.*;  
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class PatientPanel extends JPanel{
	
	private PatientLeftPanel pl=new PatientLeftPanel();
	private PatientRightPanel pr=new PatientRightPanel();
	public PatientPanel()
	{
		setLayout(new GridLayout(1,2));
		add(pl);
		add(pr);
		
	}


}
