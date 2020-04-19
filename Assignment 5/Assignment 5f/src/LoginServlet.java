import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/toLogin")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String us=request.getParameter("id");
String pa=request.getParameter("pass");
String kept=request.getParameter("keep");
if(us.equals("Masum") && pa.equals("MSU")){
HttpSession hs=request.getSession();   //it creates new Session
hs.setAttribute("direct","allow");    //String direct="allow";
if(kept!=null){
if(kept.equals("keepme")){
Cookie c1=new Cookie("valid","user");  //this cookie is checked before  login...so we have to check it in checkServlet
response.addCookie(c1);
}
}
request.getRequestDispatcher("/table.jsp").forward(request,response);
}
else{
PrintWriter pw=response.getWriter();
pw.write("<br><br> INVALID USER NAME OR PASSWORD");
pw.close();
}
}

}
