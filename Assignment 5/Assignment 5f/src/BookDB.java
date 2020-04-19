import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDB

{

Connection con=null;

String driver = "com.mysql.jdbc.Driver";

String dbURL = "jdbc:mysql://localhost:3306/Utsav1";

ResultSet rs=null;

String str[]=null;


public String[] callMethod(int id1)

{
try

{
Class.forName(driver);
con=DriverManager.getConnection(dbURL,"root","");
String query="select * from book  where Book_Id="+id1;
Statement stmt=con.createStatement();
rs=stmt.executeQuery(query);
if(rs.next())

{
str=new String[6];
str[0]=Integer.toString(rs.getInt("Book_Id"));
str[1]=rs.getString("Book_Name");

str[2]=rs.getString("Author_Name");
str[3]=rs.getString("Book_Price");
str[4]=rs.getString("Book_Qty");
}
con.close();
rs.close();
stmt.close();
return str;
}
catch(SQLException e)
{
System.out.println(e);

}
catch(Exception e1)
{
System.out.println(e1);
}
return new String[1];
}
}
