import java.io.IOException;
import java.io.PrintWriter;
              import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/tocheck")
public class CheckServlet extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String sub=request.getParameter("sub");
int flag=0;
if(sub.equals("LOGIN"))
{
Cookie c[]=request.getCookies();
if(c!=null){
for(int i=0;i<c.length;i++){
if(c[i].getValue().equals("user")){
flag=1;
request.getRequestDispatcher("/table.jsp").forward(request,response);
}
}}
if(flag==0){
request.getRequestDispatcher("/login.jsp").forward(request,response);
}
}
else{
PrintWriter pw=response.getWriter();
pw.write("<br> NOT READY");
pw.close();
}
}
}
