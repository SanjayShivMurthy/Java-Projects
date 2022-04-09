import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class GUILoginPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILoginPage frame = new GUILoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUILoginPage() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 11, 161, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(101, 61, 72, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(101, 119, 72, 26);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 119, 132, 25);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(197, 61, 132, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String s1=textField.getText().toLowerCase();
				String s2=passwordField.getText();
				
				
				passwordField.setText("");
				textField.setText("");
				
				
				
				try 
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learningdb","root","");
					Statement s=con.createStatement();
					ResultSet rs=s.executeQuery("select * from loginpage1");
					int i=0;
					
					
					  while(rs.next()) 
					  { 
						  if(s1.equals(rs.getString("name")) && s2.equals(rs.getString("pass")))
						  {
							  JOptionPane.showMessageDialog(btnNewButton, "Login Successful");
							  setVisible(false);
							  MainInterface mi=new MainInterface();
							  mi.setVisible(true);	
							  i=1;
						  }	   
					  }
					  if(i==0)
					  JOptionPane.showMessageDialog(btnNewButton, "Invalid Username or Password");
					  
					 
					rs.close();
					con.close();
					
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(166, 191, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}
