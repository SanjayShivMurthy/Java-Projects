
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainInterface extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] options1= {"-","Sleep","Restart","Shutdown","Hibernate","Log Off"};
		JComboBox comboBox = new JComboBox(options1);
		comboBox.setBounds(117, 11, 309, 32);
		contentPane.add(comboBox);
		
		JTextArea txtrSanj = new JTextArea();
		txtrSanj.setForeground(new Color(0, 255, 0));
		txtrSanj.setBackground(new Color(0, 0, 0));
		txtrSanj.setBounds(10, 313, 529, 132);
		contentPane.add(txtrSanj);
		
		JButton btnNewButton = new JButton("Execute");
		btnNewButton.setBackground(new Color(51, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(comboBox.getSelectedItem()=="Sleep")
				{

					try 
					{
						Runtime.getRuntime().exec("cmd /c RUNDLL32.EXE powrprof.dll,SetSuspendState 0,1,0", null, new File("C:\\Users\\"));
					} 
					catch (IOException e1) 
					{

						e1.printStackTrace();
					} 
					txtrSanj.setText("The System will Sleep in 30secs");
							
					
				}
				else if(comboBox.getSelectedItem()=="Restart")
				{
					//shutdown /r /t 0001
					txtrSanj.setText("The System will Restart in 30secs");
					try {
						
						Runtime.getRuntime().exec("cmd /c shutdown /r /t 0030", null, new File("C:\\Users\\"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(comboBox.getSelectedItem()=="Shutdown")
				{
					//shutdown /s /t 0001
					txtrSanj.setText("The System will Shutdown in 30secs");
					try {
						Runtime.getRuntime().exec("cmd /c shutdown /s /t 0030", null, new File("C:\\Users\\"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else if(comboBox.getSelectedItem()=="Hibernate")
				{
					//shutdown /h /t 0001
					txtrSanj.setText("The System will Hibernate in 30secs");
					try {
						//Runtime.getRuntime().exec("cmd /c timeout 30 && shutdown /h", null, new File("C:\\Users\\"));
						Runtime.getRuntime().exec("cmd /c shutdown /h", null, new File("C:\\Users\\"));
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(comboBox.getSelectedItem()=="Log Off")
				{
					//shutdown /l /t 0001
					txtrSanj.setText("The System will Logoff in 30secs");
					try {
							Runtime.getRuntime().exec("cmd /c shutdown /l", null, new File("C:\\Users\\"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			}
		});
		btnNewButton.setBounds(10, 65, 168, 42);
		contentPane.add(btnNewButton);
		
		JButton btnActivatewindows = new JButton("Logout");
		btnActivatewindows.setBackground(Color.YELLOW);
		btnActivatewindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				  GUILoginPage glp=new GUILoginPage();
				  glp.setVisible(true);
			}
		});
		btnActivatewindows.setBounds(193, 129, 168, 42);
		contentPane.add(btnActivatewindows);
		
		JButton btnAbort = new JButton("Abort");
		btnAbort.setBackground(new Color(255, 153, 0));
		btnAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				txtrSanj.setText("!!!!!!ABORTED!!!!!!");
				 if(comboBox.getSelectedItem()=="Hibernate" || comboBox.getSelectedItem()=="Log Off" || comboBox.getSelectedItem()=="Sleep")
				 {
					 try 
						{
							Runtime.getRuntime().exec("cmd /c exit", null, new File("C:\\Users\\"));
						} 
						catch (IOException e1) 
						{
							
							e1.printStackTrace();
						}
				 }
				 else
				 {
					 try 
						{
							Runtime.getRuntime().exec("cmd /c shutdown -a", null, new File("C:\\Users\\"));
						} 
						catch (IOException e1) 
						{
							
							e1.printStackTrace();
						}
				 }
			}
		});
		btnAbort.setBounds(193, 65, 168, 42);
		contentPane.add(btnAbort);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(371, 65, 168, 42);
		contentPane.add(btnExit);
		
		
	}
}
