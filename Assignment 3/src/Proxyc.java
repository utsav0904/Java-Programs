import java.io.*;
import java.net.*;
import java.util.*;
public class Proxyc
{
public static void main(String[]st)
{
try
{
Socket ser=new Socket("127.0.0.1",4000);
DataInputStream dis=new DataInputStream(ser.getInputStream());
DataOutputStream dos=new DataOutputStream(ser.getOutputStream());
Scanner scan=new Scanner(System.in);
String msg="";

while(!msg.equals("QUIT"))
{
/*to recieve msg*/      
msg=dis.readUTF();
System.out.println(" MSG FROM SERVER: "+msg); 
System.out.print(" MSG TO SERVER:");
msg=scan.nextLine();
dos.writeUTF(msg);
}
dis.close();
dos.close();
ser.close();

}
catch(Exception e)
{
System.out.println("\n CLIENT ERROR:"+e.getMessage());
}
}
}
