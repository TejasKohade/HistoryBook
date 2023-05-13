package mypack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet 
{
	private Connection con;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String title = request.getParameter("title");
			String que = "Delete from hist_info where title = '"+title+"'";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/History_Book","root","syk@2003");
			Statement st =con.createStatement();
			st.executeUpdate(que);	
			request.setAttribute("heading", "Delete");
			RequestDispatcher rd = request.getRequestDispatcher("popup.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println("Exception :" + e);
		}
	}

}
