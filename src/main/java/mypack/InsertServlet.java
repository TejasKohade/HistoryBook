package mypack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


@MultipartConfig
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String title = request.getParameter("title");
			String description = request.getParameter("desc");
			Part file = request.getPart("image");
			String imgName = file.getSubmittedFileName();
			System.out.println("Image name:"+imgName);
			PrintWriter pr = response.getWriter();
			
			//Add image to project
			String uploadPath = "C:/Users/Shravani/Documents/Java files/Shravani_practice/HistoryBook/src/main/webapp/images/contentImages/"+imgName;
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			
			//Database connection
			String query = "insert into hist_info values(?,?,?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/History_Book","root","syk@2003");
			PreparedStatement ps =con.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2,description);
			ps.setString(3, "images/contentImages/"+imgName);
			int x = ps.executeUpdate();	
			if(x>0) {
				request.setAttribute("heading", "Insert");
				RequestDispatcher rd = request.getRequestDispatcher("popup.jsp");
				rd.forward(request, response);
			}
			else {
				pr.println("Something went wrong");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception :" + e);
		}
	}

}
