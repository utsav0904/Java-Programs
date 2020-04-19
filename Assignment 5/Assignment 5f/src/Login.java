import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class Login extends HttpServlet {
private static final long serialVersionUID = 1L;


protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String user=request.getParameter("id");
String pa=request.getParameter("pass");
             if(user.equals("Masum") && pa.equals("me@7421")){
request.getRequestDispatcher("/success.html").forward(request,response);

}
else{
request.getRequestDispatcher("/error.html").forward(request, response);
}
}
}
