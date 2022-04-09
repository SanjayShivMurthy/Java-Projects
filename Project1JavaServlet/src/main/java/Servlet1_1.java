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






@WebServlet("/Servlet1_1")
public class Servlet1_1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learningdb","root","");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from loginpage1");
			PrintWriter out =response.getWriter();
			out.print("ID   ");out.print("NAME   ");out.print("PASSWORD");
			while(rs.next())
			{
				out.println();
				out.print(rs.getString("id")+"  ");out.print(rs.getString("name")+"  ");out.print(rs.getString("pass")+"  ");
				
			}
			rs.close();
			con.close();
			
			
			
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learningdb","root","");
			String check = request.getParameter("r1");		
			if(check.equals("b"))
			{
			PrintWriter out = response.getWriter();
			out.print("Inserted");
			PreparedStatement ps=con.prepareStatement("insert into loginpage1 values(?,?,?)");
			ps.setString(1, request.getParameter("t1"));
			ps.setString(2, request.getParameter("t2"));
			ps.setString(3, request.getParameter("t3"));
			ps.executeUpdate();
			
			}
			else if(check.equals("a"))
			{
				PrintWriter out = response.getWriter();
				out.print("Updated");
				PreparedStatement ps=con.prepareStatement("UPDATE loginpage1 SET name=?,pass=? WHERE id = ?");
				ps.setString(1, request.getParameter("t2"));
				ps.setString(2, request.getParameter("t3"));
				ps.setString(3, request.getParameter("t1"));
				ps.executeUpdate();
			}
			else if(check.equals("c"))
			{
				PrintWriter out = response.getWriter();
				out.print("deleted");
				PreparedStatement ps=con.prepareStatement("DELETE FROM loginpage1 where id = ?");
				ps.setString(1, request.getParameter("t1"));
				ps.executeUpdate();
			}
			
			
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
