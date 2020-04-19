import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Ass32client 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		try 
		{
			InetAddress ip=InetAddress.getLocalHost();
			DatagramSocket ods=new DatagramSocket();
			
			System.out.println("\n Enter Filename :");
			String filename=scan.next();
			byte[] buffer=filename.getBytes();
			DatagramPacket odpSending=new DatagramPacket(buffer,buffer.length,ip,9998);
			ods.send(odpSending);
			
			buffer=new byte[2048];
			DatagramPacket odpReceiving =new DatagramPacket(buffer,buffer.length);
			ods.receive(odpReceiving);
			System.out.println(new String(odpReceiving.getData(), 0, odpReceiving.getLength()));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
