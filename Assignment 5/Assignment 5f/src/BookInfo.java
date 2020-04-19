import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookInfo")
public class BookInfo extends HttpServlet
{
public void doGet(HttpServletRequest hsreq,HttpServletResponse hsres) throws ServletException,IOException
{
BookDB obook=new BookDB();
hsres.setContentType("text/html");
int id1=Integer.parseInt(hsreq.getParameter("id"));
String str[]=obook.callMethod(id1);
PrintWriter out=hsres.getWriter();

hsres.setContentType("text/html");

if(str.length<0)

{
out.println("<html>");
out.println("<head>");
out.println("</head>");
out.println("<body>");
out.println("No book found");
out.println("</body>");
out.println("</html>");
}
else
{
out.println("<html>");
out.println("<head>");
out.println("</head>");
out.println("<body>");
out.println("Book id: "+str[0]+"<br/>");
out.println("Book Title: "+str[1]+"<br/>");
out.println("Book Author: "+str[2]+"<br/>");
out.println("Book price: "+str[3]+"<br/>");
out.println("Book Quantity: "+str[4]+"<br/>");
out.println("</body>");
out.println("</html>");
}
}
}
