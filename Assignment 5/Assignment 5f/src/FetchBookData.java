import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
@WebServlet("/FetchBookData")
public class FetchBookData extends HttpServlet {
private static final long serialVersionUID = 1L;
public FetchBookData() {
super();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try{
PrintWriter pw=response.getWriter();
String a =request.getParameter("p2");
System.out.println(a);
Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bookdb", "root", "");
Statement stmt =  con.createStatement();
String id = a+"";
ResultSet rs = stmt.executeQuery("select * from book where Bookid='"+id+"'");
if(rs.next())
{
pw.write("<p>Book Id: "+rs.getString(1)+"<br>");
pw.write("Name: "+rs.getString(2)+"<br>");
pw.write("Author: "+rs.getString(3)+"<br>");
pw.write("Dop: "+rs.getString(4)+"<br>");
pw.write("Email: "+rs.getString(5)+"<br>");
pw.write("Price: "+rs.getString(6)+"<br>");
}
else
{
pw.write("<p>No such id found.....</p>");
}}
catch(Exception e){e.printStackTrace();}
}}
