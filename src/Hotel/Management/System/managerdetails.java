package Hotel.Management.System;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
@SuppressWarnings("serial")
public class managerdetails extends JFrame implements ActionListener {

	JTable table;
	JButton back;
	
	managerdetails(){
		 setIconImage(Toolkit.getDefaultToolkit().getImage(managerdetails.class.getResource("/Gallery/hotelicon.png")));
		setLayout(null);
		setTitle("Customer Details");
		setResizable(false);
		getContentPane().setBackground(Color.green);
		
		table=new JTable();
		table.setBounds(0,50,1000,400);
		table.setForeground(Color.black);
	    table.setBackground(Color.green);
		add(table);
		
		try {
			 Conn c=new Conn();
			 String query="Select * from employee where job='manager'";
			 ResultSet rs=c.s.executeQuery(query);
			 ResultSetMetaData rsmd=rs.getMetaData();
			 DefaultTableModel model=  (DefaultTableModel) table.getModel();
			 int cols=rsmd.getColumnCount();
			 String [] colName=new String[cols];
			 for(int i=0;i<cols;i++)
			 colName[i]=rsmd.getColumnName(i+1);
			 model.setColumnIdentifiers(colName);
			 

			 String name,age,gender,job,salary,phone,email,aadhar;
			 
			 while(rs.next()) {
				name=rs.getString(1);
				age=rs.getString(2);
				gender=rs.getString(3);
			    job=rs.getString(4);
				salary=rs.getString(5);
				phone=rs.getString(6);
				email=rs.getString(7);
				aadhar=rs.getString(8);
				
				
				String[] row= {name,age,gender,job,salary,phone,email,aadhar};
				model.addRow(row);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
		 JLabel name=new JLabel("Name");
		 name.setBounds(40,10,100,20);
		 name.setForeground(Color.black);
		 add(name);
		
		 JLabel age=new JLabel("Age");
		 age.setBounds(170,10,100,20);
		 age.setForeground(Color.black);
		 add(age);
		
		 JLabel gender=new JLabel("Gender");
		 gender.setBounds(290,10,100,20);
		 gender.setForeground(Color.black);
		 add(gender);
		 
		 JLabel job=new JLabel("Job");
		 job.setBounds(400,10,100,20);
		 job.setForeground(Color.black);
		 add(job);

		 JLabel salary=new JLabel("Salary");
		 salary.setBounds(540,10,100,20);
		 salary.setForeground(Color.black);
		 add(salary);

		 JLabel phone=new JLabel("Contact");
		 phone.setBounds(670,10,100,20);
		 phone.setForeground(Color.black);
		 add(phone);

		 JLabel email=new JLabel("Email");
		 email.setBounds(790,10,100,20);
		 email.setForeground(Color.black);
		 add(email);
		 
		 JLabel adhar=new JLabel("Aadhar Card ");
		 adhar.setBounds(890,10,100,20);
		 adhar.setForeground(Color.black);
		 add(adhar);
		 
			back=new JButton("Back");
			back.setBounds(420,500,120,30);
			back.setBackground(Color.red);
			back.setForeground(Color.white);
			
			back.setFont(new Font("Tahoma",Font.BOLD,18));
			back.addActionListener(this);
			add(back);
			
		 
		
		
		setBounds(150,100,1000,600);
	    setVisible(true);
	
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new managerdetails();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			setVisible(false);
			new Reception();
			
		}
	}

}
