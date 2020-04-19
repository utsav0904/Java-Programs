import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Chats {

	public static void main(String[] args) {
		
		try
		{
			ServerSocket ser=new ServerSocket(555);
			System.out.println("\n SERVER IS WAITING.");
			
			 Socket client=ser.accept(); //accept method so that the server waits for the client
			
			 System.out.println("\n CLIENT CONNECTED.");
			
			 InetAddress ip=client.getInetAddress();
			 
			 System.out.println("\n CLIENT ="+ip.getHostAddress()+"\n NAME = "+ip.getHostName());
			 
			 DataInputStream dis=new DataInputStream(client.getInputStream());
			 DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			
			 dos.writeUTF("WELCOME CLIENT!WHAT CAN I DO FOR YOU!!!!");
			 
			 //read from keyboard
			 Scanner scan=new Scanner(System.in);
			 String msg="";
			 while(!msg.equals("QUIT"))
			 {
				 msg=dis.readUTF();
				 System.out.println("CLIENT= "+msg);
				 
				 System.out.println("\n CLIENT= ");
				 msg=scan.nextLine();
				 dos.writeUTF(msg);
				 
				 
			 }
			 
			 dis.close();
			 dos.close();
			client.close();
			ser.close();
		}
		
		catch(Exception e)
		{
			System.out.println("\n SERVER ERROR "+e.getMessage());
		}

	}

}
