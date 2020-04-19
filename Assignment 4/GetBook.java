import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class GetBook extends UnicastRemoteObject implements IGetBook
{	GetBook()throws RemoteException
	{}
					String s="";	
	public String getBook(int id)throws RemoteException
	{			
					int a,b;
            		String s1,s2;
					ResultSet rs;
					Connection con;
	
		 try{
            		Class.forName("com.mysql.jdbc.Driver");  
            		con=(Connection)DriverManager.getConnection(  
            		"jdbc:mysql://localhost:5000/book","root","12345");  
            
            		Statement stmt= (Statement) con.createStatement();  
            		
            		rs=stmt.executeQuery("select * from book where book_id="+id);
					rs.next() ; 
					s1 = rs.getString(2);
					s2 = rs.getString(3);
					a = rs.getInt(1);
					b = rs.getInt(4);
					con.close();
					s = "Book ID = "+a+"\n"+"Book Name = "+s1+"\n"+"Author = "+s2+"\n"+"Price = "+b+"\n";
			
		 }
catch(Exception e){}		 
      
					
	return s;

            
        
		
				
	}
	
}