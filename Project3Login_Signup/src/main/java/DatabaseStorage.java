

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet("/DatabaseStorage")
public class DatabaseStorage extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try {
			PrintWriter out=response.getWriter();
			  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/learningdb","root","");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from useraccounts1");
			String s1=request.getParameter("t1");
			String s2=request.getParameter("t2");
			int i=0;
			while(rs.next()) 
			  { 
				  if(s1.equals(rs.getString("uname")) || s1.equals(rs.getString("email")))
				  {
					  i=1;
					  if(s2.equals(rs.getString("pass")))
					  {
						  out.print("<html>" + "<head>" + "</head>" + "<body>" + "</body>" + "<script>"
								  + "function func2()" + "{window.location.href=\"Horus2.html\";}" + "func2();" +
								  "</script>" + "</html>");
					  }
					  
				  }
				  
			  }
			if(i==0)
			{
				out.print("<html>" + "<head>" + "</head>" + "<body>" + "</body>" + "<script>"
						  + "function func2()" + "{window.location.href=\"LoginPage.html\";alert(\"Entered Username or Email-ID is invalid\");}" + "func2();" +
						  "</script>" + "</html>");
			}
			else if(i==1)
			{
				out.print("<html>" + "<head>" + "</head>" + "<body>" + "</body>" + "<script>"
						  + "function func2()" + "{window.location.href=\"LoginPage.html\";alert(\"Entered Password is invalid\");}" + "func2();" +
						  "</script>" + "</html>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			PrintWriter out=response.getWriter();
			  out.print("<html>" + "<head>" + "</head>" + "<body>" + "</body>" + "<script>"
			  + "function func2()" + "{window.location.href=\"LoginPage.html\";}" + "func2();" +
			  "</script>" + "</html>");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/learningdb","root","");
			PreparedStatement ps=con.prepareStatement("insert into useraccounts1 values(?,?,?,?,?)");
			ps.setString(1, request.getParameter("t1"));
			ps.setString(2, request.getParameter("t2"));
			ps.setString(3, request.getParameter("t3"));
			ps.setString(4, request.getParameter("t4"));
			ps.setString(5, request.getParameter("t5"));
			ps.executeUpdate();
			
			
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		 
		
	}

}
