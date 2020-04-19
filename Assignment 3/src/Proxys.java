import java.net.*;
import java.io.*;
import java.util.*;

public class Proxys
{
public static void main(String[] st)
{

try
{
ServerSocket server=new ServerSocket(3000);


Socket client=server.accept();
InetAddress ip=client.getInetAddress();

System.out.println("\n WEL-COME CLIENT:"+ip.getHostAddress()+" "+ip.getHostName());
DataInputStream dis=new DataInputStream(client.getInputStream());
DataOutputStream dos=new DataOutputStream(client.getOutputStream());
Scanner scan=new Scanner(System.in);
String msg=" ";
	while(!msg.equals("quit"))
	{
	System.out.print("\n msg to client :-");
	msg=scan.nextLine();
	dos.writeUTF(msg);
	msg=dis.readUTF();
	System.out.println("msg from client :- "+msg);
	}
dis.close();
dos.close();
client.close();
server.close();
}
catch(Exception e)
{
System.out.println("\n server error: "+e.getMessage());
}
}
}
