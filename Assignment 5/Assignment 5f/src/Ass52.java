import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetBook")
public class Ass52 extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		try 
		{
			String bookid=request.getParameter("txtBookid");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Utsav1" ,"root","root");
			System.out.println("Database connected.");
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from book where Book_ID="+bookid);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			if(rs.next())
			{
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Book Details</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Book ID :"+bookid+"</h1>");
				out.println("<h3>Book Name :"+rs.getString("Book_Name")+"</h3>");
				out.println("<h3>Author :"+rs.getString("Author_Name")+"</h3>");
				out.println("<h3>Price :"+rs.getInt("Book_Price")+"</h3>");
				out.println("<h3>Quantity :"+rs.getString("Book_Qty")+"</h3>");
			//	out.println("<h3>Available :"+rs.getInt("available")+"</h3>");
			//	out.println("<h3>Publication :"+rs.getString("publication")+"</h3>");
				out.println("</body>");
				out.println("</html>");
			}
			else
			{
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Book Not Found</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Book ID :"+bookid+" Book Not Found!!</h1>");
				out.println("</body>");
				out.println("</html>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}



