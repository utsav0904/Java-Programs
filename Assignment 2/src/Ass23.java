import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.CallableStatement;

public class Ass23 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
       
        try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Utsav1";
		String user="root";
		String pwd="";
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("Connected to DataBase"); 
       
		CallableStatement csmt=(CallableStatement) con.prepareCall("{call updateR()}");
		csmt.execute();
	    
		System.out.println("Price Updated Using PL/SQL Procedure"); 
	       }catch(Exception e) {
   System.out.println("Error"+e);	 
 }
 }
}
