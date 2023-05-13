package mypack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login_op
 */
public class Login_op extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/History_Book","root","syk@2003");
			String que = "select * from admin_login where username = '"+user+"' and pass = '"+pass+"'";
			PreparedStatement st = con.prepareStatement(que);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("adminPanel.html");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception :" + e);
		}
	}

}
