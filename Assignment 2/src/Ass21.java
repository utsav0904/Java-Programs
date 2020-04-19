import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSet;

import java.sql.PreparedStatement;


public class Ass21 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
        int id,price,qty,ch;
        String bookn="";
        String authn="";
        boolean flag=true;
       PreparedStatement psmt=null;
       
        try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Utsav1";
		String user="root";
		String pwd="";
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("Connected to DataBase"); 
        
        
		DatabaseMetaData dbm=(DatabaseMetaData) con.getMetaData();
		ResultSet rs=(ResultSet) dbm.getTables(null, null, "book", null);
		
		if(rs.next()) {
		  System.out.println("Table Book Already Exist !!");
		}
		else {
			 Statement st=con.createStatement();
			 st.execute("create table book ( Book_Id INT(6) PRIMARY KEY, Book_Name VARCHAR(30) , Auther_Name VARCHAR(30) , Book_Price INT(6), Book_Qty INT(6))");
		
		System.out.println("Table Created Successfully !!");
		}
		
		
		Scanner scan = new Scanner(System.in); 
		
	do {	
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Exit");
		
		ch=Integer.parseInt(scan.nextLine());
		
		
		switch(ch) {
		
		case 1:
			try {
			 psmt=con.prepareStatement("insert into book values(?,?,?,?,?)");
			
			System.out.println("Enter Book Id->");
			id=scan.nextInt();scan.nextLine();
			System.out.println("Enter Book Name->");
			bookn=scan.nextLine();
			System.out.println("Enter Auther Name->");
			authn=scan.nextLine();
			System.out.println("Enter Book Price->");
			price=scan.nextInt();
			System.out.println("Enter Book Quantity->");
			qty=scan.nextInt();
			
			psmt.setInt(1,id);
			psmt.setString(2,bookn);
			psmt.setString(3,authn);
			psmt.setInt(4,price);
			psmt.setInt(5,qty);
			
			psmt.execute();
            			
			System.out.println("Data Inserted Successfully !!");
			psmt.close();
			} catch(Exception e)  
		    {  
			    System.out.println("Error:"+e);  
			    
			    }      
	      break;
	      
		case 2: 
			  
			  try  
			   {  
			    System.out.println("Enter Book Id to Update Price:");  
			    String bid1=scan.nextLine();   
			    psmt=con.prepareStatement("update book set Book_Price=190 where Book_Id='"+bid1+"'");  
			    psmt.execute();  
			    System.out.println("Price Updated Suceessfully!!");  
			   
			   }  
			    catch(Exception e)  
			    {  
			    System.out.println("Error:"+e);  
			    
			    }     
			
			break;
		 
		case 3: 
			 try  
			   {  
			       System.out.println("Eneter Book Id to Delete:");  
			       int id2=scan.nextInt();  
			       
			    psmt=con.prepareStatement("delete from book where Book_Id="+"'"+id2+"' ");
			   	psmt.execute();
			   	psmt.close();
			   	
			   	System.out.println("Row Deleted Successfully!!");
			   	
			   }  
			    catch(Exception e)  
			    {  
			    System.out.println("Error:"+e);  
			    
			    }     
			break;
		
		case 4: System.exit(1);
		         break;
		
	       	
		}
		//System.out.println("do u want to continue(yes /no)");  
		 String str=scan.nextLine();  
		 if(str.equals("yes")|| str.equals("y"))  
		 flag=true;  
		 if(str.equals("no")||str.equals("n"))  
		 flag=false;  
		 
	}while(flag);
	
	
		
		con.close();
	
	}catch(Exception e) {
    	System.out.println("Error:"+e);
    }
  }
}
