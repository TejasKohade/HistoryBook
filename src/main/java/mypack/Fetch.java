package mypack;

import jakarta.servlet.RequestDispatcher;
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

public class Fetch extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String sea = request.getParameter("search");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/History_Book","root","syk@2003");
			String que = "select * from hist_info where title like '%"+sea+"%'";
			PreparedStatement st = con.prepareStatement(que);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				String title = rs.getString(1);
				String description = rs.getString(2);
				String image = rs.getString(3);
				request.setAttribute("heading", title);
				request.setAttribute("photo", image);
				request.setAttribute("content", description);
				RequestDispatcher rd = request.getRequestDispatcher("contentPage.jsp");
				rd.forward(request, response);
		    }
		}
		catch(Exception e)
		{
			System.out.println("Exception :" + e);
		}
	}

}