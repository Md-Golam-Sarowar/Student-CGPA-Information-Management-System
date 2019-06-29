package com.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main_frame extends JFrame {
	
	
	JPanel panel_main =new JPanel();
	JPanel panel_center =new JPanel();
	JPanel panel_north =new JPanel();
	JPanel panel_south =new JPanel();
	
	
	JLabel lbl_student_id =new JLabel("Student ID");
	JLabel lbl_student_name=new JLabel("Name");
	//JLabel lbl_mobile =new JLabel("Mobile");
	//JLabel lbl_email=new JLabel("Email");
	
	JLabel lbl_1st_semester =new JLabel("1st Semester GPA");
	JLabel lbl_2nd_semester =new JLabel("2nd Semester GPA");
	JLabel lbl_3rd_semester =new JLabel("3rd Semester GPA");
	JLabel lbl_4th_semester =new JLabel("4th Semester GPA");
	JLabel lbl_5th_semester =new JLabel("5th Semester GPA");
	JLabel lbl_6th_semester =new JLabel("6th Semester GPA");
	JLabel lbl_7th_semester =new JLabel("7th Semester GPA");
	JLabel lbl_8th_semester =new JLabel("8th Semester GPA");
	//JLabel lbl_9th_semester =new JLabel("9th Semester GPA");
	//JLabel lbl_10th_semester =new JLabel("10th Semester GPA");
	//JLabel lbl_11th_semester =new JLabel("11th Semester GPA");
	//JLabel lbl_12th_semester =new JLabel("12th Semester GPA");
	
	
	JLabel lbl_1st_credit =new JLabel("Credit");
	JLabel lbl_2nd_credit =new JLabel("Credit");
	JLabel lbl_3rd_credit =new JLabel("Credit");
	JLabel lbl_4th_credit =new JLabel("Credit");
	JLabel lbl_5th_credit =new JLabel("Credit");
	JLabel lbl_6th_credit =new JLabel("Credit");
	JLabel lbl_7th_credit =new JLabel("Credit");
	JLabel lbl_8th_credit =new JLabel("Credit");
	//JLabel lbl_9th_credit =new JLabel("Credit");
	//JLabel lbl_10th_credit =new JLabel("Credit");
	//JLabel lbl_11th_credit =new JLabel("Credit");
	//JLabel lbl_12th_credit =new JLabel("Credit");
	
	JTextField txt_student_id =new JTextField(15);
	JTextField txt_student_name =new JTextField(15);
	//JTextField txt_mobile =new JTextField(15);
	//JTextField txt_email =new JTextField(15);
	JTextField txt_1st_semester =new JTextField(15);
	JTextField txt_2nd_semester =new JTextField(15);
	JTextField txt_3rd_semester =new JTextField(15);
	JTextField txt_4th_semester =new JTextField(15);
	JTextField txt_5th_semester =new JTextField(15);
	JTextField txt_6th_semester =new JTextField(15);
	JTextField txt_7th_semester =new JTextField(15);
	JTextField txt_8th_semester =new JTextField(15);
	//JTextField txt_9th_semester =new JTextField(15);
	//JTextField txt_10th_semester =new JTextField(15);
	//JTextField txt_11th_semester =new JTextField(15);
	//JTextField txt_12th_semester =new JTextField(15);
	
	
	JTextField txt_1st_credit =new JTextField(15);
	JTextField txt_2nd_credit =new JTextField(15);
	JTextField txt_3rd_credit =new JTextField(15);
	JTextField txt_4th_credit =new JTextField(15);
	JTextField txt_5th_credit =new JTextField(15);
	JTextField txt_6th_credit =new JTextField(15);
	JTextField txt_7th_credit =new JTextField(15);
	JTextField txt_8th_credit =new JTextField(15);
	//JTextField txt_9th_credit =new JTextField(15);
	//JTextField txt_10th_credit =new JTextField(15);
	//JTextField txt_11th_credit =new JTextField(15);
	//JTextField txt_12th_credit =new JTextField(15);
	
	JTextField txt_search =new JTextField(30);
	
	JButton btn_add =new JButton("Add");
	JButton btn_edit =new JButton("Edit");
	JButton btn_delete =new JButton("Delete");
	JButton btn_view_cgpa =new JButton("View CGPA");
	JButton btn_search =new JButton("Search");
	
	GridBagConstraints c=new GridBagConstraints();
	

	public Main_frame() {
		
		
		Initialization();
		Components();
		btnAction();
		
	}
	
	public void btnAction() {
		
		btn_add.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
		int credit_1st=Integer.parseInt(txt_1st_credit.getText());
		int credit_2nd=Integer.parseInt(txt_2nd_credit.getText());
		int credit_3rd=Integer.parseInt(txt_3rd_credit.getText()); 
		int credit_4th=Integer.parseInt(txt_4th_credit.getText());
		int credit_5th=Integer.parseInt(txt_5th_credit.getText());
		int credit_6th=Integer.parseInt(txt_6th_credit.getText());
		int credit_7th=Integer.parseInt(txt_7th_credit.getText());
		int credit_8ht=Integer.parseInt(txt_8th_credit.getText());
		double gpa_1st=Double.valueOf(txt_1st_semester.getText())*credit_1st;
		double gpa_2nd=Double.valueOf(txt_2nd_semester.getText())*credit_2nd;
		double gpa_3rd=Double.valueOf(txt_3rd_semester.getText())*credit_3rd;
		double gpa_4th=Double.valueOf(txt_4th_semester.getText())*credit_4th; 
		double gpa_5th=Double.valueOf(txt_5th_semester.getText())*credit_5th;
		double gpa_6th=Double.valueOf(txt_6th_semester.getText())*credit_5th;
		double gpa_7th=Double.valueOf(txt_7th_semester.getText())*credit_7th;
		double gpa_8ht=Double.valueOf(txt_8th_semester.getText())*credit_8ht;
		double gpa=gpa_1st+gpa_2nd+gpa_3rd+gpa_4th+gpa_5th+gpa_6th+gpa_7th+gpa_8ht;
		int credit=credit_1st+credit_2nd+credit_3rd+credit_4th+credit_5th+
		credit_6th+credit_7th+credit_8ht;
		
		double cgpa=gpa/credit;
		try {
		String sql="insert into result values('"+txt_student_id.getText().trim()+"','"+txt_student_name.getText().trim()+"','"+txt_1st_semester.getText().trim()+"','"+txt_2nd_semester.getText().trim()+"','"+txt_3rd_semester.getText().trim()+"','"+txt_4th_semester.getText().trim()+"','"+txt_5th_semester.getText().trim()+"','"+txt_6th_semester.getText().trim()+"','"+txt_7th_semester.getText().trim()+"','"+txt_8th_semester.getText().trim()+"','"+txt_1st_credit.getText().trim()+"','"+txt_2nd_credit.getText().trim()+"','"+txt_3rd_credit.getText().trim()+"','"+txt_4th_credit.getText().trim()+"','"+txt_5th_credit.getText().trim()+"','"+txt_6th_credit.getText().trim()+"','"+txt_7th_credit.getText().trim()+"','"+txt_8th_credit.getText().trim()+"','"+cgpa+"')";
		//db.sta.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "New Record Insert Successfull.....");
		}
		catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
		}
		}});
		
		
		btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
			int credit_1st=Integer.parseInt(txt_1st_credit.getText());
			int credit_2nd=Integer.parseInt(txt_2nd_credit.getText());
			int credit_3rd=Integer.parseInt(txt_3rd_credit.getText());
			int credit_4th=Integer.parseInt(txt_4th_credit.getText());
			int credit_5th=Integer.parseInt(txt_5th_credit.getText());
			int credit_6th=Integer.parseInt(txt_6th_credit.getText());
			int credit_7th=Integer.parseInt(txt_7th_credit.getText());
			int credit_8ht=Integer.parseInt(txt_8th_credit.getText());
			double gpa_1st=Double.valueOf(txt_1st_semester.getText())*credit_1st;
			double gpa_2nd=Double.valueOf(txt_2nd_semester.getText())*credit_2nd;
			double gpa_3rd=Double.valueOf(txt_3rd_semester.getText())*credit_3rd;
			double gpa_4th=Double.valueOf(txt_4th_semester.getText())*credit_4th;
			double gpa_5th=Double.valueOf(txt_5th_semester.getText())*credit_5th;
			double gpa_6th=Double.valueOf(txt_6th_semester.getText())*credit_5th;
			double gpa_7th=Double.valueOf(txt_7th_semester.getText())*credit_7th;
			double gpa_8ht=Double.valueOf(txt_8th_semester.getText())*credit_8ht;
			double gpa=gpa_1st+gpa_2nd+gpa_3rd+gpa_4th+gpa_5th+gpa_6th+gpa_7th+gpa_8ht;
			int credit=credit_1st+credit_2nd+credit_3rd+credit_4th+credit_5th+credit_6th+credit_7th+credit_8ht;
			double cgpa=gpa/credit;
			String cgpa1=Double.toString(cgpa);
			String sql="update result setstudent_id='"+txt_student_id.getText().trim()+"',student_name='"+txt_student_name.getText().trim()+"',gpa_1st='"+txt_1st_semester.getText().trim()+"',gpa_2nd='"+txt_2nd_semester.getText().trim()+"',gpa_3rd='"+txt_3rd_semester.getText().trim()+"',gpa_4th='"+txt_4th_semester.getText().trim()+"',gpa_5th='"+txt_5th_semester.getText().trim()+"',gpa_6th='"+txt_6th_semester.getText().trim()+"',gpa_7th='"+txt_7th_semester.getText().trim()+"',gpa_8th='"+txt_8th_semester.getText().trim()+"',credit1='"+txt_1st_credit.getText().trim()+"',credit2='"+txt_2nd_credit.getText().trim()+"',credit3='"+txt_3rd_credit.getText().trim()+"',credit4='"+txt_4th_credit.getText().trim()+"',credit5='"+txt_5th_credit.getText().trim()+"',credit6='"+txt_6th_credit.getText().trim()+"',credit7='"+txt_7th_credit.getText().trim()+"',credit8='"+txt_8th_credit.getText().trim()+"',cgpa='"+cgpa1+"' wherestudent_id='"+txt_search.getText().trim()+"'";
			//db.sta.executeUpdate(sql); 
			JOptionPane.showMessageDialog(null, "Update Data Success....");
					
			}
			
			catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
			}
			});
		
		
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
			String sql="delete from result where student_id='"+txt_student_id.getText().toString()+"'";
			db.sta.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Delete Data Success....");
			}
			catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
			}
			});
		
		
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
			String sql="select * from result wherestudent_id='"+txt_search.getText().trim()+"'";
			ResultSet rs=db.sta.executeQuery(sql);
			while(rs.next())
			{
			txt_student_id.setText(rs.getString("student_id"));
			txt_student_name.setText(rs.getString("student_name"));
			txt_1st_semester.setText(rs.getString("gpa_1st"));
			txt_2nd_semester.setText(rs.getString("gpa_2nd"));
			txt_3rd_semester.setText(rs.getString("gpa_3rd"));
			txt_4th_semester.setText(rs.getString("gpa_4th"));
			txt_5th_semester.setText(rs.getString("gpa_5th"));
			txt_6th_semester.setText(rs.getString("gpa_6th"));
			txt_7th_semester.setText(rs.getString("gpa_7th"));
			txt_8th_semester.setText(rs.getString("gpa_8th"));
			txt_1st_credit.setText(rs.getString("credit1"));
			txt_2nd_credit.setText(rs.getString("credit2"));
			txt_3rd_credit.setText(rs.getString("credit3"));
			txt_4th_credit.setText(rs.getString("credit4"));
			txt_5th_credit.setText(rs.getString("credit5"));
			txt_6th_credit.setText(rs.getString("credit6"));
			txt_7th_credit.setText(rs.getString("credit7"));
			txt_8th_credit.setText(rs.getString("credit8"));
			}
			}
			catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
			}
			});
		
		btn_view_cgpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JFrame fr=new JFrame();
			fr.setVisible(true);
			fr.setSize(444,444);
			fr.setLocationRelativeTo(null);
			fr.setTitle("TERM CGPA");
			final JTextField txt=new JTextField(11);
			JButton b=new JButton("CGPA");
			fr.setLayout(new FlowLayout());
			fr.add(txt);
			fr.add(b);
			b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
			String s="select cgpa from result where student_id='"+txt.getText().trim()+"'";
			ResultSet rs=db.sta.executeQuery(s);
			while(rs.next())
			{
			String bbb=rs.getString("cgpa");
			JOptionPane.showMessageDialog(null, bbb);
			}
			}
			catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
			}
			});
			}
			});
		
	}
	
	public void Components() {
		
		add (panel_main);
		panel_main.setLayout(new BorderLayout());
		panel_main.add(panel_center,BorderLayout.CENTER);
		panel_main.add(panel_north, BorderLayout.NORTH);
		panel_main.add(panel_south,BorderLayout.SOUTH);
		
		center_panel_work();
		north_panel_work();
		south_panel_work();
	    
		
	}

	private void south_panel_work() {
		
		panel_south.setLayout(new FlowLayout());
		panel_south.add(btn_add);
		panel_south.add(btn_edit);
		panel_south.add(btn_delete);
		panel_south.add(btn_view_cgpa);
		
		
	}

	private void north_panel_work() {
		
		panel_north.setLayout(new FlowLayout());
		panel_north.add(txt_search);
		panel_north.add(btn_search);
				
		
	}

	private void center_panel_work() {
		
		panel_center.setLayout(new GridBagLayout());
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panel_center.add(lbl_student_id,c);
		c.gridx=1;
		c.gridy=0;
		panel_center.add(txt_student_id,c);
		c.gridx=2;
		c.gridy=0;
		panel_center.add(lbl_student_name,c);
		c.gridx=3;
		c.gridy=0;
		panel_center.add(txt_student_name,c);
		c.gridx=0;
		c.gridy=1;
		//panel_center.add(lbl_mobile, c);
		c.gridx=1;
		c.gridy=1;
		//panel_center.add(txt_mobile, c);	
		c.gridx=2;
		c.gridy=1;
		//panel_center.add(lbl_email, c);
		c.gridx=3;
		c.gridy=1;
		//panel_center.add(txt_email, c);
		c.gridx=0;
		c.gridy=2;
		panel_center.add(lbl_1st_semester,c);
		c.gridx=1;
		c.gridy=2;
		panel_center.add(txt_1st_semester,c);
		c.gridx=2;
		c.gridy=2;
		panel_center.add(lbl_1st_credit,c);
		c.gridx=3;
		c.gridy=2;
		panel_center.add(txt_1st_credit,c);
		c.gridx=0;
		c.gridy=3;
		panel_center.add(lbl_2nd_semester,c);
		c.gridx=1;
		c.gridy=3;
		panel_center.add(txt_2nd_semester,c);
		c.gridx=2;
		c.gridy=3;
		panel_center.add(lbl_2nd_credit,c);
		c.gridx=3;
		c.gridy=3;
		panel_center.add(txt_2nd_credit,c);
		c.gridx=0;
		c.gridy=4;
		panel_center.add(lbl_3rd_semester,c);
		c.gridx=1;
		c.gridy=4;
		panel_center.add(txt_3rd_semester,c);
		c.gridx=2;
		c.gridy=4;
		panel_center.add(lbl_3rd_credit,c);
		c.gridx=3;
		c.gridy=4;
		panel_center.add(txt_3rd_credit,c);
		c.gridx=0;
		c.gridy=5;
		panel_center.add(lbl_4th_semester,c);
		c.gridx=1;
		c.gridy=5;
		panel_center.add(txt_4th_semester,c);
		c.gridx=2;
		c.gridy=5;
		panel_center.add(lbl_4th_credit,c);
		c.gridx=3;
		c.gridy=5;
		panel_center.add(txt_4th_credit,c);
		c.gridx=0;
		c.gridy=6;
		panel_center.add(lbl_5th_semester,c);
		c.gridx=1;
		c.gridy=6;
		panel_center.add(txt_5th_semester,c);
		c.gridx=2;
		c.gridy=6;
		panel_center.add(lbl_5th_credit,c);
		c.gridx=3;
		c.gridy=6;
		panel_center.add(txt_5th_credit,c);
		c.gridx=0;
		c.gridy=7;
		panel_center.add(lbl_6th_semester,c);
		c.gridx=1;
		c.gridy=7;
		panel_center.add(txt_6th_semester,c);
		c.gridx=2;
		c.gridy=7;
		panel_center.add(lbl_6th_credit,c);
		c.gridx=3;
		c.gridy=7;
		panel_center.add(txt_6th_credit,c);
		c.gridx=0;
		c.gridy=8;
		panel_center.add(lbl_7th_semester,c);
		c.gridx=1;
		c.gridy=8;
		panel_center.add(txt_7th_semester,c);
		c.gridx=2;
		c.gridy=8;
		panel_center.add(lbl_7th_credit,c);
		c.gridx=3;
		c.gridy=8;
		panel_center.add(txt_7th_credit,c);
		c.gridx=0;
		c.gridy=9;
		panel_center.add(lbl_8th_semester,c);
		c.gridx=1;
		c.gridy=9;
		panel_center.add(txt_8th_semester,c);
		c.gridx=2;
		c.gridy=9;
		panel_center.add(lbl_8th_credit,c);
		c.gridx=3;
		c.gridy=9;
		panel_center.add(txt_8th_credit,c);
		c.gridx=0;
		c.gridy=10;
		//panel_center.add(lbl_9th_semester,c);
		c.gridx=1;
		c.gridy=10;
		//panel_center.add(txt_9th_semester,c);
		c.gridx=2;
		c.gridy=10;
		//panel_center.add(lbl_9th_credit,c);
		c.gridx=3;
		c.gridy=10;
		//panel_center.add(txt_9th_credit,c);
		c.gridx=0;
		c.gridy=11;
		//panel_center.add(lbl_10th_semester,c);
		c.gridx=1;
		c.gridy=11;
		//panel_center.add(txt_10th_semester,c);
		c.gridx=2;
		c.gridy=11;
		//panel_center.add(lbl_10th_credit,c);
		c.gridx=3;
		c.gridy=11;
		//panel_center.add(txt_10th_credit,c);
		c.gridx=0;
		c.gridy=12;
		//panel_center.add(lbl_11th_semester,c);
		c.gridx=1;
		c.gridy=12;
		//panel_center.add(txt_11th_semester,c);
		c.gridx=2;
		c.gridy=12;
		//panel_center.add(lbl_11th_credit,c);
		c.gridx=3;
		c.gridy=12;
		//panel_center.add(txt_11th_credit,c);
		c.gridx=0;
		c.gridy=13;
		//panel_center.add(lbl_12th_semester,c);
		c.gridx=1;
		c.gridy=13;
		//panel_center.add(txt_12th_semester,c);
		c.gridx=2;
		c.gridy=13;
		//panel_center.add(lbl_12th_credit,c);
		c.gridx=3;
		c.gridy=13;
		//panel_center.add(txt_12th_credit,c);
		
		
	}
	

	public void Initialization() {
		
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("STUDENT INFORMATION");
		
	}
	

	public static void main(String[] args) {
		
		
		Main_frame mf=new Main_frame();
		

	}

}
