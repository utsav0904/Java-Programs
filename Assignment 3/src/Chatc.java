import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Chatc {

	public static void main(String[] args) {
		try
		{
		 Socket server=new Socket("localhost",555);	
		      
		 System.out.println("\n SERVER CONNECTED..."); 
		
		 InetAddress ip=server.getInetAddress();
		 System.out.println("\n CLIENT ="+ip.getHostAddress()+"\n NAME = "+ip.getHostName());
		 
		 DataInputStream dis=new DataInputStream(server.getInputStream());
		 
		 DataOutputStream dos=new DataOutputStream(server.getOutputStream());
		 
		 String msg=dis.readUTF();  
		 System.out.println("SERVER="+msg);
		 
		
		 Scanner scan=new Scanner(System.in);
		 
		 while(!msg.equals("QUIT"))
		 {
			 System.out.println("\n  SERVER= ");
			 msg=scan.nextLine();
			 dos.writeUTF(msg);
			 
			 msg=dis.readUTF();
			 System.out.println("\n SERVER= "+msg);
			 
		 }
		 
		 dis.close();
		 dos.close();
		 server.close();
		}
		
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR "+e.getMessage());
		}
	}

}
